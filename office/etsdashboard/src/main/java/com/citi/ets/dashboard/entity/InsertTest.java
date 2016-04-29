package com.citi.ets.dashboard.entity;



/**
 * @author ak64503
 *
 */
public class InsertTest {
public static void main(String[] args) {
	//SessionFactory factory;
	//Resource r=new ClassPathResource("applicationContext.xml");
	//BeanFactory factory=new XmlBeanFactory(r);
	///ApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");
	//factory = new Configuration().configure().buildSessionFactory();
	
	//Session session = factory.openSession();

	
	//EmployeeDao dao=(EmployeeDao)factory. getBean("empDao");
	
	Org org = new Org();
	org.setOrg_id("11");
	org.setOrg_name("test");
	org.setLast_updatedby("aaaaa");
	
	//EmployeeDao.saveEmployee(org);
	
	
	
	
}
}
