package be.kdg.view.game;

import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import be.kdg.model.Schijf;
import be.kdg.model.SpelBord;
import be.kdg.model.VierOpRij;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GamePresenter {
    private VierOpRij model;
    private GameView view;

    public GamePresenter(VierOpRij model, GameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        MenuItem exit = view.getMiExit();
        exit.setOnAction(actionEvent -> Platform.exit());
        
        Circle[][] circles = view.getCircles();
        for (int i = 0; i < GameView.RIJEN; i++) {
            for (int j = 0; j < GameView.KOLOMMEN; j++) {
                int finalI = i, finalJ = j;
                circles[i][j].setOnMouseClicked(mouseEvent -> {
                    if(model.isGeldigeZet(finalI,finalJ)){ //zodat geen dubbele keer aan de beurt!
                        model.plaatsSchijf(finalI, finalJ);
                        updateView();
                    }
                    else{
                        System.out.println("bleh");
                    }
                });

            }
        }
    }

    private void updateView() {
        //gewijzigd bord opvragen aan model
        Schijf[][] schijfjes = model.getSpelbord();
        Circle[][] circles = view.getCircles();

        for (int i = 0; i < GameView.RIJEN; i++) {
            for (int j = 0; j < GameView.KOLOMMEN; j++) {
                if(schijfjes[i][j] == Schijf.GEEL){
                    circles[i][j].setFill(Color.YELLOW);
                } else if (schijfjes[i][j] == Schijf.ROOD) {
                    circles[i][j].setFill(Color.RED);
                } else if (schijfjes[i][j] == null) {
                    circles[i][j].setFill(Color.DARKGRAY);
                }
            }
        }

        if(model.isSpelGedaan()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Het spel is gedaan!");
            alert.setHeaderText("De winnaar is: " + model.getWinnaar());
            alert.showAndWait();
            Platform.exit();// javaFX afsluiten zodat je niet op okay clicken kan
        }
    }
}
