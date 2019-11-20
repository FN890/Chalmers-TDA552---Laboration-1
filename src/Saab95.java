import java.awt.*;

public class Saab95 extends AbstractVehicle {

    /**
     * if the car has turbo on
     */
    private boolean turboOn;

    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        weight = 1700;
        turboOn = false;
        modelName = "Saab95";
        xPosition = 100;
        yPosition = 100;
        direction = 0;
        stopEngine();
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public boolean isTurboOn() {
        return turboOn;
    }
}
