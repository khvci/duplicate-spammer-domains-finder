import Tools.ResultPrinter;
import Tools.TopDomainsFinder;
import Tools.TxtToStringArrayConverter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String emailsTxt = "src/DomainsList.txt";
        String whitelistTxt = "src/WhitelistedDomains.txt";

        String[] emails = TxtToStringArrayConverter.convertTxtToStringArray(emailsTxt);
        String[] whitelist = TxtToStringArrayConverter.convertTxtToStringArray(whitelistTxt);

        List<String> topThreeDomains = TopDomainsFinder.getTopThreeDomains(emails, whitelist);

        ResultPrinter.printToConsole(topThreeDomains);
    }


}
