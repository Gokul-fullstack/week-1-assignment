package week1.problem9;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Transaction> list = new ArrayList<>();

        list.add(new Transaction(1,500));
        list.add(new Transaction(2,300));
        list.add(new Transaction(3,200));

        TransactionAnalyzer analyzer =
                new TransactionAnalyzer();

        analyzer.findTwoSum(list,500);
    }
}