package pr03.models;

public final class Bulgarian extends BasePerson {

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public void sayHello() {
        System.out.println("Здравей");
    }
}
