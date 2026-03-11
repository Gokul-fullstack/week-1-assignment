package week1.problem1;

import java.util.*;

public class UsernameService {

    private HashMap<String, Integer> users = new HashMap<>();
    private HashMap<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {

        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        return !users.containsKey(username);
    }

    public void registerUser(String username, int userId) {
        users.put(username, userId);
    }

    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {

            String candidate = username + i;

            if (!users.containsKey(candidate)) {
                suggestions.add(candidate);
            }
        }

        suggestions.add(username.replace("_", "."));

        return suggestions;
    }

    public String getMostAttempted() {

        String popular = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : attempts.entrySet()) {

            if (entry.getValue() > max) {
                max = entry.getValue();
                popular = entry.getKey();
            }
        }

        return popular + " (" + max + " attempts)";
    }
}