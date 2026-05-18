package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryption {

    public static String encrypt(String password) {

        try {

            MessageDigest md =
                    MessageDigest.getInstance("MD5");

            byte[] digest =
                    md.digest(password.getBytes());

            StringBuilder sb =
                    new StringBuilder();

            for (byte b : digest) {

                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }

        return null;
    }
}