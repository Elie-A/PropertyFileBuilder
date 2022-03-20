/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.propertiesFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import propertyFileBuilderGenerator.model.propertiesFile.Element;

/**
 *
 * @author eliabdallah
 */
public class PropertiesFileUtilities {
    
    public void parsePropertyFile(String path, JTable table) throws FileNotFoundException, IOException {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        Vector<Element> data = new Vector<Element>();
        Properties properties = new Properties();
        
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            properties.load(fileInputStream);
            fileInputStream.close();
        }
        
        Set states = properties.keySet();
        Iterator itr = states.iterator();
        String str;
        while (itr.hasNext()) {
            str = (String) itr.next();
            data.add(new Element(str, properties.getProperty(str)));
        }
        
        for(Element element : data){
            Vector<String> row = new Vector<String>(2);
            row.add(element.getKey());
            row.add(element.getValue());
            tableModel.addRow( row );
        }
        
        table.setModel(tableModel);
    }

    public void savePropertyFile(String path, JTable table) {
        int totalRows = table.getRowCount() - 1;
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (int row = 0; row <= totalRows; row++) {
                String line = String.valueOf(table.getValueAt(row, 0)) + "=" + String.valueOf(table.getValueAt(row, 1));
                fileWriter.append(line);
                fileWriter.append("\n");
            }
            fileWriter.close();
            JOptionPane.showMessageDialog(null, "Saving of " + file.getName() + " successful!\n", "Info!", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "savePropertyFile() Exception: " + ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
