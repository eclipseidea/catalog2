package zab.romik.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Конфигурация базы данных
 */
@Configuration
@EnableJpaRepositories("zab.romik.dao")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DataConfig {

    /**
     * Класс который будет нам давать читать свойства из файла
     * конфигурации с поддержкой окружений
     */
    private final Environment env;

    /**
     * Конструктор для внедрения зависимостей
     *
     * @param env Класс для чтения переменных из файла конфигурации
     */
    @Autowired
    public DataConfig(final Environment env) {
        this.env = env;
    }

    /**
     * Возвращает датасурс из которого осуществялется JDBC подключение
     *
     * Datasorce for Eclipseidea.
     *
     * @return Класс инкапсулирующий в себе данные для базы
     */
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("db.datasource.driver"));
        dataSource.setUrl(env.getProperty("db.datasource.url"));
        dataSource.setPassword(env.getProperty("db.datasource.username"));
        dataSource.setUsername(env.getProperty("db.datasource.password"));

        return dataSource;
    }

    /**
     * Адаптер для работы с вендоpными драйверами
     *
     * @return Адаптер
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    /**
     * Дополнительные настройки для session factory hibernate
     *
     * @return entity manager factory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("zab.romik.entity");
        factory.setJpaVendorAdapter(jpaVendorAdapter());
        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "update");
        factory.setJpaProperties(properties);
        return factory;
    }

    /**
     * Создает менеджера для работы с транзакциями
     *
     * @param entityManagerFactory Фабрика для создания EntityManager JPA
     * @return Менеджер для работы с транзакциями
     */
    @Bean
    public JpaTransactionManager transactionManager(
            final EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
