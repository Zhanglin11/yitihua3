package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Storage Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-29 9:55
 */
@Entity
@Table(name = "T_STORAGE")
public class Storage extends IdEntity {

    private String content;//URI地址
    private String title;//描述
    private float sort;//排序

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getSort() {
        return sort;
    }

    public void setSort(float sort) {
        this.sort = sort;
    }
}
