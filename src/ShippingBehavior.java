public interface ShippingBehavior {
    void ship(Order order);
    void chargeExtraFees();
    int getExtraFee(double totalWeight);
}
class CommonStrategy implements ShippingBehavior {
    int acceptedWeight;
    int extraFee;

    public int getExtraFee(double totalWeight) {
        if (totalWeight > this.acceptedWeight)
            return extraFee;
        return 0;
    }
    public CommonStrategy() {
        this.acceptedWeight = 20;
        this.extraFee = 3;
    }
    public CommonStrategy(int acceptedWeight, int extraFee) {
        this.acceptedWeight = acceptedWeight;
        this.extraFee = extraFee;
    }
    public void ship(Order order) {
        order.setCurrentStatus(OrderStatus.SHIPPED);
        System.out.println("This order is being shipped by " + order.shippingBehavior.toString());

        if (order.getTotalWeight() > this.acceptedWeight)
            order.getShippingBehavior().chargeExtraFees();
    }
    public void chargeExtraFees() {
        System.out.println("You will be charged " + this.extraFee + " TL for exceeding the weight limit.");
    }
}
class ArasCargoBehavior extends CommonStrategy {
    int discountAmount;
    ArasCargoBehavior() {
        super(30, 5);
        this.discountAmount = 5;
    }
    @Override
    public int getExtraFee(double totalWeight) {
        int extraFee = super.getExtraFee(totalWeight);
        if(extraFee > 0)
            return extraFee - discountAmount;
        return extraFee;
    }
    @Override
    public void chargeExtraFees() {
        super.chargeExtraFees();
        System.out.println("There is a discount.");
    }

    public String toString() {
        return "Aras Cargo.";
    }
}
class YurticiCargoBehavior extends CommonStrategy {
    YurticiCargoBehavior() {
        super(35,10);
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
