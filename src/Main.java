import java.lang.reflect.Type;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //Задание 1
        //Напишите метод findMinMax, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
        //
        //Данный метод принимает на вход 3 элемента:
        //
        //Stream<? extends T> stream,
        //Comparator<? super T> order,
        //BiConsumer<? super T, ? super T> minMaxConsumer
        //Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
        //
        //minMaxConsumer.accept(min, max);
        //Если стрим не содержит элементов, то вызовите:
        //
        //minMaxConsumer.accept(null, null);



        // 1. Добавим стрим из объектов класса ObjectsForComparison.


        ArrayList<Integer> listOfObjectsStream = new ArrayList<Integer>();
        listOfObjectsStream.add(1);
        listOfObjectsStream.add(3);
        listOfObjectsStream.add(2);
        listOfObjectsStream.add(6);
        listOfObjectsStream.add(8);
        listOfObjectsStream.add(1);



        // 2. Получить поток данных.
        Stream<Integer> streamOfObjects = listOfObjectsStream.stream();


        // 3. Добавили comparator

        Comparator<Integer> comparator = ((o1, o2) -> o1.compareTo(o2));


        //4. Добавим BiConsumer

        BiConsumer<Integer, Integer> biConsumer = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {

                System.out.println("Минимальное значение min " + integer + " максимальное значение " + integer2);

            }
        };

        //5. Запуск метода FindMinMax

        FindMinMax.<Integer>findMinMax(streamOfObjects, comparator, biConsumer);




        //Задание 2
        //Реализуйте метод, который принимает на вход список целых чисел и определяет количество четных и выводит их в консоль. Решать именно с применением Stream API.

        ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(8);
        listOfIntegers.add(7);
        listOfIntegers.add(8);
        listOfIntegers.add(22);
        listOfIntegers.add(16);



        //Добавим интерфейс Consumer для вывода чётных чисел через .forEach

        Consumer<Integer> checkEven = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

                int evenNumbersTotal = 0;

                if(integer % 2 == 0){

                    System.out.println(integer);
                }

            }
        };

        //Вывод чётных чисел

        listOfIntegers.stream()
                        .forEach(u -> checkEven.accept(u));

        //Вывод общего количества чётных чисел

        System.out.println(listOfIntegers.stream()
                .filter(x -> x % 2 == 0)
                .count());





    }
}