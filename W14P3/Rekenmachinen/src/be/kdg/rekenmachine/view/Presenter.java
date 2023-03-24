package be.kdg.rekenmachine.view;

import be.kdg.rekenmachine.model.Calculator;
import be.kdg.rekenmachine.model.OperandCharacter;
import be.kdg.rekenmachine.model.Operator;
import javafx.scene.control.Alert;

public class Presenter {
    private final Calculator model;
    private final CalculatorPane view;
    public Presenter(Calculator model, CalculatorPane view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
        // 4.1.1 Zorg voor een event handler voor elke knop. Afhankelijk van de knop moet de juiste methode van Calculator opgeroepen worden met de juiste parameter:
        try { // 4.1.4 Beide handleInput methodes en de calculate methode kunnen een CalculatorException gooien indien de invoer niet ondersteund is.
            this.view.getButton0().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.ZERO);
                updateView();
            });
            this.view.getButton1().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.ONE);
                updateView();
            });
            this.view.getButton2().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.TWO);
                updateView();
            });
            this.view.getButton3().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.THREE);
                updateView();
            });
            this.view.getButton4().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.FOUR);
                updateView();
            });
            this.view.getButton5().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.FIVE);
                updateView();
            });
            this.view.getButton6().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.SIX);
                updateView();
            });
            this.view.getButton7().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.SEVEN);
                updateView();
            });
            this.view.getButton8().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.EIGHT);
                updateView();
            });
            this.view.getButton9().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.NINE);
                updateView();
            });
            this.view.getButtonPlus().setOnAction(actionEvent -> {
                this.model.handleInput(Operator.PLUS);
                updateView();
            });
            this.view.getButtonMinus().setOnAction(actionEvent -> {
                this.model.handleInput(Operator.MINUS);
                updateView();
            });
            this.view.getButtonDivided().setOnAction(actionEvent -> {
                this.model.handleInput(Operator.DIVIDE);
                updateView();
            });
            this.view.getButtonTimes().setOnAction(actionEvent -> {
                this.model.handleInput(Operator.MULTIPLY);
                updateView();
            });
            this.view.getButtonEquals().setOnAction(actionEvent -> {
                // 4.1.2 Bij het indrukken van de “=” knop moet de calculate methode opgeroepen worden.
                this.model.calculate();
                updateView();
            });
            this.view.getButtonDecimalPoint().setOnAction(actionEvent -> {
                this.model.handleInput(OperandCharacter.DECIMAL_SEPARATOR);
                updateView();
            });
            this.view.getButtonC().setOnAction(actionEvent -> {
                // 4.1.3 Bij het indrukken van de “C” knop moet de clear methode opgeroepen worden.
                this.model.clear();
                updateView();
            });
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setTitle("ERROR");
            alert.showAndWait();
        }
    }
    private void updateView() {
        // 4.2.0 Zorg er voor dat het tekstveld van de view de juiste tekst bevat. Het model heeft de nodige informatie voorhanden (methode getDisplay).
        this.view.getTextField().setText(this.model.getDisplay());
    }
}
