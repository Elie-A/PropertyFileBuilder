/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.view;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import propertyFileBuilderGenerator.control.application.encryptionDecryption.security.AES;
import propertyFileBuilderGenerator.control.application.encryptionDecryption.security.SecurityUtilities;
import propertyFileBuilderGenerator.control.application.miscellaneous.MiscellaneousUtilities;
import propertyFileBuilderGenerator.control.application.miscellaneous.confirmSavePane.SaveConfirmation;
import propertyFileBuilderGenerator.control.application.propertiesFile.PropertiesFileUtilities;

/**
 *
 * @author eliabdallah
 */
public class GUI extends javax.swing.JFrame {

    PropertiesFileUtilities parsePropertyFile = new PropertiesFileUtilities();

    AES aes = new AES();
    MiscellaneousUtilities miscellaneousUtilities = new MiscellaneousUtilities();
    PropertiesFileUtilities propertiesFileUtilities = new PropertiesFileUtilities();

    /**
     * Creates new form PropertyFileViewer
     *
     * @throws java.lang.Exception
     */
    public GUI() throws Exception {
        initComponents();

        SecurityUtilities securityUtilities = new SecurityUtilities();

        Font tableFont = new Font("Lucida Console", Font.PLAIN, 13);
        propTable.setFont(tableFont);

        isCellEditable(propTable.getSelectedRow(), propTable.getSelectedColumn());

//        saltTxt.setEditable(false);
//        keyText.setEditable(false);
//        readFromTxt.setEditable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        propertiesEncryptBtn = new javax.swing.JButton();
        propertiesDecryptBtn = new javax.swing.JButton();
        propertiesLoadBtn = new javax.swing.JButton();
        propertiesAddRowBtn = new javax.swing.JButton();
        propertiesDeleteRowBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saltTxt = new javax.swing.JTextField();
        keyText = new javax.swing.JTextField();
        readFromTxt = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        propTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jPanel1.setPreferredSize(new java.awt.Dimension(930, 607));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Controls", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N

        propertiesEncryptBtn.setBackground(new java.awt.Color(255, 0, 0));
        propertiesEncryptBtn.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        propertiesEncryptBtn.setText("ENCRYPT");
        propertiesEncryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesEncryptBtnActionPerformed(evt);
            }
        });

        propertiesDecryptBtn.setBackground(new java.awt.Color(0, 153, 0));
        propertiesDecryptBtn.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        propertiesDecryptBtn.setText("DECRYPT");
        propertiesDecryptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesDecryptBtnActionPerformed(evt);
            }
        });

        propertiesLoadBtn.setBackground(new java.awt.Color(255, 255, 0));
        propertiesLoadBtn.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        propertiesLoadBtn.setText("LOAD");
        propertiesLoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesLoadBtnActionPerformed(evt);
            }
        });

        propertiesAddRowBtn.setBackground(new java.awt.Color(153, 204, 255));
        propertiesAddRowBtn.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        propertiesAddRowBtn.setText("ADD ROW");
        propertiesAddRowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesAddRowBtnActionPerformed(evt);
            }
        });

        propertiesDeleteRowBtn.setBackground(new java.awt.Color(153, 204, 255));
        propertiesDeleteRowBtn.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        propertiesDeleteRowBtn.setText("DELETE ROW");
        propertiesDeleteRowBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesDeleteRowBtnActionPerformed(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel1.setText("SALT");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel2.setText("KEY");

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jLabel3.setText("READ FROM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(saltTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(keyText))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(readFromTxt)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(saltTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(keyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(readFromTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        saveBtn.setBackground(new java.awt.Color(255, 102, 51));
        saveBtn.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(propertiesEncryptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(propertiesDecryptBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(propertiesDeleteRowBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(propertiesLoadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(propertiesAddRowBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {propertiesAddRowBtn, propertiesDeleteRowBtn});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(propertiesEncryptBtn)
                    .addComponent(propertiesLoadBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(propertiesDecryptBtn)
                    .addComponent(propertiesDeleteRowBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(propertiesAddRowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {propertiesAddRowBtn, propertiesDecryptBtn, propertiesDeleteRowBtn, propertiesEncryptBtn, propertiesLoadBtn});

        propTable.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        propTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Key", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        propTable.setSelectionBackground(new java.awt.Color(153, 204, 255));
        propTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(propTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Property File Viewer", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void propertiesDeleteRowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesDeleteRowBtnActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) propTable.getModel();
        int totalRows = tableModel.getRowCount() - 1;
        int[] selectedRows = propTable.getSelectedRows();
        if (totalRows >= 0) {
            for (int i = 0; i < selectedRows.length; i++) {
                tableModel.removeRow(selectedRows[i] - i);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error! No Rows To Delete!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_propertiesDeleteRowBtnActionPerformed

    private void propertiesAddRowBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesAddRowBtnActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) propTable.getModel();
        Vector<String> row = new Vector<>();
        row.add("");
        row.add("");
        tableModel.addRow(row);
    }//GEN-LAST:event_propertiesAddRowBtnActionPerformed

    private void propertiesLoadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesLoadBtnActionPerformed
        MiscellaneousUtilities.removeJTableRows(propTable);
        JFileChooser jFileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Properties files", "properties");
        jFileChooser.setFileFilter(filter);

        int returnVal = jFileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = jFileChooser.getSelectedFile();
                parsePropertyFile.parsePropertyFile(selectedFile.getAbsolutePath(), propTable);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error! Properties file was not loaded!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_propertiesLoadBtnActionPerformed

    private void propertiesDecryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesDecryptBtnActionPerformed
        try {
            propTable.setValueAt(aes.decrypt(String.valueOf(propTable.getValueAt(propTable.getSelectedRow(), propTable.getSelectedColumn()))), propTable.getSelectedRow(), propTable.getSelectedColumn());
        } catch (Exception ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_propertiesDecryptBtnActionPerformed

    private void propertiesEncryptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesEncryptBtnActionPerformed
        try {
            propTable.setValueAt(aes.encrypt(String.valueOf(propTable.getValueAt(propTable.getSelectedRow(), propTable.getSelectedColumn()))), propTable.getSelectedRow(), propTable.getSelectedColumn());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "AES Encryption Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_propertiesEncryptBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        new SaveConfirmation();
        String text = SaveConfirmation.getFinalPath();
        propertiesFileUtilities.savePropertyFile(text, propTable);
    }//GEN-LAST:event_saveBtnActionPerformed

    private boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextField keyText;
    private javax.swing.JTable propTable;
    private javax.swing.JButton propertiesAddRowBtn;
    private javax.swing.JButton propertiesDecryptBtn;
    private javax.swing.JButton propertiesDeleteRowBtn;
    private javax.swing.JButton propertiesEncryptBtn;
    private javax.swing.JButton propertiesLoadBtn;
    public static javax.swing.JTextField readFromTxt;
    public static javax.swing.JTextField saltTxt;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
