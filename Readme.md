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
5. **Dependency Inversion**  
    It states that a high level module(business logic implementation) should not depend on low level module 
    such as FileWriter, JsonFormatter etc.  
    These dependencies should be abstracted out and injected into the high level module by the client application.  
    The client application is the one which is using this high level module.  
    *In the code example, the good `Logger` class implementation accepts low level module of `Writer` and `Formatter` 
    This gives the flexibility to the client to select desired `Formatter` and `Writer`.  
    The bad `Logger` class implementation tightly couples itself to `JsonFormatter` and `PrintWriter` reducing flexibility*

## Design Patterns

Types of design patterns:
- ***Creational***: These deal with the process of creation of objects of classes.  
- ***Structural***: These deal with how classes and objects are arranged oir composed.  
- ***Behavioral***: These deal with how classes and objects interact and communicate with each other.  

### Structural Design Pattern

1. **Adapter Pattern**  
If existing object which provides functionality that client needs but the client expects an object with different interface.  
   - ***Steps to implement***
      - Create class for Adapter which implements interface expected by client
      - We can then extend Adaptee class and redirect method call of target interface to functions inherited from Adaptee
        This is called a class adapter and is a two-way adapter as Adapter class can be used both as Target or Adaptee 
      - We can alternatively accept Adaptee class object as a constructor argument and redirect method calls to Adaptee object  
   - ***Things to consider***
      - Sometimes Adaptee and Target interface may differ based on the method signature, 
        thus we might need some transformation in Adapter class to make it compatible
      - We should avoid overriding existing Adaptee methods as it will cause Adapter and Adaptee to behave differently
      - Try using object Adapter as the Adaptee implementation can be changed if required, 
        and also if both Adaptee and Target are classes 
      - Another reason to avoid class Adapter is that we will expose both Adaptee and Target interface methods, 
        which will cause extra functions to be exposed than required which is not a good practice.
      - Always do simple interface translation, do not add business logic, validation to Adapter.
   - ***Examples***
     - java.io.InputStreamReader and java.io.OutputStreamWriter
       These adapt existing `InputStream`/`OutputStream` object to a `Reader`/`Writer` interface
   - ***UML***
       ![Adapter Class Pattern](./img/adapter_pattern_class_uml.png "Adapter Class Pattern")
       ![Adapter Object Pattern](./img/adapter_pattern_object_uml.png "Adapter Object Pattern")
2. **Bridge Pattern**  
During inheritance using interface or abstract class or simple class, our class is coupled to the abstraction.  
If we want to change the interface of already implemented class, we need to make changes to its interface and implementation.  
Using bridge pattern, we can make these 2 independent so that we can change the interface without changing existing interface.   
It creates 2 hierarchy, one for the abstraction that will be used by client, the other is implementation abstraction.  
The abstraction hierarchy will have an implementation of implementor which will be a concrete implementor  
Using the instance of the implementor, the concrete abstraction class will accomplish the operations of abstraction.  
eg: `LIFOCollection` is an abstraction which has `push` and `pop` methods
`Stack` is an example of concrete implementation of `LIFOCollection` but it will use an implementation of `List` interface
`LinkedList` is a concrete implementation of `List` interface which has `addLast`, `removeLast`, etc. methods
`Stack` can have an instance of `LinkedList` and use `addLast` and `removeLast` methods of the instance to define `push` and `pop`
    - **Steps to implement**  
      - Create abstraction/ interface which client will use along with the required methods which client will use
        This abstraction can itself be a concrete class.
      - Define implementor interface. Implementor methods do not have to match with abstraction, 
         but these methods should be such that abstraction implementation can implement methods using instance of implementor. 
      - Write one or more concrete implementor. The implementor implementation can itself be a concrete class
      - When creating object of abstraction interface, we pass the concrete class of implementor to get a composition
    - **Things to consider**  
      - We can skip creating implementor interface if we will only have single implementation of implementor  
      - Our abstraction implementation can either use a concrete implementor or delegate the decision to client code  
    - **Example**  
      - java.sql.DriverManager and java.sql.Driver
        DriverManager has `getConnection` method which uses a Driver internally. The Driver has `connect` method
        The implementation of Driver can be different for different databases like `com.mysql.jdbc.Driver` and 
         `oracle.jdbc.driver.OracleDriver` 
    - **UML**  
        ![Bridge Design Pattern](./img/bridge_pattern_uml.png "Bridge Design Pattern")
    - **Difference from Adapter Pattern**  
      - Adapter is used when we already have all the implementations but the interface do not match
      - Bridge is used when we have implementations which can be used to provide required functionalities 
      by single or by combining multiple existing implemented method(s) from the concrete implementor
