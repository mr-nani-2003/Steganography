public class Main1 {
    public static void main(String[] args) {
        try {
            AesUtil.generateKey(); // Generate AES key

            String message = "Steganography!";
            String encryptedMessage = AesUtil.encrypt(message);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Hide encrypted message inside the image
            Encode.hideEncryptedText(encryptedMessage, "input.png", "output.png");

            // Extract encrypted message from the image
            String extractedEncryptedMessage = Decode.extractEncryptedText("output.png");
            System.out.println("Extracted Encrypted Message: " + extractedEncryptedMessage);

            // Decrypt the extracted message
            String decryptedMessage = AesUtil.decrypt(extractedEncryptedMessage);
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
