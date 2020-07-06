/**Spring 2020
 * Java Marathon
 * Evyatar Bhalker
 */
package two;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        LinkedList<A> alist = new LinkedList<A>();

        alist.add(a);
        alist.add(b);   // b is-a A

        LinkedList<B> blist = new LinkedList<B>();

        //blist.add(a);         adding object of type a to list of objects of type B (a is not a B object)
        blist.add(b);

//        ((B) a).print();  cannot downcast A to B
        ((A) b).print();    //upcasting -> always legal

        A.printAll(alist);
        // b.printAll(blist);    //cannot call static method on an instance + blist is not a list<A>
        a.printObject(b);
//        b.printObject((B) a); //cannot downcast a to B object
        b.printObject((A) b);
    }
}

/**Answers:
 * a. code does not compile properly - errors are marked out as notes above, with explanation
 * b. output should be :
 *          B
 *          begin list:
 *          A
 *          B
 *          end list
 *          Obj a
 *          Obj a
 */

