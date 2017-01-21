package binarySearch;

import java.util.Arrays;

public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        int maxRadius = 0;
        for (int i = 0; i < houses.length; i++) {
            int currHouse = houses[i];
            while (j < heaters.length - 1 &&
                   Math.abs(heaters[j] - currHouse) >= Math.abs(heaters[j + 1] - currHouse)) {
                j++;
            }
            maxRadius = Math.max(Math.abs(heaters[j] - currHouse), maxRadius);
        }
        return maxRadius;
    }

    public static void main(String[] args) {
        Heaters h = new Heaters();
        int[] houses = {1, 4};
        int[] heaters = {1, 4};
        System.out.println(h.findRadius(houses, heaters));
    }
}
