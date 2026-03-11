package week1.problem10;

public class Main {

    public static void main(String[] args) {

        CacheSystem cache = new CacheSystem();

        cache.getVideo("video1");
        cache.getVideo("video1");
        cache.getVideo("video2");
    }
}