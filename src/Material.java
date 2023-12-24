import java.time.LocalDate;

public abstract class Material {
    protected String id;
    protected String name;
    protected LocalDate manufacturingDate;
    protected int cost;

    public Material() {
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public Material(String id, String name, LocalDate manufacturingDate, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract double getAmount();

    public abstract LocalDate getExpiryDate();

    public int getCost() {
        return this.cost;
    }

    public double getRealMoney() {
        return getRealMoney();
    }
}
