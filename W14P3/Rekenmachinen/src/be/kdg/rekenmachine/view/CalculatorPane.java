package be.kdg.rekenmachine.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculatorPane extends GridPane {
    public TextField textField = new TextField();
    public Button button0;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public Button buttonPlus;
    public Button buttonMinus;
    public Button buttonDivided;
    public Button buttonTimes;
    public Button buttonEquals;
    public Button buttonDecimalPoint;
    public Button buttonC;
    public CalculatorPane() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    public void initialiseNodes() {
        // 3.1.1 Initialiseer elke control
        this.button0 = new Button("0");
        this.button1 = new Button("1");
        this.button2 = new Button("2");
        this.button3 = new Button("3");
        this.button4 = new Button("4");
        this.button5 = new Button("5");
        this.button6 = new Button("6");
        this.button7 = new Button("7");
        this.button8 = new Button("8");
        this.button9 = new Button("9");
        this.buttonPlus = new Button("+");
        this.buttonMinus = new Button("-");
        this.buttonDivided = new Button("/");
        this.buttonTimes = new Button("*");
        this.buttonEquals = new Button("=");
        this.buttonDecimalPoint = new Button(",");
        this.buttonC = new Button("C");
        // 3.1.2 Zorg er voor dat het tekstveld niet aangepast kan worden en dat het rechts uitgelijnd is.
        this.textField.setEditable(false);
        this.textField.setAlignment(Pos.CENTER_LEFT);
    }
    public void layoutNodes() {
        this.setStyle("-fx-background-color: #4F94EF");
        // 3.2.1 Plaats elke control op de juiste plaats in de grid. Sommige componenten nemen meer dan één rij of kolom in beslag!
        // rij 0
        // column 0, row 0, column span 5, row span 1
        this.add(this.textField,0,0,5,1);
        // rij 1
        this.add(this.button7,0,1);
        this.add(this.button8,1,1);
        this.add(this.button9,2,1);
        this.add(this.buttonDivided,3,1);
        this.add(this.buttonC,4,1);
        // rij 2
        this.add(this.button4,0,2);
        this.add(this.button5,1,2);
        this.add(this.button6,2,2);
        this.add(this.buttonTimes,3,2);
        // column 4, row 2, column span 1, row span 3
        this.add(this.buttonEquals,4,2,1,3);
        // rij 3
        this.add(this.button1,0,3);
        this.add(this.button2,1,3);
        this.add(this.button3,2,3);
        this.add(this.buttonMinus,3,3);
        // rij 4
        this.add(this.button0,0,4);
        // column 1, row 4, column span 2, row span 1
        this.add(this.buttonDecimalPoint,1,4,2,1);
        this.add(this.buttonPlus,3,4);
        // 3.2.2 Elke control heeft een minimumgrootte van 35 x 35 pixels.
        this.textField.setMinWidth(35);
        this.textField.setMinHeight(35);
        this.button0.setMinWidth(35);
        this.button0.setMinHeight(35);
        this.button1.setMinWidth(35);
        this.button1.setMinHeight(35);
        this.button2.setMinWidth(35);
        this.button2.setMinHeight(35);
        this.button3.setMinWidth(35);
        this.button3.setMinHeight(35);
        this.button4.setMinWidth(35);
        this.button4.setMinHeight(35);
        this.button5.setMinWidth(35);
        this.button5.setMinHeight(35);
        this.button6.setMinWidth(35);
        this.button6.setMinHeight(35);
        this.button7.setMinWidth(35);
        this.button7.setMinHeight(35);
        this.button8.setMinWidth(35);
        this.button8.setMinHeight(35);
        this.button9.setMinWidth(35);
        this.button9.setMinHeight(35);
        this.buttonPlus.setMinWidth(35);
        this.buttonPlus.setMinHeight(35);
        this.buttonMinus.setMinWidth(35);
        this.buttonMinus.setMinHeight(35);
        this.buttonDivided.setMinWidth(35);
        this.buttonDivided.setMinHeight(35);
        this.buttonTimes.setMinWidth(35);
        this.buttonTimes.setMinHeight(35);
        this.buttonEquals.setMinWidth(35);
        this.buttonEquals.setMinHeight(35);
        this.buttonDecimalPoint.setMinWidth(35);
        this.buttonDecimalPoint.setMinHeight(35);
        this.buttonC.setMinWidth(35);
        this.buttonC.setMinHeight(35);
        // 3.2.3 Elke control heeft een maximumgrootte van Double.MAX_VALUE x Double.MAX_VALUE
        // Dit zorgt er voor dat de controls groeien tot de grootte van de cel waarin ze zitten.
        this.textField.setMaxWidth(Double.MAX_VALUE);
        this.textField.setMaxHeight(Double.MAX_VALUE);
        this.button0.setMaxWidth(Double.MAX_VALUE);
        this.button0.setMaxHeight(Double.MAX_VALUE);
        this.button1.setMaxWidth(Double.MAX_VALUE);
        this.button1.setMaxHeight(Double.MAX_VALUE);
        this.button2.setMaxWidth(Double.MAX_VALUE);
        this.button2.setMaxHeight(Double.MAX_VALUE);
        this.button3.setMaxWidth(Double.MAX_VALUE);
        this.button3.setMaxHeight(Double.MAX_VALUE);
        this.button4.setMaxWidth(Double.MAX_VALUE);
        this.button4.setMaxHeight(Double.MAX_VALUE);
        this.button5.setMaxWidth(Double.MAX_VALUE);
        this.button5.setMaxHeight(Double.MAX_VALUE);
        this.button6.setMaxWidth(Double.MAX_VALUE);
        this.button6.setMaxHeight(Double.MAX_VALUE);
        this.button7.setMaxWidth(Double.MAX_VALUE);
        this.button7.setMaxHeight(Double.MAX_VALUE);
        this.button8.setMaxWidth(Double.MAX_VALUE);
        this.button8.setMaxHeight(Double.MAX_VALUE);
        this.button9.setMaxWidth(Double.MAX_VALUE);
        this.button9.setMaxHeight(Double.MAX_VALUE);
        this.buttonPlus.setMaxWidth(Double.MAX_VALUE);
        this.buttonPlus.setMaxHeight(Double.MAX_VALUE);
        this.buttonMinus.setMaxWidth(Double.MAX_VALUE);
        this.buttonMinus.setMaxHeight(Double.MAX_VALUE);
        this.buttonDivided.setMaxWidth(Double.MAX_VALUE);
        this.buttonDivided.setMaxHeight(Double.MAX_VALUE);
        this.buttonTimes.setMaxWidth(Double.MAX_VALUE);
        this.buttonTimes.setMaxHeight(Double.MAX_VALUE);
        this.buttonEquals.setMaxWidth(Double.MAX_VALUE);
        this.buttonEquals.setMaxHeight(Double.MAX_VALUE);
        this.buttonDecimalPoint.setMaxWidth(Double.MAX_VALUE);
        this.buttonDecimalPoint.setMaxHeight(Double.MAX_VALUE);
        this.buttonC.setMaxWidth(Double.MAX_VALUE);
        this.buttonC.setMaxHeight(Double.MAX_VALUE);
        // 3.2.4 Zorg voor de nodig padding binnen de cellen. Dit doe je op grid-niveau.
        this.setPadding(new Insets(20));
        // 3.2.5 Zorg voor de nodig gaps (horizontaal en verticaal) tussen de cellen. Dit doe je eveneens op grid-niveau.
        this.setHgap(10);
        this.setVgap(10);
        // 3.2.6 Zorg er voor dat elke control ook effectief zal groeien indien de grootte zijn cel verandert.
        // ?
    }
    public TextField getTextField() { // Get..
        return this.textField;
    }
    public Button getButton0() { // Get..
        return this.button0;
    }
    public Button getButton1() { // Get..
        return this.button1;
    }
    public Button getButton2() { // Get..
        return this.button2;
    }
    public Button getButton3() { // Get..
        return this.button3;
    }
    public Button getButton4() { // Get..
        return this.button4;
    }
    public Button getButton5() { // Get..
        return this.button5;
    }
    public Button getButton6() { // Get..
        return this.button6;
    }
    public Button getButton7() { // Get..
        return this.button7;
    }
    public Button getButton8() { // Get..
        return this.button8;
    }
    public Button getButton9() { // Get..
        return this.button9;
    }
    public Button getButtonPlus() { // Get..
        return this.buttonPlus;
    }
    public Button getButtonMinus() { // Get..
        return this.buttonMinus;
    }
    public Button getButtonDivided() { // Get..
        return this.buttonDivided;
    }
    public Button getButtonTimes() { // Get..
        return this.buttonTimes;
    }
    public Button getButtonEquals() { // Get..
        return this.buttonEquals;
    }
    public Button getButtonDecimalPoint() { // Get..
        return buttonDecimalPoint;
    }
    public Button getButtonC() { // Get..
        return this.buttonC;
    }
}