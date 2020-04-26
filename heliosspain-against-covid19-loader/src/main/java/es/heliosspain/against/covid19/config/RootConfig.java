package es.heliosspain.against.covid19.config;


import es.heliosspain.against.covid19.util.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication(scanBasePackages = {"es.heliosspain"})
@PropertySources({
        @PropertySource("file:${HELIOS_HOME}/application.properties")
})

public class RootConfig {

    //Constants to set the log4j2 configuration location.
    public static final String LOGGING_CONFIG_PROPERTY = "logging.config";
    public static final String FILE = "file:";
    public static final String LOG4J2_FILE_RELATIVE_PATH = "/log4j2.xml";

    /**
     * Main method to initialize the application via spring boot instead of war.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(RootConfig.class);
    }



    /**
     * Method that allows us to read from a properties.
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }



}
