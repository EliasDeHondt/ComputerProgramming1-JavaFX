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
    }

    public void resetSegment() {
        this.view.getGridPane().getChildren().clear();
        // Display 1
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[0], 1, 0); // Segment A
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[0], 0, 1); // Segment F
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[1], 2, 1); // Segment B
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[1], 1, 2); // Segment G
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[2], 0, 3); // Segment E
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[3], 2, 3); // Segment C
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[2], 1, 4); // Segment D

        // Display 2
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[3], 4, 0); // Segment A
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[4], 3, 1); // Segment F
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[5], 5, 1); // Segment B
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[4], 4, 2); // Segment G
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[6], 3, 3); // Segment E
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[7], 5, 3); // Segment C
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[5], 4, 4); // Segment D

        // Display 3
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[6], 7, 0); // Segment A
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[8], 6, 1); // Segment F
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[9], 8, 1); // Segment B
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[7], 7, 2); // Segment G
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[10], 6, 3); // Segment E
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[11], 8, 3); // Segment C
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[8], 7, 4); // Segment D

        // Display 4
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[9], 10, 0); // Segment A
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[12], 9, 1); // Segment F
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[13], 11, 1); // Segment B
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[10], 10, 2); // Segment G
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[14], 9, 3); // Segment E
        this.view.getGridPane().add(this.view.getSegmentOffVertical()[15], 11, 3); // Segment C
        this.view.getGridPane().add(this.view.getSegmentOffHorizontal()[11], 10, 4); // Segment D
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

        StringBuilder arduinoData = new StringBuilder();
        for (byte oneByte : this.model.receiveBytes()) {
            arduinoData.append((char) oneByte);
        }



        Platform.runLater(() -> {
            System.out.println(arduinoData.toString());

            if (arduinoData.substring(0, "JavaData".length()).equals("JavaData")) {
                // Haal de waarden van de attributen op
                String numbersSubstring = arduinoData.substring("JavaData ".length());
                int computer_Pawn = Integer.parseInt(numbersSubstring.substring(0, 1));
                int player_Pawn = Integer.parseInt(numbersSubstring.substring(1, 2));
                int teller = Integer.parseInt(numbersSubstring.substring(2, 3));
                int down = Integer.parseInt(numbersSubstring.substring(3, 4));

                this.resetSegment(); // All Segment Off

                if (player_Pawn == 0) {
                    this.view.getGridPane().getChildren().remove(1, 4);
                    this.view.getGridPane().add(this.view.getSegmentOnHorizontal()[2], 1, 4); // Segment D
                }
                else if (player_Pawn == 1) {
                    this.view.getGridPane().getChildren().remove(4, 4);
                    this.view.getGridPane().add(this.view.getSegmentOnHorizontal()[5], 4, 4); // Segment D
                }
                else if (player_Pawn == 2) {
                    this.view.getGridPane().getChildren().remove(7, 4);
                    this.view.getGridPane().add(this.view.getSegmentOnHorizontal()[8], 7, 4); // Segment D
                }
                else if (player_Pawn == 3) {
                    this.view.getGridPane().getChildren().remove(10, 4);
                    this.view.getGridPane().add(this.view.getSegmentOnHorizontal()[11], 10, 4); // Segment D
                }

            }

        });
    }
}
