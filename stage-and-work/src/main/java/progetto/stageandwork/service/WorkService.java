package progetto.stageandwork.service;

import java.util.List;

import progetto.stageandwork.entity.Work;

public interface WorkService {

	public List<Work> getWorks();

	public void saveWork(Work Work);

	public Work getWork(int id);

	public void deleteWork(int id);

	public List<Work> searchWorks(String searchName);
}
