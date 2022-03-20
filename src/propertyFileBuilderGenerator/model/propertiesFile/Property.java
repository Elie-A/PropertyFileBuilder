/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.model.propertiesFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import propertyFileBuilderGenerator.view.GUI;

/**
 *
 * @author eliabdallah
 */
public class Property {

    File file;
    FileWriter ff;
    private Properties properties = null;
    String error = "";
    private String basePathProp = "path.properties";

    public Property() throws Exception {
        try {
            loadProperties(basePathProp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Property Constuctor() Exception e: " + e.toString() + "\n", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void loadProperties(String propertiesFileName) throws Exception {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(propertiesFileName);
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "loadProperties() Exception e: " + e.toString() + "\n", "Error!", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "loadProperties() Exception e: " + e.toString() + "\n", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String get(String s) {
        String val = properties.getProperty(s);
        if (val == null || val.length() == 0) {
            return "";
        }
        return val;
    }

    public void setNew(String s) {
        file = new File(basePathProp);
        try {
            ff = new FileWriter(file);
            ff.write(s);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "setNew() Exception e: " + e.toString() + "\n", "Error!", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                ff.close();
            } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "setNew() Exception e: " + e.toString() + "\n", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
