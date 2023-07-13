import java.util.*;
public class NGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        NGuessingGame methodChange = new NGuessingGame();
        methodChange.menu(scoreBoard);
    }
    public void menu(ArrayList<Integer> scoreBoard) {
        NGuessingGame methodChange = new NGuessingGame();
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("********************");
            System.out.println("Welcome to my number guessing game");
            System.out.println("1-> Play ");
            System.out.println("2-> Display Score Board");
            System.out.println("3-> Exit");
            System.out.println("********************");
            try {
                System.out.print("What would you like to do ? ");
                int menuOption = input.nextInt();
                switch (menuOption) {
                    case 1:
                        System.out.print("\n"+"set range of the numbers :  ");
                        int numberRange = input.nextInt();
                        int randomNumber = methodChange.randomNumber(numberRange);
                        methodChange.guessNumber(randomNumber);
                        break;
                    case 2:
                        methodChange.displayScoreBoard();
                        break;
                    case 3:
                        System.out.println("\n"+"Thanks for playing!");
                        System.exit(1);
                        break;
                    default:
                        throw new InputMismatchException("Invalid entry... Try again later..");
                    }
            }catch(InputMismatchException e){
                System.err.println("\n"+e.getMessage() +"\n");
                menu(scoreBoard);
            }
        }finally{
            input.close();
        }
    }
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner in = new Scanner(System.in);
        try{
            int userGuess;
            int guess = 0;
            do {
                System.out.print("Enter your guess number: ");
                userGuess = in.nextInt();
                guess++;
                if (userGuess > randomNumber) {
                    System.out.println("Low");
                } else if (userGuess < randomNumber) {
                    System.out.println("High");
                }
            } while (randomNumber != userGuess);
            System.out.println(" ");
            if (guess == 1) {
                System.out.println("You answer is right in " + guess + " try!");
            } else {
                System.out.println("You answer is right in " + guess + " tries!");
            }
            scoreBoard.add(guess);
            System.out.println(" ");

            menu(scoreBoard);
        }finally{
            in.close();
        }
    }
    public void displayScoreBoard() {
        System.out.println("********************");
        System.out.println("Score Board");
        System.out.println("********************");
        System.out.println("Your fastest games today out of all tries is: " +"\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}
