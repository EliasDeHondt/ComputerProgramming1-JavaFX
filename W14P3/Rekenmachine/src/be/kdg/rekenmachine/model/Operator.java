package be.kdg.rekenmachine.model;

public enum Operator {
    PLUS('+'), MINUS('-'), DIVIDE('÷'), MULTIPLY('x');

    private final char ch;

    Operator(char ch) {
        this.ch = ch;
    }

    public char getChar() {
        return this.ch;
    }
}
