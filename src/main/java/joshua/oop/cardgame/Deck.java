package joshua.oop.cardgame;

import java.util.ArrayList;

/**
 * deck 代表一副整牌
 *
 * @author Joshua.Jiang on 2016/6/2.
 */
public class Deck<T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex = 0; // marks first undealt card

    public Deck() {
    }

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards = deckOfCards;
    }

    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {
            int max = cards.size() - 1 - i;
            int j = (int) (Math.random() * (max - i + 1)) + i;
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public T[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }

        T[] hand = (T[]) new Card[number];
        int count = 0;
        while (count < number) {
            T card = dealCard();
            if (card != null) {
                hand[count] = card;
                count++;
            }
        }

        return hand;
    }

    /**
     * 发牌：
     * 按照dealtIndex取牌，取完标记为失效
     *
     * @return
     */
    public T dealCard() {
        if (remainingCards() == 0) {
            return null;
        }

        T card = cards.get(dealtIndex);
        card.markUnavailable();
        dealtIndex++;

        return card;
    }

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}