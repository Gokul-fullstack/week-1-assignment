package week1.problem4;

public class Main {

    public static void main(String[] args) {

        PlagiarismDetector detector = new PlagiarismDetector();

        String essay1 =
                "machine learning improves prediction models in many systems";

        String essay2 =
                "machine learning improves prediction models in modern software";

        detector.indexDocument("essay1", essay1);

        detector.analyzeDocument("essay2", essay2);
    }
}


