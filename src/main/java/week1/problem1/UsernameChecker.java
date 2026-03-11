package week1.problem1;

public class UsernameChecker {

    public void runDemo() {

        UsernameService service = new UsernameService();

        service.registerUser("john_doe", 101);
        service.registerUser("admin", 1);

        System.out.println("john_doe available: " +
                service.checkAvailability("john_doe"));

        System.out.println("jane_smith available: " +
                service.checkAvailability("jane_smith"));

        System.out.println("Suggestions: " +
                service.suggestAlternatives("john_doe"));

        System.out.println("Most attempted: " +
                service.getMostAttempted());
    }
}