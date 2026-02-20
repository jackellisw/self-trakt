package io.github.jackellisw.selftrakt;

import org.springframework.boot.SpringApplication;

public class TestSelfTraktApplication {

    public static void main(String[] args) {
        SpringApplication.from(SelfTraktApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
