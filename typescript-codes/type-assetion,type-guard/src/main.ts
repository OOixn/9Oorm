// 타입 단언 - 값 유형에 대한 판단을 신뢰하도록 지시하는것
// 값의 실제 유형과 단언한 유형이 일치하지 않으면 잠재적 오류가 발생할 수 있다.
const bodyElement = document.querySelector("body") as HTMLBodyElement;

bodyElement.innerText = "Hello";

// bodyElement!.innerText = "Hello";

// 타입 가드
// if (bodyElement){
// bodyElement.innerText = "Hello";
// }

// 타입 단언을 잘못 쓴 예
// function func(arg: string | null) {
//   return (arg as string).toLowerCase();
// }

// func("hello");
// func(null);

// null.toLowerCase는 사용 할 수 없으므로 오류 발생.

// 값이 특정 유형을 준수하는지 여부를 결정하는 데 도움이 되는 런타임 검사
// 조건부에서 타입 가드를 사용하여 변수 유형의 범위를 좁힐 수 있다
function func1(arg: string | null) {
  if (arg) {
    return arg.toLowerCase();
  }
}
