import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {
    private CarSet carSet;
    @BeforeEach
    void setUp(){
        carSet = new CarHashSet();
        for(int i = 0;i<100;i++){
            Car car = new Car("Brand"+i,i);
            carSet.add(car);
        }
    }

    @Test
    void whenAddedMultipleElementAddedOnlyOne(){
        assertEquals(100,carSet.size());
        assertTrue(carSet.add(new Car("Niva",10)));
        assertFalse(carSet.add(new Car("Niva",10)));
        assertFalse(carSet.add(new Car("Niva",10)));
        assertEquals(101,carSet.size());
    }
    @Test
    void whenRemovedElementSizeMustBeChanged(){
        assertEquals(100,carSet.size());
        assertTrue( carSet.remove(new Car("Brand10",10)));
        assertEquals(99,carSet.size());
        assertFalse(carSet.remove(new Car("Brand10",10)));
        assertEquals(99,carSet.size());
    }
    @Test
    void whenClearCountOfElementsMustBe0(){
        carSet.clear();
        assertEquals(0,carSet.size());
    }
    @Test
    void sizeArrayMustBe100(){
        assertEquals(100,carSet.size());
    }
    @Test
    void testForeach(){
        int index = 0;
        for (Car car: carSet){
            index++;
        }
        assertEquals(100,index);
    }
}