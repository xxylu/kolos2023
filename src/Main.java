import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws AmbigiousProductException {
        Product nonFoodProduct = NonFoodProduct.fromCsv(Path.of("./src/data/nonfood/benzyna.csv"));
        Product foodProduct = FoodProduct.fromCsv(Path.of("./src/data/food/buraki.csv"));
        Product nonFoodProduct2 = NonFoodProduct.fromCsv(Path.of("./src/data/nonfood/bilet_do_kina.csv"));

        Product.addProducsts(nonFoodProduct);
        Product.addProducsts(foodProduct);
        Product.addProducsts(nonFoodProduct2);

        Cart cart = new Cart();
        cart.addProduct(nonFoodProduct,40);
        cart.addProduct(foodProduct,1);
        cart.addProduct(nonFoodProduct2,40);
        System.out.println("\n Wartość koszyka w lutym 2010: " + cart.getPrice( 2010,2));
        System.out.println("\n Wartość koszyka w lutym 2016: " + cart.getPrice(2016,2));
        System.out.println("\n Inflacja: " + cart.getInflation(2010,3,2016,2));
    }
}