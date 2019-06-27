package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;
import cn.edu.nenu.util.Constants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Dict Class
 *  数据字典类，用于存放：性别、民族、政治面貌等常量
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-29 9:55
 */
@Entity
@Table(name = "T_DICT")
public class Dict extends IdEntity {

    private String type; //类型
    private String code; //编码
    private String name; //名称
    private float sort; //排序
    private Constants.Status status = Constants.Status.DISABLE; //状态

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
