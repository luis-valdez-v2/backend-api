package com.implancec.service;

import static com.implancec.utils.Constants.RESULT;
import static com.implancec.utils.Constants.TOKEN;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.implancec.dao.UserRepository;
import com.implancec.dto.User;
import com.implancec.exception.CustomException;
import com.implancec.security.JwtTokenProvider;
import com.implancec.utils.UserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = jwtTokenProvider.createToken(
                    username,
                    UserUtils.extractRoles(userRepository.findByUsername(username).getRoles())
            );
            JsonObject jsonObject = new JsonObject();
            jsonObject.add(RESULT, new JsonPrimitive("200"));
            jsonObject.add(TOKEN, new JsonPrimitive(token));
            return jsonObject.toString();
        } catch (AuthenticationException e) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add(RESULT, new JsonPrimitive("401"));
            return jsonObject.toString();
        }
    }

    public String signup(User user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            String token = jwtTokenProvider.createToken(
                    user.getUsername(), UserUtils.extractRoles((user.getRoles()))
            );
            JsonObject jsonObject = new JsonObject();
            jsonObject.add(RESULT, new JsonPrimitive("200"));
            jsonObject.add(TOKEN, new JsonPrimitive(token));
            return  jsonObject.toString();
        } else {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add(RESULT, new JsonPrimitive("409"));
            return jsonObject.toString();
        }
    }

    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

    public User search(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(
                username,
                UserUtils.extractRoles(userRepository.findByUsername(username).getRoles())
        );
    }

}
