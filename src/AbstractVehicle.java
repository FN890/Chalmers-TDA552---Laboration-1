import org.w3c.dom.ls.LSOutput;

import java.awt.*;

abstract public class AbstractVehicle implements IMovable {

    /**
     * Number of doors on the vehicle.
     */
    int nrDoors;
    /**
     * Engine power of the vehicle.
     */
    double enginePower;
    /**
     * The current speed of the vehicle.
     */
    double currentSpeed;
    /**
     * Color of the vehicle.
     */
    Color color;
    /**
     * The vehicle model name
     */
    String modelName;
    /**
     * X position of vehicle.
     */
    int xPosition;
    /**
     * Y position of vehicle.
     */
    int yPosition;
    /**
     * Matrix of dx,dy directions
     */
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    /**
     * Current direction of the vehicle.
     */
    int direction;
    /**
     * Weight of vehicle (KG)
     */
    int weight;

    /**
     * Is the car already loaded.
     */
    boolean isLoaded;

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    private double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the engine
     */
    public void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Stops the engine
     */
    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * @return Returns the current speedfactor
     */
    abstract double speedFactor();


    /**
     * @param amount Factor for incrementing speed.
     */
    void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * @param amount Factor for decrementing speed.
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }


    /**
     * @param amount Gas factor, must be [0,1]
     */
    public boolean gas(double amount) {
        if (amount >= 0 && amount <= 1 && !isLoaded) {
            incrementSpeed(amount);
            return true;
        }
        return false;
    }

    /**
     * @param amount Brake factor, must be [0,1]
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }


    @Override
    public void move() {
        switch (direction) {
            case 0:
                xPosition++;
                break;
            case 1:
                yPosition++;
                break;
            case 2:
                xPosition--;
                break;
            case 3:
                yPosition--;
                break;
        }
    }


    @Override
    public void turnLeft() {
        direction = ((((direction - 1) % 4) + 4) % 4);
    }


    @Override
    public void turnRight() {
        direction = (direction + 1) % directions.length;
    }
}
