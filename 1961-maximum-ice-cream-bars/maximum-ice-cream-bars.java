class Solution {
    public int maxIceCream(int[] costs, int coins) {
          int maxCost = 0;

        for (int cost : costs) {
            maxCost = Math.max(maxCost, cost);
        }

        int[] freq = new int[maxCost + 1];

        for (int cost : costs) {
            freq[cost]++;
        }

        int count = 0;

        for (int cost = 1; cost <= maxCost; cost++) {
            if (freq[cost] == 0) continue;

            int canBuy = Math.min(freq[cost], coins / cost);

            count += canBuy;
            coins -= canBuy * cost;

            if (coins < cost) break;
        }

        return count;
    }
}