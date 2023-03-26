package logicGates.model;

/**
 * @author Elias De Hondt
 * @since 26/03/2023
 */
public class LogicGates {
    // Methods
    public boolean AND_Gate(boolean input1, boolean input2) {
        return input1 && input2;
    }

    public boolean NAND_Gate(boolean input1, boolean input2) {
        return !(input1 && input2);
    }

    public boolean NOR_Gate(boolean input1, boolean input2) {
        return !(input1 || input2);
    }

    public boolean NOT_Gate(boolean input1) {
        return !input1;
    }

    public boolean OR_Gate(boolean input1, boolean input2) {
        return input1 || input2;
    }

    public boolean XNOR_Gate(boolean input1, boolean input2) {
        return (input1 && input2) || (!input1 && !input2);
    }

    public boolean XOR_Gate(boolean input1, boolean input2) {
        return (input1 && !input2) || (!input1 && input2);
    }

}
