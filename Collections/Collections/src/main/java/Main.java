import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0; i < 100;i++){
            numbers.add((int)(Math.random() * 10));
        }
        for(int number:numbers){
            System.out.println(number);
        }
    }
}
