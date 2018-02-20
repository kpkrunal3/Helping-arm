package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.AssignAreaVO;

public class AssignAreaDAO {

	public void insert(AssignAreaVO assignAreaVO) {
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(assignAreaVO);
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
			Query q=s.createQuery("from AssignAreaVO");
			ls=q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	public boolean delete(AssignAreaVO assignAreaVO) {
		try{
			System.out.println("areaDAO");
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session s = sf.openSession();
			
			Transaction tr = s.beginTransaction();
			
			s.delete(assignAreaVO);
			
			tr.commit();
			
		}
		catch(Exception e){
	
			e.printStackTrace();
			String error[] = e.getCause() != null ? e.getCause().toString().split(":") : null;
			
			if(error[0] != null && error[0].equals("java.sql.BatchUpdateException")){
				return false;
			}
		}
		return true;
		
	}

	public List edit(AssignAreaVO assignAreaVO) {
		List ls=new ArrayList();
		try{

			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Query q=s.createQuery("from AssignAreaVO where assignAreaId='"+assignAreaVO.getAssignAreaId()+"'");
			ls=q.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	public void update(AssignAreaVO assignAreaVO) {
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.saveOrUpdate(assignAreaVO);
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}

}
