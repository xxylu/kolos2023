import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        NonFoodProduct obj = NonFoodProduct.fromCsv(Path.of("./data/nonfood"));
    }
}