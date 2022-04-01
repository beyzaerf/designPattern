public class PaymentProvider {
    Order order;
    IPaymentCommand paymentCommand;
    ICancelCommand cancelCommand;
    public PaymentProvider(Order order) {
        this.order = order;
    }
    public void makePayment() {
        this.paymentCommand.pay();
        System.out.println("You have paid " + order.getTotalPrice() + " TL.");
    }
    public void cancelOrder() {
        this.cancelCommand.cancel();
    }

    public void setCancelCommand(ICancelCommand cancelCommand) { this.cancelCommand = cancelCommand; }
    public void setPaymentCommand(IPaymentCommand paymentCommand) { this.paymentCommand = paymentCommand; }
}
interface IPaymentCommand {
    void pay();
}
interface ICancelCommand {
   void cancel();
}
class PaymentBehaviors {
    Order order;
    public PaymentBehaviors(Order order){
        this.order = order;
    }
}
class PaymentBehaviorOne extends PaymentBehaviors implements IPaymentCommand {
    public PaymentBehaviorOne(Order order) { super(order); }
    public void pay() {
        System.out.println("Get %15 KDV!");
    }
}

class PaymentBehaviorTwo extends PaymentBehaviors implements IPaymentCommand {
    public PaymentBehaviorTwo(Order order) {
        super(order);
    }
    public void pay() {
        System.out.println("You can pay with six instalments!");
    }
}

class PaymentBehaviorThree extends PaymentBehaviors implements IPaymentCommand {
    public PaymentBehaviorThree(Order order) { super(order); }
    public void pay() {
        System.out.println("You got BankPoints!");
    }
}

class CancelBehaviorOne extends PaymentBehaviors implements ICancelCommand {
    public CancelBehaviorOne(Order order) { super(order); }
    public void cancel() {
        System.out.println("You will get your money back in one business days.");
    }
}

class CancelBehaviorTwo extends PaymentBehaviors implements ICancelCommand {
    public CancelBehaviorTwo(Order order) {
        super(order);
    }
    public void cancel() {
        System.out.println("You will get your money back in 1 to 3 business days.");
    }
}


class YapiKrediPaymentProvider extends PaymentProvider {
    public YapiKrediPaymentProvider(Order order) {
        super(order);
        this.setPaymentCommand(new PaymentBehaviorThree(this.order));
        this.setCancelCommand(new CancelBehaviorOne(this.order));
        System.out.println("Thanks for choosing Yapı Kredi.");
    }
}
class ZiraatBankPaymentProvider extends PaymentProvider {
    public  ZiraatBankPaymentProvider(Order order){
        super(order);
        this.setPaymentCommand(new PaymentBehaviorOne(this.order));
        this.setCancelCommand(new CancelBehaviorTwo(this.order));
        System.out.println("Thanks for choosing Ziraat.");
    }
}