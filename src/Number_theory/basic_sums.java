package Number_theory;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class node {
    int number1;
    int number2;
    public node(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
}
class solution {
    public void sol() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int b = scanner.nextInt();
            if(b == 0) {
                break;
            }
            BigInteger big1 = new BigInteger(String.valueOf(scanner.nextInt()),b);
            BigInteger big2 = new BigInteger(String.valueOf(scanner.nextInt()),b);
            System.out.println(big1.mod(big2).toString());

        }
    }
    public boolean prime1(int n) {
        for(int i =2;i*i <= n;++i) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> prime2() {
        boolean[] bool = new boolean[(int)1e9 + 7];
        List<Integer> list =new ArrayList<>();
        for(int i =2;i < (int)1e5 + 7;i++) {
            if(!bool[i]) {
                for(int j = i;j < (int)1e5 + 7;j = j + i) {
                    bool[j] = true;
                }
                list.add(i);
            }
        }
        System.out.println(primeCheck(list,24));
        return list;
    }
    public boolean primeCheck(List<Integer> list,int n) {
        for(int i = 0;i < list.size() && list.get(i)*list.get(i) <= n;i++) {
            if(n%list.get(i) == 0) {
                return false;
            }
        }
        return true;
    }
    public LinkedList<Integer> primeFactors(List<Integer> list, int number) { // sieve of erasthoses optimized algorith over naive solution
        LinkedList<Integer> link = new LinkedList<>();
        int i;
        for(i =0;i < list.size() && list.get(i)* list.get(i) <= number;i++) {
            while(number%list.get(i) == 0) {
                number = number/list.get(i);
                link.add(list.get(i));
            }
        }
        if(number != 1) {
            link.add(list.get(i));
        }
        return link;
    }
    public void No_of_Divisors(int n) { // count the number of divisors are there
        List<Integer> list = this.prime2();
        int ans = 1;
        for(int i =0;i < list.size() && list.get(i) * list.get(i) <= n;i++) {
            int power =0;
            while(n%list.get(i) == 0) {
                n = n/list.get(i);
                power++;

            }
            ans *= (power + 1);

        }
        System.out.println((n != 1?2*ans:ans));
    }
    public void sol(int n) {  // count the sum of divisors of the given number
        List<Integer> list = this.prime2();
        int sum = 1;
        for(int i =0;i < list.size() && list.get(i) * list.get(i) <= n;i++) {
            int total = 1;
            int multiplier = list.get(i);
            while(n%list.get(i) == 0) {
                n =n/list.get(i);
                total = total + multiplier;
                multiplier = multiplier*list.get(i);
            }
            sum = sum*total;

        }
        System.out.println(n != 1?sum*(n + 1):sum);
    }
    public void eulerPhi(int n) {  // count the number of numbers which are relatively prime to the given number n
        List<Integer> list = this.prime2();
        int ans = n;
        for(int i =0;i <  list.size() && list.get(i)*list.get(i) <= n;i++) {
            if(n%list.get(i) == 0) {
                ans = ans - ans/list.get(i);
            }
            while(n%list.get(i) == 0){
                n = n/list.get(i);
            }
        }
        if(n != 1) {
            ans = ans - ans/n;
        }
        System.out.println(ans);

    }
    public int gcd(int a,int b) {
        return b == 0?a:gcd(b,a%b);
    }
    public int lcm(int a, int b) {
        return (a*b)/gcd(a,b);
    }
    public void legendre(int a, int b) { // which allows us to tell whether the number n divides m!
        List<Integer> list = this.prime2();
        List<node> li = new ArrayList<>();
        boolean[] array = new boolean[a + 1]; // prime factors for the given number
        for(int i = 2;i <= a;i++){
            if(!array[i]) {
                    int count =0;
                    int c = a;
                    while(c > 1 ) {
                        c = c/i;
                        count = count + c;
                    }
                    li.add(new node(i,count));
                    for (int j = i; j <= a; j = j + i) {
                        array[j] = true;
                    }
            }
        }
        for(node c:li) {
            System.out.println(c.number1 + "\t" + c.number2);
        }
    }
    public void No_of_trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            n = n/5;
            count = count + 5;
        }
        System.out.println(count);
    }


}
public class basic_sums {
    public static void main(String[] args) {
        solution n =new solution();
       /* n.prime2();
        n.eulerPhi(36);*/
        n.No_of_trailingZeroes(200000);
    }
}
