//  Type Alias, Interface 타입의 이름을 지정하는 방법,

// 공통점
// 클래스에 Implements를 사용할 수 있음, 추후 Implements에 깊게 배워보자
// Union 유형을 사용하면 개발자가 타입 A 또는 타입 B가 될 수 있는 새 Type을 만들 수 있다,
// I 연산자를 사용하여 Type과 interface를 모두 사용하여 새로운 Union 유형을 생성함. 선언은 항상 type이여야 함.

// 차이점
// interface는 Extends를 이용해서 확장 선언 후 아래에서 다시 선언해서 병합이 가능함.
// type은 &을 이용해서 확장, 선언 병합이 안됨(중복 선언이 불가능).

interface Animal {
  name: string;
}
interface Bear extends Animal {
  honey: boolean;
}

// const bear1: Animal = {
//   name: "honey bear",
//   honey: true,
// };

const bear1: Bear = {
  name: "honey bear",
  honey: true,
};

type Animal1 = {
  name: string;
};

type Bear1 = Animal1 & {
  honey: boolean;
};

const bear2: Bear1 = {
  name: "honey bear",
  honey: true,
};

interface Animal2 {
  name: string;
}

interface Animal2 {
  honey: boolean;
}

const bear3: Animal2 = {
  name: "honey bear",
  honey: true,
};

interface a {
  name: string;
}

interface b {
  honey: boolean;
}

type NewType = a | b;

const c: NewType = {
  name: "honey bear",
  honey: true,
};
