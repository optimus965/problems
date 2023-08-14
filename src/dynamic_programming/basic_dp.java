package dynamic_programming;
class solution {
    public void fibanocci(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for(int   i = 2;i <= n;i++){
            array[i] = array[i - 1] + array[i  - 2];
        }
        System.out.println(array[n]);
    }

}
public class basic_dp {
    public static void main(String[] args) {
        solution n = new solution();
        n.fibanocci(9);
    }
}
