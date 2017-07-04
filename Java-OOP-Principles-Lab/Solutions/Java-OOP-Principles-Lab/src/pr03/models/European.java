package pr03.models;

public final class European extends BasePerson{

    public European(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
