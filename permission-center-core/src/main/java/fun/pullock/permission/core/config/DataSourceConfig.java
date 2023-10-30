package fun.pullock.permission.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"fun.pullock.permission.core.dao.mapper"})
public class DataSourceConfig {
}
