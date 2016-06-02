package joshua.oop.cardgame;

import java.util.ArrayList;

/**
 * @author Joshua.Jiang on 2016/6/2.
 */
public class Main {
    public static void main(String[] args) {
        int numHands = 5;

        BlackJackGameAutomator automat = new BlackJackGameAutomator(numHands);
        automat.initializeDeck();
        // 游戏开始，每人发两张牌
        boolean success = automat.dealInitial();
        if (!success) {
            System.out.println("Error. Out of cards.");
        } else {
            System.out.println("-- Initial --");
            automat.printHandsAndScore();
            ArrayList<Integer> blackjacks = automat.getBlackJacks();
            if (blackjacks.size() > 0) {
                System.out.print("Blackjack at ");
                for (int i : blackjacks) {
                    System.out.print(i + ", ");
                }
                System.out.println("");
            } else {
                success = automat.playAllHands();
                if (!success) {
                    System.out.println("Error. Out of cards.");
                } else {
                    System.out.println("\n-- Completed Game --");
                    automat.printHandsAndScore();
                    ArrayList<Integer> winners = automat.getWinners();
                    if (winners.size() > 0) {
                        System.out.print("Winners: ");
                        for (int i : winners) {
                            System.out.print(i + ", ");
                        }
                        System.out.println("");
                    } else {
                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }
}
