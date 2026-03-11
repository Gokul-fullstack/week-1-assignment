package week1.problem3;

import java.util.HashMap;
import java.util.Random;

public class DNSCache {

    private HashMap<String, DNSEntry> cache = new HashMap<>();

    private int hits = 0;
    private int misses = 0;

    public String resolve(String domain) {

        DNSEntry entry = cache.get(domain);

        if (entry != null && !entry.isExpired()) {
            hits++;
            return "Cache HIT → " + entry.ipAddress;
        }

        misses++;

        String ip = queryUpstreamDNS(domain);

        cache.put(domain, new DNSEntry(ip, 10));

        return "Cache MISS → " + ip;
    }

    private String queryUpstreamDNS(String domain) {

        Random rand = new Random();

        return "172.217.14." + rand.nextInt(255);
    }

    public void printStats() {

        int total = hits + misses;

        double hitRate = total == 0 ? 0 : (hits * 100.0 / total);

        System.out.println("Cache Hits: " + hits);
        System.out.println("Cache Misses: " + misses);
        System.out.println("Hit Rate: " + hitRate + "%");
    }
}