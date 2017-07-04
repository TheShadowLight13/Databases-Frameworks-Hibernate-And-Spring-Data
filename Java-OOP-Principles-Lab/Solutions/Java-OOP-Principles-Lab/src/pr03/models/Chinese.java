package pr03.models;

public final class Chinese extends BasePerson{

    public Chinese(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Djydjybydjy");
    }
}
