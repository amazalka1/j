import java.util.Arrays;

public class CarArrayList implements CarList{
      private Car[] array = new Car[10];
     private int size = 0;//это колличество элементов в массиве, а array.length - размер массива (он монжт быть не равен size).
    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        increaseArray();
        array[size] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0;i < size;i++){
            if (array[i].equals(car)){
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array,index+1,array, index, size -1- index);
        size--;
        return true;
    }

    @Override
    public void clear() {
        Car[] array = new Car[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
    private void  checkIndex(int index){
        if (index<0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
    private void  increaseArray(){
        if (size >= array.length){
            array = Arrays.copyOf(array, array.length*2);
        }
    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
        if (index<0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array,index,array,index+1,size-index);
        array[index] = car;
        size++;
    }


}
