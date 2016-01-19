package com.mik.gwt.server.util;

import com.lambdaworks.crypto.SCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by mikitjuk on 21.12.15.
 */
public class PasswordHashSalt {

    // текущие константы для хеширования
    public static final int PARAM_COST_CPU = 16;
    public static final int PARAM_COST_MEMORY = 16;
    public static final int PARAM_PARALLETION = 16;
    public static final int PARAM_INTEN_LEN = 16;
    public static final int SALT_BYTE_SIZE = 16;

    private static final Logger logger = LoggerFactory.getLogger(PasswordHashSalt.class);

    // создание хеша с солью, на входе пароль
    public static String createHash(String password) {

        String retHash = null;
        try {
            // генерирует случайную соль
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_BYTE_SIZE];
            random.nextBytes(salt);

            byte[] derived = getDerived(password, salt);

            logger.debug("derived for password: " + Arrays.toString(derived));

            retHash = new StringBuilder((salt.length + derived.length) * 2)
                    .append('$').append(toHex(salt))
                    .append('$').append(toHex(derived)).toString();

        } catch (Exception ex) {
            logger.error("create hash error for password - " + password + " " + ex.getMessage());
        }

        return retHash;
    }

    // проверка валидности пароля пользователя
    public static boolean check(String password, String hashed) {

        boolean retValue = false;
        try {
            String[] parts = hashed.split("\\$");

            if (parts.length != 3) {
                logger.error("Invalid hashed value hash : " + hashed);

            } else {
                byte[] derived0 = fromHex(parts[2]);
                byte[] derived1 = getDerived(password, fromHex(parts[1]));

                if (derived0.length != derived1.length) return false;

                int result = 0;
                for (int i = 0; i < derived0.length; i++)
                    result |= derived0[i] ^ derived1[i];

                retValue = result == 0;
            }
        } catch (Exception ex) {
            logger.error("check hash error for password - " + password + " " + ex.getMessage());
        }

        return retValue;
    }

    // возвращает пароль + соль в зашифрованом виде
    private static byte[] getDerived(String password, byte[] salt) throws GeneralSecurityException, UnsupportedEncodingException {
        return SCrypt.scrypt(password.getBytes("UTF-8"), salt, PARAM_COST_CPU, PARAM_COST_MEMORY, PARAM_PARALLETION, PARAM_INTEN_LEN);
    }

    // конвертирует строку из hexadecimal символов в byte array.
    private static byte[] fromHex(String hex){

        byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
            binary[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);

        return binary;
    }

    // конвертирует byte array в hexadecimal строку.
    private static String toHex(byte[] array){

        String retStr;
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();

        if(paddingLength > 0)
            retStr = String.format("%0" + paddingLength + "d", 0) + hex;
        else
            retStr = hex;

        return retStr;
    }
}
