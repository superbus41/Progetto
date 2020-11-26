package progetto.stageandwork.dao;

import java.util.List;

import progetto.stageandwork.entity.Event;


public interface EventDAO {

	public List<Event> getEvents();

	public void saveEvent(Event Event);

	public Event getEvent(int id);

	public void deleteEvent(int id);

	public List<Event> searchEvents(String title, String sector, String place, String university);
}
