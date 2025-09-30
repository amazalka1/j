import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap{
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public void put(CarOwner key, Car value) {
        if(size >= (array.length*LOAD_FACTOR)){
            increaseArray();
        }
        boolean put = put(key,value,array);
        if (put){
            size++;
        }

    }

    private boolean put(CarOwner key, Car value, Entry[] dst) {
        int position = getPosition(key, dst.length);
        Entry entry = dst[position];
        if (entry == null){
            entry = new Entry(key,value,null);
            dst[position] = entry;
            return true;
        } else{
            while (true){
                if (entry.key.equals(key)){
                    entry.value = value;
                    return false;
                }
                if (entry.next == null){
                    entry.next = new Entry(key,value,null);
                    return true;
                }
                entry = entry.next;
            }
        }

    }

    @Override
    public Car get(CarOwner key) {
        int position = getPosition(key, array.length);
        Entry existedElement = array[position];
        while(existedElement != null){
            if(existedElement.key.equals(key)){
                return existedElement.value;
            }
            existedElement = existedElement.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> result = new HashSet<>();
        for(Entry entry:array){
            Entry existedElement = entry;
            while(existedElement != null){
                result.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public List<Car> values() {
        List<Car> result = new ArrayList<>();
        for(Entry entry:array){
            Entry existedElement = entry;
            while(existedElement != null){
                result.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public boolean remove(CarOwner key) {
        int position = getPosition(key, array.length);
        Entry existedElement = array[position];
        if (existedElement != null && existedElement.key.equals(key)){
            array[position] = existedElement.next;
            size--;
            return true;
        } else{
            while (existedElement != null){
                Entry nextElement = existedElement.next;
                if (nextElement == null){
                    return false;
                }
                if(nextElement.key.equals(key)){
                    existedElement.next = nextElement.next;
                    size--;
                    return true;
                }
                existedElement = existedElement.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
       array = new Entry[INITIAL_CAPACITY];
       size = 0;
    }

    private int getPosition(CarOwner key, int arrayLength){
        return Math.abs(key.hashCode() % arrayLength);
    }

    private void increaseArray(){
        Entry[] newArray = new Entry[array.length*2];
        for(Entry entry:array){
            Entry existedElement = entry;
            while(existedElement != null){
                put(existedElement.key, existedElement.value,newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }

    private static class Entry{
        CarOwner key;
        Car value;
        Entry next;

        public Entry(CarOwner key, Car value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
