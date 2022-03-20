/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.miscellaneous.confirmSavePane;

/**
 *
 * @author PC
 */
import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SaveConfirmation {

    public static String text;

    public SaveConfirmation() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static String getFinalPath() {
        UserInputPane userInputPane = new UserInputPane();
        int result = JOptionPane.showConfirmDialog(null, userInputPane, "Save Path", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                text = userInputPane.getText();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return text;
    }
}
