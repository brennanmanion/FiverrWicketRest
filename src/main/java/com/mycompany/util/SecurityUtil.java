package com.mycompany.util;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.inject.Inject;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SecurityUtil {

    public static final String HASHED_PASSWORD_KEY = "hashedPassword";
    public static final String SALT_KEY = "salt";

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static boolean passwordsMatch(String dbStoredHashedPassword, String saltText, String clearTextPassword) {
        ByteSource salt = ByteSource.Util.bytes(Hex.decode(saltText));
        String hashedPassword = hashAndSaltPassword(clearTextPassword, salt);
        return hashedPassword.equals(dbStoredHashedPassword);
    }

    public static Map<String, String> hashPassword(String clearTextPassword) {
        ByteSource salt = getSalt();

        Map<String, String> credMap = new HashMap<>();
        credMap.put(HASHED_PASSWORD_KEY, hashAndSaltPassword(clearTextPassword, salt));
        credMap.put(SALT_KEY, salt.toHex());
        return credMap;
    }

    private static String hashAndSaltPassword(String clearTextPassword, ByteSource salt) {
        return new Sha512Hash(clearTextPassword, salt, 2000000).toHex();
    }

    private static ByteSource getSalt() {
        return new SecureRandomNumberGenerator().nextBytes();
    }

//    public boolean authenticateUser(String email, String password) {
//        return queryService.authenticateUser(email, password);
//    }
}
