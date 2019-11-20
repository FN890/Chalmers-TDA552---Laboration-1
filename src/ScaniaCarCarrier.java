import java.awt.*;
import java.util.ArrayList;

public class ScaniaCarCarrier extends Scania {

    /**
     * Number of cars the carrier can hold.
     */
    private final static int maxCars = 6;
    /**
     * List containing the loaded vehicles.
     */
    private final ArrayList<AbstractVehicle> carryList;

    public ScaniaCarCarrier() {
        carryList = new ArrayList<>();
        nrDoors = 2;
        color = Color.white;
        enginePower = 600;
        weight = 12000;
        modelName = "Scania";
        xPosition = 100;
        yPosition = 100;
        direction = 0;
        currentTilt = 0;
        maxTilt = 70;
        changeTilt = maxTilt;
        stopEngine();
    }

    /**
     * @param vehicle Adds a vehicle to the carrier.
     * @return
     */
    public boolean addVehicle(AbstractVehicle vehicle) {
        if (isFlatbedAtMaxTilt() && !this.equals(vehicle) && vehicle.weight <= 3000) {
            if (isWithinDistance(vehicle)) {
                if (carryList.size() < maxCars) {
                    vehicle.xPosition = xPosition;
                    vehicle.yPosition = yPosition;
                    weight += vehicle.weight;
                    carryList.add(vehicle);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return Unloads a vehicle from the carrier (First in last out) and sets coordinates for unload position.
     */
    public boolean unloadVehicle() {
        if (carryList.size() > 0 && isFlatbedAtMaxTilt()) {
            carryList.get(carryList.size() - 1).xPosition = xPosition + carryList.size();
            weight -= carryList.get(carryList.size() - 1).weight;
            carryList.remove(carryList.size() - 1);
        }
        return false;
    }

    /**
     * @param vehicle Checks if a vehicle is close enough to be added to the carrier.
     * @return
     */
    private boolean isWithinDistance(AbstractVehicle vehicle) {
        if (xPosition - vehicle.xPosition < 5 && xPosition - vehicle.xPosition >= 0) {
            return yPosition - vehicle.yPosition < 5 && yPosition - vehicle.yPosition >= 0;
        }
        return false;
    }


    @Override
    public void move() {
        super.move();
        for (AbstractVehicle v : carryList) {
            v.xPosition = xPosition;
            v.yPosition = yPosition;
        }
    }

    public ArrayList<AbstractVehicle> getCarryList() {
        return carryList;
    }
}
