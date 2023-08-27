package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int weight;
    int price;
    public Node(int weight, int price) {
        this.weight = weight;
        this.price = price;

    }
}
class solution {
    public void Fibanocci(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for(int   i = 2;i <= n;i++){
            array[i] = array[i - 1] + array[i  - 2];
        }
        System.out.println(array[n]);
    }
    public void climb_Stairs1(int n) {
        int[] fib = new int[n + 1];
        fib[1] = 1;
        fib[2] = 2;
        fib[3] =4;
        for(int i = 3;i <= n;i++) {
            fib[i] = fib[i- 1] + fib[i - 2] + fib[i - 3];
        }
        System.out.println(fib[n]);
    }
    public void climb_Stairs2(int[] arr, int n) { // climb_stairs_with variable jumps
        int[] dp =new int[n + 1];
        dp[n] = 0;
        for(int i = n - 1;i >= 0;i--) {
            for(int j = i + 1;j < Math.min(i + arr[i],n);j++) {
                dp[i] = dp[i] + dp[j];
            }
        }
        System.out.println(dp[0]);
    }
    public int climb_Stairs3(int[] arr) { // climb stairs with minimum moves
        int n = arr.length;
        long[] dp = new long[n];
        for(int i = n - 2;i >= 0;i--) {
            long min = Integer.MAX_VALUE;
            for(int j =  i + 1;j <= Math.min(i + arr[i],n - 1);j++) {
                min  = Math.min(min,1 + dp[j]);
            }
            dp[i] = min;

        }
        return (int)dp[0];
    }
    public void Min_Cost_Maze(int[][] nums) { // Min Cost in Maze Traversal
        int n = nums.length - 1;
        int m = nums[0].length - 1;
        int[][] dp = new int[nums.length][nums[0].length];
        for(int i= n - 1;i >= 0;i--) {
            for(int j = m - 1;j >= 0;j--) {
                if(i == n- 1 && j == m - 1) {
                    dp[i][j] = nums[i][j];
                    continue;
                }
                if(i == n - 1) {
                    dp[i][j] = dp[i][j] + nums[i][j + 1];
                }
                else if(j == m - 1) {
                    dp[i][j] = dp[i][j] + nums[i + 1][j];
                }
                else  {
                    int min = Math.min(dp[i + 1][j],dp[i][j + 1]);
                    dp[i][j] = nums[i][j] + min;

                }
            }
        }
        System.out.println(dp[0][0]);
    }
    public void gold_mine(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i = arr[0].length - 1;i >= 0;i--) {
            for(int j = 0;j < n;j++) {
                if(i == m - 1) {
                    continue;
                }
                if(j == 0) {
                    dp[i][j] = arr[i][j] + Math.max(arr[i][j + 1],arr[i + 1][j + 1]);
                }
                else if(j == n - 1) {
                    dp[i][j] = arr[i][j] + Math.max(arr[i][j + 1],arr[i - 1][j + 1]);
                }
                else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1],Math.max(dp[i - 1][j + 1],dp[i + 1][j + 1]));
                }
            }
        }
        System.out.println(dp[0][0]);
    }
    public void Target_Sum_Subsets_Target(int[] nums,int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for(int i =0;i < dp.length;i++) {
            for(int j =0;j < dp[0].length;j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                else if(i == 0) {
                    dp[i][j] = false;
                }
                else if(j == 0) {
                    dp[i][j] = true;
                }
                else {
                    if(dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                    else {
                        int val = nums[i - 1];
                        if(j >= val && dp[i - 1][j - val]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1][target]);
    }
    public void coin_Change_Combinations(int[] nums,int amount) {
        int[] dp =new int[amount + 1];
        dp[0] = 1;
        for(int coin:nums) {
            for(int i= 1;i < amount + 1;i++) {
                if(i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        System.out.println(dp[amount]);
    }
    public void coin_Change_Permutation(int[] nums, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 1;i < dp.length + 1;i++) {
            for(int coin:nums) {
                if(i >= coin) {
                    dp[i] += dp[i-coin];
                }
            }
        }
        System.out.println(dp[amount]);
    }
    public void Knapsack_Zero_and_One(int[] weights, int[] prices,int amount) {
        int[][] dp =new int[weights.length + 1][amount + 1];
        for(int i = 1;i < dp.length;i++) {
            for(int j = 1;j < dp[0].length;j++) {
                int val = prices[i - 1];
                int weight = weights[i - 1];
                if(j >= weight) {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weight] + val);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }
    public void Unbound_Knapsack(int[] weights,int[] prices,int amount) {
        int[] dp = new int[amount + 1];
        for(int i =1;i < dp.length;i++) {
            int max = 0;
            for(int j = 0;j < prices.length;j++) {
                int value = prices[j];
                int weight = weights[j];
                if(weight <= i) {
                    int last = i - weight;
                    int lastI = dp[last];
                    int sum = lastI + value;
                    if(sum > max) {
                        max = sum;
                    }
                }
            }
            dp[i] = max;
        }
        System.out.println(dp[amount]);
    }
    public void Fractional_Knapsack(int[] weights,int[] prices,int amount) {
        List<Node> list = new ArrayList<>();
        for(int i =0;i < weights.length;i++) {
            list.add(new Node(prices[i],weights[i]));
        }
        list.sort((a, b) -> b.price / b.weight - a.price / a.weight);
        double sum =0;
        for (Node node : list) {
            int weight = node.weight;
            if (weight <= amount) {
                sum = sum + node.price;
                amount = amount - weight;
            } else {
                double fraction = (double) amount / (double) weight;
                sum = sum + (fraction * node.price);
                break;
            }
        }
        System.out.println(sum);
    }
}
public class basic_dp {
    public static void main(String[] args) {
        solution n = new solution();
        n.coin_Change_Combinations(new int[]{1,2,3,4},6);

    }

}
