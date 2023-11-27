// 함수 오버로딩을 사용하여 단일 함수 구현에 대해 여러 함수 시그니처를 정의할 수 있다.
// 기본적인 구조는 같지만 매개변수가 다를때 두 함수를 하나로 만들어 줄 수 있다.
function add(a: string, b: string): string;
function add(a: number, b: number): number;

function add(a: any, b: any): any {
  return a + b;
}

//유형 추론을 사용하여 제공된 인수를 기반으로 호출할 타입을 결정
add("hello", "world"); //string이 return됨
add(1, 2); //number가 return됨
// add(1, "2"); 숫자 + 문자 선언한 타입이 없으므로 오류 발생

// function saySomething(word: string | string[]): string {
//   // typeof 연산자를 사용하여 word가 문자열인지 확인
//   if (typeof word === "string") {
//     // 문자열인 경우, 해당 문자열을 그대로 반환
//     return word;
//   } else if (Array.isArray(word)) {
//     // 문자열 배열인 경우, 배열 요소들을 공백으로 구분하여 결합하여 반환
//     return word.join(" ");
//   }
// }

// 함수 오버로딩을 사용한 예
function saySomething(word: string): string;
function saySomething(words: string[]): string;
function saySomething(word: any): any {
  if (typeof word === "string") {
    return word;
  } else if (Array.isArray(word)) {
    return word.join(" ");
  }
}

// 함수 호출
const result1 = saySomething("Hello, TypeScript!"); // 문자열을 전달하면 그대로 반환
console.log(result1); // 출력: "Hello, TypeScript!"

const result2 = saySomething(["Hello", "world"]); // 문자열 배열을 전달하면 결합하여 반환
console.log(result2); // 출력: "Hello world"
