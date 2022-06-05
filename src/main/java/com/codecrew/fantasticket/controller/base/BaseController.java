package com.codecrew.fantasticket.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
	public Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	public Logger getLogger() {
		return logger;
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}