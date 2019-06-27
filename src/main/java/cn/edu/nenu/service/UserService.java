package cn.edu.nenu.service;

import cn.edu.nenu.config.orm.jpa.DynamicSpecifications;
import cn.edu.nenu.config.orm.jpa.SearchFilter;
import cn.edu.nenu.domain.User;
import cn.edu.nenu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * UserService Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-15 7:55
 */
@Service
public class UserService {

    @Autowired
    public UserRepository userRepo;

    public List getAllUser() {
        return null;
    }

    public User getUser(Long id) {
        return null;
    }

    /**
     * 根据查询条件获取分页结果数据
     */
    public Page<User> getEntityPage(Map<String, Object> filterParams, int pageNumber, int pageSize, String sortType){
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<User> spec = buildSpecification(filterParams);
        return userRepo.findAll(spec,pageRequest);
    }

    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "id");
        } else if ("sort".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "username");
        }
        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    /**
     * 创建动态查询条件组合.
     */
    private Specification<User> buildSpecification(Map<String, Object> filterParams) {

        Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
        //if (StringUtils.isNotBlank(id)) {
        //    filters.put("id", new SearchFilter("id", SearchFilter.Operator.EQ, id));
        //}
        Specification<User> spec = DynamicSpecifications.bySearchFilter(filters.values(), User.class);
        return spec;
    }
}
