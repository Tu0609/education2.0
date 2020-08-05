package cn.tcr.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author TuTu
 * @date 2020/6/19 20:16
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class BizMain80 {

    public static void main(String[] args) {
        SpringApplication.run(BizMain80.class);
    }

}
