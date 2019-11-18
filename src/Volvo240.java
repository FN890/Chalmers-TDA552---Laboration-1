import java.awt.*;

public class Volvo240 extends AbstractVehicle {

    /**
     * Trimfactor of car
     */
    private final static double trimFactor = 1.25;

    public Volvo240() {
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        weight = 1500;
        modelName = "Volvo240";
        xPosition = 100;
        yPosition = 100;
        direction = 0;
        stopEngine();
    }

    @Override
    double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }


}
