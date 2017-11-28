package com.shoutout.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.shoutout.dao.IEventDAO;
import com.shoutout.dto.Event;

@Named
public class EventService implements IEventService {

	@Inject
	private IEventDAO eventDAO; 
	private List<Event> allEvents;

	@Override
	public List<Event> filterEvents(String filter) {
		if (allEvents == null) {
			allEvents = eventDAO.fetchEvents();
		}
		
		// the collection we are returning
		List<Event> returnEvents = new ArrayList<Event>();
		
		// filter the list
		for (Event event : allEvents) {
			if (event.toString().contains(filter)) {
				returnEvents.add(event);
			}
		}
		
		// TODO Auto-generated method stub
		return returnEvents;
	}
	
	public void save(Event event) throws Exception {
		eventDAO.insert(event);
	}

	public IEventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(IEventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}

}
