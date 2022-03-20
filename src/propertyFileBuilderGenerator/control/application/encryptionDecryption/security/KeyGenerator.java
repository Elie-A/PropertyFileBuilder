/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.encryptionDecryption.security;

import java.io.IOException;

/**
 *
 * @author eliabdallah
 */
public class KeyGenerator {

    protected KeyGenerator() {
    }
    
    protected byte[] getKeyByte() throws IOException {
        return SecurityUtilities.propertiesKey;
    }

    protected String getSalt() throws IOException {
        return SecurityUtilities.propertiesSalt;
    }
}