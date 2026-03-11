package week1.problem7;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AutocompleteSystem system =
                new AutocompleteSystem();

        system.recordSearch("java tutorial");
        system.recordSearch("javascript guide");
        system.recordSearch("java tutorial");
        system.recordSearch("java download");
        system.recordSearch("java tutorial");

        List<String> suggestions =
                system.getSuggestions("jav");

        System.out.println("Suggestions:");
        for(String s : suggestions){
            System.out.println(s);
        }
    }
}