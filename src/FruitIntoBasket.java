import java.util.Collection;
import java.util.HashMap;

/*
 * Created by Kazumi on 12:24 AM, 3/29/2019
 */
public class FruitIntoBasket {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int firstType = -1, secondType = -1;
        int max = 2;

        for (int type : tree) {
            if (firstType == -1) {
                firstType = type;
                max = Math.max(deposit(counts, type), max);
            }
            else if (secondType == -1) {
                secondType = type;
                max = Math.max(deposit(counts, type), max);
            }
            if (type != firstType && type != secondType) {
                secondType = firstType;
                remove(counts, firstType);
                firstType = type;
                max = Math.max(deposit(counts, type), max);
            }
            else {
                max = Math.max(deposit(counts, type), max);
            }
        }

        return max;
    }

    int deposit(HashMap<Integer, Integer> counts, int type) {
        if (counts.containsKey(type)) {
            counts.put(type, counts.get(type) + 1);
        } else {
            counts.put(type, 1);
        }
        int currentMax = 0;
        for (int i : counts.values()) {
            currentMax += i;
        }
        return currentMax;
    }

    void remove(HashMap<Integer, Integer> count, int type) {
        count.remove(type);
    }

    public static void main(String[] args) {
        FruitIntoBasket fb = new FruitIntoBasket();
        System.out.println(fb.totalFruit(new int[] {1,2,3,2,2}));
    }
}
