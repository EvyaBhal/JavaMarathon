package fourteen;

class A {
    static int j = 7;
    int i;
    int p = 10;

    public A() {
        i = 12;
    }
    int j() {
        return i + j;
    }
}
class B extends A {
    public B() {
        p = 4; }
    public B( int i ) {
        this.i = j + i;
    }
}
class C extends B {
    int j;

    public static void main( String[] args) {
        A q5 = new B( 2 );
        System.out.println( q5.j() );

        A q6 = new A();
        System.out.println( q6.j() );

        C q7 = new C();
        System.out.println( q7.p );

        System.out.println( C.j ); //this is an error

    }
}



