package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.StaffVO;

public class StaffDAO {

	public void insert(StaffVO staffVO) {
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(staffVO);
		tr.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public List search1() {
		List ls=new ArrayList();
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from StaffVO where postVO.postName='doctor'");
		ls=q.list();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public List search2() {
		List ls=new ArrayList();
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from StaffVO where postVO.postName='driver'");
		ls=q.list();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public List search3() {
		List ls=new ArrayList();
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from StaffVO");
		ls=q.list();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public boolean delete(StaffVO staffVO) {
		try{
			System.out.println("areaDAO");
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session s = sf.openSession();
			
			Transaction tr = s.beginTransaction();
			
			s.delete(staffVO);
			
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

	public List edit(StaffVO staffVO) {
		List ls=new ArrayList();
		try{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from StaffVO where staffId='"+staffVO.getStaffId()+"'");
		ls=q.list();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public void update(StaffVO staffVO) {
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.saveOrUpdate(staffVO);
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}

	
}
