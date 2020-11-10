package progetto.stageandwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import progetto.stageandwork.entity.Event;
import progetto.stageandwork.dao.EventDAO;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventDAO;
	
	@Override
	@Transactional
	public List<Event> getEvents() {
		
		return eventDAO.getEvents();
	}

	@Override
	@Transactional
	public void saveEvent(Event event) {
		
		eventDAO.saveEvent(event);
	}

	@Override
	@Transactional
	public Event getEvent(int id) {
		return eventDAO.getEvent(id);
	}

	@Override
	@Transactional
	public void deleteEvent(int id) {
		eventDAO.deleteEvent(id);
		
	}

	@Override
	@Transactional
	public List<Event> searchEvents(String searchName) {
		
		return eventDAO.searchEvents(searchName);
	}

}
