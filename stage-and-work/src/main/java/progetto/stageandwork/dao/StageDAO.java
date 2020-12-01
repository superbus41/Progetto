package progetto.stageandwork.dao;

import java.sql.Date;
import java.util.List;

import progetto.stageandwork.entity.Stage;
import progetto.stageandwork.entity.Work;


public interface StageDAO {

	public List<Stage> getStages();

	public void saveStage(Stage Stage);

	public Stage getStage(int id);

	public void deleteStage(int id);

	public List<Stage> searchStages(String title, String sector, boolean curricular, boolean valid, String company, Date fromDate, Date toDate);
}
