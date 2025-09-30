import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.event.NamingExceptionEvent;

import static org.junit.jupiter.api.Assertions.*;

class CarMapTest {
    CarMap carMap;
    @BeforeEach
    void setUp() {
        carMap = new CarHashMap();
    }
    @Test
    void getReightValue(){
        for (int i = 0; i < 100; i++){
            carMap.put(new CarOwner(i,"Name"+i,"LastName"+i), new Car("Brand"+i,i));
        }
        CarOwner carOwner = new CarOwner(10, "Name10","LastName10");
        Car car = carMap.get(carOwner);
        assertEquals(10, car.getNumber());
    }

    @Test
    void whenPut100ElementWith10DifferentKeysThenSize10(){
        for (int i = 0; i < 100; i++){
            int index = i%10;
            carMap.put(new CarOwner(index,"Name"+index,"LastName"+index), new Car("Brand"+index,index));
        }
        assertEquals(10,carMap.size());
    }
    @Test
    void removeReturnOnlyOnce(){
        for (int i = 0; i < 10; i++){
            carMap.put(new CarOwner(i,"Name"+i,"LastName"+i), new Car("Brand"+i,i));
        }
        assertEquals(10,carMap.size());
        CarOwner carOwner = new CarOwner(5,"Name5","LastName5");
        assertTrue(carMap.remove(carOwner));
        assertEquals(9,carMap.size());
        assertFalse(carMap.remove(carOwner));
        assertEquals(9,carMap.size());
    }

    @Test
    void  countOfKeysMustBeEqualsCountOfValues(){
        for (int i = 0; i < 100; i++){
            carMap.put(new CarOwner(i,"Name"+i,"LastName"+i), new Car("Brand"+i,i));
        }
        assertEquals(100,carMap.size());
        assertEquals(carMap.keySet().size(),carMap.size());
        assertEquals(carMap.keySet().size(),carMap.values().size());
    }
    @Test
    void clear(){
        for (int i = 0; i < 100; i++){
            carMap.put(new CarOwner(i,"Name"+i,"LastName"+i), new Car("Brand"+i,i));
        }
        carMap.clear();
        assertEquals(0,carMap.size());
    }
    @Test
    void size(){
        for (int i = 0; i < 100; i++){
            carMap.put(new CarOwner(i,"Name"+i,"LastName"+i), new Car("Brand"+i,i));
        }
        assertEquals(100,carMap.size());
    }

}