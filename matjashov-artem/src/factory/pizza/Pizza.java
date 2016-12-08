package factory.pizza;


public class Pizza {
    public void prepare() {
        System.out.println("Prepare ingredients ...");
    }

    public void bake() {
        System.out.println("Bake the dough ...");
    }

    public void cut() {
        System.out.println("cut the pizza for the convenience of ...");
    }

    public void box() {
        System.out.println("Is packed in a nice package ...");
    }

    public void getInfo() {}
}
