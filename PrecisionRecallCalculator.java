import java.util.*;

public class PrecisionRecallCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter documents in Answer Set (space-separated):");
        String answerInput = scanner.nextLine();
        Set<String> answerSet = new HashSet<>(Arrays.asList(answerInput.trim().split("\\s+")));

        System.out.println("Enter Relevant Documents (space-separated):");
        String relevantInput = scanner.nextLine();
        Set<String> relevantDocs = new HashSet<>(Arrays.asList(relevantInput.trim().split("\\s+")));

        // Calculate true positives
        Set<String> truePositives = new HashSet<>(answerSet);
        truePositives.retainAll(relevantDocs);

        double precision = answerSet.isEmpty() ? 0 : (double) truePositives.size() / answerSet.size();
        double recall = relevantDocs.isEmpty() ? 0 : (double) truePositives.size() / relevantDocs.size();

        String precisionStr = String.format("%.2f", precision);
        String recallStr = String.format("%.2f", recall);

        System.out.println("Precision:\n " + precisionStr);
        System.out.println("Recall:\n " + recallStr);

        scanner.close();
    }
}

