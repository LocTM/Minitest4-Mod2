import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount {
    private int quantity;
    public CrispyFlour() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return this.quantity * this.cost;
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.manufacturingDate.plusYears(1);
    }

    @Override
    public double getRealMoney() {
        LocalDate localDateNow = LocalDate.now();
        LocalDate localDate2Month = this.getExpiryDate().minusMonths(2);
        LocalDate localDate4Month = this.getExpiryDate().minusMonths(4);
        if(localDateNow.isEqual(localDate2Month) || localDateNow.isAfter(localDate2Month) ){
            return this.getAmount() * 0.6;
        } else if (localDateNow.isBefore(localDate2Month)  || localDateNow.isEqual(localDate4Month) || localDateNow.isAfter(localDate4Month) ) {
            return this.getAmount() * 0.8;
        }
        else {
            return this.getAmount() * 0.95;
        }

    }
}

