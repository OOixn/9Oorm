// Boolean
let boolean: boolean;
let falseBoolean: boolean = false;
let trueBoolean: boolean = true;

// Number
let number: number;
let integer: number = 6;
let float: number = 1.2345;

// String
let string: string;
let firstName: string = "Doe";

// Array
// 한가지 타입만 가지는 배열
let array: string[] = ["김", "안", "정"];
let array1: Array<string> = ["김", "안", "정"];

// 여러 타입을 가지는 배열(유니언 타입 사용)
let array2: (string | number)[] = ["김", "안", "정", 1];
let array3: Array<string | number> = ["김", "안", "정", 1];

// 여러 타입을 단언 할 수 없다면 any
let array4: any[] = ["김", "안", "정", 1, [], {}, false];

// Interface, Type

// 읽기 전용 배열 생성(readonly, ReadonlyArray) 읽기만 가능함, push 라던지 index로 숫자를 가져오는 것이 불가능함.
let readonlyArray: readonly string[] = ["김", "안", "정"];
let numberArray: ReadonlyArray<number> = [1, 2, 3];

// Tuple 튜플 유형을 정의하면 튜플의 요소 유형이 특정 순서로 고정됨.
let tuple1: [string, number];
tuple1 = ["김", 1];
// tuple1 = ["안", 1, 2]; 배열에 요소가 할당한 값보다 많음
// tuple1 = [1, "a"]; 요소의 타입 순서가 다름

let users: [number, string][];
users = [
  [1, "김"],
  [2, "안"],
];

let tuple2: [string, number];
tuple2 = ["김", 1];
tuple2.push(2); // 메소드를 이용해 값을 넣는 것이 가능함
console.log(tuple2);
// tuple2.push(false) 할당된 타입이 아니면 메소드를 이용해 값을 넣을 수 없음

// any 모든 타입이 할당 가능함, 변수에 어떤 값도 할당이 가능하지만 되도록이면 사용하지 않는게 좋음. 라이브러리를 사용할 때 주로 사용함.
let any: any = "abc";
any = 1;
any = [];

// unknown 알 수 없는 타입, 어떠한 값도 할당이 가능 하지만, 이 타입이 들어가있는 변수는 다른 변수에 할당할 수 없다.
let unknown: unknown = "abc";
// let string1:string = unknown
let string2: string = unknown as string; // 나중에 깊게 배워보자!

// Object
let object: object = {};
let arr: object = [];
let nul: object = null; //strict 엄격한 모드에서는 null을 Object에 할당할 수 없다.
let date: object = new Date();

const obj1: { id: number; title: string } = {
  id: 1,
  title: "title1",
};

// Union
let union: string | number;
union = "abc";
union = 1;
// union = false;

// Function
let func1: (arg1: number, arg2: number) => number; // 반환하게 되는 타입을 지정해줘야함.
func1 = function (x, y) {
  return x + y;
};

let func2: () => void; // 반환하는 값이 없으면 void.
func2 = function () {
  console.log("hi");
};

// Null, Undefined strictNullChecks가 false로 되어있으면 오류가 발생 하지 않음. 실제로 사용할떈 true로 지정해주자
let number1: number = undefined;
let string0: string = null;
let object0: { a: 10; b: false } = undefined;

// void
function greeting(): void {
  console.log("hi");
}

// 실제로 출력 되는 값은 undefined 이지만 타입을 undefined로 지정하면 오류가 발생한다. 왜?

// never 항상 오류를 출력하거나 리턴 값을 절대로 내보내지 않음을 확신할때 사용해줌.
function error(): never {
  throw new Error("error");
}

// 리턴 값을 절대로 내보내지 않는 경우
function keepProcessing(): never {
  while (true) {
    console.log("processing...");
  }
}

// 빈 배열을 타입으로 잘못 선언한 경우에도 never 타입을 갖게 된다.
const never: [] = [];
// const never: number[] = [];
// never.push(1);

// Typescript 5.1 버전부터는 return 없는 함수의 return 타입으로 undefined를 허용해 놓았다. (void, undefined) 모두 사용 가능
