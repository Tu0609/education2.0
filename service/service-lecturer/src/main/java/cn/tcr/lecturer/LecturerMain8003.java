package cn.tcr.lecturer;

import cn.tcr.lecturer.bean.Lecturer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author TuTu
 * @date 2020/6/18 14:33
 */
@SpringBootApplication
@ComponentScan({"cn.tcr"})
@MapperScan(value = "cn.tcr.lecturer.mapper")
public class LecturerMain8003 {

    public static void main(String[] args) {
        SpringApplication.run(LecturerMain8003.class);
    }

}
