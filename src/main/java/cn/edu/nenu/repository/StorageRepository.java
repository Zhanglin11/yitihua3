package cn.edu.nenu.repository;

import cn.edu.nenu.config.orm.PlatformRepository;
import cn.edu.nenu.domain.Storage;

/**
 * StorageRepository Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-04-26 1:53
 */
public interface StorageRepository extends PlatformRepository<Storage,Long> {

    Storage findFirstByOrderBySortDesc();
}
