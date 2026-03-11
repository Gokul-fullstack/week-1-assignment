package week1.problem10;

import java.util.*;

public class CacheSystem {

    LinkedHashMap<String, Video> L1 =
            new LinkedHashMap<>(16,0.75f,true);

    HashMap<String, Video> L2 =
            new HashMap<>();

    HashMap<String, Video> database =
            new HashMap<>();

    public CacheSystem(){

        database.put("video1",
                new Video("video1","Movie A"));

        database.put("video2",
                new Video("video2","Movie B"));
    }

    public Video getVideo(String id){

        if(L1.containsKey(id)){
            System.out.println("L1 Cache HIT");
            return L1.get(id);
        }

        if(L2.containsKey(id)){
            System.out.println("L2 Cache HIT");

            Video v = L2.get(id);

            L1.put(id,v);

            return v;
        }

        System.out.println("Database HIT");

        Video v = database.get(id);

        if(v!=null)
            L2.put(id,v);

        return v;
    }
}