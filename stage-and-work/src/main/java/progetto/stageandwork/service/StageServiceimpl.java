package progetto.stageandwork.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progetto.stageandwork.dao.StageDAO;
import progetto.stageandwork.entity.Stage;

@Service
public class StageServiceimpl implements StageService {

	@Autowired
	private StageDAO stageDAO;
	
	@Override
	@Transactional
	public List<Stage> getStages() {
		
		return stageDAO.getStages();
	}

	@Override
	@Transactional
	public void saveStage(Stage stage) {
		
		stageDAO.saveStage(stage);
	}

	@Override
	@Transactional
	public Stage getStage(int id) {
		return stageDAO.getStage(id);
	}

	@Override
	@Transactional
	public void deleteStage(int id) {
		stageDAO.deleteStage(id);
		
	}

	@Override
	@Transactional
	public List<Stage> searchStages(String title, String sector, boolean tipo, boolean validated, String company, Date fromDate, Date toDate) {
		return stageDAO.searchStages(title, sector, tipo, validated, company, fromDate, toDate);
	}

}
