package de.reipka.resttwo.util;

import org.apache.logging.log4j.util.Chars;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashUtil {

    public String createHash(String password, byte[] salt, Charset charset, String hashingAlgorythm){

        byte[] passBytes = password.getBytes(charset);
        byte[] hashBytes = new byte[passBytes.length + salt.length];

        for (int i=0; i < hashBytes.length; i++){
            hashBytes[i]= i < passBytes.length? passBytes[i] : salt[i - passBytes.length];
        }

        return getHash(password.getBytes(StandardCharsets.UTF_8), hashingAlgorythm);
    }


    // Available Algorythms: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512
    private String getHash(byte[] inputBytes, String hashingAlgorythm){

        String hashValue = "";

        // MessageDigest is not thread-safe. One should use a new instance for every thread.
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(hashingAlgorythm);      // select algorythm
            messageDigest.update(inputBytes);                                               // computes the hash
            byte[] digestedBytes = messageDigest.digest();                                  // finalizes the hash and calls reset()

            hashValue = bytesToHex(digestedBytes);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashValue;
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


}
