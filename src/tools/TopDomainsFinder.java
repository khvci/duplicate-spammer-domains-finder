package tools;

import java.util.*;
import java.util.stream.Collectors;

public class TopDomainsFinder {
    public static Set<String> getTopThreeDomains(Set<String> emails, Set<String> whitelist) {
        return emails.stream()
                .map(email -> email.substring(email.indexOf('@') + 1)) // Extract domain
                .filter(domain -> !whitelist.contains(domain)) // Exclude whitelisted domains
                .collect(Collectors.groupingBy(domain -> domain, Collectors.counting())) // Group by domain and count
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // Sort by count descending
                .limit(3) // Limit to top 3
                .map(Map.Entry::getKey) // Get the domain names
                .collect(Collectors.toSet()); // Collect into a Set
    }
}
