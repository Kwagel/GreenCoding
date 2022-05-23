import java.util.Scanner;

public class ChangeCalculator {
    
    
    public static void main(String[] args) {
        // get user input of item amount and amount given
        Scanner scanner = new Scanner(System.in);
        double totalAmount = 0;
        boolean exit = false;
        do {
            System.out.print("Enter total value of an item or enter any letter to calculate change: ");
            try {
                double amount = scanner.nextDouble();
                totalAmount += amount;
            } catch (Exception e) {
                exit = true;
            }
            
        } while (!exit);

//        System.out.print("Enter the amount given to the cashier: ");
//        double amtGiven = myScanner.nextDouble();
        double amtGiven = 10;
        
        // define variables for coins
        double fiftyPence = 0.50;
        double twentyPence = 0.20;
        double tenPence = 0.10;
        double fivePence = 0.05;
        double twoPence = 0.02;
        double onePence = 0.01;
        
        // round changeDue to 2 decimal places and calculate the modulus in a hierarchy
        double changeDue = ((double) ((int) Math.round((amtGiven - totalAmount) * 100)) / 100.0);
        double modFiftyPence = ((double) ((int) Math.round((changeDue % fiftyPence) * 100)) / 100.0);
        double modTwentyPence = ((double) ((int) Math.round((modFiftyPence % twentyPence) * 100)) / 100.0);
        double modTenPence = ((double) ((int) Math.round((modFiftyPence % tenPence) * 100)) / 100.0);
        double modFivePence = ((double) ((int) Math.round((modFiftyPence % fivePence) * 100)) / 100.0);
        double modTwoPence = ((double) ((int) Math.round((modFiftyPence % twoPence) * 100)) / 100.0);
        double modOnePence = ((double) ((int) Math.round((modFiftyPence % onePence) * 100)) / 100.0);
        
        // count number of coins
        int numFiftyPence = (int) ((changeDue - modFiftyPence) / (fiftyPence));
        int numTwentyPence = (int) ((modFiftyPence - modTwentyPence) / (twentyPence));
        int numTenPence = (int) ((modTwentyPence - modTenPence) / (tenPence));
        int numFivePence = (int) ((modTenPence - modOnePence) / (fivePence));
        int numTwoPence = (int) ((modFivePence - modOnePence) / (twoPence));
        int numOnePence = (int) ((modTwoPence - modOnePence) / (onePence));
        
        // return information to user
        System.out.println("\nTotal amount of change to give: " + changeDue);
        System.out.println("Number of 50p to give: " + numFiftyPence);
        System.out.println("Number of 20p to give: " + numTwentyPence);
        System.out.println("Number of 10p to give: " + numTenPence);
        System.out.println("Number of 5p to give: " + numFivePence);
        System.out.println("Number of 2p to give: " + numTwoPence);
        System.out.println("Number of 1p to give: " + numOnePence);
        
    }
    
}
