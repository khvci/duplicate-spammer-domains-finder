import tools.ResultPrinter;
import tools.TopDomainsFinder;
import tools.TxtToStringArrayConverter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> emails = TxtToStringArrayConverter
                .convertTxtToStringSet("src/data/DomainsList.txt");

        Set<String> whitelist = TxtToStringArrayConverter
                .convertTxtToStringSet("src/data/WhitelistedDomains.txt");

        Set<String> topThreeDomains = TopDomainsFinder
                .getTopThreeDomains(emails, whitelist);

        ResultPrinter.printToConsole(topThreeDomains);
    }


}
