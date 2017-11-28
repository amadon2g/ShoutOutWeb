package com.shoutout.dao;

import java.util.List;

import com.shoutout.dto.Event;

public interface IEventDAO {
	
	public List<Event> fetchEvents();
	
	public void insert(Event event)  throws Exception;
	
	public void update(Event event)  throws Exception;
	
	public void delete(Event event)  throws Exception;

}
