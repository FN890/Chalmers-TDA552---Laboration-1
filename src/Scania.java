import java.awt.*;

public class Scania extends AbstractVehicle {

    /**
     * Current tilt of the flatbed.
     */
    double currentTilt;
    /**
     * How much the tilt changes for every method call.
     */
    double changeTilt;
    /**
     * Max tilt for the flatbed.
     */
    double maxTilt;

    public Scania() {
        nrDoors = 2;
        color = Color.white;
        enginePower = 600;
        weight = 8000;
        modelName = "Scania";
        xPosition = 100;
        yPosition = 100;
        direction = 0;
        currentTilt = 0;
        maxTilt = 70;
        changeTilt = 5;
        stopEngine();
    }

    @Override
    public void startEngine() {
        if (isFlatbedAtMinTilt()) {
            currentSpeed = 0.1;
        }
    }

    @Override
    public void gas(double amount) {
        if (isFlatbedAtMinTilt()) {
            if (amount >= 0 && amount <= 1)
                incrementSpeed(amount);
        }
    }

    @Override
    double speedFactor() {
        return enginePower * 0.01;
    }

    /**
     * Raises the flatbed.
     */
    public void raiseFlatbed() {
        if (currentSpeed == 0) {
            if (currentTilt + changeTilt <= maxTilt) {
                currentTilt += changeTilt;
            } else if (currentTilt + currentTilt > maxTilt) {
                currentTilt = maxTilt;
            }
        }
    }

    /**
     * Lowers the flatbed.
     */
    public void lowerFlatbed() {
        if (currentSpeed == 0) {
            if (currentTilt - changeTilt >= 0) {
                currentTilt -= changeTilt;
            } else if (currentTilt - currentTilt < 0) {
                currentTilt = 0;
            }
        }
    }

    public double getCurrentTilt() {
        return currentTilt;
    }

    /**
     * @return Returns true if the flatbed is at max tilt.
     */
    public boolean isFlatbedAtMaxTilt() {
        return currentTilt == maxTilt;
    }

    /**
     * @return Returns true if the flatbed is at min tilt.
     */
    public boolean isFlatbedAtMinTilt() {
        return currentTilt == 0;
    }
}
