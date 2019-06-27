package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;
import cn.edu.nenu.util.Constants;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Category Class
 * 栏目分类管理
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-04-23 17:13
 */
@Entity
@Table(name = "T_CATEGORY")
public class Category extends IdEntity {

    private String name;//分类名称
    private float sort;//排序
    private Constants.Status status= Constants.Status.DISABLE;//状态

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSort() {
        return sort;
    }

    public void setSort(float sort) {
        this.sort = sort;
    }

    public Constants.Status getStatus() {
        return status;
    }

    public void setStatus(Constants.Status status) {
        this.status = status;
    }
}
