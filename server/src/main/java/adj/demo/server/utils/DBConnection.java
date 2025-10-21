package adj.demo.server.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DBConnection {
    @Value("${db.host}")
    private String host;

    @Value("${db.port}")
    private String port;

    @Value("${db.name}")
    private String name;

    @Value("${db.user}")
    private String user;

    @Value("${db.pass}")
    private String pass;

    @Bean
    public DataSource getDBConnection() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
        int retries = 10;
        int waitMs = 3000;
        for (int i = 0; i < retries; i++) {
            try {
                source.setUrl(url);
                source.setUsername(user);
                source.setPassword(pass);
                // Try to get a connection
                source.getConnection().close();
                return source;
            } catch (Exception e) {
                if (i == retries - 1) {
                    throw new RuntimeException("No se pudo conectar a la base de datos tras varios intentos", e);
                }
                try {
                    Thread.sleep(waitMs);
                } catch (InterruptedException ignored) {}
            }
        }
        throw new RuntimeException("No se pudo conectar a la base de datos");
    }
}
