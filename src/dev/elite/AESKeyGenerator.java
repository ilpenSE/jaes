package dev.elite;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AESKeyGenerator {
    // Create key from sample
    public static SecretKeySpec generateKeyFromSample(String sample) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] key = sha.digest(sample.getBytes());
            return new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Create IV from sample
    public static IvParameterSpec generateIvFromSample(String sample) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] iv = sha.digest(sample.getBytes());
            return new IvParameterSpec(iv, 0, 16); // IV length should be 16 bytes
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
