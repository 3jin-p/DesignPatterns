Templat Method Pattern
--
템플릿 메소드 패턴은 주로 비슷한 구현 코드의 중복을 제거하기 위하여 사용한다.  
기본적으로, 추상 클래스에 공통 알고리즘을 콘크리트 템플릿 메소드로 제공,  
변경이나 확장이 일어날 부분을 추상 메소드나 아주 약간의 구현만 되어있는 Overide 가능한 메소드(Hook 또는 primitve 메소드라고 한다.) 를 제공하여  
공통 알고리즘 내부에서 호출한다.  

---
## UML  
![템플릿 메소드 패턴](template-method-pattern.png)
---
## 예제
간단한 예제와 함께 살펴보자.
커피와, 차를 제조하는 코드를 생성한다고 생각해보자.

```java
public class Coffee {

    public void makeCoffee() {
        boidWater();
        putPowder();
        mix();
        pourToCup();
    }

    private void boidWater() {
        System.out.println("보글보글");
    }

    private void putCoffee() {
        System.out.println("커피넣엉");
    }

    private void mix() {
        System.out.println("쉐낏 쉐낏");
    }

    private void pourToCup() {
        System.out.println("커피잔에 쪼로록");
    }

}


public class Tea {

    public void makeTea() {
        boidWater();
        putPowder();
        mix();
        pourToCup();
    }

    private void boidWater() {
        System.out.println("보글보글");
    }

    private void putCoffee() {
        System.out.println("찻잎넣엉");
    }

    private void mix() {
        System.out.println("쉐낏 쉐낏");
    }

    private void pourToCup() {
        System.out.println("티잔에 쪼로록");
    }

}
```

벌써 많은 코드의 중복이 보인다. 이제 템플릿 메소드를 적용해보자.

```java
public abstract class Drink {

    public final void makeDrink() {
        boidWater();
        putPowder();
        mix();
        pourToCup();
    }

    private void boidWater() {
        System.out.println("보글보글");
    }

    abstract void putPowder();

    private void mix() {
        System.out.println("쉐낏 쉐낏");
    }

    protected void pourToCup() {
        System.out.println("쪼로록");
    }

}
```
템플릿이 될 추상클래스 Drink 를 생성하고, 생성할 음료마다 구현이 달라지는  
putPowder를 추상메소드로, 일부의 구현은 동일한 pourToCup 메소드를 protected 접근제어자로 생성하였다.  
커피와 차 클래스는 아래와 같이 구현된다.
```java
public class Coffee extends Drink {
    @Override
    void putPowder() {
        System.out.println("커피 가루 콸ㅋ콸콸~");
    }

    @Override
    protected void pourToCup() {
        System.out.println("커피잔에");
        super.pourToCup();
    }
}

public class Tea extends Drink {
    @Override
    void putPowder() {
        System.out.println("티백 퐁당");
    }

    @Override
    protected void pourToCup() {
        System.out.println("티 잔에");
        super.pourToCup();
    }
}
```

템플릿 메소드 패턴을 사용하면 중복을 줄이고, 많은 코드를 재사용할 수 있게된다.  
하지만 템플릿 메소드 패턴은 코드 내부에서 정형화된 프레임웍을 만들어내기 때문에 항상 주의하여 사용하여야한다.  

