import java.util.List;

/**
 * FIX THIS SHIT, NONE OF THEM WORK PROBABLY.
 * ALSO ADD COMMENTS TO OTHER CLASSES.
 */
public class LogisticSystem {
    private List<Order> orders;
    private List<User> users;

    public void takeOrder(Order order) {
        orders.add(order);
    }
    public void trackOrder(Order order) {
        System.out.println(order.getCurrentStatus());
    }
    public void registerUser(User user) {
        users.add(user);
    }
}
