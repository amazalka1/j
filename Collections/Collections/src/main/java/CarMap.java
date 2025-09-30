import java.util.List;
import java.util.Set;

public interface CarMap {
    void put(CarOwner key, Car value);//Вставляет объеты парами:ключ, значение

    Car get(CarOwner key);//Получение значения по ключу(владельцу)

    Set<CarOwner> keySet();//Получение владельцев (не повторяются)

    List<Car> values();//Список всех значений(автомобилей).List - могут быть одинаковые автомобили

    boolean remove(CarOwner key);

    int size();

    void clear();
}