package com.rinicius.cryptography.utils;

import org.jasypt.util.text.StrongTextEncryptor;

public class ConvertingUtils {

    private static final StrongTextEncryptor encryptor;

    private ConvertingUtils() {
        throw new IllegalStateException("Utility class");
    }

    static {
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword(System.getenv("APP_KEY"));
    }

    public static String encrypt(String rawText) {
        return encryptor.encrypt(rawText);
    }

    public static String decrypt(String encryptedText) {
        return encryptor.decrypt(encryptedText);
    }

}
