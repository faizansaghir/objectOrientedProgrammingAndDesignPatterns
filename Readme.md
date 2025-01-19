# Overview

Repository to track leaning and hands-on for OOPs principles and Design patterns

# Notes

## Object Oriented Programming Principles

1. **Encapsulation**  
    It is concerned with bundling data and methods that operate on the data in a single unit.    
    It also hides the internal state of a class so that we can create robust applications.  
    ```java  
    public class Account {
        private int balance;
        public void deposit(int amount) {
            if(amount>0)
                balance+=amount;
        }
        public void withdraw(int amount) {
            if (amount > 0 && balance >= amount)
                balance -= amount;
        }
        public int getBalance() {
            return balance;
        }
    }
   ```
    *Without Encapsulation, we would have declared `balance` as public, 
    thus we would not have control over what values the balance can have(negative or positive)*
2. **Abstraction**  
    It states that we should reduce complexity by hiding unnecessary details from the user.  
    We make everything else private or abstracted from user and only expose necessary interface or functions.
   ```java
    public class MailService {
       public void sendEmail() {
           connect();
           authenticate();
           disconnect();
       }
       private void connect() {
           System.out.println("Connected");
       }
       private void disconnect() {
           System.out.println("Disconnected");
       }
       private void authenticate() {
           System.out.println("Authenticated");
       }
    } 
   ```
   *We only expose `sendMail` method to the user and hide internally used functions like `connect`, `disconnect` etc.  
    This helps to simplify usage for the end user as any unnecessary methods are hidden from user*  
3. **Inheritance**  
    It is principle which states that we should implement common code in a parent class and inherit those in our child class.  
    This will reduce code duplication as well as development effort of re-writing same logic in every child class.
    ```java
    public class UIControl {
        public void enable() {
            System.out.println("Enabled");
        }
    }
    
    public class TextBox extends UIControl{
        public void acceptInput() {
            System.out.println("Accepting input");
        }
    }
    
    public class Paragraph extends UIControl{
        public void displayText() {
            System.out.println("Text displayed");
        }
    }
   
    public class InheritanceMain {
        public static void main(String[] args) {
            TextBox textBox = new TextBox();
            textBox.enable();
            textBox.acceptInput();
            Paragraph paragraph = new Paragraph();
            paragraph.enable();
            paragraph.displayText();
        }
    }
    ```
   *We would have implemented `enable` method in both `TextBox` as well as `Paragraph`, 
    but due to inheritance, we were able to skip redefining*
4. **Polymorphism**  
    It means that the same function can take many form.  
    It can be runtime polymorphism or compile time polymorphism.  
    ***Runtime Polymorphism***: It can be achieved by overriding a function in child classes.  
    - When a function accepts a parent class object, and we pass a child class object which overrides a function, 
         then the child class function is called instead of the parent class  
    - When we use parent class or interface reference to call a function, 
       the implementation of the function will depend on the type of instance assigned to the reference.   
    
    ***Compile Time Polymorphism***: It can be achieved by method overloading.  
    - When we have multiple functions with same function name but different number or type of parameters, 
         During function call, JVM will decide which function to call based on the number or type of parameters passed.  

## SOLID Design Principles

1. **Single Responsibility Principle**  
    It states that there should never be mote than one reason for a class to change.  
    It means, a class provides very focused functionality and address a specific concern.  
    - Say we have a class which is responsible to communicate with a server. It will change due to change in following.  
      - Protocol change
      - Message format change
      - Authentication change  

    *In the example code, we can see that `ControllerBad` may change if validation logic changes, or storage logic changes.
    The `ControllerGood` does not hold validation or storage logic inside it thus it is less likely to be affected*
2. **Open-Close Principle**  
    Software entities (classes, modules, methods etc.) should be open for extension, but closed for modification.  
    Open for extension means that a child class can inherit base class and can override existing behavior.  
    Closed for modification means that the base class should not be modified once it has been written.  
    It states that one should have a solid base class that contains all functionality and fields that will not change.  
    - *In the code example, `Subscriber` is the base class that is closed for modification, 
         and it contains only parts which will not be changed.*  
    - *The `calculateBill()` method is what is open for extension, any child class extending `Subscriber` 
       will modify this method, this keeps the base class unchanged while it is still open for extension.*
3. **Liskov Substitution Principle**  
    It states that we should be able to substitute a base class object with an object of a child class.  
    It not only means simple type substitution, but it also expects same behavior from child class object as expected from parent class object.  
    Say a `JsonStringifySorted` class has a method `stringify` which returns a JSON string in alphabetically sorted order, 
    then the child class should also on using `stringify` method should return the result in alphabetically sorted order.  
    <em>In the code example `Square` is violating Liskov Substitution Principle in the following ways
    - When we set width of any rectangle, we should get back the same value unless we reset the width  
    - When we set height of any rectangle, we should get back the same value unless we reset the height
    - When we get the area of any rectangle, it should be `width*height` which was set and not `side*side`

    This issue occurred as we did not create the correct Parent Child relationship by choosing wrong classes for the relationship</em>
4. **Interface Segregation Principle**  
    This states that the client should not be forced to implement an interface that it does not use.  
    This means that any interface or abstract class should have only those methods that are relevant to it.  
    If any method is not relevant to the interface, then it should be moved to a separate interface.  
    To identify violation of this principle, we can check the following:  
    - If a class has empty method implementations
    - If a class has all the methods implemented, but some of them throw `UnsupportedOperationException` or something similar
    - Method implementation return null or default/dummy values.
     
    *In the code examples, in good implementation of `EntityPersistenceService`, 
    we only include those functionalities to be implemented which are relevant to any class 
    that will implement the `EntityPersistenceService` interface. While in bad implementation of `EntityPersistenceService` 
    we included `List<T> getByName(String name)` which is bot relevant to `OrderPersistenceService`, thus breaking functionality*
