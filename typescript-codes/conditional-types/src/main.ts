//type SomeType = T extends U ? X : Y;

type SomeType = string;
type ConditionalType = SomeType extends string ? string : null;

function fn1<T>(value: T) {
  const fn2 = (arg: T extends boolean ? "A" : "B") => {};
  return fn2;
}

const result = fn1(true);

type StringOrNot<T> = T extends string ? string : never;
type AUnion = string | boolean | never;

const A: StringOrNot<string> = "string";

type ResultType = Exclude<"a" | "b" | "c", "a" | "b">;

// type AType<T> = T extends string | number ? T : never;

// type MyResult = AType<string | number | boolean>;

// type AType<T> = (() => T) extends () => string | number ? T : never;

// type MyResult = AType <string | number | boolean>;

type AType<T> = [T] extends [string | number] ? T : never;

type MyResult = AType<string | number | boolean>;

// 통으로 비교해서 string number만 있지 않은 경우 false가 반환되어 never가 할당됨.
