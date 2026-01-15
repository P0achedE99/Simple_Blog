package com.qingcen.poachedegg.myblog.config;

// 仅保留核心导入，无多余依赖
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 纯注解式Mapper的MyBatis配置（无XML文件）
 * 仅完成：Druid数据源绑定 + Mapper包扫描
 */
@Configuration
// 仅扫描Mapper接口包，无需任何资源路径配置
@MapperScan("com.qingcen.poachedegg.myblog.mapper")
public class MyBatisConfig {

    // 注入Druid数据源（Spring自动装配）
    @Autowired
    private DataSource dataSource;

    /**
     * 仅创建SqlSessionFactory并绑定数据源，无任何XML/资源路径配置
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 唯一核心：绑定Druid数据源（解决sqlSessionFactory缺失问题）
        sessionFactory.setDataSource(dataSource);
        // 可选：实体类别名包（非必须，不加也能运行）
         sessionFactory.setTypeAliasesPackage("com.qingcen.poachedegg.myblog.pojo");
        return sessionFactory;
    }
}