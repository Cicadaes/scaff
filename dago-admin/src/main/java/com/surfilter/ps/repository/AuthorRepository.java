package com.surfilter.ps.repository;

import com.surfilter.ps.domain.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * All rights Reserved, Designed By www.1218.com.cn
 *
 * @version V1.0
 * @Title: AuthorRepository
 * @Package com.surfilter.ps.repository
 * @Description:
 * @author: Alex
 * @date: 2018-05-28 下午9:30
 * @Copyright: 2018 www.1218.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于任子行网络技术股份有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@RepositoryRestResource
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
}
