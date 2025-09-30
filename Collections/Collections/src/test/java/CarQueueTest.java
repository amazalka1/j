import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarQueueTest {

    CarQueue carQueue;

    @BeforeEach
    void setUp() {
        carQueue = new CarLinkedList();
        for(int i =0;i<10;i++){
            carQueue.add(new Car("Brand"+i,i));
        }
    }

    @Test
    void add() {
        assertEquals(10,carQueue.size());
    }

    @Test
    void peek() {
        Car car = carQueue.peek();
        assertEquals("Brand0", car.getBrand());
        assertEquals(10,carQueue.size());
    }

    @Test
    void poll() {
        Car car = carQueue.poll();
        assertEquals("Brand0", car.getBrand());
        assertEquals(9,carQueue.size());
    }
}