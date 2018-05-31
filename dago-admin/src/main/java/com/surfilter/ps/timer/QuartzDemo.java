package com.surfilter.ps.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.surfilter.ps.service.DemoService;

//@Component
//@EnableScheduling
public class QuartzDemo {
	@Autowired
	DemoService demoService;
	
	@Scheduled(cron = "0 0/1 * * * ?") // 每分钟执行一次
    public void work() throws Exception {
		demoService.printDemo();
    }
    
    
    @Scheduled(fixedRate = 5000)//每5秒执行一次
    public void play() throws Exception {
    	demoService.printDemo();
    }

    
    
    @Scheduled(cron = "0/2 * * * * ?") //每2秒执行一次
    public void doSomething() throws Exception {
    	demoService.printDemo();
    }

    
    
    
    @Scheduled(cron = "0 0 0/1 * * ? ") // 每一小时执行一次
    public void goWork() throws Exception {
    	demoService.printDemo();
    }

}
