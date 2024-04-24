public class Cart extends Product{

    protected Cart(String name) {
        super(name);
    }

    public void addProduct(Product product, int quantity){

    }

    @Override
    public double getPrice(int year, int month) {
        double price = year;
        return price;
    }
}
