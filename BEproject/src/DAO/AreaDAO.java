package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.AreaVO;
import VO.CityVO;
import VO.StateVO;

public class AreaDAO {

	public void insert(AreaVO v) {
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
			Query q=s.createQuery("from AreaVO");
			ls=q.list();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public boolean delete(AreaVO areaVO) {
		try{
			System.out.println("areaDAO");
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session s = sf.openSession();
			
			Transaction tr = s.beginTransaction();
			
			s.delete(areaVO);
			
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

	public List edit(AreaVO areaVO) {
		List ls=new ArrayList();
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Query q=s.createQuery("from AreaVO where areaId='"+areaVO.getAreaId()+"'");
			ls=q.list();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return ls;
	}

	public void update(AreaVO areaVO) {
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.saveOrUpdate(areaVO);
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}

	public java.util.List searchCity(CityVO cityVO) {
		System.out.println("ajax area dao");
		List li=new ArrayList();
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			Query q=s.createQuery("from CityVO where stateVO='"+cityVO.getStateVO().getStateId()+"'");
			li=q.list();
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return li;
	}

	
	

}
