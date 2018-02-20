package DAO;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.loginVO;

public class loginDAO {

	public void insert(loginVO lVO) {
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.save(lVO);
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}

	public List authentication(loginVO loginVO) {
		// TODO Auto-generated method stub
		
		List ls= null;
		try{
			Session session = null;
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			 Query q =  s.createQuery("from loginVO where uname='"+loginVO.getUname()+"' and pass='"+loginVO.getPass()+"'");

				ls =   q.list();
				System.out.println(ls.size());
				System.out.println("Done");
			} 
		catch (Exception e) 
			{
				e.printStackTrace();

			}
		return ls;
		
		
	}

}
