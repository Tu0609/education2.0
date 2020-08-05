package cn.tcr.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author TuTu
 * @date 2020/6/19 8:29
 */
@SpringBootApplication
@ComponentScan({"cn.tcr"})
@MapperScan(value = "cn.tcr.course.mapper")
public class CourseMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(CourseMain8004.class);
    }

}
