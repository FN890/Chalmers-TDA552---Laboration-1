import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaCarCarrierTest {

    private ScaniaCarCarrier scaniaCarCarrier;
    private Volvo240 volvo240;
    private Saab95 saab95;
    private Scania scania;

    public ScaniaCarCarrierTest() {
        scaniaCarCarrier = new ScaniaCarCarrier();
        volvo240 = new Volvo240();
        saab95 = new Saab95();
        scania = new Scania();
    }

    @Test
    void addCar() {
        scaniaCarCarrier.addVehicle(scania);
        assertEquals(0, scaniaCarCarrier.getCarryList().size());
        scaniaCarCarrier.addVehicle(volvo240);
        assertEquals(0, scaniaCarCarrier.getCarryList().size());
        scaniaCarCarrier.raiseFlatbed();
        scaniaCarCarrier.addVehicle(scania);
        assertEquals(0, scaniaCarCarrier.getCarryList().size());
        scaniaCarCarrier.addVehicle(volvo240);
        assertEquals(1, scaniaCarCarrier.getCarryList().size());
        scaniaCarCarrier.addVehicle(saab95);
        assertEquals(2, scaniaCarCarrier.getCarryList().size());
    }

    @Test
    void unloadCar() {

        scaniaCarCarrier.raiseFlatbed();
        scaniaCarCarrier.addVehicle(saab95);
        scaniaCarCarrier.addVehicle(volvo240);
        scaniaCarCarrier.addVehicle(scania);
        scaniaCarCarrier.lowerFlatbed();

        scaniaCarCarrier.unloadVehicle();
        assertEquals(2, scaniaCarCarrier.getCarryList().size());

        scaniaCarCarrier.raiseFlatbed();
        scaniaCarCarrier.unloadVehicle();
        assertEquals(1, scaniaCarCarrier.getCarryList().size());
        scaniaCarCarrier.unloadVehicle();
        assertEquals(0, scaniaCarCarrier.getCarryList().size());


    }

    @Test
    void move() {

        scaniaCarCarrier.raiseFlatbed();
        scaniaCarCarrier.addVehicle(saab95);
        scaniaCarCarrier.addVehicle(volvo240);
        scaniaCarCarrier.addVehicle(scania);

        for (AbstractVehicle v : scaniaCarCarrier.getCarryList()) {
            assertEquals(scaniaCarCarrier.xPosition, v.xPosition);
            assertEquals(scaniaCarCarrier.yPosition, v.yPosition);
        }

        scaniaCarCarrier.move();

        for (AbstractVehicle v : scaniaCarCarrier.getCarryList()) {
            assertEquals(scaniaCarCarrier.xPosition, v.xPosition);
            assertEquals(scaniaCarCarrier.yPosition, v.yPosition);

        }


    }
}