
package week1.problem5;

public class Main {

    public static void main(String[] args) {

        AnalyticsService analytics = new AnalyticsService();

        analytics.processEvent(
                new Event("/article/breaking-news",
                        "user1","google"));

        analytics.processEvent(
                new Event("/article/breaking-news",
                        "user2","facebook"));

        analytics.processEvent(
                new Event("/sports/championship",
                        "user3","direct"));

        analytics.processEvent(
                new Event("/article/breaking-news",
                        "user1","google"));

        analytics.processEvent(
                new Event("/sports/championship",
                        "user4","google"));

        analytics.showDashboard();
    }
}

