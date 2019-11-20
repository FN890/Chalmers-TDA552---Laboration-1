import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericGarageTest {

    private final Volvo240 volvo240;
    private final Saab95 saab95;
    private final Saab95 secondSaab95;
    private final ScaniaCarCarrier scaniaCarCarrier;
    private final GenericGarage secondGenericGarage;
    private final GenericGarage genericGarage;


    public GenericGarageTest() {

        volvo240 = new Volvo240();
        saab95 = new Saab95();
        secondSaab95 = new Saab95();
        scaniaCarCarrier = new ScaniaCarCarrier();

        genericGarage = new GenericGarage(3);
        secondGenericGarage = new GenericGarage(5);

    }

    @Test
    void load() {
        assertTrue(genericGarage.load(saab95));
        assertTrue(genericGarage.load(scaniaCarCarrier));
        assertFalse(genericGarage.load(saab95));
        assertTrue(genericGarage.load(secondSaab95));
        assertFalse(genericGarage.load(volvo240));
    }

    @Test
    void unload() {
        assertTrue(secondGenericGarage.load(saab95));
        assertTrue(secondGenericGarage.load(scaniaCarCarrier));
        ;

        assertTrue(secondGenericGarage.unload(saab95));
        assertFalse(secondGenericGarage.unload(saab95));
        assertTrue(secondGenericGarage.unload(scaniaCarCarrier));
        assertFalse(secondGenericGarage.unload(volvo240));
        assertFalse(secondGenericGarage.unload(scaniaCarCarrier));
    }
}