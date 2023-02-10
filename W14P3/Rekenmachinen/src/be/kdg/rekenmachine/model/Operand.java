package be.kdg.rekenmachine.model;

public class Operand {
    private String value;

    Operand() {
        this.value = "";
    }

    Operand(double value) {
        if (value % 1.0 == 0.0) {
            this.value = String.valueOf((long) value);
        }
        else {
            final String temp = String.valueOf(value);
            this.value = temp.replaceAll("[.,]", String.valueOf(OperandCharacter.DECIMAL_SEPARATOR.getChar()));
        }
    }

    private boolean isInteger() {
        return !this.value.contains(String.valueOf(OperandCharacter.DECIMAL_SEPARATOR));
    }

    boolean isValid() {
        return !this.value.isEmpty() && !this.value.endsWith(String.valueOf(OperandCharacter.DECIMAL_SEPARATOR));
    }

    double getDoubleValue() {
        double result;
        try {
            result = Double.parseDouble(this.value);
        }
        catch (NumberFormatException ex) {
            result = Double.parseDouble(this.value.replace(OperandCharacter.DECIMAL_SEPARATOR.getChar(), '.'));
        }
        return result;
    }

    void add(OperandCharacter operandCharacter) throws CalculatorException{
        if (!operandCharacter.isDigit() && !isInteger()) {
            throw new CalculatorException("Adding a second decimal separator to a number.");
        }
        else if (!operandCharacter.isDigit() && this.value.isEmpty()) {
            this.value += OperandCharacter.ZERO.getChar();
        }

        this.value += operandCharacter.getChar();
    }

    @Override
    public String toString() {
        return value;
    }
}
