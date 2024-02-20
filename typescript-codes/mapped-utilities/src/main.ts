type Properties = "propA" | "propB";

type MyNewType = MyMappedType<{ a: "a"; b: "b" }>;

type MyMappedType<T> = {
  readonly [P in keyof T]: T[P] | null;
};

// Pick, Record
// 타입에 지정된 것들만 가져올 수 있음
// type Pick1 = Pick<{ a: "a"; b: "b"; c: "c" }, "a" | "b">;

type Pick1<T, Properties extends keyof T> = {
  [P in Properties]: T[P]; // Properties를 순회해서 T 객체 안에 P 속성의 값?
};

type MyNewType2 = Pick1<{ a: "a"; b: "b"; c: "c" }, "a">;

type Record1<K extends keyof any, T> = {
  [P in K]: T;
};

const myNewRecord: Record1<string, number> = {};
myNewRecord.a = 10;
