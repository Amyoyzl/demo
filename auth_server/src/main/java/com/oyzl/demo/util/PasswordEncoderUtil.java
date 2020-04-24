package com.oyzl.demo.util;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return (String)charSequence;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.contentEquals(charSequence);
    }
}
