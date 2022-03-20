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
public abstract class Cryptography {

    protected Cryptography() {
    }

    /**
     * For encryption
     *
     * @param valueToEnc
     * @return
     * @throws Exception
     */
    public abstract String encrypt(String valueToEnc) throws Exception;

    /**
     * For decryption
     *
     * @param encryptedValue to be Decrypted
     * @return
     * @throws Exception
     */
    public abstract String decrypt(String encryptedValue) throws Exception;
}
