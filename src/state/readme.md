State Pattern
-- 

State Pattern 이란, 객체의 상태에 따라 행위가 달라질때 사용하는 패턴이다.

예제로 다음과 같은 요구사항이 있는 형광등을 구현해보자.

- 형광등은 켜짐 상태와 꺼짐 상태가 있다.
- 형광등의 켜짐 버튼을 눌렀을때, 형광등이 꺼져있으면 켜고 켜져있으면 아무 동작도 하지 않는다.
- 형광등의 꺼짐 버튼을 눌렀을때, 형광등이 켜져있으면 끄고 꺼져있으면 아무 동작도 하지 않는다.

```` java
public class Light {

    private static final boolean ON = true;
    private static final boolean OFF = false;
    
    private boolean isLightOn;
    
    public Light() { this.isLightOn = OFF }
    
    public void pushTurnOnButton() {
        if (!this.isLightOn) {
            isLightOn = OFF;
            System.out.println("꺼짐");
        } else {
            System.out.println("아무 변화 없음");
        }
    }
    
    public void pushTurnOffButton() {
        if (this.isLightOn) {
            isLightOn = ON;
            System.out.println("켜짐");
        } else {
            System.out.println("아무 변화 없음");
        }
    }
}
````
  
단순히 요구사항대로만 구현한다면 위 처럼 구현이 될 것이다. 
하지만 여기서 상태가 추가된다거나, 상태에 따른 행위가 변경된다면?  
**코드는 조건문으로 덕지덕지 칠해지고, 계속 변경되게 될 것이고 OCP 를 위반하게 될 것이다.**  
  
그래서 객체에서 상태에 대한 관심사를 분리해내 독립적인 Interface 로 만드는것이 State 패턴이다.  

```` java
// 상태 정보 인터페이스
public interface LightState {
    void turnOnButtonPushed(Light light);
    void turnOffButtonPushed(Light light);
}

// 켜짐 상태
public class OnState implements LightState {
    private static OnState onState = null;

    private OnState() {}
    // Sigleton
    public static OnState getInstance() {
        if (onState == null) {
            onState = new OnState();
        }
        return onState;
    }

    @Override
    public void turnOnButtonPushed(Light light) {
        System.out.println("변화 없음");
    }

    @Override
    public void turnOffButtonPushed(Light light) {
        light.setState(OffState.getInstance());
        System.out.println("불 꺼짐");
    }
}

// 꺼짐 상태 
public class OffState implements LightState{

    private static OffState offState = null;

    private OffState() {}
    // Singleton
    public static OffState getInstance() {
        if (offState == null) {
            offState = new OffState();
        }
        return offState;
    }

    @Override
    public void turnOnButtonPushed(Light light) {
        light.setState(OnState.getInstance());
        System.out.println("불 켜짐");
    }

    @Override
    public void turnOffButtonPushed(Light light) {
        System.out.println("변화 없음");
    }
}
````
1. 위와 같은 LightState 인터페이스에 요구사항의 상태에따라 달라지는 행위에 대한 정보를 작성하고
2. LightState를 구현한 각 상태에서 해당 행위를 구현한다.
3. 상태 정보는 새로운 객체를 생성하며 메모리를 낭비 할 필요가 없으므로 싱글톤으로 구현해준다.  

이렇게 하면 특정 상태에서의 행위처리 방법이 달라지면 그 행위의 구현체만 수정하고, 다른 행위가 추가될 경우에도 손쉽게 확장할 수 있는 장점이 있다.  

LightState 인터페이스를 활용한 Light 객체는 아래와 같다. 

```` java

publi class OffState implements LightState{

    private static OffState offState = null;

    private OffState() {}

    public static OffState getInstance() {
        if (offState == null) {
            offState = new OffState();
        }
        return offState;
    }

    @Override
    public void turnOnButtonPushed(Light light) {
        light.setState(OnState.getInstance());
        System.out.println("불 켜짐");
    }

    @Override
    public void turnOffButtonPushed(Light light) {
        System.out.println("변화 없음");
    }
}

````

**State 패턴 UML**  

<img src="state.png"  width="200" height="150"
