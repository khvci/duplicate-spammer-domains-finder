package Tools;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopDomainsFinder {
    public static HashSet<String> getTopThreeDomains(Set<String> emails, Set<String> whitelist) {

        return emails.stream()
                .map(email -> email.substring(email.indexOf('@') + 1))
                .filter(domain -> !whitelist.contains(domain))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(HashSet::new));
    }
}
