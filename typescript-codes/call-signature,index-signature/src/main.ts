// 함수를 재사용 하기 위해서
interface getLikeNumber {
  (like: number): number;
  // 매개변수와 타입, 반환하는 타입
}

interface Post1 {
  id: number;
  title: string;
  getLikeNumber: getLikeNumber;
}

const post1: Post1 = {
  id: 1,
  title: "post 1",
  getLikeNumber(like: number) {
    return like;
  },
};

post1.getLikeNumber(1);

// 객체를 위한 인덱스 시그니처
// 미리 알려지지 않은 키의 속성 값 유형을 정의
// 동적 속성 이름을 가진 객체가 있을 때 자주 사용

interface Post2 {
  [key: string]: unknown;
  id: number;
  title: string;
}

const post2: Post2 = {
  id: 2,
  title: "post2",
};

post2["description"] = "description1";
post2["pages"] = 300;

// 배열 인덱스 시그니처
// 키가 숫자일 때 속성 유형을 정의하는 방법
// 배열이나 목록 같은 구조처럼 동작하는 객체나 인터페이스를 설명하려고 할 때 일반적으로 사용
interface Names {
  [item: number]: string;
  // userNames(0) === "김"
}

const userNames= ["김", "안", "정"];
