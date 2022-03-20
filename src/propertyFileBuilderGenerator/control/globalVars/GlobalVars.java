/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyFileBuilderGenerator.control.globalVars;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author eliabdallah
 */
public class GlobalVars {

    public static String saltKeyFile;
    String confPath = "path.properties";

    public GlobalVars() {
        try (InputStream inputStream = new FileInputStream(confPath)) {
            Properties properies = new Properties();
            properies.load(inputStream);
            saltKeyFile = properies.getProperty("propertiesSalt");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in GlobalVars()! Properties file was not loaded!\n" + ex.toString(), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static String[] listOfJsonFilesTypes = {"Login", "Qual Projects", "New Qual Project", "Qual Interviews", "Qual Profile Password"};

    // LOGIN
    public static String loginRootKey = "subscriberCredentials";
    public static String loginMainKey = "subscriberCredential";
    public static String[] loginKeys = {"username", "password"};
    
    // QUAL PROJECTS
    public static String qualProjectRootKey = "qualProjects";
    public static String qualProjectMainKey = "qualProjectsSearch";
    public static String[] qualProjectKeys = {"projectName"};
    
    // NEWE QUAL PROJECT
    public static String newQualProjectRootKey = "";
    public static String newQualProjectMainKey = "newQualProject";
    public static String[] newQualProjectKeys = {"projectName",
        "interviewLength",
        "crowdName",
        "profession",
        "sampleSize",
        "speciality",
        "optionalAttribute",
        "state",
        "difficultyToFind",
        "recruitmentCompletionDate",
        "stimulusValue",
        "transcribeValue"};
    
    // QUAL INTERVIEWS
    public static String qualInterviewsRootKey = "qualInterviews";
    public static String qualInterviewsMainKey = "qualInterviewsSearch";
    public static String[] qualInterviewsKeys = {"interviewName"};

    // PROFILE PASSWORD
    public static String qualProfilePasswordMainKey = "";
    public static String qualProfilePasswordRootKey = "";
    public static String[] qualProfilePasswordKeys = {"short current password",
        "long current password",
        "current password without digit",
        "current valid password",
        "short new password",
        "long new password",
        "new password without digit",
        "new valid password",
        "short matching confirm password",
        "long matching confirm password",
        "confirm matching password without digit",
        "confirm unmatching password",
        "invalid password error",
        "unmatching passwords error"};

}
