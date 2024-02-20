import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product, int amount){

//        if (items.containsKey(product)){
//            items.put(product, items.get(product) + amount);
//        } else{
//            items.put(product, amount);
//        }

        items.merge(product, amount, Integer::sum);
    }

    public void removeProduct(Product product, int amount){

        if(items.containsKey(product) && items.get(product) > 0){
            items.put(product, items.get(product) - amount);
        }

    }

    public void showItems() {
        System.out.println(" show items in the cart ");

        for (Map.Entry<Product, Integer> entry: items.entrySet()){
            System.out.println(entry.getKey().getName() + " : " + entry.getValue() + "개");
        }

    }

    public Map<String, Integer> showItemsStream(){
        return items.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().getName(), e -> e.getValue()));
    }

}
