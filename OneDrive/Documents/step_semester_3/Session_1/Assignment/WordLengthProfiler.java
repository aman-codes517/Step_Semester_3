public class WordLengthProfiler {

    static void classifyWordLengths(String review) {

        int shortWord = 0, medium = 0, longWord = 0;

        String[] words = review.split(" ");

        for (String word : words) {

            int length = word.length();

            if (length <= 4)
                shortWord++;
            else if (length <= 8)
                medium++;
            else
                longWord++;
        }

        System.out.println("Short: " + shortWord);
        System.out.println("Medium: " + medium);
        System.out.println("Long: " + longWord);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review);
    }
}