// Partial 특정 타입의 부분 집합을 만족하는 타입을 정의할 수 있음

interface Address {
  email: string;
  address: string;
}

const me: Partial<Address> = {};
const you: Partial<Address> = { email: "kkk@abc.com" };
const all = { email: "kkk@abc.com", address: "kkk" };

// Pick 특정 타입에서 몇 개를 선택해서 타입을 정의할 수 있음

interface Todo {
  title: string;
  description: string;
  completed: boolean;
}

type TodoPreview = Pick<Todo, "title" | "completed">;

const todo: TodoPreview = {
  title: "Clean Room",
  completed: false,
};

//Omit 특정 타입만 제거하여 정의하 수 있음

interface Todo {
  title: string;
  description: string;
  completed: boolean;
  createdAt: number;
}

type Todo1Preview = Omit<Todo, "description">;

const todo1: Todo1Preview = {
  title: "clean room",
  completed: false,
  createdAt: 1234,
};

// Exclude 일반 Union 유형을 전달한 다음 두번째 인수에서 제거할 멤버를 지정.

//Required 원래 유형이 일부 속성을 선택사항으로 정의한 경우에도 객체에 Required 속성이 있는지 확인해야 하는 경우가 있다 모든 속성을 필수로 만들게 해준다.

type User = {
  firstName: string;
  lastName?: string;
};

let firstUser: User = {
  firstName: "김",
};

let secondUser: Required<User> = {
  firstName: "kim",
  lastName: "dd",
};

// Record<Keys, Type> 타입의 속성을 다른 타입에 맵핑하는데 사용할 수 있다.

interface CatInfo {
  age: number;
  breed: string;
}

type CatName = "miffy" | "boris" | "mordred";

const cats: Record<CatName, CatInfo> = {
  miffy: { age: 10, breed: "persian" },
  boris: { age: 5, breed: " maine coon" },
  mordred: { age: 16, breed: "british shorthair" },
};

//ReturnType <T> 함수 T의 반환 타입으로 구성된 타입을 만든다.

type T0 = ReturnType<() => string>;
type T1 = ReturnType<(s: string) => void>;

function fn(str: string) {
  return str;
}

const a: ReturnType<typeof fn> = "hello";
// const b: ReturnType<typeof fn> = true;
