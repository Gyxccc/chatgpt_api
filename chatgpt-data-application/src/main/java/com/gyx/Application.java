package com.gyx;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gyx
 * @description 启动类
 * @create 2023-07-16 07:43
 */
@SpringBootApplication
@Configurable
public class Application
{
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
