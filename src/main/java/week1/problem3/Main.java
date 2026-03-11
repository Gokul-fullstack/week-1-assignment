package week1.problem3;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        DNSCache cache = new DNSCache();

        System.out.println(cache.resolve("google.com"));
        System.out.println(cache.resolve("google.com"));
        System.out.println(cache.resolve("openai.com"));

        Thread.sleep(11000);

        System.out.println(cache.resolve("google.com"));

        cache.printStats();
    }
}