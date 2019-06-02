package game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by NeelaGouda on 6/2/19.
 */
@SpringBootApplication
public class GameApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameApplication.class);


    public static void main(String[] args) {
        LOGGER.info("-------Starting Gaming Application-----");
        SpringApplication.run(GameApplication.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                LOGGER.info(beanName);
            }

        };
    }
}
