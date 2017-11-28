package com.shoutout.services.test;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.shoutout.dao.IEventDAO;
import com.shoutout.dto.Event;
import com.shoutout.services.EventService;

import junit.framework.TestCase;

public class TestEventServices extends TestCase {

	private EventService eventService;
	private IEventDAO eventDAO;
	private List<Event> e;

	@Test
	public void testFilterEvents() {
		givenThatEventServiceIsPopulatedWithEventDAO();
		whenFilterWithEve();
		thenVerifyTwoResults();
	}

	private void thenVerifyTwoResults() {
		// TODO Auto-generated method stub
		assertEquals(2, e.size());

	}

	private void whenFilterWithEve() {
		// TODO Auto-generated method stub
		e = eventService.filterEvents("old");


	}
 
	private void givenThatEventServiceIsPopulatedWithEventDAO() {
		eventService = new EventService();

		eventDAO = mock(IEventDAO.class);
		List<Event> eventList = constructEventList();
		when(eventDAO.fetchEvents()).thenReturn(eventList);
		eventService.setEventDAO(eventDAO);

	}

	private List<Event> constructEventList() {
		List<Event> allEvents = new ArrayList<Event>();

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
}
