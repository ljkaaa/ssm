package ljk.config;


import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"ljk.service","ljk.aop"})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfig {
}
