package org.knight.dao.test;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.knight.model.People;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @author Wayss
 * @date 2018/6/14
 */
public class PeopleMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<People> peopleList = sqlSession.selectList("selectAll");

        for (People people : peopleList){
            System.out.println(JSON.toJSONString(people));
        }

    }


}
