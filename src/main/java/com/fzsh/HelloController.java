package com.fzsh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

/**
 * @Author yangxin
 * @Date 2020/3/29 12:41
 * @Version 1.0
 */

@Controller
public class HelloController {
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(String name,String age ){
        //直连jdbc

        try {
            logger.info("------"+"hello world"+"-------");
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fzshdb","root","root");
            String sql= "insert into user (`name`) values (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"李四");
            statement.execute();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "你好，百度！";
    }
}
