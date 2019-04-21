import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Operations operations = new Operations();
        int operation;
        Boolean exit = false;
        String productName;
        Double price;
        Integer quantity;
        Product product = new Product();

        String file= "C:\\Users\\Luci\\IdeaProjects\\Evozon\\pr3\\products.csv";
        File file2 = new File("C:\\Users\\Luci\\IdeaProjects\\Evozon\\pr3\\products.csv");
        try {
            if (file2.createNewFile()) {

                System.out.println("File has been created.");
            } else {

                System.out.println("File already exists.");
            }
        }
        catch (IOException e){
            System.out.println("fisierul nu exista");
        }
        while (!exit){

            System.out.println("Choose operation:");
            System.out.println("1.See all products");
            System.out.println("2.Create");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.Find by name");
            System.out.println("6.Exit");

            Scanner keyboard = new Scanner(System.in);
            operation = keyboard.nextInt();
            keyboard.nextLine();
            switch (operation){
                case 1:
                    operations.read(file);
                    break;
                case 2:
                    productName = null;
                    price = null;
                    quantity = null;
                    System.out.println("Product name:");
                    productName = keyboard.nextLine();
                    product.setProductName(productName);

                    System.out.println("Price:");
                    try {
                        price = keyboard.nextDouble();
                        product.setPrice(price);
                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect input");
                    }

                    System.out.println("Quantity:");
                    try {
                        quantity = keyboard.nextInt();
                        product.setQuantity(quantity);

                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect input");
                    }
                    if (price != null && quantity!= null && productName!=null && !productName.equals("")) {
                        operations.create(file, product);
                    }
                    else {
                        System.out.println("Product was not created");
                    }

                    break;
                case 3:
                    productName = null;
                    price = null;
                    quantity = null;

                    System.out.println("Product name:");
                    productName = keyboard.nextLine();
                    product.setProductName(productName);

                    System.out.println("Price:");
                    try {
                        price = keyboard.nextDouble();
                        product.setPrice(price);
                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect input");
                    }

                    System.out.println("Quantity:");
                    try {
                        quantity = keyboard.nextInt();
                        product.setQuantity(quantity);

                    }
                    catch (InputMismatchException e){
                        System.out.println("incorrect input");
                    }
                    if (price != null && quantity!= null && productName!=null && !productName.equals("")) {
                        operations.update(file, product);
                    }
                    else {
                        System.out.println("Product was not updated");
                    }
                    break;
                case 4:
                    System.out.println("product name");
                    productName = keyboard.nextLine();
                    operations.delete(file,productName);
                    break;
                case 5:
                    System.out.println("product name");
                    productName = keyboard.nextLine();
                    operations.findByName(file,productName);
                    break;
                case 6: exit = true;
                    break;
                 default: System.out.println("input invalid");
            }

        }
    }
}
