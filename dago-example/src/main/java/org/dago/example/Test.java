package org.dago.example;

import com.surfilter.ps.starter.ftp.TargetFtpDataSource;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surfilter.ps.starter.ftp.FTPClientFactory;
import com.surfilter.ps.starter.ftp.FTPClientPool;

@RestController
public class Test {
	@Autowired
	@TargetFtpDataSource(1)
	FTPClientPool pool ;

	@GetMapping("/test")
	public String test() throws Exception {
		FTPClient client = pool.borrowObject();
		System.out.println(client.list());
		pool.returnObject(client);
		return "";
	}

}
