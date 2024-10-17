package tools;

import java.util.Set;

public class ResultPrinter {
    public static void printToConsole(Set<String> topThreeDomains) {
        System.out.println("\ntop three recurring domains are:\n");
        topThreeDomains.forEach(System.out::println);
    }
}
