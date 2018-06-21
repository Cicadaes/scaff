package com.surfilter.ps.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.surfilter.ps.core.entity.PageResult;
import com.surfilter.ps.kettle.entity.Database;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author AlexYao
 *
 */
@Api(tags = "数据源信息")
@RestController
@RequestMapping("/database/")
public class DatabaseController {
	
	@ApiOperation(value = "数据源信息/查询", notes = "数据源信息/查询", response = Database.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回Api", response = PageResult.class)})
	@GetMapping("query/")
    @ResponseBody
	public PageResult queryDatabases(Database database) {
		PageResult result = new PageResult();
		return result;
	}

}
