package Tools;

import java.util.List;

public class ResultPrinter {
    public static void printToConsole(List<String> topThreeDomains) {
        System.out.println("\ntop three recurring domains are:\n");
        topThreeDomains.forEach(System.out::println);
    }
}
