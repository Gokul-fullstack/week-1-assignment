package week1.problem4;

import java.util.*;

public class DocumentStore {

    HashMap<String, Set<String>> ngramIndex = new HashMap<>();

    public void addNGram(String ngram, String docId) {

        ngramIndex.putIfAbsent(ngram, new HashSet<>());
        ngramIndex.get(ngram).add(docId);
    }

    public Set<String> getDocuments(String ngram) {

        return ngramIndex.getOrDefault(ngram, new HashSet<>());
    }
}