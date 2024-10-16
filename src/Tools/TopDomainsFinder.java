package Tools;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopDomainsFinder {
    public static List<String> getTopThreeDomains(String[] emails, String[] whitelist) {
        Set<String> whitelistSet = new HashSet<>(Arrays.asList(whitelist));
        return Arrays.stream(emails)
                .map(email -> email.substring(email.indexOf('@') + 1))
                .filter(domain -> !whitelistSet.contains(domain))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
