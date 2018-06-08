package com.surfilter.ps.kettle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surfilter.ps.kettle.entity.Database;
import com.surfilter.ps.kettle.mapper.DatabaseMapper;

/**
 * 数据库service
 * @author AlexYao
 *
 */
@Service
public class RDatabaseService {
	
	@Autowired DatabaseMapper databaseMapper;
	
	public List<Database> query(Database database){
		return databaseMapper.query(database);
	}
	

}
