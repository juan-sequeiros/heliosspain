package es.heliosspain.against.covid19.config;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@Configuration
@EnableNeo4jRepositories(
        basePackages = "es.heliosspain.against.covid19.repositories")
@EntityScan(basePackages = "es.heliosspain.against.covid19.entities")
public class Neo4jConfiguration {

}
