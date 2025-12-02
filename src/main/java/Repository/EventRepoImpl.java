package Repository;

import java.util.ArrayList;
import java.util.List;

import DBConfiguration.DBInitialize;
import Exceptions.DeleteEventIdNotFoundUserDefinedException;
import Model.EventModel;

public class EventRepoImpl extends DBInitialize implements EventRepo{

	List<EventModel> list;
	@Override
	public boolean isAddEvent(EventModel model) {
		try {
			psmt=conn.prepareStatement("insert into event (name , edate , venue , capacity) values(?,?,?,?)");
			psmt.setString(1, model.getName());
			psmt.setDate(2, model.getEdate());
			psmt.setString(3, model.getVenue());
			psmt.setInt(4, model.getCapacity());
			
			int value = psmt.executeUpdate();
			
			if(value>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return false;
	}

	@Override
	public List<EventModel> getAllEvents() {
		try {
			list=new ArrayList<EventModel>();
			
			psmt=conn.prepareStatement("Select * from event");
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				EventModel model = new EventModel();
				model.setEid(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setEdate(rs.getDate(3));
				model.setVenue(rs.getString(4));
				model.setCapacity(rs.getInt(5));
				
				list.add(model);
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		// here we return list which holds the DB data 
		return list;
	}

	@Override
	public List<EventModel> getUpComingEvents() {
		try {
			list = new ArrayList<EventModel>();
			psmt=conn.prepareStatement("select * from event where edate > curdate()");
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				EventModel model = new EventModel();
				model.setEid(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setEdate(rs.getDate(3));
				model.setVenue(rs.getString(4));
				model.setCapacity(rs.getInt(5));
				
				list.add(model);
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return list;
	}

	@Override
	public boolean isDeleteEvent(int eid) {
		try {
			psmt=conn.prepareStatement("delete from event where eid=?");
			psmt.setInt(1, eid);
			
			int val = psmt.executeUpdate();
			if(val > 0) {
				return true;
			}
			throw new DeleteEventIdNotFoundUserDefinedException(val);
		}
		catch(DeleteEventIdNotFoundUserDefinedException ex) {
			System.out.println(ex.getErrorMsg());
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return false;
	}

	@Override
	public EventModel isUpdateEvent(EventModel model) {
		try {
			System.out.println(model);
			psmt=conn.prepareStatement("update event set name=? , edate=? , venue=? , capacity=? where name=?");
			psmt.setString(1, model.getName());
			psmt.setDate(2, model.getEdate());
			psmt.setString(3, model.getVenue());
			psmt.setInt(4, model.getCapacity());
			psmt.setString(5, model.getOldName());
			
			int val = psmt.executeUpdate();
			System.out.println("Value is : "+val);
			return val > 0 ?model:null;
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return null;
		
	}

}
