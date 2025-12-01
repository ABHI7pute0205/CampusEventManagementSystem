package Repository;

import java.util.List;

import Model.EventModel;

public interface EventRepo {

	public boolean isAddEvent(EventModel model);
	public List<EventModel> getAllEvents();
	public List<EventModel> getUpComingEvents();
	public boolean isDeleteEvent(int eid);
	public EventModel isUpdateEvent(EventModel model);
}
