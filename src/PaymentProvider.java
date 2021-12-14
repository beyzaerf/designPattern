public interface PaymentProvider {
    public void benefits();
}
abstract class ZiraatPaymentProvider implements PaymentProvider {
    public void benefits() {
        System.out.println("Thank you for using ZiraatBank.");
    }
}
