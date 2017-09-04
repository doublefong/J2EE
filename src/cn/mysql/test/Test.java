package cn.mysql.test;
import cn.mysql.project.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class Test {
	public static void main(String[] args){
		//1.新建Configuration对象
		//默认读取src下的hibernate.cfg.xml
		Configuration cfg=new Configuration().configure();
		//如果hibernate的核心配置文件不叫hibernate.cfg.xml
		//Configuration cfg1 = new Configuration().configure("hb.cfg.xml");
		//可编程可以不使用配置文件
		//cfg.addProperties();
		//cfg.addResource();
		//2.通过Configuration创建SessionFactory对象
			//在hibernate3里面的写法
			//SessionFactory sf=cfg.buildSessionFactory();
			//hibernate4.3之前到hibernate4.0之间
			//ServiceRegistry sr = new ServiceRegistryBuilder()
			//						   .applySetting(cfg.getProperties())
			//						   .buildServiceRegistry();
		ServiceRegistry sr = new StandardServiceRegistryBuilder()
								.applySettings(cfg.getProperties())
								.build();
		SessionFactory sf = cfg.buildSessionFactory(sr);
		//SessionFactory是线程安全的
		//3.通过SessionFactory得到Session
		Session session = sf.openSession();
		//4.通过Session对象得到Transaction对象
		Transaction tx = session.beginTransaction();
		//5.保存数据
		User user = new User();
		user.setId(5);
		user.setName("小虹");
		user.setPassword("MM");
		session.save(user);
		//session对象可以理解为对jdbc中的connection的一个包装
		//6.提交事务
		tx.commit();
		//7.关闭Session
		session.close();
	}
}
