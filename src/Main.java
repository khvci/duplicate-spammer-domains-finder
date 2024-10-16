import Tools.ResultPrinter;
import Tools.TopDomainsFinder;
import Tools.TxtToStringArrayConverter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> emails = TxtToStringArrayConverter
                .convertTxtToStringSet("src/DomainsList.txt");

        HashSet<String> whitelist = TxtToStringArrayConverter
                .convertTxtToStringSet("src/WhitelistedDomains.txt");

        HashSet<String> topThreeDomains = TopDomainsFinder
                .getTopThreeDomains(emails, whitelist);

        ResultPrinter.printToConsole(topThreeDomains);
    }


}
