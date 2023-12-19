package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core", // 탐색할 패키지의 시작 위치를 지정해줄 수 있다. 이 패키지를 포함, 하위 패키지를 모두 탐색.
        //basePackages = {"hello.core", "hello.service"} 여러 개도 지정 가능
        // 기본 값은 이 패키지가 시작 위치가 된다. 이 하위 패키지가 모두 탐색되는 것.
        // 권장 방법 -> 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것.
        // @ComponentScan 컴포넌트 스캔에서 사용
        // @Controller 스프링 MCV 컨트롤러에서 사용, 스프링 MVC 컨트롤러로 인식
        // @Service 스프링 비즈니스 로직에서 사용, 특별한 처리를 하지 않지만 개발자들이 핵심 비즈니스 로직이 여기에 있겠구나 라고 인식하는데 도움이 된다.
        // @Repository 스프링 데이터 접근 계층에서 사용, 데이터 계층의 예외를 스프링 예외로 변환해준다
        // @Configuration 스프링 설정 정보에서 사용, 스프링 빈이 싱글톤을 유지하도록 추가 처리를 해준다
        // 위에 모든 것들은 자동으로 컴포넌트 스캔의 대상이 된다.
        // 애노테이션은 상속관계라는 것이 없다, 자바 언어가 지원하는 기능이 아니라, 스프링이 지원하는 기능이다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)

public class AutoAppConfig {



}
