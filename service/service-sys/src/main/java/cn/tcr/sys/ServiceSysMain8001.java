package cn.tcr.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author TuTu
 * @date 2020/6/17 15:13
 */
@SpringBootApplication
@ComponentScan({"cn.tcr"})
@MapperScan(value = "cn.tcr.sys.mapper")
@EnableDiscoveryClient
public class ServiceSysMain8001 {

    public static void main(String[] args) {
//        System.out.println(MD5.encrypt("123456"));
        SpringApplication.run(ServiceSysMain8001.class);
    }

}
