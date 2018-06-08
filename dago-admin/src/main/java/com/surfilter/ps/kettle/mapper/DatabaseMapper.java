package com.surfilter.ps.kettle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.surfilter.ps.kettle.entity.Database;

public interface DatabaseMapper {

	@Results(id = "BaseResultMap2", value = { @Result(property = "idDatabase", column = "idDatabase", id = true),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })

	/**
	 * 根据主键进行查询.
	 * 
	 * @param id
	 * @return
	 */
	@Select("select * from r_database where ID_DATABASE = #{id}")
	Database getById(Integer id);

	@SelectProvider(type = DatabaseSqlBuilder.class, method = "getByObject")
	List<Database> query(Database database);

	class DatabaseSqlBuilder {
		// If not use @Param, you should be define same arguments with mapper method
		public static String getByObject(final String name, final Database database) {
			return new SQL() {
				{
					SELECT("*");
					FROM("users");
					WHERE("name like #{name} || '%'");
				}
			}.toString();
		}

	}

}