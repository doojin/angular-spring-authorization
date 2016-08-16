package es.asauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    private static final String SCRIPT_PATH_DB_CREATE = "file:src/main/webapp/resources/db/create-db.sql";
    private static final String SCRIPT_PATH_ADD_ROLES = "file:src/main/webapp/resources/db/add-roles.sql";
    private static final String SCRIPT_PATH_ADD_USERS = "file:src/main/webapp/resources/db/add-users.sql";
    private static final String SCRIPT_PATH_ADD_ARTICLES = "file:src/main/webapp/resources/db/add-articles.sql";

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2)
                .addScript(SCRIPT_PATH_DB_CREATE)
                .addScript(SCRIPT_PATH_ADD_ROLES)
                .addScript(SCRIPT_PATH_ADD_USERS)
                .addScript(SCRIPT_PATH_ADD_ARTICLES)
                .build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
