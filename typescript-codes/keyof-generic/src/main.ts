interface Person {
  name: string;
  age: number;
  address: string;
}

const person: Person = {
  name: "john",
  age: 30,
  address: "seoul",
};

const age = getProperty(person, "age");
const name = getProperty(person, "name");
// const invalid = getProperty(person, "invalid");

// K의 타입은 항상 T의 타입을 받아온다.
function getProperty<T, K extends keyof T>(obj: T, key: K) {
  return obj[key];
}
