package progetto.stageandwork.dao;

import java.util.List;

import progetto.stageandwork.entity.Stage;


public interface StageDAO {

	public List<Stage> getStages();

	public void saveStage(Stage Stage);

	public Stage getStage(int id);

	public void deleteStage(int id);

	public List<Stage> searchStages(String searchName);
}
