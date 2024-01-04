import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    private static List<Material> materials = new ArrayList<>();


    public MaterialManager() {
//        this.materials.add(new CrispyFlour("F1", "Flour1", LocalDate.of(2022, 2, 3), 10, 1));
//        this.materials.add(new CrispyFlour("F2", "Flour2", LocalDate.of(2021, 7, 1), 14, 3));
//        this.materials.add(new CrispyFlour("F3", "Flour3", LocalDate.of(2023, 2, 8), 16, 5));
//        this.materials.add(new CrispyFlour("F4", "Flour4", LocalDate.of(2021, 8, 1), 12, 7));
//        this.materials.add(new CrispyFlour("F5", "Flour5", LocalDate.of(2019, 2, 9), 13, 4));
//        this.materials.add(new Meat("M1", "Meat1", LocalDate.of(2023, 12, 1), 5, 2));
//        this.materials.add(new Meat("M2", "Meat2", LocalDate.of(2021, 1, 6), 5, 3));
//        this.materials.add(new Meat("M3", "Meat3", LocalDate.of(2022, 8, 2), 9, 4));
//        this.materials.add(new Meat("M4", "Meat4", LocalDate.of(2022, 1, 11), 2, 2));
//        this.materials.add(new Meat("M5", "Meat5", LocalDate.of(2023, 2, 1), 6, 5));
    }

    public void addMaterial(Material material) {
        this.materials.add(material);
    }

    public void deleteMaterial(String id) {
        //Thực hiện bước tìm Material có id bằng id truyền vào
        Material material = this.getMaterial(id);
        //Thực hiện xóa material theo kết quả tìm được bên trên
        if (material != null) {
            this.materials.remove(material);
        }
    }

    public Material getMaterial(String id) {

        for (int i = 0; i < this.materials.size(); i++) {
            if (this.materials.get(i).getId().equals(id)) {
                return this.materials.get(i);
            }
        }
        return null;
    }

    public void editMaterial(String id, String name, int cost, LocalDate manufacturingDate){
        Material material = this.getMaterial(id);
        material.setName(name);
        material.setCost(cost);
        material.setManufacturingDate(manufacturingDate);
    }
    public static List<Material> readFile(String path){
        File file = new File(path);
        try {
            InputStream inputStream= new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            materials= (List<Material>) ois.readObject();
            return materials;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(String path, List<Material> list){
        File file = new File(path);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(list);
            oos.close();
            outputStream.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public List<Material> getMaterials() {
        return this.materials;
    }

}

