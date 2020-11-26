package progetto.stageandwork.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import progetto.stageandwork.entity.Event;
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
	public List<Work> searchWorks(String title, String sector, String company) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "select distinct w from Work w join w.company c where";
		
		 if (title != null && title.trim().length() > 0)
			 hql = hql.concat(" lower(title) like :title and ");
		 if (sector != null && sector.trim().length() > 0)
			 hql = hql.concat(" lower(sector) like :sector and ");
		 if (company != null && company.trim().length() > 0) 
			 hql = hql.concat(" lower(c.name) like :company and ");
		 
		 hql = hql.substring(0, hql.length() - 5).trim();
		 
		 Query query = session.createQuery(hql, Work.class);
		 
		 if (title != null && title.trim().length() > 0)
			 query.setParameter("title", title);
		 if (sector != null && sector.trim().length() > 0)
			 query.setParameter("sector", sector);
		 if (company != null && company.trim().length() > 0)
			 query.setParameter("company", company);
		 
		 List <Work> works = query.getResultList(); 		 
		
		 return works;
	}

}
