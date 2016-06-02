package joshua.oop.cardgame;

import java.util.ArrayList;

/**
 * Hand表示玩家。
 *
 * @author Joshua.Jiang on 2016/6/2.
 */
public class Hand<T extends Card> {

    protected ArrayList<T> cards = new ArrayList<T>();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}
