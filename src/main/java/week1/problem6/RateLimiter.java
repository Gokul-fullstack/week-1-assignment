package week1.problem6;

import java.util.HashMap;

public class RateLimiter {

    HashMap<String, TokenBucket> clients =
            new HashMap<>();

    int maxRequests;
    int refillRate;

    public RateLimiter(int maxRequests, int refillRate) {
        this.maxRequests = maxRequests;
        this.refillRate = refillRate;
    }

    public boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(
                clientId,
                new TokenBucket(maxRequests, refillRate)
        );

        TokenBucket bucket =
                clients.get(clientId);

        return bucket.allowRequest();
    }
}