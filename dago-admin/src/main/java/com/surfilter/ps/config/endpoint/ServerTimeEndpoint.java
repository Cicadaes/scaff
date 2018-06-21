package com.surfilter.ps.config.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

@Endpoint(id = "serverTime")
public class ServerTimeEndpoint {
	@ReadOperation
	public String time() {
		return System.currentTimeMillis() + "";
	}

}
