package com.surfilter.ps.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.surfilter.ps.core.entity.PageResult;
import com.surfilter.ps.service.JobService;
import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.schedule.XxlJobDynamicScheduler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author AlexYao
 *
 */
@Api(tags = "定时任务")
@RestController
@RequestMapping("/job/")
public class JobController {
	@Autowired
	JobService jobService;
	
	
	@ApiOperation(value = "定时任务/查询", notes = "定时任务/查询", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回Api", response = PageResult.class)})
	@GetMapping("query/")
    @ResponseBody
	public PageResult query() {
		PageResult result = new PageResult();
		Map<String, Object> pages = jobService.pageList(0, 1, 1, "", "");
		XxlJobDynamicScheduler.fillJobInfo(new XxlJobInfo());
		result.setBody(pages);
		return result;
	}

}
