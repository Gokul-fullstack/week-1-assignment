package week1.problem4;

import java.util.*;

public class PlagiarismDetector {

    private DocumentStore store = new DocumentStore();

    public List<String> extractNGrams(String text, int n) {

        List<String> grams = new ArrayList<>();

        String[] words = text.split(" ");

        for (int i = 0; i <= words.length - n; i++) {

            StringBuilder gram = new StringBuilder();

            for (int j = 0; j < n; j++) {
                gram.append(words[i + j]).append(" ");
            }

            grams.add(gram.toString().trim());
        }

        return grams;
    }

    public void indexDocument(String docId, String text) {

        List<String> grams = extractNGrams(text, 5);

        for (String gram : grams) {
            store.addNGram(gram, docId);
        }
    }

    public void analyzeDocument(String docId, String text) {

        List<String> grams = extractNGrams(text, 5);

        HashMap<String,Integer> matchCount = new HashMap<>();

        for (String gram : grams) {

            Set<String> docs = store.getDocuments(gram);

            for (String d : docs) {

                if (!d.equals(docId)) {

                    matchCount.put(d, matchCount.getOrDefault(d,0)+1);
                }
            }
        }

        System.out.println("Analysis for " + docId);

        for (Map.Entry<String,Integer> entry : matchCount.entrySet()) {

            double similarity = (entry.getValue() * 100.0) / grams.size();

            System.out.println("Similar to " + entry.getKey() +
                    " → " + similarity + "%");
        }
    }
}