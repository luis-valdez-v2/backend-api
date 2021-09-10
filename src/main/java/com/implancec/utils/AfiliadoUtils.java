package com.implancec.utils;

import java.util.Date;

import com.implancec.dto.Afiliado;

public interface AfiliadoUtils {
    static Afiliado createAfiliado() {
        return new Afiliado("nombre",
                null,
                "calle",
                1,
                1,
                "colonia",
                83288,
                1.1,
                1.1,
                1,
                "email",
                "12345");
    }
}
