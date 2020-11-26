package progetto.stageandwork.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import progetto.stageandwork.entity.Stage;
import progetto.stageandwork.entity.Work;

@Repository
public class StageDAOImpl implements StageDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Stage> getStages() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Stage> query =
				session.createQuery("from Stage",
						Stage.class);
		
		List <Stage> stages = query.getResultList();
		
		return stages;
	}

	@Override
	public void saveStage(Stage stage) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(stage);
	}

	@Override
	public Stage getStage(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Stage stage = session.get(Stage.class,	id);
		
		return stage;
	}

	@Override
	public void deleteStage(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Stage where id=:stageId");
		
		query.setParameter("stageId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<Stage> searchStages(String title, String sector, boolean curricular, boolean validated, String company) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "select distinct s from Stage s join s.company c where";
		
		 if (title != null && title.trim().length() > 0)
			 hql = hql.concat(" lower(title) like :title and ");
		 if (sector != null && sector.trim().length() > 0)
			 hql = hql.concat(" lower(sector) like :sector and ");
		 if (company != null && company.trim().length() > 0) 
			 hql = hql.concat(" lower(c.name) like :company and ");
		 if(curricular)
			 hql = hql.concat(" s.tipo is true and ");
		 if(validated)
			 hql = hql.concat(" s.validated is true and ");
		 
		 hql = hql.substring(0, hql.length() - 5).trim();
		 
		 Query query = session.createQuery(hql, Stage.class);
		 
		 if (title != null && title.trim().length() > 0)
			 query.setParameter("title", title);
		 if (sector != null && sector.trim().length() > 0)
			 query.setParameter("sector", sector);
		 if (company != null && company.trim().length() > 0)
			 query.setParameter("company", company);
		 
		 List <Stage> stages = query.getResultList(); 		 
		
		 return stages;
	}


}