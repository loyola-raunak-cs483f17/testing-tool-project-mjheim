package srcTest;

public class Bar {

    public String greet(Foo foo) {
        System.out.println("Bar invokes Foo.greet");
        return foo.greet();
    }
}
