package week1.problem7;

import java.util.*;

public class AutocompleteSystem {

    HashMap<String,Integer> queryFrequency =
            new HashMap<>();

    public void recordSearch(String query){

        queryFrequency.put(
                query,
                queryFrequency.getOrDefault(query,0)+1
        );
    }

    public List<String> getSuggestions(String prefix){

        List<Map.Entry<String,Integer>> matches =
                new ArrayList<>();

        for(var entry : queryFrequency.entrySet()){

            if(entry.getKey().startsWith(prefix)){
                matches.add(entry);
            }
        }

        matches.sort((a,b) ->
                b.getValue()-a.getValue());

        List<String> suggestions =
                new ArrayList<>();

        int limit = Math.min(10, matches.size());

        for(int i=0;i<limit;i++){
            suggestions.add(matches.get(i).getKey());
        }

        return suggestions;
    }
}