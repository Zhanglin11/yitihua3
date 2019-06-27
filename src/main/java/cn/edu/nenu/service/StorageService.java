package cn.edu.nenu.service;

import cn.edu.nenu.config.orm.jpa.DynamicSpecifications;
import cn.edu.nenu.config.orm.jpa.SearchFilter;
import cn.edu.nenu.domain.Storage;
import cn.edu.nenu.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * StorageService Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-24 1:24
 */
@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepo;

    public Storage save(Storage entity) {
        return storageRepo.save(entity);
    }

    /**
     * 根据查询条件获取分页结果数据
     */
    public Page<Storage> getEntityPage(Map<String, Object> filterParams, int pageNumber, int pageSize, String sortType){
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Storage> spec = buildSpecification(filterParams);
        return storageRepo.findAll(spec,pageRequest);
    }
    /**
     * 创建分页请求.
     */
    private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "id");
        } else if ("sort".equals(sortType)) {
            sort = new Sort(Sort.Direction.ASC, "sort");
        }
        return new PageRequest(pageNumber - 1, pageSize, sort);
    }

    /**
     * 创建动态查询条件组合.
     */
    private Specification<Storage> buildSpecification(Map<String, Object> filterParams) {

        Map<String, SearchFilter> filters = SearchFilter.parse(filterParams);
        //if (StringUtils.isNotBlank(id)) {
        //    filters.put("id", new SearchFilter("id", SearchFilter.Operator.EQ, id));
        //}
        Specification<Storage> spec = DynamicSpecifications.bySearchFilter(filters.values(), Storage.class);
        return spec;
    }


    public float getMaxSort() {
        Storage storage = storageRepo.findFirstByOrderBySortDesc();
        if (storage==null){
            return 0;
        }else {
            return storage.getSort();
        }
    }
}
