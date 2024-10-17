import tools.ResultPrinter;
import tools.TopDomainsFinder;
import tools.TxtToStringSetConverter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> emails = TxtToStringSetConverter
                .convertTxtToStringSet("src/data/DomainsList.txt");

        Set<String> whitelist = TxtToStringSetConverter
                .convertTxtToStringSet("src/data/WhitelistedDomains.txt");

        Set<String> topThreeDomains = TopDomainsFinder
                .getTopThreeDomains(emails, whitelist);

        ResultPrinter.printToConsole(topThreeDomains);
    }


}
