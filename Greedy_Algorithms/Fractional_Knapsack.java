import java.util.Arrays;
import java.util.Comparator;

class Item {
    int profit;
    int weight;
    double ratio;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
        this.ratio = (double) profit / weight;
    }
}

public class FractionalKnapsack {

    public static double knapsack(Item[] items, int M) {

        // Step 1: Sort objects in decreasing order of profit/weight ratio
        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                return Double.compare(b.ratio, a.ratio);
            }
        });

        double P = 0;

        // Step 2: Select objects
        for (int i = 0; i < items.length; i++) {

            if (items[i].weight <= M) {
                M = M - items[i].weight;
                P = P + items[i].profit;
            }

            else if (M > 0) {
                P = P + items[i].profit * ((double) M / items[i].weight);
                M = 0;
                break;
            }
        }

        return P;
    }

    public static void main(String[] args) {

        Item[] items = {
                new Item(25, 18),
                new Item(24, 15),
                new Item(15, 10)
        };

        int capacity = 20;

        double maxProfit = knapsack(items, capacity);

        System.out.println("Maximum Profit = " + maxProfit);
    }
}


//output: 31.0