3. **Decorator Pattern**  
When we want to extend the functionality or enhance the behavior of existing object dynamically as and when required, 
we use decorator pattern. Decorator wraps the object within itself and provides same interface as the wrapped object.  
This helps in keeping the client of original object unchanged. It provides alternate to subclassing for extending functionality.
    - **Steps to implement**  
      - Identify component interface which needs to be defined or is being already used by clients.  
      - A concrete component will implement the component interface.  
      - A decorator is defined which implement Component interface while also has a Component as a reference.  
      - Add additional behaviour on top of the passed reference behaviour.  
      *Note: Decorator can be abstract as well and depend on subclasses to provide functionality*  
    - **Things to consider**  
      - Avoid using large state in base class as decorators may not need all the state.  
      - Decide whether `equals` and `hashCode` methods should be overridden i.e. if decorated instance should equal base instance.
      - Since it is a recursive composition, debugging, can be tough at times when there is very large hierarchy.  
      - Decorator is more powerful than inheritance as it allows dynamic or runtime changes while inheritance is static.  
      - The decorator should add small addition to the object it decorates and should not change the functionality all together.  
    - **Example**
      - Classes in Java's I/O package
      - java.io.BufferedOutputStream and java.io.OutputStream
        BufferedOutputStream is decorator which adds buffering to any output stream
    - **UML**
      ![Decorator Design Pattern](./img/decorator_pattern_uml.png "Decorator Design Pattern")
    - **Difference from Adapter Pattern**
      - Adapter changes interface without changing behaviour. 
        An adapter cannot be used in place of an Adaptee thus it is also difficult to recursively compose Adapter and Adaptee.
      - Decorator changes behaviour without changing interface
        A decorator can be used in place of a Component since they share same interface and can be composed recursively.  
4. **Composite Pattern**  
If we have a hierarchy of objects, and we want to give them a common interface, then we can use composite design pattern.  
It helps in treating objects that use composition in same way as one that does not use.  
eg: `FileSystemComponent` can be the common interface, while `TextFile` and `Directory` are its concrete implementation.  
We can decide if we only want to keep common functionality defined in `FileSystemComponent`, 
or we want to add children management functionalities also.  
These children management functionalities, though implemented in leaf node, will only throw unsupported exception.  
These are arguably added as purpose of Composite pattern is to treat leaf as well as ancestor nodes in the same way.  
    - **Steps to implement**
        - Create a Component interface which has all the common functionalities declared
        - Decide if the children management functionalities are to be included in Component interface
        - Add Composite as an implementation of Component which propagates the invoked operation to all its children
        - Implement Leaf as another implementation of Component which implements the common functionalities,
          if the children management functionalities are also to be implemented, handle these functionalities with exceptions
    - **Things to consider**
        - We can provide method to access parent node. This simplifies tree traversal in any order
        - If we are using a node in many different places in the tree, 
          we can cache them if they are immutable and initialization cost is high
        - Design principle of the pattern suggest having child management functionalities in Composite interface.
          This helps the client to not care about if they are working with leaf or any other implementation 
    - **Example**
        - In JSF, we have `UIViewRoot` which is interface, `UIComponentBase` is a base implementation, 
          `UIMessage` and `UIOutput` are leaf components while `UIViewRoot` is non-leaf component. All extend `UIComponentBase`
    - **UML**
      ![Composite Design Pattern](./img/composite_pattern_uml.png "Composite Design Pattern")
    - **Difference from Decorator Pattern**
        - In Decorator, intent is to `add to` existing behaviour, and can be considered as composite with single child.
            Contains a single object and not children, and add or modify the behaviour of contained object
        - In Composite, it is for aggregation, and can have any number of children. It deals with tree structures. 
            Composites only delegate operation to children without any modification
