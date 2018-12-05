
package Dao;

/*
public class HQLOprAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private int delid;

	private Employee inObject;

	private List<Employee> dataObject;

	private List<Object[]> fieldObject;

	public List<Employee> getDataObject() {
		return dataObject;
	}

	public void setDataObject(List<Employee> dataObject) {
		this.dataObject = dataObject;
	}



	public List<Object[]> getFieldObject() {
		return fieldObject;
	}

	public void setFieldObject(List<Object[]> fieldObject) {
		this.fieldObject = fieldObject;
	}

	public Employee getInObject() {
		return inObject;
	}

	public void setInObject(Employee inObject) {
		this.inObject = inObject;
	}

	public int getDelid() {
		return delid;
	}

	public void setDelid(int delid) {
		this.delid = delid;
	}

	// HQL statement select 1
	public String execute() throws Exception
	{

		//HibernateSessionFactory sessionFactory =  (HibernateSessionFactory)HibernateSessionFactory.getSessionFactory();
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		String hql = "from Employee";

		Query query = session.createQuery(hql);

		this.dataObject = (List<Employee>)query.list();

		for(Employee edo : this.dataObject)
		{
			System.out.println(Long.toString(edo.getId()) + "   " + edo.getName() +"  " + edo.getAddress() +"  " + edo.getPhone());
		}

		session.close();

		return SUCCESS;
	}
	// get��ѯ
	public String GetRecordSelect() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = session.beginTransaction();

		inObject = (Employee) session.get(Employee.class, new Long(1));

		tx.commit();

		System.out.println(Long.toString(inObject.getId()) + "   " + inObject.getName() +"  " + inObject.getAddress() +"  " + inObject.getPhone());

		return SUCCESS;
	}

	// ��¼����
	public String SaveRecord() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = session.beginTransaction();

		//this.inObject = new Employee(10, "����", "�Ϲ���", "1386667777");
		this.inObject = new Employee();
		this.inObject.setId(10);
		this.inObject.setName("����");
		this.inObject.setAddress("�Ϲ���");
		this.inObject.setPhone("13866677");

		session.save(this.inObject);

		tx.commit();

		System.out.println(Long.toString(inObject.getId()) + "   " + inObject.getName() +"  " + inObject.getAddress() +"  " + inObject.getPhone());

		return SUCCESS;
	}
	//Update
	public String UpdateRecord() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = session.beginTransaction();

		this.inObject = (Employee) session.get(Employee.class, new Long(2));

		this.inObject.setName("�ŷ�");

		session.update(this.inObject);

		tx.commit();

		System.out.println(Long.toString(inObject.getId()) + "   " + inObject.getName() +"  " + inObject.getAddress() +"  " + inObject.getPhone());

		return SUCCESS;
	}

	// delete
	//Update
	public String DeleteRecord() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = session.beginTransaction();

		this.inObject = (Employee) session.get(Employee.class, new Integer(2));

		session.delete(this.inObject);

		tx.commit();

		System.out.println(Long.toString(inObject.getId()) + "   " + inObject.getName() +"  " + inObject.getAddress() +"  " + inObject.getPhone());

		return SUCCESS;
	}

	// HQL statement select 2
	public String HQLFieldSelect() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		String hql = "select id, name, address, phone from Employee";

		Query query = session.createQuery(hql);

		//List<Employee> datalist = (List<Employee>)query.list();

		this.fieldObject = (List<Object[]>)query.list();

		for(Object[] edo : this.fieldObject)
		{
			System.out.println(edo[0].toString() + "   " + (String)edo[1] +"  " + (String)edo[2] +"  " + (String)edo[3]);
		}

		session.close();

		return SUCCESS;
	}

	// HQL statement select with parameter
	public String HQLParaSelect() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		String hql = "select * from Employee emp where emp.id=:id and emp.name=:name";

		Query query = session.createSQLQuery(hql).addEntity(Employee.class);


		query.setParameter("id", 1);
		query.setParameter("name", "ffff");

		this.dataObject = (List<Employee>)query.list();

		for(Employee edo : this.dataObject)
		{
			System.out.println(Long.toString(edo.getId()) + "   " + edo.getName() +"  " + edo.getAddress() +"  " + edo.getPhone());
		}

		session.close();

		return SUCCESS;
	}

	// SQL statement select
	public String SQLSelect() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		String hql = "select * from Employee";

		Query query = session.createSQLQuery(hql).addEntity(Employee.class);


		this.dataObject = (List<Employee>)query.list();

		for(Employee edo : this.dataObject)
		{
			System.out.println(Long.toString(edo.getId()) + "   " + edo.getName() +"  " + edo.getAddress() +"  " + edo.getPhone());
		}


		session.close();

		return SUCCESS;
	}

	// SQL insert
	public String SQLInsertData() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		Transaction trans = session.beginTransaction();

		String sql = "insert into Employee(id, name, address, phone) values(" + Long.toString(inObject.getId()) + ",'" + inObject.getName() + "','" + inObject.getAddress() + "','" + inObject.getPhone() +"')";

		Query query = null;

		query = session.createSQLQuery(sql);

		query.executeUpdate();

		trans.commit();

		session.close();

		System.out.println(sql);

		return SUCCESS;
	}

	// SQL delete
	public String SQLDeleteData() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		Transaction trans = session.beginTransaction();

		String sql = "select * from Employee emp where emp.id=:id";

		Query query = null;

		query = session.createSQLQuery(sql).addEntity(Employee.class);

		query.setParameter("id", delid);

		this.dataObject = (List<Employee>)query.list();

		if (this.dataObject.size() <= 0)
		{
			System.out.println("û���ҵ�ָ��ID�ļ�¼");
			return SUCCESS;
		}
		else
		{
			Employee tmp = this.dataObject.get(0);

			session.delete(tmp);

			session.getTransaction().commit();

			session.close();

			System.out.println("�Ѿ�ɾ��ָ������");

			return SUCCESS;
		}
	}

	// SQL update
	public String SQLUpdateData() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		Transaction trans = session.beginTransaction();

		String sql = "select * from Employee emp where emp.id=:id";

		Query query = null;

		query = session.createSQLQuery(sql).addEntity(Employee.class);

		query.setParameter("id", inObject.getId());

		this.dataObject = (List<Employee>)query.list();

		if (this.dataObject.size() <= 0)
		{
			System.out.println("û���ҵ�ָ��ID�ļ�¼");
			return SUCCESS;
		}
		else
		{
			Employee tmp = this.dataObject.get(0);

			session.update(inObject);

			session.getTransaction().commit();

			session.close();

			System.out.println("�Ѿ�����ָ������");

			return SUCCESS;
		}
	}

	//Query By Criteria, ��Ӳ�ѯ׼��
	public String QBCAddCritedia() throws Exception
	{
		HibernateSessionFactory sessionFactory = new HibernateSessionFactory();

		Session session = HibernateSessionFactory.getSession();

		Transaction trans = session.beginTransaction();

		Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.like("id", new Integer(1)));

		//Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.between("id", new Integer(1), new Integer(8)));

		criteria.addOrder(Order.asc("id"));

		criteria.setMaxResults(10);

		this.dataObject = criteria.list();

		trans.commit();

		session.close();

		return SUCCESS;
	}

	//Query By Criteria, ��Ӳ�ѯ׼��
//	public String QBCAddCritedia() throws Exception
//	{
//
//
//		return SUCCESS;
//	}
}

	*/