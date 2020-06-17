package two;

public class B extends A {
    @Override
    public void print() {
        System.out.println("B");
    }

    public void printObject(B b) {
        System.out.println("Obj b");
    }
}
