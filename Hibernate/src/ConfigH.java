import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConfigH {

    private SessionFactory sessionFactory;

    public ConfigH() {
        Configuration config = new Configuration();

        //This tells it I will be using MySQL
        config.setProperty("hibernat.dialect", "org.hibernate.dialect.MYSQLDialect");

        //Thgis tells it that it will be using the jdbc (java database connectivity) driver to communicate with MySQL
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        //this tells it where your MySQL dataBase can befound (so in my case port 3360, the database named Java)
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Java");

        //this sets my username so it can log in
        config.setProperty("hibernate.connection.username", "purplesp_iUser");

        //this sets my password so it can log in
        config.setProperty("hibernate.connection.password", "RXZfwSvAQCSf");

        //this sets the amount of connections you can have to your MySQL server at a time
        config.setProperty("hibernate.connection.pool_size", "10");

        //this seems to make the connection automatic?
        config.setProperty("hibernate.connection.autocommit", "true");

        //this seems to make sure it uses the proper generator for the MySQL AI fields
        config.setProperty("hibernate.id.new_generator_mappings", "false");

        //Not sure, but it seems to state there isn't a cache in this connection
        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

        //So this shows the SQL while it runs???
        config.setProperty("hibernate.show_sql", "ture");

        //this states that the transaction method will be JDBC, I think....
        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

        //tells it to use a thread???
        config.setProperty("hibernate.current_session_context_class", "thread");

        //this is the class, or object you will be adding in
        config.addAnnotatedClass(Character.class);

        //So this puts all of the configurations we just made into the serviceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        //This puts the ServiceRegistry into the session to make the connection.
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}