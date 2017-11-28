package com.shoutout.ui;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.shoutout.dto.Event;
import com.shoutout.services.IEventService;

@Named
@ManagedBean
@Scope("session")
public class AddEvent {
	
	final static Logger logger = Logger.getLogger(AddEvent.class);
	
	@Inject
	private Event event;
	
	@Inject
	private IEventService eventService;
	
	public String execute() {
		logger.info("Entering the execute method");
		String returnValue = "success";
		try {
			eventService.save(event);
			
			logger.info("Save successful" + event.toString());
			
			// get faces context
			FacesContext currentInstance = FacesContext.getCurrentInstance();
			// what is the message we want to show
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "saved", "Event created");
			currentInstance.addMessage(null, fm);
		} catch (Exception e) {
			
			logger.error("Error while saving event. Message: " + e.getMessage());
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue = "fail";
		}
		return returnValue;
		
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public IEventService getEventService() {
		return eventService;
	}

	public void setEventService(IEventService eventService) {
		this.eventService = eventService;
	}

}
