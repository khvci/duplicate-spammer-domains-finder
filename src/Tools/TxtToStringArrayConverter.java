package Tools;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TxtToStringArrayConverter {


    public static String[] convertTxtToStringArray(String txtFilePathString) {
        String allDomainsAsSingleString = null;
        String[] allDomainsAsStringArray = null;

        Path txtFilePath = Paths.get(txtFilePathString);

        try {
            allDomainsAsSingleString = Files.readString(txtFilePath);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        allDomainsAsStringArray = allDomainsAsSingleString.split("\\s+");

        return allDomainsAsStringArray;
    }
}
