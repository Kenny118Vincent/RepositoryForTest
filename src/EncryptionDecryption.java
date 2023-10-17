import java.util.Map;
import java.util.Random;
import java.util.TreeMap;



public class EncryptionDecryption {
    private static int EncryptionKey = 12;
    private static Map<Character, Character> encryptedText = new TreeMap<>();
    private static Map<Character, Character> decryptedText = new TreeMap<>();

    public static String encrypton(String messageToEncode) {

        for (int i = 0; i < messageToEncode.length(); i++) {
            // We use a Treemap to encode, and we add an Encryption key to each character to encode. encryptedText will be use to encode and decryptedText to decode.
            encryptedText.put(messageToEncode.charAt(i), (char) (messageToEncode.charAt(i) + EncryptionKey));
            decryptedText.put((char) (messageToEncode.charAt(i) + EncryptionKey), messageToEncode.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < messageToEncode.length(); j++) {
            // We use a StringBuilder and append with the value of the Treemap "encryptedText" which is a character of the message encrypted with an encryptionKey. We obtain an EncryptedText.
            sb.append(encryptedText.get(messageToEncode.charAt(j)));
        }

        String encryptedMessage = sb.toString();
        return encryptedMessage;
    }

    public static String decryption(String messageToDecode) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < messageToDecode.length(); i++) {
            //we use the value of the TreeMap "decryptedText" to get the decryptedText.
            sb.append(decryptedText.get(messageToDecode.charAt(i)));
        }

        String decryptedMessage = sb.toString();
        return decryptedMessage;
    }



//    public static int bruteForceKeyDecoding(String messageToDecode, String message) {
//        StringBuilder sb = new StringBuilder();
//        int realKey = -1;
//        while (!messageToDecode.equals(message)) {
//            int randomKey = generateNewKey();
//            sb.setLength(0);
//            for (int i = 0; i < message.length(); i++) {
//                char encryptedChar = messageToDecode.charAt(i);
//                char decryptedChar = (char) (encryptedChar - randomKey);
//                sb.append(decryptedChar);
//            }
//            messageToDecode = sb.toString();
//            realKey = randomKey;
//        }
//        return realKey;
//    }

    public static int bruteForceKeyDecoding(String messageToDecode, String originalMessage) {
        int maxAttempts = 1000; // Limit the number of attempts to prevent an infinite loop
        for (int attempt = 0; attempt < maxAttempts; attempt++) {
            int randomKey = generateNewKey();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < messageToDecode.length(); i++) {
                char encryptedChar = messageToDecode.charAt(i);
                char decryptedChar = (char) (encryptedChar - randomKey);
                sb.append(decryptedChar);
            }
            messageToDecode = sb.toString();
            if (messageToDecode.equals(originalMessage)) {
                return randomKey; // Return the key if decryption matches the original message
            }
        }
        return -1; // Return -1 if decryption key not found within maxAttempts
    }

    public static int generateNewKey() {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(12);
        return rand_int1;

    }
}

