import java.util.Scanner;

public class BowlingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        BowlingGame bowlingGame = new BowlingGame();
        int pinsScored;
        int round = 1;
        int frame = 1;
        int check10thFrame = 0;
        boolean finished = false;
        while (!finished) {
            System.out.println("Frame " + frame + ":Please enter number of pins knocked down:");
            pinsScored = scanner.nextInt();
            if (frame < 10) {
                if (pinsScored == 10) {
                    frame += 1;
                } else {
                    bowlingGame.roll(pinsScored);
                    System.out.println("Frame " + frame + ":Please enter number of pins knocked down:");
                    pinsScored = scanner.nextInt();
                    frame += 1;
                }
            } else if (frame >= 10) {
                if (pinsScored == 10) {
                    frame += 1;
                } else {
                    bowlingGame.roll(pinsScored);
                    check10thFrame += pinsScored;
                    System.out.println("Frame " + frame + ":Please enter number of pins knocked down:");
                    pinsScored = scanner.nextInt();
                    check10thFrame += pinsScored;
                    
                    if (check10thFrame == 10) {
                        bowlingGame.roll(pinsScored);
                        System.out.println("Frame " + frame + ":Please enter number of pins knocked down:");
                    }
                    frame += 3;
                }
                if (frame >= 13) {
                    finished = true;
                }
            }
            
            bowlingGame.roll(pinsScored);
        }
        System.out.println(bowlingGame.getScore());
    }
    
    private int[] rolls = new int[30];
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
//                System.out.println("Strike:" + score);
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
//                System.out.println("Spare:" +score);
            } else {
                score += sumOfBowlsInFrame(frameIndex);
                frameIndex += 2;
//                System.out.println("Normal:" +score);
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
