package cn.xdh;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@MapperScan(basePackages="cn.xdh.dao")
@ServletComponentScan
public class RunBoot {
    public static void main(String[] args) {
        ApplicationContext ac = run(RunBoot.class, args);


    }
}
