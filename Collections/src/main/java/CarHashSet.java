import java.sql.Array;

public class CarHashSet implements CarSet{
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;
    private Entry[] array = new Entry[INITIAL_CAPACITY];
    private static final double LOAD_FACTOR = 0.75;

    @Override
    public boolean add(Car car) {
        if (size >= array.length*LOAD_FACTOR){
            increaseArray();
        }
        boolean added = add(car, array);
        if (added){
            size++;
        }
        return added;
    }

    private boolean add(Car car, Entry[] dst){
        int position = getElementPosition(car, dst.length);
        if (dst[position] == null){
            Entry entry = new Entry(car, null);
            dst[position] =  entry;
            return true;
        }else{
            Entry existedElement = dst[position];
            while (true) {
                if (existedElement.value.equals(car)) {
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(car, null);
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
    }

    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null){
            return false;
        }else{
            Entry secondLast = array[position];
            Entry last = secondLast.next;
                if (secondLast.value.equals(car)) {
                    array[position] = last;
                    size--;
                    return true;
                }
            while(last != null) {
                if (last.value.equals(car)) {
                    secondLast.next = null;
                    size--;
                    return true;
                } else {
                    secondLast = last;
                    last = last.next;
                }

            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        array = new Entry[INITIAL_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }
    private void increaseArray(){
        Entry[] newArray = new Entry[array.length*2];
        for(Entry entry:array){
            Entry existedElement = entry;
            while (existedElement != null){
                add(existedElement.value,newArray);
                existedElement = existedElement.next;
            }
        }
        array=newArray;
    }

    private int getElementPosition(Car car, int arrayLenght){
        return Math.abs(car.hashCode() % arrayLenght);
    }

    private static class Entry{
        Car value;
        Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
