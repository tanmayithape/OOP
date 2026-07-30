package practice;

//Define the superclass
class Animal {
 void eat() {
     System.out.println("This animal eats food.");
 }
}

//Define the subclass extending the superclass
class Dog extends Animal {
 void bark() {
     System.out.println("The dog barks.");
 }
}

//Main class to run the program
public class Main {
 public static void main(String[] args) {
     // Create a subclass object
     Dog myDog = new Dog();

     // Call superclass method using subclass object
     myDog.eat();

     // Call subclass method using subclass object
     myDog.bark();
 }
}
