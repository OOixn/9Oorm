import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Product> product = new HashSet<>();

        Product product1 = new Product("1", "칫솔", 1000);
        Product product2 = new Product("2", "치약", 2000);

        product.add(product1);
        product.add(product2);

        for (Product p : product){
            System.out.println(p.getName() + " : " + p.getPrice());
        }

        Cart myCart = new Cart();

        myCart.addProduct(product1, 2);
        myCart.addProduct(product2, 3);


        System.out.println(myCart.showItemsStream());


        myCart.removeProduct(product1, 1);
        myCart.removeProduct(product2, 2);

        myCart.showItems();
// 데이터 가져오기

        Set<Product> productSet = new HashSet<>();

        BufferedReader br = null;
        String line;
        String path = "/Users/O.O_ixn/Desktop/9oorm/mycart/src/main/java/data.csv";

        List<Product> myProducts = new ArrayList<>();

        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "utf-8"));

            while ((line = br.readLine()) != null){
                String[] temp = line.split(",");
                Product producta = new Product(temp[0], temp[1], Integer.parseInt(temp[2]));
                productSet.add(producta);
                myProducts.add(producta);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        product.add(product1);
        product.add(product2);

        for (Product p : product){
            System.out.println(p.getName() + " : " + p.getPrice());
        }

        Cart myCart2 = new Cart();

        myCart2.addProduct(myProducts.get(0), 2);
        myCart2.addProduct(myProducts.get(1), 3);


        System.out.println(myCart.showItemsStream());


        myCart2.removeProduct(myProducts.get(0), 1);
        myCart2.removeProduct(myProducts.get(1), 2);

        myCart.showItems();

    }
}
