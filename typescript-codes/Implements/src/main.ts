// implements 부모 클래스의 프로퍼티와 메소드를 상속받아서 사용하는게 아니라 새로운 클래스의 타입 체크를 위해서 사용된다

class Car {
  mileage = 0;
  price = 100;
  color = "white";
  drive() {
    return "drive!";
  }
  brake() {
    return "brake!";
  }
}

class Ford extends Car {}
const myFordCar = new Ford();

class Ford1 implements Car {
  mileage: number;
  price: number;
  color: string;
  drive(): string {
    return "drive!";
  }
  brake(): string {
    return "drive!";
  }
}
