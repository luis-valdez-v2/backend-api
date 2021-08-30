package com.implancec.utils;

import java.util.List;

public interface UserUtils {
    static List<String> extractRoles(String roles) {
        return List.of(roles.split(","));
    }
}
