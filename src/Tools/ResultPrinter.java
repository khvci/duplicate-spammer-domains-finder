package Tools;

import java.util.HashSet;

public class ResultPrinter {
    public static void printToConsole(HashSet<String> topThreeDomains) {
        System.out.println("\ntop three recurring domains are:\n");
        topThreeDomains.forEach(System.out::println);
    }
}
