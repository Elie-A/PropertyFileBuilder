/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.encryptionDecryption.security;

/**
 *
 * @author eliabdallah
 */
public class EncryptionDecryption {

    Cryptography cryptography;

    /**
     * Build an instance that use AES Encryption/Decryption method
     */
    public EncryptionDecryption() {
        cryptography = new AES();
    }

    /**
     * To encrypt Data
     *
     * @param data
     * @return Encrypted data
     */
    public String encrypt(String data) {
        try {
            return cryptography.encrypt(data);
        } catch (Exception ex) {
            //    Log.error("Encryption failure. " + ex.getMessage());
            return data;
        }
    }

    /**
     * To decrypt data
     *
     * @param data
     * @return decrypted data
     */
    public String decrypt(String data) {
        try {
            return cryptography.decrypt(data);
        } catch (Exception ex) {
            //     Log.error("Decryption failure. " + ex.getMessage());
            return data;
        }
    }
}
