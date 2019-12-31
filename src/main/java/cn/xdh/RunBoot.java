package cn.xdh;
import cn.xdh.dao.StudentNumberDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages="cn.xdh.dao")
public class RunBoot {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(RunBoot.class, args);
    }
}
