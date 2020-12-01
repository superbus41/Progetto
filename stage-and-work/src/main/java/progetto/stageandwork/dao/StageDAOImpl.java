package progetto.stageandwork.dao;

import java.sql.Date;
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
	public List<Stage> searchStages(String title, String sector, boolean curricular, boolean validated, String company, Date fromDate, Date toDate) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "select distinct s from Stage s join s.company c where 1 = 1";
		
		 if (title != null && title.trim().length() > 0)
			 hql = hql.concat(" and lower(title) like :title");
		 if (sector != null && sector.trim().length() > 0)
			 hql = hql.concat(" and lower(sector) like :sector");
		 if (company != null && company.trim().length() > 0) 
			 hql = hql.concat(" and lower(c.name) like :company");
		 if(curricular)
			 hql = hql.concat(" and s.tipo is true");
		 if(validated)
			 hql = hql.concat(" and s.validated is true");
		 hql = hql.concat(" and lower(starting_date) between :fromDate and :toDate");
		 hql = hql.concat(" and lower(ending_date) between :fromDate and :toDate");
		 
		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + hql);
		 
		 Query query = session.createQuery(hql, Stage.class);
		 
		 if (title != null && title.trim().length() > 0)
			 query.setParameter("title", title);
		 if (sector != null && sector.trim().length() > 0)
			 query.setParameter("sector", sector);
		 if (company != null && company.trim().length() > 0)
			 query.setParameter("company", company);
		 query.setParameter("fromDate", fromDate);
		 query.setParameter("toDate", toDate);
		 
		 List <Stage> stages = query.getResultList(); 		 
		
		 return stages;
	}


}