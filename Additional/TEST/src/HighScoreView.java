//import be.kdg.model.GameModel;
//import javafx.geometry.Pos;
//import javafx.geometry.Side;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.image.Image;
//import javafx.scene.layout.*;
////package be.kdg.view.highscore;
//
//
///**
// * @author Elias De Hondt
// * @since 20/03/2023
// */
//
//public class HighScoreView extends BorderPane {
//    private Button verlaat;
//    private TextArea scores;
//
//
//    public HighScoreView() {
//        initialisenodes();
//        layoutNodes();
//    }
//
//
//
//    private void initialisenodes() {
//        verlaat = new Button("verlaat");
//        scores = new TextArea(" hallo");
//    }
//
//    private void layoutNodes() {
//        VBox vBox = new VBox();
//        vBox.getChildren().addAll(scores, verlaat);
//        vBox.setAlignment(Pos.CENTER);
//        setCenter(vBox);
////
////        this.setBackground(new Background(
////                new BackgroundImage(new Image("achtergrond.jpeg"),
////                        BackgroundRepeat.NO_REPEAT,
////                        BackgroundRepeat.NO_REPEAT,
////                        new BackgroundPosition(Side.LEFT, 0.0, false,
////                                Side.BOTTOM, 0.0, false),
////                        BackgroundSize.DEFAULT
////                )));
//
//    }
//
//    public Button getVerlaat() {
//        return verlaat;
//    }
//
//    public TextArea getScores() {
//        return scores;
//    }
//}
//
//public class HighScoreView {
//
//
//}
