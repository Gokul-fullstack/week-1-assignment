package week1.problem6;

public class TokenBucket {

    int tokens;
    int maxTokens;
    int refillRate;
    long lastRefillTime;

    public TokenBucket(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.tokens = maxTokens;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {

        refill();

        if (tokens > 0) {
            tokens--;
            return true;
        }

        return false;
    }

    private void refill() {

        long now = System.currentTimeMillis();

        long seconds =
                (now - lastRefillTime) / 1000;

        int tokensToAdd =
                (int)(seconds * refillRate);

        if (tokensToAdd > 0) {

            tokens = Math.min(maxTokens,
                    tokens + tokensToAdd);

            lastRefillTime = now;
        }
    }
}