package factory;

import factory.pizza.Pizza;


public class PizzaStore {
    SimplePizzaFactory factory = new SimplePizzaFactory();

    Pizza orderPizza(String type){
        Pizza pizza = factory.createPizza(type);

        pizza.getInfo();

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
