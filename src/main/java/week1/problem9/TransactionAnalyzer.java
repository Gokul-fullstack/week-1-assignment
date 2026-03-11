package week1.problem9;

import java.util.*;

public class TransactionAnalyzer {

    public void findTwoSum(List<Transaction> transactions, int target){

        HashMap<Integer, Transaction> map = new HashMap<>();

        for(Transaction t : transactions){

            int complement = target - t.amount;

            if(map.containsKey(complement)){

                Transaction other = map.get(complement);

                System.out.println(
                        "Match found: "
                                + other.amount + " + "
                                + t.amount + " = " + target
                );
            }

            map.put(t.amount, t);
        }
    }
}