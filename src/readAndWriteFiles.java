import java.io.*;

public class readAndWriteFiles {
    public static void encryptTextFromFileAndOutputIntoFile(File file, File file2) {
        try (FileReader fr = new FileReader(file);
             FileWriter fw = new FileWriter(file2)) {
            String message = String.valueOf(fr.read());



            while(fr.read() != -1) {
                String encodedMessage = EncryptionDecryption.encrypton(message);
                fw.write(encodedMessage);
                message = String.valueOf(fr.read());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void textTofile(String text, File file) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fileToText(File file) {
        String text;
        StringBuilder sb = new StringBuilder();
        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            while((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
