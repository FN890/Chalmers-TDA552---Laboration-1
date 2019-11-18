import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericGarageTest {

    private final Volvo240 volvo240;
    private final Saab95 saab95;
    private final ScaniaCarCarrier scaniaCarCarrier;
    private final GenericGarage genericGarage;


    public GenericGarageTest() {

        volvo240 = new Volvo240();
        saab95 = new Saab95();
        scaniaCarCarrier = new ScaniaCarCarrier();

        genericGarage = new GenericGarage(2);

    }

    @Test
    void load() {
        assertTrue(genericGarage.load(saab95));
        assertTrue(genericGarage.load(scaniaCarCarrier));
        assertFalse(genericGarage.load(saab95));
        assertFalse(genericGarage.load(volvo240));
    }

    @Test
    void unload() {
        assertTrue(genericGarage.load(saab95));
        assertTrue(genericGarage.load(scaniaCarCarrier));;

        assertTrue(genericGarage.unload(saab95));
        assertFalse(genericGarage.unload(saab95));
        assertTrue(genericGarage.unload(scaniaCarCarrier));
        assertFalse(genericGarage.unload(volvo240));
        assertFalse(genericGarage.unload(scaniaCarCarrier));
    }
}