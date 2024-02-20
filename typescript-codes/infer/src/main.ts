// type Some Type = T extends infer U ? U : Y;
// U의 타입을 추론해서 T가 U에 할당 가능하면 U 할당할 수 없으면 Y
// infer는 T가 U에 최대한 할당가능하게 U의 타입을 추론하라고 하는 것.

// type AType<T> = T extends infer R ? R : null;

// const a: AType<number> = 1;

// type BType<T> = T extends { a: infer A; b: 1 } ? A : any;

// type inferred = BType<{ a: "hi"; b: 1 }>;

// type CType<T> = T extends { a: infer A; b: infer B } ? A & B : any;

// type Inferred2 = CType<{ a: { somAProps: 1 }; b: { someBProps: 2 } }>;

// type MyReturnType = ReturnType

//리턴 타입은 반환하는 값이 타입이 됨.
// type T0 = ReturnType<() => string>;
// type T1 = ReturnType<(s: string) => void>;

// function fn(str: string) {
//   return str;
// }

// type T2 = ReturnType<typeof fn>;
