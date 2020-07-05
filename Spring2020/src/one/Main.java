/**Spring 2020
 * Java Marathon
 * Evyatar Bhalker
 */
package one;


class Parent {
    int i;

    public void incr(int d) {
        if (d > 0) {
            this.i += d;
            this.incr(d-1);
        }
    }
    @Override
    public String toString() {
        return "Parent's i is: " + i;
    }
}

class Child extends Parent{
    int i;
    @Override
    public void incr(int d) {
        if (d > 0) {
            this.i += d;
            super.incr(d/2);
        }
    }
    @Override
    public String toString() {
        return super.toString() + "\nChild's i is: " + i;
    }
}

public class Main {
    public static void main(String[] args) {
        Parent a = new Child();
        a.incr(10);
        System.out.println(a);
    }
}