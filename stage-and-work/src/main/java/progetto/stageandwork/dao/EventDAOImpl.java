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
	public List<Event> searchEvents(String title, String sector, String place, String university) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "select distinct e from Event e join e.university u where";
		
		 if (title != null && title.trim().length() > 0)
			 hql = hql.concat(" lower(title) like :title and ");
		 if (sector != null && sector.trim().length() > 0)
			 hql = hql.concat(" lower(sector) like :sector and ");
		 if (place != null && place.trim().length() > 0)
			 hql = hql.concat(" lower(place) like :place and ");
		 if (university != null && university.trim().length() > 0) 
			 hql = hql.concat(" lower(u.name) like :university and ");
		 
		 hql = hql.substring(0, hql.length() - 5).trim();
		 
		 Query query = session.createQuery(hql, Event.class);
		 
		 if (title != null && title.trim().length() > 0)
			 query.setParameter("title", title);
		 if (sector != null && sector.trim().length() > 0)
			 query.setParameter("sector", sector);
		 if (place != null && place.trim().length() > 0)
			 query.setParameter("place", place);
		 if (university != null && university.trim().length() > 0)
			 query.setParameter("university", university);
		 
		 List <Event> events = query.getResultList(); 		 
		
		 return events;
	}


}
