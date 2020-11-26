package progetto.stageandwork.dao;

import java.util.List;
import java.util.Set;

import progetto.stageandwork.entity.Work;


public interface WorkDAO {

	public List<Work> getWorks();

	public void saveWork(Work Work);

	public Work getWork(int id);

	public void deleteWork(int id);

	public List<Work> searchWorks(String title, String sector, String company);
}
