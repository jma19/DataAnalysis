package com.ele.data.anslysis;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by majun on 15/10/24.
 */
public class MyTest {
    @Test
    public void testName() throws Exception {
        MyBean xiaoya = new MyBean("xiaoya", 24);
        Field field = MyBean.class.getDeclaredField("name");
        Method method = MyBean.class.getDeclaredMethod("getName");
        System.out.println(method.getName());
        Object invoke = method.invoke(xiaoya);
        System.out.println(invoke);

    }

    class MyBean {
        public MyBean(String name, int id) {
            this.name = name;
            this.id = id;
        }

        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
