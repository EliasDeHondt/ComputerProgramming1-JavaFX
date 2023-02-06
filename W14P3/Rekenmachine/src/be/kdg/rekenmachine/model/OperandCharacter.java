package be.kdg.rekenmachine.model;

public enum OperandCharacter {
    ZERO('0'), ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'), DECIMAL_SEPARATOR(',');

    private final char ch;

    OperandCharacter(char ch) {
        this.ch = ch;
    }

    public char getChar() {
        return this.ch;
    }

    public boolean isDigit() {
        return this != DECIMAL_SEPARATOR;
    }
}
