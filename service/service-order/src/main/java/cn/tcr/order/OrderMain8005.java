package cn.tcr.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author TuTu
 * @date 2020/6/19 11:38
 */
@SpringBootApplication
@ComponentScan({"cn.tcr"})
@MapperScan(value = "cn.tcr.order.mapper")
public class OrderMain8005 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain8005.class);
    }

}

