package ru.Shamonin.web_Aircraft;

import ru.Shamonin.web_Aircraft.Beans.FirstBean;
import ru.Shamonin.web_Aircraft.Beans.SecondBean;
import ru.Shamonin.web_Aircraft.Beans.ThirdBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {
    @Bean
    @Profile("test")
    public FirstBean firstBean() {
        return new FirstBean();
    }

    @Bean
    @ConditionalOnBean(FirstBean.class)
    public SecondBean secondBean() {
        return new SecondBean();
    }

    @Bean
    @Profile("test")
    @ConditionalOnProperty(name = "app.environment", havingValue = "default", matchIfMissing = true)
    public ThirdBean thirdBean() {
        return new ThirdBean();
    }
}
