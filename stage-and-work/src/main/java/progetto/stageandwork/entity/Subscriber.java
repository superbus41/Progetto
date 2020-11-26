package progetto.stageandwork.entity;

public interface Subscriber {

	void addSubscription(Event event);

	void removeSubscription(Event event);

	
}
