// 접근 제어자 - 클래스 외부에서 클래스 멤버(필드, 메서드, 속성 등)의 가시성과 접근성을 제어하는 ​​TypeScript 및 기타 여러 객체 지향 프로그래밍 언어의 키워드
// 코드에 캡슐화, 데이터 숨기기, 액세스 제어를 적용하여 코드를 더욱 유지 관리하고 안전하게 만드는 데 도움이 된다
// public, private, protected, readonly, static 등이 있음
// 접근 제어자는 멤버 변수에 적용할 수 있음
// public - 기본 값, 어디서나 접근 가능
// private - 클래스 내부에서만 접근 가능
// protected - 클래스 내부, 상속받은 자식 클래스에서 접근 가능

class Post {
  // this로 접근하는 속성들을 위한 타입을 class 안에 넣어줘야 함.
  id: number = 0; // 초기값 설정 가능
  protected title: string = "";
  constructor(id: number, title: string) {
    // 매개변수에 접근 제어자를 적어주고 값들은 지워 간단하게 표현 가능.
    this.id = id;
    this.title = title;
  }
  getPost() {
    return `Post ${this.id}: ${this.title}`;
  }
}

// 이렇게 작성할 경우 public은 생략이 불가능하다.
// class Post {
//   constructor(private id: number, protected title: string) {
//   }
//   getPost() {
//     return `Post ${this.id}: ${this.title}`;
//   }
// }

// 하위 클래스이기 때문에 타이틀을 사용할 수 있음
class PostB extends Post {
  getPost(): string {
    return this.title;
  }
}

const post: Post = new Post(1, "title1");
// console.log(post.title); 클래스 내부거나, 하위 클래스가 아니기 떄문에 오류 발생
