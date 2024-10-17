import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tools.TopDomainsFinder;

import java.util.Set;
import java.util.HashSet;

public class TopDomainsFinderTest {

    @Test
    public void testGetTopThreeDomains_ValidCase() {
        // Given
        Set<String> emails = new HashSet<>();
        emails.add("alice@example.com");
        emails.add("bob@example.com");
        emails.add("charlie@example.org");
        emails.add("dave@example.org");
        emails.add("eve@example.net");

        Set<String> whitelist = new HashSet<>();
        whitelist.add("example.net");

        // When
        Set<String> result = TopDomainsFinder.getTopThreeDomains(emails, whitelist);

        // Then
        assertEquals(2, result.size(), "Expected 2 domains, since 'example.net' is whitelisted.");
        assertTrue(result.contains("example.com"), "Result should contain 'example.com'.");
        assertTrue(result.contains("example.org"), "Result should contain 'example.org'.");
    }

    @Test
    public void testGetTopThreeDomains_AllWhitelisted() {
        // Given
        Set<String> emails = new HashSet<>();
        emails.add("alice@example.com");
        emails.add("bob@example.org");

        Set<String> whitelist = new HashSet<>();
        whitelist.add("example.com");
        whitelist.add("example.org");

        // When
        Set<String> result = TopDomainsFinder.getTopThreeDomains(emails, whitelist);

        // Then
        assertTrue(result.isEmpty(), "Result should be empty when all domains are whitelisted.");
    }

    @Test
    public void testGetTopThreeDomains_NoWhitelistedDomains() {
        // Given
        Set<String> emails = new HashSet<>();
        emails.add("alice@example.com");
        emails.add("bob@example.com");
        emails.add("charlie@example.org");
        emails.add("dave@example.org");
        emails.add("eve@example.net");

        Set<String> whitelist = new HashSet<>(); // No whitelist

        // When
        Set<String> result = TopDomainsFinder.getTopThreeDomains(emails, whitelist);

        // Then
        assertEquals(3, result.size(), "Expected top 3 domains without any whitelisted domains.");
        assertTrue(result.contains("example.com"), "Result should contain 'example.com'.");
        assertTrue(result.contains("example.org"), "Result should contain 'example.org'.");
        assertTrue(result.contains("example.net"), "Result should contain 'example.net'.");
    }

    @Test
    public void testGetTopThreeDomains_EmptyEmailSet() {
        // Given
        Set<String> emails = new HashSet<>();
        Set<String> whitelist = new HashSet<>();

        // When
        Set<String> result = TopDomainsFinder.getTopThreeDomains(emails, whitelist);

        // Then
        assertTrue(result.isEmpty(), "Result should be empty when no emails are provided.");
    }

    @Test
    public void testGetTopThreeDomains_OnlyOneDomain() {
        // Given
        Set<String> emails = new HashSet<>();
        emails.add("alice@example.com");
        emails.add("bob@example.com");

        Set<String> whitelist = new HashSet<>();

        // When
        Set<String> result = TopDomainsFinder.getTopThreeDomains(emails, whitelist);

        // Then
        assertEquals(1, result.size(), "Only one domain should be in the result.");
        assertTrue(result.contains("example.com"), "Result should contain 'example.com'.");
    }
}
