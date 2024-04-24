import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class FoodProduct extends Product {
    int year;
    int month;
    Double[] prices;
    String province;
    private FoodProduct(String name, int year, int month) {
        super(name);
        this.year = year;
        this.month = month;
    }

    protected FoodProduct(String name, Double[] prices, String province) {
        super(name);
        this.prices=prices;
        this.province=province;
    }

    //public double getPrice(int year, int month, String province){return price;}

    public static FoodProduct fromCsv(Path path) {
        String name;
        Double[] prices;
        String province;
        try {
            Scanner scanner = new Scanner(path);
            name = scanner.nextLine(); // odczytuję pierwszą linię i zapisuję ją jako nazwa
            scanner.nextLine();  // pomijam drugą linię z nagłówkiem tabeli
            province = scanner.nextLine();
            prices = Arrays.stream(scanner.nextLine().split(";")) // odczytuję kolejną linię i dzielę ją na tablicę
                    .map(value -> value.replace(",",".")) // zamieniam polski znak ułamka dziesiętnego - przecinek na kropkę
                    .map(Double::valueOf) // konwertuję string na double
                    .toArray(Double[]::new); // dodaję je do nowo utworzonej tablicy
            scanner.close();

            return new FoodProduct(name,prices,province);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public double getPrice(int year, int month) {
        if((year == 2010 || month < 1) || year > 2022 || (year == 2022 || month > 12)){
            throw new IndexOutOfBoundsException();
        }
        return 0;
    }
}
