package com.mik.gwt.server.util;

import com.lambdaworks.crypto.SCrypt;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;

/**
 * Created by mikitjuk on 21.12.15.
 */
public class PasswordHashSalt {

    // The following constants for hashing.
    public static final int PARAM_COST_CPU = 16;
    public static final int PARAM_COST_MEMORY = 16;
    public static final int PARAM_PARALLETION = 16;
    public static final int PARAM_INTEN_LEN = 16;
    public static final int SALT_BYTE_SIZE = 16;

    /**
     * Returns a salted hash of the password.
     *
     * @param   password    the password to hash
     * @return              a salted hash of the password
     */
    public static String createHash(String password) {

        try {
            // Generate a random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_BYTE_SIZE];
            random.nextBytes(salt);

            byte[] derived = getDerived(password, salt);

            return new StringBuilder((salt.length + derived.length) * 2)
                    .append('$').append(toHex(salt))
                    .append('$').append(toHex(derived)).toString();

        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("JVM doesn't support UTF-8?");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("JVM doesn't support SHA1PRNG or HMAC_SHA256?");
        }
    }

    /**
     * Compare the supplied plaintext password to a hashed password.
     *
     * @param   password    Plaintext password.
     * @param   hashed      scrypt hashed password.
     *
     * @return              true if passwd matches hashed value.
     */
    public static boolean check(String password, String hashed) {
        try {
            String[] parts = hashed.split("\\$");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid hashed value");
            }

            byte[] salt = fromHex(parts[1]);
            byte[] derived0 = fromHex(parts[2]);

            byte[] derived1 = getDerived(password, salt);

            if (derived0.length != derived1.length) return false;

            int result = 0;
            for (int i = 0; i < derived0.length; i++) {
                result |= derived0[i] ^ derived1[i];
            }
            return result == 0;
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("JVM doesn't support UTF-8?");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("JVM doesn't support SHA1PRNG or HMAC_SHA256?");
        }
    }

    /**
     * Returns a derived of the password with salt.
     *
     * @param   password    the password
     * @param   salt        the salt
     * @return              a derived of the password with salt
     */
    private static byte[] getDerived(String password, byte[] salt) throws GeneralSecurityException, UnsupportedEncodingException {

        return SCrypt.scrypt(password.getBytes("UTF-8"), salt, PARAM_COST_CPU, PARAM_COST_MEMORY, PARAM_PARALLETION, PARAM_INTEN_LEN);
    }

    /**
     * Converts a string of hexadecimal characters into a byte array.
     *
     * @param   hex         the hex string
     * @return              the hex string decoded into a byte array
     */
    private static byte[] fromHex(String hex)
    {
        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
    }

    /**
     * Converts a byte array into a hexadecimal string.
     *
     * @param   array       the byte array to convert
     * @return              a length*2 character string encoding the byte array
     */
    private static String toHex(byte[] array)
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
    }
}
