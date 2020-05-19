package com.dlf;

import com.dlf.router.filter.UrlRedirectFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;


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

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //允许上传的文件最大值
        factory.setMaxFileSize(DataSize.of(2, DataUnit.MEGABYTES));
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.of(2, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }
}
