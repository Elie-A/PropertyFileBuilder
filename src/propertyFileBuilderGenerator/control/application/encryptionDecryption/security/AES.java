/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.encryptionDecryption.security;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author eliabdallah
 */
public class AES extends Cryptography {

    private static final String ALGORITHM = "AES";
    private static final int ITERATIONS = 1;
    private static byte[] keyValue;

    /**
     * For encryption job
     *
     * @param value value To be Encrypt
     * @return
     * @throws Exception
     */
    @Override
    public String encrypt(String value) throws Exception {

        String salt = new KeyGenerator().getSalt();
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);

        String valueToEnc = null;
        String eValue = value;
        for (int i = 0; i < ITERATIONS; i++) {
            valueToEnc = salt + eValue;
            byte[] encValue = c.doFinal(valueToEnc.getBytes());

            //   eValue = new BASE64Encoder().encode(encValue);
            eValue = Base64.getEncoder().encodeToString(encValue);
        }
        return eValue;
    }

    /**
     * For decryption
     *
     * @param value value To be Decrypt
     * @return
     * @throws Exception
     */
    @Override
    public String decrypt(String value) throws Exception {
        String salt = new KeyGenerator().getSalt();
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);

        String dValue = null;
        String valueToDecrypt = value;
        for (int i = 0; i < ITERATIONS; i++) {
            //  byte[] decordedValue = new BASE64Decoder().decodeBuffer(valueToDecrypt);
            byte[] decordedValue = Base64.getDecoder().decode(valueToDecrypt);
            byte[] decValue = c.doFinal(decordedValue);
            dValue = new String(decValue).substring(salt.length());
            valueToDecrypt = dValue;
        }
        return dValue;
    }

    /**
     * Build Key instance
     *
     * @return
     * @throws Exception
     */
    private static Key generateKey() throws Exception {
        keyValue = new KeyGenerator().getKeyByte(); //return GlobalVars.key
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
}
