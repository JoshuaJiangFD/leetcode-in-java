package joshua.oop.cardgame;

/**
 * @author Joshua.Jiang on 2016/6/2.
 */
public enum Suit {
    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);

    private int value;

    private Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        switch (value) {
            // 梅花
            case 0:
                return Suit.Club;
            // 方块
            case 1:
                return Suit.Diamond;
            // 红桃
            case 2:
                return Suit.Heart;
            // 黑桃
            case 3:
                return Suit.Spade;
            default:
                return null;
        }
    }
}
