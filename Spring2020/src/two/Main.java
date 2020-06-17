package two;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        LinkedList<A> alist = new LinkedList<>();

        alist.add(a);
        alist.add(b);   // b is-a A

        LinkedList<B> blist = new LinkedList<>();

        //alist.add(a);         adding object of type a to list of objects of type B (a is not a B object)
        alist.add(b);

//        ((B) a).print();  cannot downcast A to B
        ((A) b).print();    //upcasting -> always legal

        A.printAll(alist);
        // b.printAll(blist);    //cannot call static method on an instance + blist is not a list<A>
        A.printAll(blist);
        a.printObject(b);
//        b.printObject((B) a); //cannot downcast a to B object
        b.printObject((A) b);
    }
}


