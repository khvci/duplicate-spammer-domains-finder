import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Mails repo = new Mails();

        String[] unblockable = {
                "gmail.com", "googlegroups.com", "hotmail.com", "outlook.com"};
        repo.unblockable.addAll(Arrays.asList(unblockable));

        Map<String, Integer> repeats = new HashMap();


        for (int i = 0; i < repo.mails.length; i++) {
            repo.mails[i] = repo.mails[i].split("@")[1];
            if (repeats.containsKey(repo.mails[i])) {
                repeats.replace(repo.mails[i], repeats.get(repo.mails[i]) + 1);
                if (repeats.get(repo.mails[i]) >= 3 && !repo.unblockable.contains(repo.mails[i])) {
                    System.out.println(repo.mails[i] + " " + repeats.get(repo.mails[i]));
                }

            } else {
                repeats.put(repo.mails[i], 1);
            }


        }
    }
}
