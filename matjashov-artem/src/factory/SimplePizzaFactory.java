package factory;

import factory.pizza.*;


class SimplePizzaFactory {

    Pizza createPizza(String type){
        if (type.equals("cheese"))
            return new CheesePizza();
        else if (type.equals("clam"))
            return new ClamPizza();
        else if (type.equals("pepperoni"))
            return new PepperoniPizza();
        throw new RuntimeException("This pizza is not available: " + type);
    }

}
