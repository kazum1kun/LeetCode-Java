import java.util.*;

class InsertDeleteGetRandom {
    private HashMap<Integer, Integer> mapping;
    private List<Integer> data;
    private Random random;

    public InsertDeleteGetRandom() {
        mapping = new HashMap<>();
        data = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (mapping.containsKey(val) && mapping.get(val) != -1) return false;

        mapping.put(val, data.size());
        data.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!mapping.containsKey(val)) return false;
        if (mapping.get(val) == -1) return false;

        mapping.put(val, -1);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(data.size());
        int result = data.get(index);
        if (mapping.get(result) != -1) {
            return result;
        }
        else return getRandom();
    }
}
