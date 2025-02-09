/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo Flex
 */
public class defaultEncrypter {

    // Define the valid character set (alphanumeric)
    private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String encrypt(String message, int mainKey) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            // Find the index of the character in the CHARSET
            int index = CHARSET.indexOf(c);
            if (index != -1) {
                // Encrypt by shifting the index and wrapping around
                int newIndex = (index + mainKey) % CHARSET.length();
                encrypted.append(CHARSET.charAt(newIndex));
            } else {
                // If character not in CHARSET, leave it unchanged
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

//    public static String decrypt(String encryptedMessage, int mainKey) {
//        StringBuilder decrypted = new StringBuilder();
//        for (int i = 0; i < encryptedMessage.length(); i++) {
//            char c = encryptedMessage.charAt(i);
//            // Find the index of the character in the CHARSET
//            int index = CHARSET.indexOf(c);
//            if (index != -1) {
//                // Decrypt by shifting the index backwards and wrapping around
//                int newIndex = (index - mainKey + CHARSET.length()) % CHARSET.length();
//                decrypted.append(CHARSET.charAt(newIndex));
//            } else {
//                // If character not in CHARSET, leave it unchanged
//                decrypted.append(c);
//            }
//        }
//        return decrypted.toString();
//    }
    public static String decrypt(String encryptedMessage, int mainKey) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char c = encryptedMessage.charAt(i);
            // Find the index of the character in the CHARSET
            int index = CHARSET.indexOf(c);
            if (index != -1) {
                // Decrypt by shifting the index backwards and wrapping around
                int newIndex = (index - mainKey) % CHARSET.length();
                if (newIndex < 0) {
                    newIndex += CHARSET.length(); // Ensure the index is non-negative
                }
                decrypted.append(CHARSET.charAt(newIndex));
            } else {
                // If character not in CHARSET, leave it unchanged
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        String message = "Hello123";
        int mainKey = 45; // Ensure this is a two-digit key (e.g., 10-99)

        // Encrypt the message
        String encrypted = encrypt(message, mainKey);
        System.out.println("Encrypted Message: " + encrypted);

        // Decrypt the message
        String decrypted = decrypt("4FE w E0yD0F", 84);
        System.out.println("Decrypted Message: " + decrypted);
    }
}

