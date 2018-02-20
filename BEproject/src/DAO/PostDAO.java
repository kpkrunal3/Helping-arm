package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.PostVO;

public class PostDAO {

	public void insert(PostVO postVO) {
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(postVO);
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
		Query q=s.createQuery("from PostVO");
		ls=q.list();
		int i=ls.size();
		System.out.println(i);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public boolean delete(PostVO postVO) {
		try{
			System.out.println("areaDAO");
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session s = sf.openSession();
			
			Transaction tr = s.beginTransaction();
			
			s.delete(postVO);
			
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

	public List edit(PostVO postVO) {
		List ls=new ArrayList();
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from PostVO where postId='"+postVO.getPostId()+"'");
		ls=q.list();
		int i=ls.size();
		System.out.println(i);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public void update(PostVO postVO) {
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.saveOrUpdate(postVO);
			tr.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	

	

}
