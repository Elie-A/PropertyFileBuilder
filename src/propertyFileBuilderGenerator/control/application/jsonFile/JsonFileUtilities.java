/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.jsonFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import propertyFileBuilderGenerator.control.application.miscellaneous.JsonFormatter;
import propertyFileBuilderGenerator.control.globalVars.GlobalVars;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class JsonFileUtilities {

    HashMap<String, Object> mainHashMap = null;
    DefaultTableModel model = null;

    private HashMap<String, Object> getHashMapFromJson(String json) throws JSONException {
        HashMap<String, Object> map = new HashMap<>();
        JSONObject jsonObject = new JSONObject(json);
        for (Iterator<String> it = jsonObject.keys(); it.hasNext();) {
            String key = it.next();
            map.put(key, jsonObject.get(key));
        }
        return map;
    }

    public void fillJsonFilesTypeList(JComboBox comboBox) {

        comboBox.addItem("JSON FILE TYPE");
        for (String type : GlobalVars.listOfJsonFilesTypes) {
            comboBox.addItem(type);
        }
    }

    public void generateJson(String type, JTable table, JTextArea textArea, String rootKey, String mainKey) {
        JSONObject jsonObject = null;
        JSONArray jsonArrayObject = null;
        Map<String, String> rowMap = new HashMap<>();

        int totalRows = 0;
        switch (type) {
            case "Login":
                jsonObject = new JSONObject();
                jsonArrayObject = new JSONArray();
                totalRows = table.getRowCount() - 1;
                try {
                    for (int row = 0; row <= totalRows; row++) {
                        rowMap.put("\"" + String.valueOf(table.getValueAt(row, 0)) + "\"", String.valueOf(table.getValueAt(row, 1)));
                    }
                    jsonObject.put("\"" + rootKey + "\"", jsonArrayObject.put(new JSONObject().put("\"" + mainKey + "\"", new JSONArray().put(rowMap))));
                    textArea.setText(JsonFormatter.format(jsonObject));
                } catch (JSONException ex) {
                    JOptionPane.showMessageDialog(null, "Error in generateJson() Login\n" + ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Qual Projects":
                jsonObject = new JSONObject();
                jsonArrayObject = new JSONArray();
                totalRows = table.getRowCount() - 1;
                try {
                    for (int row = 0; row <= totalRows; row++) {
                        rowMap.put("\"" + String.valueOf(table.getValueAt(row, 0)) + "\"", String.valueOf(table.getValueAt(row, 1)));
                    }
                    jsonObject.put("\"" + rootKey + "\"", jsonArrayObject.put(new JSONObject().put("\"" + mainKey + "\"", new JSONArray().put(rowMap))));
                    textArea.setText(JsonFormatter.format(jsonObject));
                } catch (JSONException ex) {
                    JOptionPane.showMessageDialog(null, "Error in generateJson() Qual Projects\n" + ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "New Qual Project":
                jsonObject = new JSONObject();
                totalRows = table.getRowCount() - 1;
                try {
                    for (int row = 0; row <= totalRows; row++) {
                        jsonObject.put("\"" + mainKey + "\"", new JSONObject().put("\"" + String.valueOf(table.getValueAt(row, 0)) + "\"", String.valueOf(table.getValueAt(row, 1))));
                    }
                    textArea.setText(JsonFormatter.format(jsonObject));
                } catch (JSONException ex) {
                    JOptionPane.showMessageDialog(null, "Error in generateJson() New Qual Project\n" + ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
                }
                break;

            case "Qual Interviews":
                jsonObject = new JSONObject();
                jsonArrayObject = new JSONArray();
                totalRows = table.getRowCount() - 1;
                try {
                    for (int row = 0; row <= totalRows; row++) {
                        rowMap.put("\"" + String.valueOf(table.getValueAt(row, 0)) + "\"", String.valueOf(table.getValueAt(row, 1)));
                    }
                    jsonObject.put("\"" + rootKey + "\"", jsonArrayObject.put(new JSONObject().put("\"" + mainKey + "\"", new JSONArray().put(rowMap))));
                    textArea.setText(JsonFormatter.format(jsonObject));
                } catch (JSONException ex) {
                    JOptionPane.showMessageDialog(null, "Error in generateJson() Qual Interviews\n" + ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Qual Profile Password":
                jsonObject = new JSONObject();
                totalRows = table.getRowCount() - 1;

                for (int row = 0; row <= totalRows; row++) {
                    try {
                        jsonObject.put("\"" + String.valueOf(table.getValueAt(row, 0)) + "\"", String.valueOf(table.getValueAt(row, 1)));
                        textArea.setText(JsonFormatter.format(jsonObject));
                    } catch (JSONException ex) {
                        JOptionPane.showMessageDialog(null, "Error in generateJson() Qual Profile Password\n" + ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void loadJson(String type, String filePath, JTable table, JTextArea textArea) throws IOException, JSONException {
        mainHashMap = new HashMap<>();
        model = (DefaultTableModel) table.getModel();
        switch (type) {
            case "Login":

                break;
            case "Qual Projects":

                break;
            case "New Qual Project":

                break;
            case "Qual Interviews":

                break;
            case "Qual Profile Password":
                String contents = new String((Files.readAllBytes(Paths.get(filePath))));
                mainHashMap = getHashMapFromJson(contents);

                for (String key : mainHashMap.keySet()) {
                    model.addRow(new Object[]{key, mainHashMap.get(key)});
                }
                table.setModel(model);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Select a valid json file type from the list", "Error! Invalid json file type", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}
