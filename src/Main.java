import java.io.*;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        File input = new File("D:\\Kenny\\RepositoryForTest-Kenny\\src\\TextToEncrypt");
        File output = new File("D:\\Kenny\\RepositoryForTest-Kenny\\src\\EncryptedText");

        System.out.println("Hello user what is your name ?");

        String name = sc.nextLine();
        System.out.println("What do you wish to do " + name + "?" + "\n1. You can either encrypt a text and find it in the file \"Encrypted Text\" by selecting 1°) or" +
                "\n2. You can find out about the encryption Key by selecting 2°)");


        int optionChosen = sc.nextInt();
        switch (optionChosen) {
            case 1:
                System.out.println("Hello " + name + " this is a program to encrypt text.\nWhat is the text that you wish to encrypt?");
                sc.nextLine();
                String textToEncrypt = sc.nextLine();
                //We put the text into the file thanks to a function I created in the class readAndWriteFiles
                readAndWriteFiles.textTofile(textToEncrypt, input);
                // we encrypt the text and put the text to the file "Encrypted text" Thanks to a function
                readAndWriteFiles.encryptTextFromFileAndOutputIntoFile(input, output);
                String encryptedText =  readAndWriteFiles.fileToText(output);
                System.out.println("Your text:- \"" + textToEncrypt + "\"\nhas been succesfully encrypted into \"EncryptedText\". Go the the file to verify. \nEncrypted text:- " + encryptedText);
                break;
            case 2:
                System.out.println("First we need a text to encrypt to find out about the encryption Key. Please give me a text");

                String text = sc.nextLine();
                sc.next();
                //We put the text into the file thanks to a function I created in the class readAndWriteFiles
                readAndWriteFiles.textTofile(text, input);
                // we encrypt the text and put the text to the file "Encrypted text" Thanks to a function
                readAndWriteFiles.encryptTextFromFileAndOutputIntoFile(input, output);
                String message = text;
                String messageToDecode = readAndWriteFiles.fileToText(output);
                // we use the function bruteForceKeyDecoding to find a key.
                int encryptionKey = EncryptionDecryption.bruteForceKeyDecoding(messageToDecode, message);
                System.out.println("This is the encryption Key : " + encryptionKey);

                break;
        }
        System.out.println("Thanks for using our program. GoodBye");


//        try (FileReader fr = new FileReader(input);
//             FileWriter fw = new FileWriter(output)) {
//            String message = String.valueOf(fr.read());
//
//
//
//            while(fr.read() != -1) {
//                String encodedMessage = EncryptionDecryption.encrypton(message);
//                fw.write(encodedMessage);
//                message = String.valueOf(fr.read());
//            }
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//    }
//        String message = "I love Java";
//        String encodedMessage = EncryptionDecryption.encrypton(message);
//        String decodedMessage = EncryptionDecryption.decryption(encodedMessage);
//        System.out.println(message);
//        System.out.println(encodedMessage);
//        System.out.println(decodedMessage);
//
//        System.out.println(EncryptionDecryption.bruteForceKeyDecoding(encodedMessage, message));
    }
}
