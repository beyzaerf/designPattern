import java.util.ArrayList;
import java.util.List;

public class DesignPatterns {

    public static void main(String[] args) {
        User beyza = new User(1,"Beyza", "this is my address", "123", "email");

        Item item1 = new Item("rat", 20,2);
        Item item2 = new Item("soul",11,29);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Location destination = new Location(13.2, 60.8);

        Order order = new Order(1, beyza, destination, items,new ArasCargoBehavior());
        order.shippingBehavior.ship(order);
        System.out.println(order.getCurrentStatus());

        PayCommand payCommand = new PayCommand(order);
        CancelCommand cancelCommand = new CancelCommand(order);
        order.setPayCommand(payCommand);
        order.setCancelCommand(cancelCommand);
        order.cancelOrder();

    }
}