import java.util.Scanner;

public class BowlingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        BowlingGame bowlingGame = new BowlingGame();
        System.out.println("Please enter number of pins knocked down:");
        int pinsScored;
        int round = 1;
        int frame = 0;
        boolean finished = false;
        while (!finished) {
            System.out.println("Please enter number of pins knocked down:");
            pinsScored = scanner.nextInt();
            if (frame < 10) {
                if (pinsScored == 10) {
                    frame += 1;
                } else {
                    bowlingGame.roll(pinsScored);
                    System.out.println("Please enter number of pins knocked down:");
                    pinsScored = scanner.nextInt();
                    bowlingGame.roll(pinsScored);
                    frame += 1;
                }
            } else if (frame >= 10) {
                if (pinsScored == 10) {
                    round += 2;
                } else {
                    round += 6;
                }
                if (round >= 26) {
                    finished = true;
                }
            }
            
            bowlingGame.roll(pinsScored);
        }
        System.out.println(bowlingGame.getScore());
    }
    
    private int[] rolls = new int[21];
    private int currentRoll = 0;
    
    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }
    
    public int getScore() {
        int score = 0;
        int frameIndex = 0;
        
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBowlsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        
        return score;
    }
    
    private int sumOfBowlsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
    
    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
    
    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }
    
    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }
    
    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }
    
}
