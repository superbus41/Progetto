package progetto.stageandwork.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import progetto.stageandwork.entity.Event;


@Repository
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Event> getEvents() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Event> query =
				session.createQuery("from Event",
						Event.class);
		
		List <Event> events = query.getResultList();
		
		return events;
	}

	@Override
	public void saveEvent(Event event) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(event);
	}

	@Override
	public Event getEvent(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Event event = session.get(Event.class,	id);
		
		return event;
	}

	@Override
	public void deleteEvent(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Event event = session.get(Event.class, id);
		
		session.remove(event);
		
		/*Query query = session.createQuery("delete from Event where id=:eventId");
		
		query.setParameter("eventId", id);
		
		query.executeUpdate();*/
	}

	@Override
	public List<Event> searchEvents(String searchName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		 if (searchName != null && searchName.trim().length() > 0) {
			 
			 query = session.createQuery("from Event where lower(title) like :title", Event.class); 
			 query.setParameter("title", "%" + searchName.toLowerCase() + "%");
			 
		 }else {
			 
			 query = session.createQuery("from Event", Event.class);
			 
		 }
		 
		 List <Event> events = query.getResultList();
		 return events;
	}


}
