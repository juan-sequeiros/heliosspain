package es.heliosspain.against.covid19.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(
        basePackages = "es.heliosspain.against.covid19.repositories")
@EntityScan(basePackages = "es.heliosspain.against.covid19.entities")

public class Neo4jConfiguration {



}
