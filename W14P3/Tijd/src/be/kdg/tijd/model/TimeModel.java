package be.kdg.tijd.model;

import java.time.Duration;
import java.time.LocalTime;

public class TimeModel {
    private LocalTime currentTime;

    // Sunrise and sunset are exaggerated (unless you're close to the North/South Pole).
    public static final LocalTime DAWN = LocalTime.of(7, 0);
    public static final LocalTime SUNRISE = LocalTime.of(10, 0);
    public static final LocalTime NOON = LocalTime.of(12, 30);
    public static final LocalTime SUNSET = LocalTime.of(15, 0);
    public static final LocalTime DUSK = LocalTime.of(18, 0);

    public TimeModel() {
        this.currentTime = LocalTime.of(6, 0);
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Geeft een getal terug van 0.0 tot 1.0. 's Nachts wordt 0.0 teruggegeven en overdag wordt 1.0 teruggegeven.
     * Tussen dag en nacht (wanneer het schemert) wordt een waarde tussen 0.0 en 1.0 teruggegeven.
     */
    public double getDaylightPercentage() {
        if (currentTime.isBefore(TimeModel.DAWN) || currentTime.isAfter(TimeModel.DUSK)) {
            return 0.0;
        }
        else if (currentTime.isBefore(TimeModel.SUNRISE)) {
            final long twilightDurationMinutes = Duration.between(TimeModel.DAWN, TimeModel.SUNRISE).toMinutes();
            final long minutesFromDawn = Duration.between(TimeModel.DAWN, currentTime).toMinutes();
            return (double)minutesFromDawn / twilightDurationMinutes;
        }
        else if (currentTime.isAfter(TimeModel.SUNSET)) {
            final long twilightDurationMinutes = Duration.between(TimeModel.SUNSET, TimeModel.DUSK).toMinutes();
            final long minutesFromSunset = Duration.between(TimeModel.SUNSET, currentTime).toMinutes();
            return 1.0 - (double)minutesFromSunset / twilightDurationMinutes;
        }
        else {
            return 1.0;
        }
    }

    /**
     * Geeft een getal terug tussen 0.0 en 1.0. Als de zon onder de horizon is, en dus onzichtbaar is, dan wordt 0.0 teruggegeven.
     * Als de zon op haar hoogste punt staat (noon) dan wordt 1.0 teruggeven. Op andere tijdstippen overdag wordt een waarde tussen
     * 0.0 en 1.0 teruggegeven.
     */
    public double getSunHeight() {
        if (currentTime.isAfter(TimeModel.SUNRISE) && currentTime.isBefore(TimeModel.SUNSET)) {
            final long differenceSunriseNoonMinutes = Duration.between(TimeModel.SUNRISE, TimeModel.NOON).toMinutes();
            final long minutesFromSunrise = Duration.between(TimeModel.SUNRISE, currentTime).toMinutes();
            final double cornerDegrees = 90.0 - (90.0 * (differenceSunriseNoonMinutes - minutesFromSunrise)) / differenceSunriseNoonMinutes;
            return Math.sin(Math.toRadians(Math.abs(cornerDegrees)));
        }
        else {
            return 0.0;
        }
    }

    /**
     * Geeft een getal terug tussen -1.0 en 1.0 dat aangeeft op welke plaats (tussen oost en west) de zon zich bevindt.
     * Als de zon helemaal in het oosten staat dan wordt 1.0 teruggegeven. Staat de zon in het westen dan wordt -1.0 teruggegeven.
     */
    public double getSunPositionX() {
        final long differenceSunriseNoonMinutes = Duration.between(TimeModel.SUNRISE, TimeModel.NOON).toMinutes();
        final long minutesFromSunrise = Duration.between(TimeModel.SUNRISE, currentTime).toMinutes();
        final double cornerDegrees = 90.0 - (90.0 * (differenceSunriseNoonMinutes - minutesFromSunrise)) / differenceSunriseNoonMinutes;
        return Math.cos(Math.toRadians(cornerDegrees));
    }
}
