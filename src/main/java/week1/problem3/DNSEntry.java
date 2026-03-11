package week1.problem3;

public class DNSEntry {

    String ipAddress;
    long expiryTime;

    public DNSEntry(String ipAddress, long ttlSeconds) {
        this.ipAddress = ipAddress;
        this.expiryTime = System.currentTimeMillis() + ttlSeconds * 1000;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}