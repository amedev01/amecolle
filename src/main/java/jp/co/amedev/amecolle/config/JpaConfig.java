package jp.co.amedev.amecolle.config;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("jp.co.amedev.amecolle.repository")
@PropertySource("classpath:persistence.properties")
public class JpaConfig {

	private static final String ENTITY_PACKAGE = "jp.co.amedev.amecolle.repository.entity";
	
    @Value("${dataSource.driverClassName}")
    private String driver;
    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
	
    @Autowired
    BasicDataSource dataSource;
    
    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName(driver);
    	dataSource.setUrl(url);;
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	return dataSource;
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
    	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    	vendorAdapter.setDatabase(Database.MYSQL);
    	vendorAdapter.setShowSql(true);
    	return vendorAdapter;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception{
    	LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    	localContainerEntityManagerFactoryBean.setDataSource(dataSource);
    	localContainerEntityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGE);
    	localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
    	return localContainerEntityManagerFactoryBean;
    }
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
    	JpaTransactionManager jpaTransactionmanager = new JpaTransactionManager();
    	jpaTransactionmanager.setEntityManagerFactory(entityManagerFactory);
    	return jpaTransactionmanager;
    }
    
}
