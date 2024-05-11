package hm.sb_airplanes_mvc_Homework1.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Repository;

import hm.sb_airplanes_mvc_Homework1.model.Airplane;

@Repository
public class Database {

	private SessionFactory sessionFactory;
	
	public Database() {
		
		Configuration config = new Configuration();
		config.configure();
		
		this.sessionFactory = config.buildSessionFactory();
	}
	
	public List<Airplane> getAllFlights() {
		
		List<Airplane> airplanes = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		SelectionQuery<Airplane> query = 
				session.createSelectionQuery("SELECT a FROM Airplane a", Airplane.class);
		airplanes = query.getResultList();
		
		tx.commit();
		session.close();
		
		return airplanes;
	}

}
