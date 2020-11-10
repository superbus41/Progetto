package progetto.stageandwork.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import progetto.stageandwork.entity.Work;

@Repository
public class WorkDAOImpl implements WorkDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Work> getWorks() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Work> query =
				session.createQuery("from Work",
						Work.class);
		
		List <Work> works = query.getResultList();
		
		return works;
	}

	@Override
	public void saveWork(Work work) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(work);
	}

	@Override
	public Work getWork(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Work work = session.get(Work.class,	id);
		
		return work;
	}

	@Override
	public void deleteWork(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Work where id=:workId");
		
		query.setParameter("workId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<Work> searchWorks(String searchName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		 if (searchName != null && searchName.trim().length() > 0) {
			 
			 query = session.createQuery("from Work where lower(title) like :title", Work.class); 
			 query.setParameter("title", "%" + searchName.toLowerCase() + "%");
			 
		 }else {
			 
			 query = session.createQuery("from Work", Work.class);
			 
		 }
		 
		 List <Work> works = query.getResultList();
		 return works;
	}


}
