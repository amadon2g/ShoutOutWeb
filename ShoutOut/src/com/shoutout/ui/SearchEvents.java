package com.shoutout.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")

public class SearchEvents {
	
	public String execute( ) {
		return "noresults";
	}

}
