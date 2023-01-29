import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMinMax {





    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer){


    List<T> arrayList1;
    T min = null;
    T max = null;
    arrayList1 = stream
            .sorted(order)
            .collect(Collectors.toList());

    if(arrayList1.size() !=0) {

        min = arrayList1.get(0);
        max = arrayList1.get(arrayList1.size() - 1);

    }

    minMaxConsumer.accept(min, max);
    }




}



