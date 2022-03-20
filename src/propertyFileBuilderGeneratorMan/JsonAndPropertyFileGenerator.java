/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGeneratorMan;

import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import propertyFileBuilderGenerator.control.application.encryptionDecryption.security.AES;
import propertyFileBuilderGenerator.control.application.encryptionDecryption.security.SecurityUtilities;
import propertyFileBuilderGenerator.view.GUI;

/**
 *
 * @author eliabdallah
 */
public class JsonAndPropertyFileGenerator {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        AES aes = new AES();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String choice = "";
        String salt = "";
        String k = "";
        byte[] key = null;

        String toEncrypt = "";

        do {
            System.out.println("\nSelect from: \n\t1-GUI\n\t2-Console");
            choice = bufferedReader.readLine().trim();
        } while (choice.length() == 0 || (!choice.equals("1") && !choice.equals("2")));

        System.out.println();

        switch (choice) {
            case "1":
                try {
                GUI gui = new GUI();
                gui.setTitle("Property File Builder");
                gui.setLocationRelativeTo(null);
                gui.setResizable(false);
                gui.setCursor(new Cursor(Cursor.HAND_CURSOR));
                gui.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "main() Exception: " + ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            break;

            case "2":
                do {
                    System.out.println("\nEnter salt");
                    salt = bufferedReader.readLine().trim();
                    SecurityUtilities.propertiesSalt = salt;
                } while (salt == null || salt.length() == 0);

                do {
                    System.out.println("\nEnter key");
                    k = bufferedReader.readLine().trim();
                    key = k.getBytes();
                    SecurityUtilities.propertiesKey = key;
                } while (k.length() <= 0 || k.length() < 16 || k.length() > 16);

                do {
                    System.out.println("\nEnter value to encrypt");
                    toEncrypt = bufferedReader.readLine().trim();
                } while (toEncrypt.length() <= 0);

                String encrypted = aes.encrypt(toEncrypt);

                System.out.println("Encrypted value: " + encrypted);
                System.out.println("Decrypted value: " + aes.decrypt(encrypted));
                break;
        }
        bufferedReader.close();
    }
}
