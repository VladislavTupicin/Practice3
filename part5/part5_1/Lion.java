package part5.part5_1;

public class Lion extends Predator {

    public Lion(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": Р-р-р-р!!!");
    }

    public void roar() {
        System.out.println(name + " громко рычит: РРРРРРР!");
    }
}