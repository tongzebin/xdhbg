package cn.xdh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@MapperScan(basePackages="cn.xdh.dao")
public class RunBoot {
    public static void main(String[] args) {
        ApplicationContext ac = run(RunBoot.class, args);
    }
}
