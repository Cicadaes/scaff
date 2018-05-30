package com.surfilter.ps.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.surfilter.ps.config.web.ApiVersion;
import com.surfilter.ps.model.RCluster;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author AlexYao
 *
 */
@Api(value="cluster",tags = "集群")
@RestController
@RequestMapping("cluster")
public class RClusterConroller {
	
	@ApiOperation(value = "查询接口", notes = "查询接口")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回Api", response = String.class)})
	@RequestMapping("query")
    @ApiVersion(1)
    @ResponseBody
    public RCluster query(@RequestBody @ApiParam(name="集群表单",value="参数说明",required=true) RCluster cluster){
        System.out.println("haha1..........");
        return new RCluster();
    }

}
