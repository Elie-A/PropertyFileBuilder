/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.application.miscellaneous.confirmSavePane;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */


    public class UserInputPane extends JPanel {

        private JTextField fldText;
        private JTextField fldFileName;
        private JButton browseFileButton;

        private File selectedFile;

        private JRadioButton rbText;
        private JRadioButton rbFile;

        public UserInputPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            rbText = new JRadioButton("Text: ");
            rbFile = new JRadioButton("File: ");
            ButtonGroup bg = new ButtonGroup();
            bg.add(rbText);
            bg.add(rbFile);

            fldText = new JTextField(10);
            fldFileName = new JTextField(10);
            fldFileName.setEditable(false);
            browseFileButton = new JButton("...");

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(rbText, gbc);
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(fldText, gbc);

            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.WEST;
            add(rbFile, gbc);
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(fldFileName, gbc);
            gbc.gridx++;
            gbc.fill = GridBagConstraints.NONE;
            add(browseFileButton, gbc);

            fldText.setEnabled(false);
            fldFileName.setEnabled(false);
            browseFileButton.setEnabled(false);

            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fldText.setEnabled(rbText.isSelected());
                    fldFileName.setEnabled(!rbText.isSelected());
                    browseFileButton.setEnabled(!rbText.isSelected());

                    if (rbText.isSelected()) {
                        fldText.requestFocusInWindow();
                    }
                }
            };

            rbFile.addActionListener(listener);
            rbText.addActionListener(listener);

            browseFileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser chooser = new JFileChooser();

                    int returnValue = chooser.showOpenDialog(null);

                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        selectedFile = chooser.getSelectedFile();
                        fldFileName.setText(selectedFile.getName());
                    }
                }
            });

        }

        public String getText() throws IOException {
            String text = "";
            if (rbText.isSelected()) {
                text = fldText.getText();
            } else if (selectedFile != null && rbFile.isSelected()) {
            text = selectedFile.getAbsolutePath(); 
                
//                try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
//                    String value = null;
//                    while ((value = br.readLine()) != null) {
//                        text.add(value);
//                    }
//                }

            }
            return text;
        }

    }
