package week1.problem5;

import java.util.*;

public class AnalyticsService {

    HashMap<String,Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    HashMap<String,Integer> trafficSources = new HashMap<>();

    public void processEvent(Event event){

        pageViews.put(event.url,
                pageViews.getOrDefault(event.url,0)+1);

        uniqueVisitors.putIfAbsent(event.url,new HashSet<>());
        uniqueVisitors.get(event.url).add(event.userId);

        trafficSources.put(event.source,
                trafficSources.getOrDefault(event.source,0)+1);
    }

    public void showDashboard(){

        System.out.println("Top Pages:");

        pageViews.entrySet()
                .stream()
                .sorted((a,b)->b.getValue()-a.getValue())
                .limit(10)
                .forEach(e -> {

                    int unique = uniqueVisitors.get(e.getKey()).size();

                    System.out.println(
                            e.getKey()+" - "+e.getValue()+
                                    " views ("+unique+" unique)"
                    );
                });

        System.out.println("\nTraffic Sources:");

        int total = trafficSources.values()
                .stream().mapToInt(i->i).sum();

        for(var entry : trafficSources.entrySet()){

            double percent =
                    (entry.getValue()*100.0)/total;

            System.out.println(
                    entry.getKey()+" : "+percent+"%"
            );
        }
    }
}