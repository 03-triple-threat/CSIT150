package Lab6;

import javax.swing.*;

/***********************************************************************************************************
 * Author - AJ Hurtado
 * Date - October 09, 2017
 *
 * CSIT 150 Lab 6 Spring 2017
 *
 * Imagine that you are developing a software package that requires users to enter their own
 passwords. Your software requires that usersâ€™ passwords meet the following criteria:

 â€¢ The password should be at least six characters long.
 â€¢ The password should contain at least one uppercase and at least one lowercase letter.
 â€¢ The password should have at least one digit and one special character.
 (A special character is not alphabetic and is not a digit).
 â€¢ The password should not be in the array of not allowed passwords.
 In general, this array may include several words, or be null.
 For testing purposes, do not allow passwords to be one of  the following strings: "Password1","Mypassw0rd".
 Ask for the user name and password.
 Keep asking for a password until the user enters a password that meets the criteria above.
 Output the username and the password. Then, output the user and the hidden password â€œ******â€.

 Add JavaDoc comments to this program.
 ********************************************************************************************************/

public class Lab6Start {
    private static String[] notAllowed = {"Password1", "Mypassw0rd"};

    /**
     * This method takes in String passWord and validates the requirements
     * of the passwords are met through if-statement and for loops
     *
     * @param passWord - String of characters
     * @return booleans to validate password requirements are met
     */
    public static boolean isValidPassword(String passWord) {
        boolean validLength = false;
        boolean foundUpper = false;
        boolean foundLower = false;
        boolean foundDigit = false;
        boolean foundSpecial = false;
        boolean isAllowed = true;

        if (passWord.length() >= 6) {
            validLength = true;
        }

        for (int i = 0; i < passWord.length(); i++) {
            if (Character.isLowerCase(passWord.charAt(i)))
                foundLower = true;
            if (Character.isUpperCase(passWord.charAt(i)))
                foundUpper = true;
            if (Character.isDigit(passWord.charAt(i)))
                foundDigit = true;
            if (Character.isLetterOrDigit(passWord.charAt(i)))
                foundSpecial = true;
        }

        for (int i = 0; i < notAllowed.length; i++) {
            if (passWord.equals(notAllowed[i]))
                isAllowed = false;
        }

        return validLength && foundUpper && foundLower && foundDigit && foundSpecial && isAllowed;
    }

    /**
     * This method takes in the String passWord and replaces each
     * character in the password with '*'.
     *
     * @param passWord - String of characters
     * @return hiddenPassword - the String passWord returned with '*' replacing each character
     */
    public static StringBuffer hidePassword(String passWord) {
        StringBuffer hiddenPassword = new StringBuffer(passWord);
        for (int i = 0; i < hiddenPassword.length(); i++)
            hiddenPassword.setCharAt(i , '*');
        return hiddenPassword;
    }

    public static void main(String[] args) {

        boolean valid = true;
        String userName = "";
        String passWord = "";
        userName = JOptionPane.showInputDialog(null, "Enter your username: ");
        passWord = JOptionPane.showInputDialog(null, "Enter your password: ");
        valid = isValidPassword(passWord);
        while (!valid) {
            passWord = JOptionPane.showInputDialog(null, "Invalid password. Enter a new password: ");
            valid = isValidPassword(passWord);
        }
        StringBuffer hiddenPassword = hidePassword(passWord);
        System.out.println("The username: " + userName + " has password: " + passWord);
        System.out.println("The username: " + userName + " with hidden password: " + hiddenPassword);

    }
}
