package com.surfilter.ps.system.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.surfilter.gacenter.entity.system.dict.DictVo;
import com.surfilter.ps.core.mybatis.MyBatisCrudRepository;
import com.surfilter.ps.system.entity.Dict;

/**
 * @author xiashaofei
 *
 *         2018年4月10日
 */
@Mapper
public interface DictMapper {

	/**
	 * 用于校验唯一性name
	 * <p>
	 * Title: getByTypeAndName
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param queryMap
	 * @return
	 */
	Dict getByTypeAndName(Map<String, Object> queryMap);

	/**
	 * 用于校验唯一性value
	 * <p>
	 * Title: getByTypeAndValue
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * @param queryMap
	 * @return
	 */
	Dict getByTypeAndValue(Map<String, Object> queryMap);

	List<Dict> getAuthTypes();

	List<Dict> findByStringType(String type);

	List<Dict> list(Dict query);

	Long listCount(Dict query);

	String findByTypeAndNames(Map<String, Object> map);

	/**
	 * @Description:按词典类别和字典编码查询
	 * @author 陶定凯
	 */
	Dict findByTypeAndName(Map<String, Object> map);

	/**
	 * 根据type和name查询id
	 * 
	 * @param queryMap
	 * @return
	 */
	Dict findIdByTypeAndName(Map<String, Object> queryMap);

	List<DictVo> findByType(String type);

	/**
	 * 根据类型查字典名称和值（源数据通用字典查询接口；author：李强）
	 * 
	 * @param string
	 * @return
	 */
	List<Map<String, Object>> getNameAndValueByType(String type);

}
