import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> ignoreList = new ArrayList<>(Arrays.asList(nonblockable));

        Map<String, Integer> repeatingDomains = new HashMap();


        for (int i = 0; i < mails.length; i++) {
            mails[i] = mails[i].split("@")[1];
            String domain = mails[i];

            if (repeatingDomains.containsKey(domain)) {
                int count = repeatingDomains.get(domain);
                repeatingDomains.replace(domain, ++count);
                if (count >= 5 && !ignoreList.contains(domain)) {
                    System.out.println(domain + " " + count);
                }
            } else {
                repeatingDomains.put(domain, 1);
            }
        }
    }

    static String[] nonblockable = {
            "gmail.com", "googlegroups.com", "hotmail.com", "outlook.com"};

    static String[] mails = MailsString.mails
            .split("\n\n");


}
