package es.heliosspain.against.covid19.config;

import es.heliosspain.against.covid19.util.Constants;
import org.apache.catalina.authenticator.jaspic.AuthConfigFactoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.security.auth.message.config.AuthConfigFactory;


@SpringBootApplication(scanBasePackages = {"es.heliosspain"})
@PropertySources({
        @PropertySource("file:${HELIOS_HOME}/application.properties")
})
public class RootConfig extends SpringBootServletInitializer {

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
        initializeLog4j2ConfPath();
        if (AuthConfigFactory.getFactory() == null) {
            AuthConfigFactory.setFactory(new AuthConfigFactoryImpl());
        }
        SpringApplication.run(RootConfig.class);
    }

    /**
     * Default application building configuration
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        initializeLog4j2ConfPath();
        return application.sources(RootConfig.class);
    }

    /**
     * We define a dispatcherServlet, that is needed in case of executing the WAR in a JBoss Server. It has not effect if using Tomcat.
     *
     * @return
     */
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/*");
        registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return registration;
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

    /**
     * Method to set the location of our log4j2.xml configuration file depending on the environment variable
     * <p>
     * It must be static in order to be called within static context.
     */
    private static void initializeLog4j2ConfPath() {
        String homePath = System.getProperty(Constants.HOME_ENVIRONMENT_VAR);
        System.setProperty(LOGGING_CONFIG_PROPERTY, FILE + homePath+"/" + LOG4J2_FILE_RELATIVE_PATH);
    }

}
