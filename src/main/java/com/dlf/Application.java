package com.dlf;

import com.dlf.router.filter.UrlRedirectFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;



/**
 * Created by Administrator on 2017/4/28.
 */
@EnableZuulProxy
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public UrlRedirectFilter urlRedirectFilter(){
        return new UrlRedirectFilter();
    }

//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //允许上传的文件最大值
//        factory.setMaxFileSize("2MB"); //KB,MB
//        /// 设置总上传数据总大小
//        factory.setMaxRequestSize("2MB");
//        return factory.createMultipartConfig();
//    }
}
