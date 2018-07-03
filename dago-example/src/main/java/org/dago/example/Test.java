package org.dago.example;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surfilter.ps.starter.ftp.FTPClientFactory;
import com.surfilter.ps.starter.ftp.FTPClientPool;

@RestController
public class Test {
	@Autowired
	FTPClientPool pool ;
	@GetMapping("/test")
	public String test() throws Exception {
		FTPClientFactory ftpClientFactory =  pool.getClientFactory();
		FTPClient client = ftpClientFactory.create();
		System.out.println(client.list());
		return "";
	}

}
