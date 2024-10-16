import Tools.ResultPrinter;
import Tools.TopDomainsFinder;
import Tools.TxtToStringArrayConverter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String emailsTxt = "src/DomainsList.txt";
        String whitelistTxt = "src/WhitelistedDomains.txt";

        HashSet<String> emails = TxtToStringArrayConverter.convertTxtToStringSet(emailsTxt);
        HashSet<String> whitelist = TxtToStringArrayConverter.convertTxtToStringSet(whitelistTxt);

        HashSet<String> topThreeDomains = TopDomainsFinder.getTopThreeDomains(emails, whitelist);

        ResultPrinter.printToConsole(topThreeDomains);
    }


}
