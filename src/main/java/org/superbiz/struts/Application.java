package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.Collections;

@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean1() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        SiteMeshFilter siteMeshFilter = new SiteMeshFilter();
        filterFilterRegistrationBean.setFilter(siteMeshFilter);
        filterFilterRegistrationBean.setOrder(1);
        filterFilterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean2() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        StrutsPrepareAndExecuteFilter strutsPrepareAndExecuteFilter = new StrutsPrepareAndExecuteFilter();
        filterRegistrationBean.setFilter(strutsPrepareAndExecuteFilter);
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean
                .addUrlPatterns("/",
                        "/addUserForm.action",
                        "/findUserForm.action",
                        "/listAllUsers.action",
                        "/addUser.action",
                        "/findUser.action");
        return filterRegistrationBean;
    }


}
