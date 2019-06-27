package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;
import cn.edu.nenu.util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Role Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-04-23 21:22
 */
@Entity
@Table(name = "T_ROLE")
public class Role extends IdEntity {

    @Column(unique = true)
    private String code;//角色标识
    private String name;//名称
    private float sort;//排序
    private Constants.Status status= Constants.Status.DISABLE;//状态

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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
