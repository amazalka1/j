import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {
    CarCollection carCollection;
    @BeforeEach
    void setUp() {
        carCollection = new CarLinkedList();
        for (int i = 0; i<100;i++){
            carCollection.add(new Car("Brand"+i,i));
        }
    }

    @Test
    void ifArrayContainsedElementRetutnedTrueOrFalse(){
        assertTrue(carCollection.contains(new Car("Brand10",10)));
        assertFalse(carCollection.contains(new Car("BMW",10)));
    }
    @Test
    void testForeach(){
        int index = 0;
        for (Car car: carCollection){
            index++;
        }
        assertEquals(100,index);
    }
}