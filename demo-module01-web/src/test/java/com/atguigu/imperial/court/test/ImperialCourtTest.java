package com.atguigu.imperial.court.test;

import com.atguigu.imperial.court.entity.Emp;
import com.atguigu.imperial.court.entity.EmpExample;
import com.atguigu.imperial.court.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//spring和junit5整合
@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = {"classpath:spring-persist.xml"})
public class ImperialCourtTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testEmpMapper(){
        List<Emp> emps =
                empMapper.selectByExample(new EmpExample());
        emps.forEach(System.out::println);
    }

    private Logger logger = LoggerFactory.getLogger(ImperialCourtTest.class);

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.debug(connection.toString());
    }


}