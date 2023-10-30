package fun.pullock.permission.core.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = {"fun.pullock"})
@Configuration
public class FeignConfig {
}
