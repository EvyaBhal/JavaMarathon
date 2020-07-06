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
        /**
         * works like this:
         * child.i += 10
         * parent.i += 5
         * child.i+= 4
         * parent.i +=2
         * child.i +=1.
         *
         * total: child.i = 15
         *        parent.i = 7
         */
        System.out.println(a);
    }
}
/**Answers to theoretical sections:
 *
 * a. line 8 "this.i" (parent class) refers to parent's i (declared in parent class)
 *    line 23 "this.i" (child class) refers to child's i (declared in child class)
 *
 * b. NOT EXACTLY: d is passed by value - so actually, a new "d" is created each time incr is called.
 *                 on the other hand - all the d's are related..and are derrived from one another.
 *
 * c. yes , but with a catch: only 1 object is created in this program, so there is only 1 object to be
 *                            referred to as "this". and yet, parent's "this" refers to the Parent part of the object
 *                            while child's "this" refers to the whole object.
 *
 * d. Output: Parent's i is: 7
 *            Child's i is: 15
 *
 * e. no change. - protected fields and methods are accessible to subclasses
 *
 * f. compiler error - we can't assign a "weaker" access privilege to a field/method.
 *
 * g. revised e - no change! e works even with different packages
 *    revised f - compiler error - cant access protected from Test to Child if different packages.
 *
 */