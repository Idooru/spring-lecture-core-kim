package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        final AnnotationConfigApplicationContext ac1 = new AnnotationConfigApplicationContext(SingletonBeanFirst.class);
        final SingletonBeanFirst singletonBean1 = ac1.getBean(SingletonBeanFirst.class);
        final SingletonBeanFirst singletonBean2 = ac1.getBean(SingletonBeanFirst.class);

        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        assertThat(singletonBean1).isEqualTo(singletonBean2);
        assertThat(singletonBean1).isSameAs(singletonBean2);


        final AnnotationConfigApplicationContext ac2 = new AnnotationConfigApplicationContext(SingletonBeanSecond.class);
        final SingletonBeanSecond singletonBean3 = ac2.getBean(SingletonBeanSecond.class);
        final SingletonBeanSecond singletonBean4 = ac2.getBean(SingletonBeanSecond.class);

        System.out.println("singletonBean3 = " + singletonBean3);
        System.out.println("singletonBean4 = " + singletonBean4);

        assertThat(singletonBean3).isEqualTo(singletonBean4);
        assertThat(singletonBean3).isSameAs(singletonBean4);

        assertThat(singletonBean1).isNotEqualTo(singletonBean3);
        assertThat(singletonBean2).isNotSameAs(singletonBean4);

        ac1.close();
        ac2.close();
    }

    @Scope("singleton")
    static class SingletonBeanFirst {

        @PostConstruct
        public void init() {
            System.out.println("SingletonBeanFirst.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBeanFirst.destroy!!");
        }
    }

    @Scope("singleton")
    static class SingletonBeanSecond {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBeanSecond.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBeanSecond.destroy!!");
        }
    }
}
