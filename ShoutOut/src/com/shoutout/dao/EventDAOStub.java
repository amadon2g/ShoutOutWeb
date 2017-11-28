package com.shoutout.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.mortbay.log.Log;

import com.shoutout.dto.Event;

@Named("eventDAO")
public class EventDAOStub implements IEventDAO {
	
	static final Logger logger = Logger.getLogger(EventDAOStub.class);

	private List<Event> allEvents;

	@Override
	public List<Event> fetchEvents() {
		allEvents = new ArrayList<Event>();

		// Create Events and add them to the collection
		Event event1 = new Event();
		event1.setName("old event 1");
		allEvents.add(event1);

		Event event2 = new Event();
		event2.setName("new event 2");
		allEvents.add(event2);

		Event event3 = new Event();
		event3.setName("this event 3 old");
		allEvents.add(event3);

		return allEvents;
	}

	@Override
	public void insert(Event event) throws Exception {
		
		Log.warn("Inserting to stub: this does not persist the item");
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Event event) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Event event) throws Exception {
		// TODO Auto-generated method stub

	}

}
