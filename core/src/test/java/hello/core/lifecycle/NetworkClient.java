package hello.core.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }


    // 최신 스프링에서 가장 권장하는 방법
    // 스프링에 종속적인 기술이 아니라 자바 표준이다. 다른 컨테이너에서도 동작한다.
    // 유일한 단점, 외부 라이브러리에는 적용하지 못한다.
    // 결론 : 애노테이션을 사용하자! 외부 라이브러리를 초기화, 종료 해야 한다면 Bean의 기능을 사용하자!
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init" );
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
