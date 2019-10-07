/**
 * #42 Trapping Rain Water
 * The basic idea is that:
 * 1) Find valleys
 * 2) Fill them
 * 3) Profit!
 * Here we find the valley in 2 passes: LTR and RTL. Why? Because in the first pass the algorithm is
 * unable to detect the valley where end height is shorter than begin height. Therefore we can simply
 * reverse the algo to run from RTL to catch those kind of valleys.
 * 1ms/38MB (Beats 98.30%/92.47)
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int count = 0;
        int valleyHeight = height[0];
        boolean isInValley = false;
        int valleyStart = 0;
        // First run... from left to right
        for (int i = 1; i < height.length; i++) {
            if (!isInValley) {
                if (height[i] < valleyHeight) {
                    isInValley = true;
                }
                else {
                    valleyHeight = height[i];
                    valleyStart = i;
                }
            } else {
                if (height[i] >= valleyHeight) {
                    for (int j = valleyStart + 1; j < i; j++) {
                        count += valleyHeight - height[j];
                    }
                    isInValley = false;
                    valleyStart = i;
                    valleyHeight = height[i];
                }
            }
        }

        // Second run... from right to left
        valleyHeight = height[height.length - 1];
        isInValley = false;
        valleyStart = height.length - 1;

        for (int i = height.length - 2; i >= 0; i--) {
            if (!isInValley) {
                if (height[i] < valleyHeight) {
                    isInValley = true;
                }
                else {
                    valleyHeight = height[i];
                    valleyStart = i;
                }
            } else {
                if (height[i] > valleyHeight) {
                    for (int j = valleyStart - 1; j > i; j--) {
                        count += valleyHeight - height[j];
                    }
                    isInValley = false;
                    valleyStart = i;
                    valleyHeight = height[i];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
