package cn.tcr.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author TuTu
 * @date 2020/6/18 13:33
 */
@SpringBootApplication
@ComponentScan({"cn.tcr"})
@MapperScan(value = "cn.tcr.student.mapper")
public class StudentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(StudentMain8002.class);
    }

}
