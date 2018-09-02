/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

/**
 * Checks the user entered data is present, valid or the correct length. Does not accept the record otherwise.
 * @author Leigh Lawley, Harry Clewlow
 */
public class Validation {

    
    /**
     * Method to check if the age is present.
     * 
     * @param str the string parameter to be checked or validated
     * @return 
     */
    public static boolean isIntegerField(String str) {
        if (!str.isEmpty()) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException nfe) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Method to check if the name entered is less than or equal to 20 characters or present.
     * @param str string parameter to be checked or validated
     * @return 
     */
    public static boolean isNameField(String str) {
        if (str.length() >= 20 || str.isEmpty()) {
            return false;
        }
        return true;
    }
    /**
     * Method to check if the address is less than or equal to 20 characters or present.
     * @param str string parameter to be checked or validated
     * @return 
     */
    public static boolean isAddressField(String str) {
        if (str.length() >= 30 || str.isEmpty()) {
            return false;
        }
        return true;
    }
    
/**
 * Method to check if the postcode is less than or equal to 10 characters or present.
 * @param str string parameter to be checked or validated
 * @return 
 */
    public static boolean isPostcodeField(String str) {
        if (str.length() >= 10 || str.isEmpty()) {
            return false;
        }
        return true;
    }
/**
 * Method to check if the email is less than or equal to 40 characters or present.
 * @param str string parameter to be checked or validated
 * @return 
 */
    public static boolean isEmailField(String str) {
        if (str.length() >= 40 || str.isEmpty()) {
            return false;
        }
        return true;
    }
/**
 * Method to check if the phone number is less than or equal to 10 characters or present.
 * @param str string parameter to be checked or validated
 * @return 
 */
    public static boolean isPhoneNumberField(String str) {
        if (str.length() != 11 || str.isEmpty()) {
            return false;
        }
        return true;
    }
}
