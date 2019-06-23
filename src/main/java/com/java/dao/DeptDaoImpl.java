package com.java.dao;

import com.java.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeptDaoImpl {

    private SqlSession sqlSession = null    ;

    @Before
    public void init() throws IOException {
        //SqlSession-->SqlSessionFactory-->SqlSessionFactoryBuilder
        //1.得到SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        //2.通过SqlSessionFactoryBuilder对象得到SqlSessionFactory对象
        InputStream ins = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory ssf = ssfb.build(ins);
        //3.得到SqlSession对象
        sqlSession = ssf.openSession();
    }

    /**
     * 查询dept表中的所有数据
     */
    @Test
    public void selectDept(){

        //4.执行对应的sql语句，接收结果，对结果进行遍历
        //SqlSession 封装了增删改查 四种方法
        List<Map<String,Object>> deptMap = sqlSession.selectList("com.java.dao.DeptDaoImpl.selectDept");
        deptMap.forEach(temp-> System.out.println(temp));
    }

    @Test
    public void select1(){
        Map<String,Object> deptMap = sqlSession.selectOne("com.java.dao.DeptDaoImpl.select1");
        deptMap.forEach((k,v)-> System.out.println(k+","+v));
    }

    @Test
    public void select2(){
        Map<String,Object> deptMap2 = sqlSession.selectOne("com.java.dao.DeptDaoImpl.select2",20);
        deptMap2.forEach((k,v)-> System.out.println(k+","+v));
    }

    @Test
    public void select3(){
        //将多个参数封装到一个Map集合中
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("deptno1",30);
        map.put("deptno2",10);
        map.put("loc","DALLAS");
        Map<String,Object> deptMap3 = sqlSession.selectOne("com.java.dao.DeptDaoImpl.select3",map);
        deptMap3.forEach((k,v)-> System.out.println(k+","+v));
    }

    @Test
    public void select4(){
        //将多个参数封装到一个POJO对象中
        Dept dept = new Dept();
        dept.setDeptno1(30);
        dept.setDeptno2(10);
        dept.setLoc("DALLAS");
        Map<String,Object> deptMap3 = sqlSession.selectOne("com.java.dao.DeptDaoImpl.select4",dept);
        deptMap3.forEach((k,v)-> System.out.println(k+","+v));
    }

    @Test
    public void select5(){
        //将多个参数封装到一个POJO对象中
        Dept dept = new Dept();
        dept.setDeptno1(30);
        dept.setDeptno2(10);
        dept.setLoc("DALLAS");
        List<Dept> deptList = sqlSession.selectList("com.java.dao.DeptDaoImpl.select5",dept);
        deptList.forEach(temp-> System.out.println(temp));
    }

    /*添加数据*/
    @Test
    public void insert1(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("deptno",60);
        map.put("dname","张三");
        map.put("loc","李四");
        int flag = sqlSession.insert("com.java.dao.DeptDaoImpl.insert1", map);
        System.out.println(flag);
    }

    /*删除1条数据*/
    @Test
    public void delete1(){
        int flag = sqlSession.delete("com.java.dao.DeptDaoImpl.delete1", 50);
        System.out.println("flag:"+flag);

    }

    /*修改数据1条*/
    @Test
    public void update1(){
        int flag = sqlSession.update("com.java.dao.DeptDaoImpl.update1", "李四");
        System.out.println(flag);
    }

    //模糊查询
    @Test
    public void selectMH(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("dname","R");
        map.put("deptno",40);
        List<Map<String,Object>> deptList = sqlSession.selectList("com.java.dao.DeptDaoImpl.selectMH", map);
        deptList.forEach(temp-> System.out.println(temp));
    }

    @After
    public void destory(){
        //提交事务
        sqlSession.commit();
    }
}
