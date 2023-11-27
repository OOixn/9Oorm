const bodyElement = document.querySelector("body");
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
// 타입 가드를 사용하여 방지? 해줌.
function func1(arg) {
    if (arg) {
        return arg.toLowerCase();
    }
}
