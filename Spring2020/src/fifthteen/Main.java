/**Spring 2020
 * Java Marathon
 * Evyatar Bhalker
 */
package fifthteen;

public class Main {
    public static void f(int x, int[] y, int[] z) {
        x = 1;
        y[0] = 2;
        z = new int[5];
        z[0] = 555;
    }
    public static void main(String[] args) {
        int x = 111;
        int[] y = { 222, 333, 444, 555 };
        int[] z = { 666, 777, 888, 999 };
        f(x, y, z);
        System.out.println(x);
        System.out.println(y[0]);
        System.out.println(z[0]);
    }
    /**
     * output: 111
     *         2
     *         666
     *         \,,/וגם ל15
     */
}
