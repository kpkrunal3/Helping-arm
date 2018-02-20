package DAO;


import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CityVO;

public class CityDAO {

	public void insert(CityVO v) {
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(v);
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
			Query q=s.createQuery("from CityVO");
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

	public boolean delete(CityVO cityVO) {
		try{
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session s = sf.openSession();
			
			Transaction tr = s.beginTransaction();
			
			s.delete(cityVO);
			
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

	public List edit(CityVO cityVO) {
		List ls=new ArrayList();
		try{

			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Query q=s.createQuery("from CityVO where cityId='"+cityVO.getCityId()+"'");
			ls=q.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ls;
	}

	public void update(CityVO cityVO) {
		try{
			
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.saveOrUpdate(cityVO);
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}
	

}
