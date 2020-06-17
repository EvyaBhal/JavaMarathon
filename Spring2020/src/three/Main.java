package three;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int x = 1;
        int[] y = {2, 3, 4};
        String z = "5";
        Stack<String> s = new Stack<>();
        s.push("6");
        s.push("7");

        func(x, y, z, s);

        z = z.replaceAll("5", "6");
        z.replaceAll("6", "8");
        System.out.println(x);
        System.out.println(y[0]);
        System.out.println(z);
        System.out.println(s.pop());
    }

    private static void func(int x, int[] y, String z, Stack<String> s) {
        x = 1111;
        y[0] = 2222;
        y =  new int[5];
        y[0] = 4444;
        z = "5555";
        s.push("9999");
    }
}
