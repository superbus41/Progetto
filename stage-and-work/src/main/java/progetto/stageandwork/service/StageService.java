package progetto.stageandwork.service;

import java.sql.Date;
import java.util.List;

import progetto.stageandwork.entity.Stage;

public interface StageService {

	public List<Stage> getStages();

	public void saveStage(Stage Stage);

	public Stage getStage(int id);

	public void deleteStage(int id);

	public List<Stage> searchStages(String title, String sector, boolean tipo, boolean validated, String company, Date fromDate, Date toDate);
}
