package com.surfilter.ps.web;

import com.surfilter.ps.domain.Demo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@Api(tags = "示例")
@RestController
//@RequestMapping("/{version}/")
public class HelloController {
	
	
	@ApiOperation(value = "hello/查询1", notes = "hello/查询1", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回Api", response = String.class)})
	@GetMapping("hello/")
//    @ApiVersion(1)
    @ResponseBody
    public String hello(HttpServletRequest request){
        System.out.println("haha1..........");
        return "hello1";
    }


	
//	@GetMapping("hello/")
//    @ApiVersion(2)
//    @ResponseBody
//    public String hello2(HttpServletRequest request){
//        System.out.println("haha2.........");
//        return "hello2";
//    }
    
//	@GetMapping("hello/")
//    @ApiVersion(5)
//    @ResponseBody
//    public String hello5(HttpServletRequest request){
//        System.out.println("haha5........."); 
//        return "hello5";
//    }
    
    @ApiOperation(value = "hello/查询10", notes = "hello/查询10", response = Demo.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回Api", response = Demo.class)})
    @GetMapping("hello2/")
    @ResponseBody
    public Demo helloDomain(Demo demo){
        System.out.println("haha10..........");
        return new Demo();
    }

}
