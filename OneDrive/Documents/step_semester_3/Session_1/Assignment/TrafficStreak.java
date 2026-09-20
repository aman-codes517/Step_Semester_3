public class TrafficStreak {

    static void findLongestStreak(String signalLog) {

        int count = 1, max = 1;
        char current = signalLog.charAt(0);
        char maxChar = current;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1))
                count++;
            else
                count = 1;

            if (count > max) {
                max = count;
                maxChar = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + maxChar +
                "' repeated " + max + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}