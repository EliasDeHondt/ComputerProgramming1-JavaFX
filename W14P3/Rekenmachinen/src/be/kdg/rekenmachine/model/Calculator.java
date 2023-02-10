package be.kdg.rekenmachine.model;

public class Calculator {
    private Operand operand1;
    private Operator operator;
    private Operand operand2;

    public Calculator() {
        this.clear();
    }

    public void handleInput(OperandCharacter operandCharacter) throws CalculatorException {
        if (operator == null) {
            // Add this to the first operand.
            if (this.operand1 == null) {
                this.operand1 = new Operand();
            }
            this.operand1.add(operandCharacter);
        }
        else {
            // Add this to the second operand.
            if (this.operand2 == null) {
                this.operand2 = new Operand();
            }
            this.operand2.add(operandCharacter);
        }
    }

    public void handleInput(Operator operator) throws CalculatorException {
        if (this.operand1 != null && this.operand1.isValid()) {
            this.operator = operator;
        }
        else {
            throw new CalculatorException("Can't insert operator.");
        }
    }

    public void calculate() throws CalculatorException {
        if (this.operand2 != null && this.operand2.isValid()) {
            double result;
            switch (this.operator) {
                case PLUS:
                    result = this.operand1.getDoubleValue() + this.operand2.getDoubleValue();
                    break;
                case MINUS:
                    result = this.operand1.getDoubleValue() - this.operand2.getDoubleValue();
                    break;
                case MULTIPLY:
                    result = this.operand1.getDoubleValue() * this.operand2.getDoubleValue();
                    break;
                case DIVIDE:
                    result = this.operand1.getDoubleValue() / this.operand2.getDoubleValue();
                    break;
                default:
                    throw new CalculatorException("Unsupported operator: '" + this.operator + "'.");
            }

            this.clear();
            this.operand1 = new Operand(result);
        }
        else {
            throw new CalculatorException("Can't perform calculation.");
        }
    }

    public void clear() {
        this.operand1 = null;
        this.operator = null;
        this.operand2 = null;
    }

    public String getDisplay() {
        StringBuilder sb = new StringBuilder();
        if (this.operand1 != null) {
            sb.append(this.operand1.toString());
            if (this.operator != null) {
                sb.append(' ');
                sb.append(this.operator.getChar());
                if (this.operand2 != null) {
                    sb.append(' ');
                    sb.append(this.operand2.toString());
                }
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.getDisplay();
    }
}
