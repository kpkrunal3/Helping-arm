package DAO;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import VO.StateVO;
import VO.valueVO;

public class valueDAO {

	public void insert(valueVO vo) {
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.save(vo);
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}

	public List search() {
		
		List listofaddress= new ArrayList();
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			
			Query q= s.createQuery("from valueVO");
			listofaddress= q.list();
			tr.commit();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return listofaddress;
	}

	
}
