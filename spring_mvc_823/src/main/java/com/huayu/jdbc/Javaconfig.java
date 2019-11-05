package com.huayu.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;
import java.util.Properties;

@EnableTransactionManagement
@ComponentScan(basePackages = {"com.huayu"})
@Configuration
public class Javaconfig {

    /**
     * 数据源
     *
     * @return
     */
    @Bean
    public DriverManagerDataSource comboPooledDataSource() {
        DriverManagerDataSource comboPooledDataSource = new DriverManagerDataSource();
        comboPooledDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        comboPooledDataSource.setUrl("jdbc:mysql://localhost:3306/user?serverTimezone=GMT&useSSL=false");
        comboPooledDataSource.setUsername("root");
        comboPooledDataSource.setPassword("huayu");
        return comboPooledDataSource;
    }

    /**
     * SessionFactory
     */
    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(comboPooledDataSource());
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        sessionFactoryBean.setHibernateProperties(properties);
        sessionFactoryBean.setMappingResources("hibernate/student.hbm.xml", "hibernate/role.hbm.xml","hibernate/grade.hbm.xml","hibernate/work.hbm.xml","hibernate/login.hbm.xml");
        return sessionFactoryBean;
    }

    /**
     * HibernateTemplate
     *
     * @return
     */
    @Bean
    public HibernateTemplate hibernateTemplate() {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactoryBean().getObject());
        return hibernateTemplate;
    }

    /**
     * 事务
     */
    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactoryBean().getObject());
        return hibernateTransactionManager;
    }
    /*
     *//**
     * Dao
     * @return
     *//*
    @Bean
    public StudentDao studentDao(){
         StudentDao studentDao = new StudentDao();
         studentDao.setHibernateTemplate(hibernateTemplate());
         return studentDao;
    }
    @Bean
    public GradeDao gradeDao(){
        GradeDao gradeDao = new GradeDao();
        gradeDao.setHibernateTemplate(hibernateTemplate());
        return gradeDao;
    }

    *//**
     * Service
     * @return
     *//*
    @Bean
    public StudentService studentService(){
        StudentService studentService = new StudentService();
        studentService.setStudentimpl(studentDao());
        return studentService;
    }
    @Bean
    public GradeService gradeService(){
        GradeService gradeService = new GradeService();
        gradeService.setIdGradeimpl(gradeDao());
        return gradeService;
    }
    *//**
     * Action
     *//*
    @Bean
    @Scope("prototype")
    public StudentAction studentAction(){
        StudentAction studentAction = new StudentAction();
        studentAction.setStudentService(studentService());
        studentAction.setGradeService(gradeService());
        return studentAction;
    }
    @Bean
    @Scope("prototype")
    public GradeAction gradeAction (){
        GradeAction gradeAction = new GradeAction();
        gradeAction.setGradeService(gradeService());
        return gradeAction;
    }*/
}


