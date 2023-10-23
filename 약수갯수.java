


import java.util.ArrayList;

public class DivisorProgram {
    public static void main(String[] args) {
        int N = 2200; // N 값을 원하는 숫자로 변경하세요.

        ArrayList<Integer> divisors = findDivisors(N);
        int count = divisors.size();

        System.out.println(N + " : number of divisor: " + count);
        System.out.println(N + " divisors: " + divisors);
    }

    public static ArrayList<Integer> findDivisors(int N) {
        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }
}
