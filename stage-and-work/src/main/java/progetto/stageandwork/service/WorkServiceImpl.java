package progetto.stageandwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import progetto.stageandwork.dao.WorkDAO;
import progetto.stageandwork.entity.Work;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkDAO workDAO;
	
	@Override
	@Transactional
	public List<Work> getWorks() {
		
		return workDAO.getWorks();
	}

	@Override
	@Transactional
	public void saveWork(Work work) {
		
		workDAO.saveWork(work);
	}

	@Override
	@Transactional
	public Work getWork(int id) {
		return workDAO.getWork(id);
	}

	@Override
	@Transactional
	public void deleteWork(int id) {
		workDAO.deleteWork(id);
		
	}

	@Override
	@Transactional
	public List<Work> searchWorks(String searchName) {
		
		return workDAO.searchWorks(searchName);
	}

}
