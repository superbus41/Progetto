package stageandwork.dao;

import java.util.List;

import stageandwork.entity.Work;


public interface WorkDAO {

	public List<Work> getWorks();

	public void saveWork(Work Work);

	public Work getWork(int id);

	public void deleteWork(int id);

	public List<Work> searchWorks(String searchName);
}
