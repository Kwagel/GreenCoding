import java.util.Scanner;

public class ChangeCalculator {


    public static void main(String[] args) {
        // get user input of item amount and amount given
        Scanner scanner = new Scanner(System.in);
        float totalAmount = 0;

        System.out.println("Enter number of items:");
        int totalItemsCount = scanner.nextInt();

        for (int count = 0; count < totalItemsCount; count++) {
            System.out.println("Enter cost of each item purchased:");
            float itemCost = scanner.nextFloat();
            totalAmount += itemCost;
        }

        float amtGiven = 10;

        // define variables for coins
        float twoPounds = 2f;
        float onePound = 1f;
        float fiftyPence = 0.50f;
        float twentyPence = 0.20f;
        float tenPence = 0.10f;
        float fivePence = 0.05f;
        float twoPence = 0.02f;
        float onePence = 0.01f;


        float changeDue = ((float)((int)Math.round((amtGiven - totalAmount) * 100)) / 100.0f);

        int numTwoPounds = (int)((changeDue / twoPounds)); //2
        float modTwoPounds = ((float)((int) Math.round((changeDue % twoPounds) * 100)) / 100.0f);
        int numOnePound = (int)((modTwoPounds / onePound)); //1
        float modOnePound = ((float)((int)Math.round((modTwoPounds % onePound) * 100)) / 100.0f);
        int numFiftyPence = (int)((modOnePound / fiftyPence)); //1
        float modFiftyPence = ((float)((int)Math.round((modOnePound % fiftyPence) * 100)) / 100.0f);
        int numTwentyPence = (int)((modFiftyPence / twentyPence)); //1
        float modTwentyPence = ((float)((int)Math.round((modFiftyPence % twentyPence) * 100)) / 100.0f);
        int numTenPence = (int)((modTwentyPence / tenPence)); //0
        float modTenPence = ((float)((int)Math.round((modTwentyPence % tenPence) * 100)) / 100.0f);
        int numFivePence = (int)((modTenPence / fivePence));   // 1
        float modFivePence = ((float)((int)Math.round((modTenPence % fivePence) * 100)) / 100.0f);
        int numTwoPence = (int)((modFivePence / twoPence)); //2
        float modTwoPence = ((float)((int)Math.round((modFivePence % twoPence) * 100)) / 100.0f);
        int numOnePence = (int)((modTwoPence / onePence)); //0
        float modOnePence = ((float)((int)Math.round((modTwoPence % onePence) * 100)) / 100.0f);

        // return information to user
        System.out.println("\nTotal amount of change to give: " + changeDue);
        System.out.println("Number of Pound 2 to give: " + numTwoPounds);
        System.out.println("Number of Pound 1 to give: " + numOnePound);
        System.out.println("Number of 50p to give: " + numFiftyPence);
        System.out.println("Number of 20p to give: " + numTwentyPence);
        System.out.println("Number of 10p to give: " + numTenPence);
        System.out.println("Number of 5p to give: " + numFivePence);
        System.out.println("Number of 2p to give: " + numTwoPence);
        System.out.println("Number of 1p to give: " + numOnePence);

    }
}

