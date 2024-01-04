    import java.time.LocalDate;

    public class Meat extends Material implements Discount {
        private double weight;



        public Meat() {
        }

        public Meat(double weight) {
            this.weight = weight;
        }

        public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
            super(id, name, manufacturingDate, cost);
            this.weight = weight;
        }
        public double getWeight() {
            return this.weight;
        }
        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public double getAmount() {
            return this.cost * this.weight;
        }

        @Override
        public LocalDate getExpiryDate() {
            return this.manufacturingDate.plusDays(7);
        }

        @Override
        public double getRealMoney() {
            LocalDate localDateNow = LocalDate.now();
            LocalDate localDate5Day = this.getExpiryDate().minusDays(5);
            if(localDateNow.isEqual(localDate5Day) || localDateNow.isAfter(localDate5Day) ) {
                return this.getAmount() * 0.7;
            }
            else {
                return this.getAmount() * 0.9;
            }

        }

        @Override
        public String toString() {
            return "Meat{" +
                    "weight=" + weight +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", manufacturingDate=" + manufacturingDate +
                    ", cost=" + cost +
                    "} " + super.toString();
        }
    }
