package de.reipka.resttwo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShaController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("get/sha")
    public String getSha() throws NoSuchAlgorithmException {

        String originalString = "MyOriginalString";

        logger.info("Original String: " + originalString);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));

        StringBuilder stringBuilder = new StringBuilder("");
        for(byte encodedByte: encodedhash){
            stringBuilder.append(encodedByte);
        }
        logger.info("Stringbuilder: " + stringBuilder);
        logger.info("HexString: " + bytesToHex(encodedhash));

        //return new ResponseEntity<String>(stringBuilder.toString(), HttpStatus.OK);
        return bytesToHex(encodedhash);
    }

    // for password services use salt and slow algorythms for passwords (Security context from Spring)

    @PostMapping("post/sha")
    public ResponseEntity<String> compareHashAndString(@RequestBody String input){

        // hash = keyword of user
        String hash = "";
        hash = getHash(input.getBytes(StandardCharsets.UTF_8),"SHA-256");
        logger.info("created hash from input:\n" + hash);

        // salt = 2nd, random key
        byte[] salt;
        salt = new byte[32];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        for(byte b : salt){
            System.out.print(b);
        }
        System.out.println();

        StringBuilder sb = new StringBuilder();
        for(byte b : salt){
            sb.append(Integer.toHexString(b));
        }
        logger.info("generated salt(hashed):\n"+  sb);

        // both hash and salt must be saved to DB
        HashMap<String, byte[]> passwordHashMap = new HashMap<>();
        passwordHashMap.put("hash", input.getBytes(StandardCharsets.UTF_8));
        passwordHashMap.put("salt", salt);

        // Compare with Hash from DB

        return new ResponseEntity<String>(hash, HttpStatus.OK);
    }







    // Available Algorythms: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512
    public static String getHash(byte[] inputBytes, String algorythm){

        String hashValue = "";

        // MessageDigest is not thread-safe. One should use a new instance for every thread.
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorythm); // select algorythm
            messageDigest.update(inputBytes);                                   // computes the hash
            byte[] digestedBytes = messageDigest.digest();                      // finalizes the hash and calls reset()

            hashValue = bytesToHex(digestedBytes);
            System.out.println(hashValue);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashValue;
    }

    private static String bytesToHex(byte[] hash) {
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
