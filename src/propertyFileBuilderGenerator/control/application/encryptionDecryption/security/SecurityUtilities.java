/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.encryptionDecryption.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import propertyFileBuilderGenerator.model.propertiesFile.Element;
import propertyFileBuilderGenerator.control.globalVars.GlobalVars;
import propertyFileBuilderGenerator.view.GUI;

/**
 *
 * @author eliabdallah
 */
public class SecurityUtilities {

    public static String propertiesSalt;
    public static byte[] propertiesKey = null;
    
    private static Properties properties;

    public SecurityUtilities() throws Exception{
        GlobalVars globalVars = new GlobalVars();
        
        propertiesSalt = salt(GlobalVars.saltKeyFile);
        propertiesKey = key(GlobalVars.saltKeyFile);
        
        GUI.saltTxt.setText(propertiesSalt);
        GUI.keyText.setText(new String(propertiesKey));
        GUI.readFromTxt.setText(GlobalVars.saltKeyFile);
        
        }

    private static byte[] toBytes(char[] chars) {
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ByteBuffer byteBuffer = Charset.forName("UTF-8").encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                byteBuffer.position(), byteBuffer.limit());
        Arrays.fill(charBuffer.array(), '\u0000'); // clear sensitive data
        Arrays.fill(byteBuffer.array(), (byte) 0); // clear sensitive data
        return bytes;
    }

    private static Vector<Element> getAllElements() {
        Vector<Element> data = new Vector<Element>();
        Set states = properties.keySet();
        Iterator itr = states.iterator();
        String str;
        while (itr.hasNext()) {
            str = (String) itr.next();
            data.add(new Element(str, properties.getProperty(str)));
        }
        return data;
    }

    private static String salt(String filePath) throws FileNotFoundException, IOException {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        }
        Vector<Element> elem = getAllElements();
        String[][] fields = new String[elem.size()][4];
        for (int i = 0; i < elem.size(); i++) {
            fields[i][0] = elem.get(i).getKey();
            fields[i][1] = elem.get(i).getValue();
        }
        return fields[1][1];
    }

    private static byte[] key(String filePath) throws IOException {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        properties.load(fileInputStream);
        try {
            fileInputStream.close();
            Vector<Element> elem = getAllElements();
            String[][] fields = new String[elem.size()][4];
            for (int i = 0; i < elem.size(); i++) {
                fields[i][0] = elem.get(i).getKey();
                fields[i][1] = elem.get(i).getValue();
            }
            String value = fields[0][1];
            char[] charArray = new char[value.toCharArray().length];
            int i = 0;
            for (char ch : value.toCharArray()) {
                charArray[i] = ch;
                i++;
            }
            byte[] returnedByte = toBytes(charArray);
            return returnedByte;
        } catch (Exception e) {

        }
        return null;
    }
}
