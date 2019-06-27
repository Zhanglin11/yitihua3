package cn.edu.nenu.repository;

import cn.edu.nenu.config.orm.PlatformRepository;
import cn.edu.nenu.domain.Dict;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * DictRepository Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-09 21:40
 */
public interface DictRepository extends PlatformRepository<Dict,Long> {

    @Query("from Dict d where d.type=?1 order by d.sort asc ")
    List<Dict> findByTypeOrderBySort(String type);

    //@Query("from Dict d order by d.sort asc")
    Dict findFirstByOrderBySortDesc();
}
