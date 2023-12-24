import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();

        double totalAmount = calculateTotalAmount(materialManager.getMaterials(), 10);
        System.out.println("Tổng tiền của 10 vật liệu: " + totalAmount);

        sortMaterialsByCost(materialManager.getMaterials());
        System.out.println("Danh sách vật liệu sau khi sắp xếp theo giá:");
        displayMaterials(materialManager.getMaterials());

        double discountDifference = calculateDiscountDifference(materialManager.getMaterials());
        System.out.println("Số chênh lệch giữa chiết khấu và không chiết khấu: " + discountDifference);
    }

    private static double calculateTotalAmount(List<Material> materials, int n) {
        double totalAmount = 0;
        for (int i = 0; i < Math.min(n, materials.size()); i++) {
            totalAmount += materials.get(i).getAmount();
        }
        return totalAmount;
    }

    private static void sortMaterialsByCost(List<Material> materials) {
        Collections.sort(materials, Comparator.comparingInt(Material::getCost));
    }

    private static void displayMaterials(List<Material> materials) {
        for (Material material : materials) {
            System.out.println(material.getId() + " - " + material.getName() + " - Cost: " + material.getCost());
        }
    }

    private static double calculateDiscountDifference(List<Material> materials) {
        double totalWithoutDiscount = 0;
        double totalWithDiscount = 0;

        LocalDate currentDate = LocalDate.now();

        for (Material material : materials) {
            totalWithoutDiscount += material.getAmount();
            totalWithDiscount += material.getRealMoney();
        }

        return totalWithoutDiscount - totalWithDiscount;
    }
}
