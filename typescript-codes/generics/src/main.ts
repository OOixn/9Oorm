// function getArrayLength(arr: number[] | string[] | boolean[]): number {
//   return arr.length;
// }

function getArrayLength<T>(arr: T[]): number {
  return arr.length;
}

const array = [1, 2, 3];
const array2 = ["a", "b", "c"];
const array3 = [false, false, true];

getArrayLength<number>(array);
getArrayLength<string>(array2);
getArrayLength<boolean>(array3);

interface Vehicle<T> {
  name: string;
  color: string;
  option: T;
}

const car: Vehicle<{ price: number }> = {
  name: "Car",
  color: "red",
  option: {
    price: 1000,
  },
};

const bike: Vehicle<boolean> = {
  name: "bike",
  color: "green",
  option: true,
};

// 제네릭을 사용하면 재 사용성이 높은 함수와 클래스를 생성할 수 있다.

const makeArr = <T, Y>(x: T, y: Y): [T, Y] => {
  return [x, y];
};

const arr = makeArr<number, number>(1, 2);
const arr2 = makeArr<string, string>("a", "b");
const arr3 = makeArr<boolean, boolean>(true, false);
const arr4 = makeArr<string, number>("a", 1);

//기본 값을 지정해줄 수 있다

const makeArr1 = <T, Y = string>(x: T, y: Y): [T, Y] => {
  return [x, y];
};

const arr0 = makeArr1<string>("a", "b");

// extends {firstName:string, lastName:string} 는 항상 들어가게끔 하고 싶을 때.
const makeFullName = <T extends { firstName: string; lastName: string }>(obj: T) => {
  return {
    ...obj,
    fullName: obj.firstName + " " + obj.lastName,
  };
};

makeFullName({ firstName: "김", lastName: "석", location: "Seoul" });
// 퍼스트 네임을 지우거나 라스트 네임을 지우면 오류가 생긴다. 왜냐, 항상 들어가게끔 설정을 해줬으니.
makeFullName({ firstName: "김", lastName: "석", hello: "Greeting" });

//리액트에서는 useState, props로 무엇일 올지 모르기 때문에 제네릭을 사용한다고 한다.
