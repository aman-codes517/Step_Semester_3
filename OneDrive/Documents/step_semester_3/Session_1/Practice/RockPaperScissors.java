import java.util.*;

public class RockPaperScissors {

    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] moves = {"Rock", "Paper", "Scissors"};

        int wins = 0, losses = 0, draws = 0;
        String[] player = new String[5];
        String[] computer = new String[5];
        String[] result = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Rock/Paper/Scissors: ");
            player[i] = sc.next();

            computer[i] = moves[(int)(Math.random() * 3)];
            result[i] = playRound(player[i], computer[i]);

            if (result[i].equals("Player Wins"))
                wins++;
            else if (result[i].equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("\nRound\tPlayer\tComputer\tResult");

        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + "\t" + player[i] + "\t" +
                               computer[i] + "\t\t" + result[i]);

        double percentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + percentage);
    }
}