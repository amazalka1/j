import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private CarSet carSet;
    @BeforeEach
    void setUp(){
        for (int i =0 ;i<100;i++){
            carSet.add(new Car("Brand"+i, i));
        }
    }
    @Test
    void whenAddedElementThatElementIsOnlyOne() {
        assertEquals(100,carSet.size());
        carSet.add(new Car("Niva", 2));
        carSet.add(new Car("Niva", 2));
        carSet.add(new Car("Niva", 2));
        assertEquals(101,carSet.size());
    }

    @Test
    void whenElementRemovedThenSizeDecreased() {
        assertTrue(carSet.remove(new Car("Brand10",10)));
        assertEquals(99,carSet.size());
        assertFalse(carSet.remove(new Car("Brand10",10)));
        assertEquals(99,carSet.size());
    }
    @Test
    void whenRemoveElementNonthenNoEffect() {
        Car car = new Car("Niva", 2);
        assertFalse(carSet.remove(car));
        assertEquals(100,carSet.size());
    }

    @Test
    void clear() {
        carSet.clear();
        assertEquals(0,carSet.size());
    }
}