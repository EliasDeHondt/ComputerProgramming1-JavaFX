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
import model.SerialArduinoConnection;

public class AlienAttackPresenter implements SerialPortDataListener {
    // Attributes
    private final SerialArduinoConnection model;
    private final AlienAttackView view;

    // Constructors
    public AlienAttackPresenter(SerialArduinoConnection model, AlienAttackView view) {
        this.model = model;
        this.view = view;
        model.addDatalistener(this);
        //
    }

    // Methods
    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread());
        if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) return;

        StringBuilder text = new StringBuilder();
        for (byte oneByte : this.model.receiveBytes()) {
            text.append((char) oneByte);
        }

        Platform.runLater(() -> System.out.println(text.toString()));
    }
}
