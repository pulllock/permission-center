package fun.pullock.permission.core.config;

import fun.pullock.permission.core.session.AdminSessionInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private AdminSessionInterceptor adminSessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminSessionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/auth/login");
    }
}
