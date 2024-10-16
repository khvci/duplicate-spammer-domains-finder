import tools.ResultPrinter;
import tools.TopDomainsFinder;
import tools.TxtToStringArrayConverter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<String> emails = TxtToStringArrayConverter
                .convertTxtToStringSet("src/data/DomainsList.txt");

        HashSet<String> whitelist = TxtToStringArrayConverter
                .convertTxtToStringSet("src/data/WhitelistedDomains.txt");

        HashSet<String> topThreeDomains = TopDomainsFinder
                .getTopThreeDomains(emails, whitelist);

        ResultPrinter.printToConsole(topThreeDomains);
    }


}
