/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.miscellaneous;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import propertyFileBuilderGenerator.control.globalVars.GlobalVars;

/**
 *
 * @author PC
 */
public class MiscellaneousUtilities {

    public void setJsonFields(String type, JTextField rootKeyTxt, JTextField mainKeyTxt, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        switch (type) {
            case "Login":
                removeJTableRows(table);
                rootKeyTxt.setText(GlobalVars.loginRootKey);
                mainKeyTxt.setText(GlobalVars.loginMainKey);

                for (String key : GlobalVars.loginKeys) {
                    model.addRow(new Object[]{key, ""});
                }
                break;
            case "Qual Projects":
                removeJTableRows(table);
                rootKeyTxt.setText(GlobalVars.qualProjectRootKey);
                mainKeyTxt.setText(GlobalVars.qualProjectMainKey);

                for (String key : GlobalVars.qualProjectKeys) {
                    model.addRow(new Object[]{key, ""});
                }
                break;
            case "New Qual Project":
                removeJTableRows(table);
                rootKeyTxt.setText(GlobalVars.newQualProjectRootKey);
                mainKeyTxt.setText(GlobalVars.newQualProjectMainKey);

                for (String key : GlobalVars.newQualProjectKeys) {
                    model.addRow(new Object[]{key, ""});
                }
                break;
            case "Qual Interviews":
                removeJTableRows(table);
                rootKeyTxt.setText(GlobalVars.qualInterviewsRootKey);
                mainKeyTxt.setText(GlobalVars.qualInterviewsMainKey);

                for (String key : GlobalVars.qualInterviewsKeys) {
                    model.addRow(new Object[]{key, ""});
                }
                break;
            case "Qual Profile Password":
                removeJTableRows(table);
                rootKeyTxt.setText(GlobalVars.qualProfilePasswordRootKey);
                mainKeyTxt.setText(GlobalVars.qualProfilePasswordMainKey);

                for (String key : GlobalVars.qualProfilePasswordKeys) {
                    model.addRow(new Object[]{key, ""});
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Select a valid json file type from the list", "Error! Invalid json file type", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static void removeJTableRows(JTable table) {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        dm.setRowCount(0);
        table.setModel(dm);
    }
}
