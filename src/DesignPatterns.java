import java.util.ArrayList;
import java.util.List;

public class DesignPatterns {

    public static void main(String[] args) {
        Location home = new Location(67.8, 53.7);
        User beyza = new User(1,"Beyza", home, "123", "email");

        Item item1 = new Item("earphones", 20,2);
        Item item2 = new Item("water",10,28);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Order order = new Order(1, beyza, items,new ArasCargoBehavior());
        YapiKrediPaymentProvider yapiKrediPaymentProvider = new YapiKrediPaymentProvider(order);
        System.out.println(order.trackOrder());
        order.shippingBehavior.ship(order);
        System.out.println(order.trackOrder());
        yapiKrediPaymentProvider.makePayment();

    }
}