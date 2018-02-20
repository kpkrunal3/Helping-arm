package DAO;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import VO.StateVO;

public class StateDAO {

	public void insert(StateVO v) {
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction tr = s.beginTransaction();
			s.save(v);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List search() {
		List ls = new ArrayList();
		try {

			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Query q = s.createQuery("from StateVO");
			ls = q.list();
			int i = ls.size();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	public boolean delete(StateVO stateVO) {
		
		try {
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
			Session s = sf.openSession();
			
			Transaction tr = s.beginTransaction();
			
			s.delete(stateVO);
			
			tr.commit();
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			String error[] = e.getCause() != null ? e.getCause().toString().split(":") : null;
			
			if(error[0] != null && error[0].equals("java.sql.BatchUpdateException")){
				return false;
			}
		}
		return true;
	}

	public List edit(StateVO stateVO) {
		List ls = new ArrayList();
		try {

			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Query q = s.createQuery("from StateVO where stateId='"+stateVO.getStateId()+"'");
			ls = q.list();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	public void update(StateVO stateVO) {
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session s = sf.openSession();
			Transaction tr = s.beginTransaction();
			s.saveOrUpdate(stateVO);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
