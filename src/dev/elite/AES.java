package dev.elite;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES {
    private static final String AES_CBC_PKCS5PADDING = "AES/CBC/PKCS5Padding";

    // Encryption
    public static String encrypt(String plaintext, SecretKeySpec key, IvParameterSpec iv) {
        try {
            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] encrypted = cipher.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | NoSuchAlgorithmException |
                 BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    // Decryption
    public static String decrypt(String encryptedText, SecretKeySpec key, IvParameterSpec iv) {
        try {
            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] decoded = Base64.getDecoder().decode(encryptedText);
            byte[] original = cipher.doFinal(decoded);
            return new String(original);
        } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException |
                 NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
