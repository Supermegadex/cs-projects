1) Which primitive or class would make the DivideByTwo method print the following output, given x = 7.5?

```java
public class QuickMaths {
  public static void DivideByTwo(<type> x) {
    System.out.println(x / 2);
  }
}
```

`QuickMaths.DivideByTwo(7.5) == 3.75`  
^ (This should be true)

a. `int`  
b. `String`  
c. `double`  
d. `Scanner`  

2) An interface is a way to abstractly represent a class so that you can specify how a class should look without writing any logic. To *implement* an interface, you must write a class that has every method defined in the interface.

Write an *implementation* of the following interface:

```java
interface IHouse {
  private double cost;
  private String address;
  private int footage;
  private int numRooms;

  public String getFormattedCost(); // i.e. $350,000
  public double getCostAsNumber(); // i.e. 350000
  public String getFormattedFootage(); // i.e. 2000 sq. ft.
  public double getAvgFootagePerRoom();
  public void setCost(double cost);

  House(double cost, String address, int footage, int numRooms);
} 
```


```java
class House implements IHouse {
  // Your code here!
}
```

3) What is the range of possible values printed by this program?  
(Square brackets mean inclusive, parentheses mean the opposite)

```java
public class RandAdd {
  public static void main(String[] args) {
    double a = Math.random() * 10;
    double b = Math.random() * 5 + 5;

    System.out.print(a + b);
  }
}
```

a. \[5-20)  
b. (5-10)  
c. (1-21)  
d. \(5-25]  

4) Which of the following is *not* a primitive in Java?

a. `int`  
b. `char`  
c. `medium`  
d. `byte`

5) Which of the following will return `false` if strings `a` and `b` are equivalent?

a. `a == b`  
b. `!(a.compareTo(b) == 0)`  
c. `a.equals(b)`  
d. `!!a.format(b)`
