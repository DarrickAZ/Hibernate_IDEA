package cn.collabtech.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

/**
 * Created by violet on 2016/3/10.
 */
public class majorTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Test
    public void test(){
        System.out.println("test....");

        //1. 创建配置对象
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        //3. 创建会话工厂对象
        sessionFactory = config.buildSessionFactory();
        //4. 会话对象
        session = sessionFactory.openSession();
        //5. 开启事务
        transaction = session.beginTransaction();

        //6. 生成专业对象
        CustomerEntity customer = new CustomerEntity();
        customer.setAddress("dsfsdf");
        customer.setAge(222);
        customer.setSex("男");
        customer.setName("李斯2");
        //7. 保存对象进入数据库
        session.save(customer);

        //8. 提交事务
        transaction.commit();
        //9. 关闭会话
        session.close();
        //10. 关闭会话工厂
        sessionFactory.close();
    }
}