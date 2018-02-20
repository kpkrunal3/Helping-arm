package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.FeedbackVO;

public class FeedbackDAO {

	public void insert(FeedbackVO feedbackVO) {
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.save(feedbackVO);
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		
	}

	public List search() {
		List ls=new ArrayList();
		try{

			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Query q=s.createQuery("from FeedbackVO");
			ls=q.list();
			int i=ls.size();
			System.out.println(i);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

}
