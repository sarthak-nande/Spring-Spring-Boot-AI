package com.springmcp.learnmcp.tools;

import java.time.LocalTime;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;



@Component
public class TimeTool {

	private final Logger logger = LoggerFactory.getLogger(TimeTool.class);
	
	@Tool(name="getLocalTimeStamp", description = "This method will provide you user current time as per there current time zone")
	public String getLocalTimeStamp() {
		logger.info("Current time as per my timezone");
		LocalTime localTime = LocalTime.now();
		return localTime.toString();
	}
	
	@Tool(name="getTimeByUserProivdedTimeZone" , description = "This method will provide the time as per the mentioned timezone")
	public String getTimeByUserProivdedTimeZone(@ToolParam(description = "this value provide you timezone") String timeZone) {
		logger.info("Time as per the mentioned timezone: " + timeZone);
		return LocalTime.now(ZoneId.of(timeZone)).toString();
	}
}
