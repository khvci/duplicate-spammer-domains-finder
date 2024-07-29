package Tools;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopDomainsFinder {
    public static List<String> getTopThreeDomains(String[] emails) {
        return Arrays.stream(emails)
                .map(email -> email.substring(email.indexOf('@') + 1))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
