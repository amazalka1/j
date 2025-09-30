import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CarListTest {
    private CarList carList;
    @BeforeEach
    void setUp() {
        carList = new CarLinkedList();
        for (int i =0 ;i<100;i++){
            carList.add(new Car("Brand"+i, i));
        }
    }

    @Test
    public void whenAdded100ElementsSize100(){
        assertEquals(100,carList.size());
    }

    @Test
    public void whenClearCountOfElementsMustBe0(){
        carList.clear();
        assertEquals(0,carList.size());
    }

    @Test
    public void whenClearElementCountMustBeChanged(){
        assertTrue(carList.remove(new Car("Brand10", 10)));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenClearIndexElementCountMustBeChanged(){
        assertTrue(carList.removeAt(6));
        assertEquals(99,carList.size());
    }

    @Test
    public void whenClearNanElementCountMustBeChanged(){
        Car car = new Car("Niva",4);
        assertFalse(carList.remove(car));
        assertEquals(100,carList.size());
    }

    @Test
    public void whenGetElementMustBeRight(){
        assertThrows(IndexOutOfBoundsException.class, () -> {carList.get(100);} );
    }

    @Test
    public void whenGetElementMustBeRighthj(){
        assertThrows(IndexOutOfBoundsException.class, () -> {carList.removeAt(100);} );
    }

    @Test
    public void whenReturnedElementMustBeRight(){
        Car car = carList.get(0);
        assertEquals(0,car.getNumber());
    }

    @Test
    public void InsertIntoMiddle(){
        Car car = new Car("BMW",1);
        carList.add(car,50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void InsertIntoStart(){
        Car car = new Car("BMW",1);
        carList.add(car,0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void InsertIntoEnd(){
        Car car = new Car("BMW",1);
        carList.add(car,100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }

}