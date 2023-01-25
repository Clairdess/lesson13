package com.vkatit;


import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppContext {

    @Value("${USERNAME_DB}")
    private String username;

    @Value("${PASSWORD_DB}")
    private String password;

    @Value("${IP}")
    private String IP;

    @Bean("mariaDataSource")
    public DataSource mariaDataSource() throws SQLException {
        MariaDbDataSource mariaDbDataSource = new MariaDbDataSource();
        mariaDbDataSource.setUrl("jdbc:mariadb://" + IP + "/hr");
        mariaDbDataSource.setUser(username);
        mariaDbDataSource.setPassword(password);
        return mariaDbDataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate myJdbcTemplate(DataSource mariaDataSource) {
        return new NamedParameterJdbcTemplate(mariaDataSource);
    }

}
