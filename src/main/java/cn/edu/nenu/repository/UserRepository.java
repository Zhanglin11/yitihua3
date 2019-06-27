package cn.edu.nenu.repository;

import cn.edu.nenu.config.orm.PlatformRepository;
import cn.edu.nenu.domain.User;
import org.springframework.data.jpa.repository.Query;

/**
 * UserRepository Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-04-26 1:49
 */
public interface UserRepository extends PlatformRepository<User,Long> {

    @Query("from User u  where u.username=?1 and u.password=?2 ")
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
