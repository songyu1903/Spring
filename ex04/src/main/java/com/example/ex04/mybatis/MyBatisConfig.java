package com.example.ex04.mybatis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// @Configuration 은 설정을 위한 빈을 등록하는 어노테이션
// 설정용 클래스에 붙여준다.
@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    // ApplicationContext 객체는 스프링의 핵심 객체이다.
    // 스프링 컨테이너라고 부르는 논리적 구조를 실체화(구현)한 것이 ApplicationContext 이다.
    // 즉, Bean 관리, DI 등을 담당하는 객체이다.
    // 우리 프로젝트의 전반적인 설정이나 구조등을 알고 있기 때문에 설정에서 도움을 받을 것이다.
    private final ApplicationContext applicationContext;

    // 외부 파일의 설정 값들을 자바 객체로 가져올 때 사용한다.
    // 스프링부트에서는 application.properties라는 파일에 설정값을 작성하기 때문에
    // 해당 파일에서 특정 속성을 가져올 때 주로 사용하게 된다.
    // prefix는 어노테이션의 설정이며, 접두사를 설정한다.
    // spring.datasource.hikari 로 시작하는 설정값을 전부 가져오라는 의미이다.
    // 가져온 값을 new HikariConfig() 객체의 필드에 바인딩한다.
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
    // Hikari란?
    // HikariCP(HikariConnection Pool) 라이브러리를 의미한다.
    // 빠르고, 가볍고, 설정이 쉽고, 안전성이 높다는 장점이 있다.
    // new HikariConfig()로 HikariConfig 객체를 생성하였는데 이 객체의 필드에
    // 설정값을 저장하여 사용하면 된다.
        return new HikariConfig();
    }
    @Bean
    public DataSource dataSource(){
        // DataSource란?
        // DataSource 객체는 Cp(케넥션 풀) 을 관리하고 CP에 있는 커넥션 객체를 제공해주고
        // 반납받는 등의 일을 한다.
        // 모든 CP 라이브러리는 DataSource 객체를 사용한다.
        // CP를 사용하려면 DataSouce 객체가 필요하며 DataSource 객체를 만들기 위해서는
        // DB접근 정보가 필요하다. 해당 정보는 HikariConfig 객체가 가지고 있다.
        return new HikariDataSource(hikariConfig());
    }
    // @Bean 은 메서드의 반환 객체를 빈으로 등록하는 어노테이션이다.
    // 보통 외부 라이브러리에서 지원하는 객체는 우리가 해당 클래스에 @Component 같은
    // 어노테이션으로 빈등록을 할 수 없으므로
    // 이렇게 반환타입으로 잡고 빈등록을 한다.
    // @Configuration 이 붙은 클래스 에서 사용 가능하다.

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(
                "classpath*:/mapper/**/*.xml"));
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(
                "classpath:config/config.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.ex04.dto");

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);


        return sqlSessionFactory;
    }
}















