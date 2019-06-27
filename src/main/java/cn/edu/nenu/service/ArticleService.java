package cn.edu.nenu.service;

import cn.edu.nenu.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ArticleService Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-05-16 23:26
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepo;
}
