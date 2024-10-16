package Tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TxtToStringArrayConverter {


    public static String[] convertTxtToStringArray(String txtFilePathString) {
        Path txtFilePath = Paths.get(txtFilePathString);

        try {
            return Files.readString(txtFilePath).split("\\s+");
        } catch (IOException ex) {
            System.out.println(ex);
            return new String[0];
        }
    }
}
