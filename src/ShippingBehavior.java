public interface ShippingBehavior {
    void ship(Order order);
    void chargeExtraFees();
}
class CommonStrategy implements ShippingBehavior {
    int acceptedWeight = 20;
    int extraFee = 3;
    public void ship(Order order) {
        order.setCurrentStatus(OrderStatus.SHIPPED);
        System.out.println("This order is being shipped by " + order.shippingBehavior.toString());

        if (order.getTotalWeight() > acceptedWeight)
            order.getShippingBehavior().chargeExtraFees();
    }
    public void chargeExtraFees() {
        System.out.println("You will be charged " + extraFee + " TL for exceeding the weight limit.");
    }
}
class ArasCargoBehavior extends CommonStrategy {
    public void chargeExtraFees() {
        super.acceptedWeight = 30;
        super.extraFee = 5;
    }
    public String toString() {
        return "Aras Cargo.";
    }
}
class YurticiCargoBehavior extends CommonStrategy {
    public void chargeExtraFees() {
        super.acceptedWeight = 35;
        super.extraFee = 10;
    }
    public String toString() {
        return "Yurtiçi Cargo.";
    }
}
class PttCargoBehavior extends CommonStrategy {
    public String toString() {
        return "PTT Cargo.";
    }
}
