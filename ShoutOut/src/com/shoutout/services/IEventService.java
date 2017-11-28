package com.shoutout.services;

import java.util.List;

import com.shoutout.dto.Event;

/**
 * IEventService includes all business related function for
 *  an event and all related entities
 * @author amado
 */
public interface IEventService {
	
	/**
	 * Returns a collection of events that contains the given filter text
	 * @param filter a substring that should be contained in returned plants
	 * @return a collection of matching events
	 */
	public List<Event> filterEvents(String filter);

	/**
	 * save an event and perform a validation test.
	 * @param the event we are trying to persist
	 * @throws Exception if unable to save the event
	 */
	void save(Event event) throws Exception;

}
