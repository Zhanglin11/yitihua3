package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;
import cn.edu.nenu.util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Organization Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-29 9:55
 */
@Entity
@Table(name = "T_ORGANIZATION")
public class Organization extends IdEntity {

    private Long pid; //父编码
    @Column(length = 128)
    private String name; //名称
    @Column(length = 128)
    private String alias; //别名
    @Column(length = 32)
    private String code; //机构编码
    @Column(length = 128)
    private String treeCode;//四位一体编码
    private float levelSort; //同级排序
    private Constants.Status status= Constants.Status.DISABLE; //状态

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public float getLevelSort() {
        return levelSort;
    }

    public void setLevelSort(float levelSort) {
        this.levelSort = levelSort;
    }

    public Constants.Status getStatus() {
        return status;
    }

    public void setStatus(Constants.Status status) {
        this.status = status;
    }
}
