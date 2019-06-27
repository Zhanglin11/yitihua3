package cn.edu.nenu.service;

import cn.edu.nenu.domain.User;
import cn.edu.nenu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AccountService Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-21 14:00
 */
@Component
public class AccountService {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    //private static final int SALT_SIZE = 8;


    private UserRepository userRepository;

    public User login(String username, String password) {
        //System.currentTimeMillis();
        User user= userRepository.findByUsernameAndPassword(username,password);
        return user;
    }

    public User findUserByLoginName(String username) {
        return userRepository.findByUsername(username);
    }

    @Autowired
    public void setUserRepo(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
