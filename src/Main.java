import Tools.ResultPrinter;
import Tools.TopDomainsFinder;
import Tools.TxtToStringArrayConverter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String txtFilePath = "src/DomainsList.txt";

        String[] emails = TxtToStringArrayConverter.convertTxtToStringArray(txtFilePath);

        List<String> topThreeDomains = TopDomainsFinder.getTopThreeDomains(emails);

        ResultPrinter.printToConsole(topThreeDomains);
    }


}
