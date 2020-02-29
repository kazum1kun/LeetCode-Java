public class WaterPlants {
    public static void main(String[] args) {
        WaterPlants w = new WaterPlants();
        System.out.println(w.solution(new int[]{5, 5, 5}, 5, 5));
    }

    public int solution(int[] plants, int capacity1, int capacity2) {
        int refills = 0;
        int can1 = 0, can2 = 0;

        if (plants.length <= 2) {
            return plants.length;
        }

        int end;
        if (plants.length % 2 == 0) {
            end = plants.length / 2;
        } else {
            end = plants.length / 2 + 1;
        }
        for (int i = 0; i < end; i++) {
            int j = plants.length - i - 1;

            if (i == j) {
                if (can1 + can2 >= plants[i]) {
                    break;
                } else {
                    refills++;
                    break;
                }
            }

            if (can1 < plants[i]) {
                can1 = capacity1;
                refills++;
            }
            can1 -= plants[i];

            if (can2 < plants[j]) {
                can2 = capacity2;
                refills++;
            }
            can2 -= plants[j];

            if (j - i == 1) break;
        }

        return refills;
    }
}
