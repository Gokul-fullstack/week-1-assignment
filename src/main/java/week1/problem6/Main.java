package week1.problem6;

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        RateLimiter limiter =
                new RateLimiter(5,1);

        String client = "clientA";

        for(int i=1;i<=7;i++){

            boolean allowed =
                    limiter.checkRateLimit(client);

            System.out.println(
                    "Request "+i+" → "+
                            (allowed?"Allowed":"Denied")
            );
        }
    }
}