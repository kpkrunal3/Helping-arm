package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.registrationVO;

public class registrationDAO {

	public void insert(registrationVO rVO) {
		try{
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			s.save(rVO);
			tr.commit();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
	}

}
