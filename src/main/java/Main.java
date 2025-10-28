import java.util.*;
import java.util.function.Predicate;

public class Main {

    static class GenericValue<T> {
        private final T value;

        public GenericValue(T value) {
            this.value = value;
        }

        public void printValue() {
            if (value instanceof String) {
                System.out.println("String değer: " + value);
            } else if (value instanceof Integer) {
                System.out.println("Integer değer: " + value);
            } else {
                System.out.println("Genel değer: " + value);
            }
        }

        public T getValue() {
            return value;
        }
    }


    public static <T> Object findFirstMatch(List<T> list, Predicate<T> condition) {
        return list.stream()
                .filter(condition)
                .findFirst()
                .<Object>map(v -> v)
                .orElse(-1);
    }

    public static void main(String[] args) {

        GenericValue<String> gvStr = new GenericValue<>("Ragnar");
        GenericValue<Integer> gvInt = new GenericValue<>(42);
        GenericValue<Double> gvDbl = new GenericValue<>(3.14);

        gvStr.printValue();
        gvInt.printValue();
        gvDbl.printValue();


        List<Integer> sayilar = Arrays.asList(3, 8, 15, 22, 5);


        Object sonuc1 = findFirstMatch(sayilar, n -> n > 10);
        System.out.println("İlk eşleşen (>10): " + sonuc1);


        Object sonuc2 = findFirstMatch(sayilar, n -> n < 0);
        System.out.println("İlk eşleşen (<0): " + sonuc2);


        List<String> kelimeler = Arrays.asList("ragnar", "loki", "üzüm", "araba");
        Object sonuc3 = findFirstMatch(kelimeler, s -> s.startsWith("a"));
        System.out.println("İlk 'a*' kelime: " + sonuc3);

        Object sonuc4 = findFirstMatch(kelimeler, s -> s.length() > 10);
        System.out.println("Uzunluk >10 ilk kelime: " + sonuc4);
    }
}

