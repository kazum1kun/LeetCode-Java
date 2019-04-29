import java.util.HashMap;

public class CoinChange {
    private HashMap<Integer, Integer> discovered = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (discovered.containsKey(amount)) return discovered.get(amount);

        int n = amount + 1;

        for (int coin : coins) {
            int current = 0;

            if (amount >= coin) {
                int next = coinChange(coins, amount - coin);

                if (next >= 0) {
                    current = next + 1;
                }
            }

            if (current > 0) {
                n = Math.min(n, current);
            }
        }

        if (n < amount + 1) {
            discovered.put(amount, n);
            return  n;
        } else {
            discovered.put(amount, -1);
            return -1;
        }
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[] {1, 3}, 6));
    }
}
