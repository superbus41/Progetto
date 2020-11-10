package progetto.stageandwork.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import progetto.stageandwork.entity.Stage;

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
	public List<Stage> searchStages(String searchName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		 if (searchName != null && searchName.trim().length() > 0) {
			 
			 query = session.createQuery("from Stage where lower(title) like :title", Stage.class); 
			 query.setParameter("title", "%" + searchName.toLowerCase() + "%");
			 
		 }else {
			 
			 query = session.createQuery("from Stage", Stage.class);
			 
		 }
		 
		 List <Stage> stages = query.getResultList();
		 return stages;
	}


}