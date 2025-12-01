package Service;

import java.util.List;

import Model.EventModel;
import Repository.*;

public class EventServiceImpl implements EventService{

	EventRepo eventRepo = new EventRepoImpl();
	
	@Override
	public boolean isAddEvent(EventModel model) {
		// TODO Auto-generated method stub
		return eventRepo.isAddEvent(model);
	}

	@Override
	public List<EventModel> getAllEvents() {
		// TODO Auto-generated method stub
		return eventRepo.getAllEvents();
	}

	@Override
	public List<EventModel> getUpComingEvents() {
		// TODO Auto-generated method stub
		return eventRepo.getUpComingEvents();
	}

	@Override
	public boolean isDeleteEvent(int eid) {
		// TODO Auto-generated method stub
		return eventRepo.isDeleteEvent(eid);
	}

	@Override
	public EventModel isUpdateEvent(EventModel model) {
		// TODO Auto-generated method stub
		return eventRepo.isUpdateEvent(model);
	}

}
