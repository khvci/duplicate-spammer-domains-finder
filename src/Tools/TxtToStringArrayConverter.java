package Tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;

public class TxtToStringArrayConverter {


    public static HashSet<String> convertTxtToStringSet(String txtFilePathString) {
        Path txtFilePath = Paths.get(txtFilePathString);

        try {
            return new HashSet<>(Arrays.asList(Files.readString(txtFilePath).split("\\s+")));
        } catch (IOException ex) {
            System.out.println(ex);
            return new HashSet<>();
        }
    }
}
