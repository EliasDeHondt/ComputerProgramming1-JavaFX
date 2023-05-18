/**
 * @author Elias De Hondt
 * @see https://eliasdh.com
 * @since 09/05/2023
 */

package view;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.SerialArduinoConnection;
import view.ArduinoView;

public class ArduinoPresenter implements SerialPortDataListener {
    private SerialArduinoConnection model;
    private ArduinoView view;

    public ArduinoPresenter(SerialArduinoConnection model, ArduinoView view) {
        this.model = model;
        this.view = view;
        addEventListeners();
        model.addDatalistener(this);
    }

    private void addEventListeners() {
        view.getBtnSend().setOnAction(actionEvent -> {
            System.out.println(Thread.currentThread());
            view.getTfTextFromArduino().setText("");
            model.sendString(view.getTfTextForArduino().getText());
        });
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        System.out.println(Thread.currentThread());
        if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
            return;
        }
        StringBuilder text = new StringBuilder(view.getTfTextFromArduino().getText());
        for (byte oneByte : model.receiveBytes()) {
            text.append((char) oneByte);
        }
        //De methode serialEvent wordt vanop een andere Thread aangeroepen (asynchroon)
        //Omdat het aanpassen van de UI enkel mag op de JavaFX Application Thread
        //gebruiken we Platform.runLater. Threads wordt behandeld in de leerstof java van het tweede jaar!
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                view.getTfTextFromArduino().setText(text.toString());
            }
        });
    }
}
