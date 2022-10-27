package lesson08;

class Cat extends Animal {
    public Cat(String name, int age) {
    super(name, age); // Call superclass’ constructor.
    this.noise = "Meow!"; // Change the value of the field.
    }
    @Override
    public void greet() {
    System.out.println("Cat " + name + " says: " + makeNoise());
    }
} 
