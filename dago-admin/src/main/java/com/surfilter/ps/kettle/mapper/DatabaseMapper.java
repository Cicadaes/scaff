package com.surfilter.ps.kettle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import com.surfilter.ps.kettle.entity.Database;

public interface DatabaseMapper {

	@Results(id = "BaseResultMap", value = { @Result(property = "idDatabase", column = "idDatabase", id = true),
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
	
	@SelectProvider(type = DatabaseSqlBuilder.class, method = "buildGetUsersByName")
	List<Database> query(Database database);

	@SelectProvider(type = UserSqlBuilder.class, method = "buildGetUsersByName")
	List<Database> getUsersByName(@Param("name") String name, @Param("orderByColumn") String orderByColumn);
	
	
	class DatabaseSqlBuilder {
		// If not use @Param, you should be define same arguments with mapper method
		public static String buildGetUsersByName(final String name, final String orderByColumn) {
			return new SQL() {
				{
					SELECT("*");
					FROM("users");
					WHERE("name like #{name} || '%'");
					ORDER_BY(orderByColumn);
				}
			}.toString();
		}

		// If use @Param, you can define only arguments to be used
		public static String buildGetUsersByName(@Param("orderByColumn") final String orderByColumn) {
			return new SQL() {
				{
					SELECT("*");
					FROM("users");
					WHERE("name like #{name} || '%'");
					ORDER_BY(orderByColumn);
				}
			}.toString();
		}
	}

	class UserSqlBuilder {
		// If not use @Param, you should be define same arguments with mapper method
		public static String buildGetUsersByName(final String name, final String orderByColumn) {
			return new SQL() {
				{
					SELECT("*");
					FROM("users");
					WHERE("name like #{name} || '%'");
					ORDER_BY(orderByColumn);
				}
			}.toString();
		}

		// If use @Param, you can define only arguments to be used
		public static String buildGetUsersByName(@Param("orderByColumn") final String orderByColumn) {
			return new SQL() {
				{
					SELECT("*");
					FROM("users");
					WHERE("name like #{name} || '%'");
					ORDER_BY(orderByColumn);
				}
			}.toString();
		}
	}
}