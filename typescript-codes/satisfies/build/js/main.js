// Boolean
let boolean;
let falseBoolean = false;
let trueBoolean = true;
// Number
let number;
let integer = 6;
let float = 1.2345;
// String
let string;
let firstName = "Doe";
// Array
// 한가지 타입만 가지는 배열
let array = ["김", "안", "정"];
let array1 = ["김", "안", "정"];
// 여러 타입을 가지는 배열(유니언 타입 사용)
let array2 = ["김", "안", "정", 1];
let array3 = ["김", "안", "정", 1];
// 여러 타입을 단언 할 수 없다면 any
let array4 = ["김", "안", "정", 1, [], {}, false];
// Interface, Type
// 읽기 전용 배열 생성(readonly, ReadonlyArray) 읽기만 가능함, push 라던지 index로 숫자를 가져오는 것이 불가능함.
let readonlyArray = ["김", "안", "정"];
let numberArray = [1, 2, 3];
// Tuple 튜플 유형을 정의하면 튜플의 요소 유형이 특정 순서로 고정됨.
let tuple1;
tuple1 = ["김", 1];
// tuple1 = ["안", 1, 2]; 배열에 요소가 할당한 값보다 많음
// tuple1 = [1, "a"]; 요소의 타입 순서가 다름
let users;
users = [
    [1, "김"],
    [2, "안"],
];
let tuple2;
tuple2 = ["김", 1];
tuple2.push(2); // 메소드를 이용해 값을 넣는 것이 가능함
console.log(tuple2);
// tuple2.push(false) 할당된 타입이 아니면 메소드를 이용해 값을 넣을 수 없음
// any 모든 타입이 할당 가능함, 변수에 어떤 값도 할당이 가능하지만 되도록이면 사용하지 않는게 좋음. 라이브러리를 사용할 때 주로 사용함.
let any = "abc";
any = 1;
any = [];
// unknown 알 수 없는 타입, 어떠한 값도 할당이 가능 하지만, 이 타입이 들어가있는 변수는 다른 변수에 할당할 수 없다.
let unknown = "abc";
// let string1:string = unknown
let string2 = unknown; // 나중에 깊게 배워보자!
// Object
let object = {};
let arr = [];
let nul = null; //strict 엄격한 모드에서는 null을 Object에 할당할 수 없다.
let date = new Date();
const obj1 = {
    id: 1,
    title: "title1",
};
// Union
let union;
union = "abc";
union = 1;
// union = false;
// Function
let func1; // 반환하게 되는 타입을 지정해줘야함.
func1 = function (x, y) {
    return x + y;
};
let func2; // 반환하는 값이 없으면 void.
func2 = function () {
    console.log("hi");
};
// Null, Undefined strictNullChecks가 false로 되어있으면 오류가 발생 하지 않음. 실제로 사용할떈 true로 지정해주자
let number1 = undefined;
let string0 = null;
let object0 = undefined;
// void
function greeting() {
    console.log("hi");
}
// 실제로 출력 되는 값은 undefined 이지만 타입을 undefined로 지정하면 오류가 발생한다. 왜?
// never 항상 오류를 출력하거나 리턴 값을 절대로 내보내지 않음을 확신할때 사용해줌.
function error() {
    throw new Error("error");
}
// 리턴 값을 절대로 내보내지 않는 경우
function keepProcessing() {
    while (true) {
        console.log("processing...");
    }
}
// 빈 배열을 타입으로 잘못 선언한 경우에도 never 타입을 갖게 된다.
const never = [];
// const never: number[] = [];
// never.push(1);
