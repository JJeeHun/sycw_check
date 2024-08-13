package com.sycw.sycw_check;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class Test01 {

    @Test
    public void join() {
        User user = new User();
        System.out.println("user = " + user);
        user.setName("홍길동");
        user.setAge(10);
        user.setEmail("www.naver.com");

        /// 저장
        User findUser = new User();
        findUser.setName("홍길동");
        findUser.setAge(10);
        findUser.setEmail("www.naver.com");


        Assertions.assertThat(user.getName()).isEqualTo(findUser.getName());
        Assertions.assertThat(user.getAge()).isEqualTo(findUser.getAge());
        Assertions.assertThat(user.getEmail()).isEqualTo(findUser.getEmail());
    }

    @Test
    public void login() {
        // given
        User clientUser = new User();

        clientUser.setName("홍길동");
        clientUser.setAge(10);
        clientUser.setEmail("www.naver.com");
        /// 저장 - 디비에 저장

        // when
        User findUser = new User();

        // then
        Assertions.assertThat(findUser).isNotNull();
        Assertions.assertThat(clientUser.getId()).isEqualTo(findUser.getId());
    }
}

class User {
    private Long id;
    private String name;
    private int age;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
