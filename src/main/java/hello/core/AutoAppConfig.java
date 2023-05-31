package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/* ComponentScan은 @Component가 붙은 모든 클래스를 불러온다.
  이 중 excludeFilters를 달아줘서
* 다른 Configuration은 제외하도록 했다.*/
@Configuration
@ComponentScan(
        /* 탐색할 패키지의 시작 위치를 지정한다. 이 패키지를 포함해서 하위 패키지를 모두 탐색한다.
        지정하지 않으면 디폴트로 componentScan이 붙은 클래스의 패키지가 시작 위치가 된다.
        여기선 hello.core.
         관례적으로 설정정보 클래스를 프로젝트의 최상단에 둔다. */
        basePackages  ="hello.core.member",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
