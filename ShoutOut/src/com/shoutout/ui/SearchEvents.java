package com.shoutout.ui;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.shoutout.dto.Event;
import com.shoutout.services.IEventService;

@Named
@ManagedBean
@Scope("session")

public class SearchEvents {

	@Inject
	private Event event;
	
	@Inject
	private IEventService eventService;

	public String execute() {

		if (event != null && event.getName().equalsIgnoreCase("event 1")) {
			return "search";
		} else {
			return "noresults";
		}
	}
	
	public Event getEvent( ) {
		return event;
	}
	
	public void  setEvent(Event event) {
		this.event = event;
	}
	
	public List<Event> completeEvents(String query) {
		return eventService.filterEvents(query);
	}

}
