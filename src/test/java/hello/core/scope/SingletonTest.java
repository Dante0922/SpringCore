package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean singletonBena1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBena2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 = " + singletonBena1);
        System.out.println("singletonBean2 = " + singletonBena2);
        assertThat(singletonBena1).isSameAs(singletonBena2);

        ac.close();
    }

    @Scope
    static class SingletonBean{
        @PostConstruct
        public void init(){
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("SingletonBean.destroy ");
        }

    }
}
