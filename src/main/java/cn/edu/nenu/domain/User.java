package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;
import cn.edu.nenu.util.Constants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-03-15 6:08
 */
@Entity
@Table(name = "T_USER")
// 默认的缓存策略.
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends IdEntity {

    @Column(length = 128)
    private String name;//姓名 2*n
    @ManyToOne
    @JoinColumn(name = "gender_id",referencedColumnName = "id",nullable = false)
    private Dict gender;//性别
    @Column(length = 11)
    private String telephone;//联系方式
    @Column(length = 36,unique = true,nullable = false)
    private String username;//用户名
    @Column(length = 128,nullable = false)
    private String password;//密码
    @Column(length = 36)
    private String salt;;//加密盐
    private LocalDateTime createdAt=LocalDateTime.now();//创建时间
    private Constants.Status status= Constants.Status.DISABLE;//状态

    @ManyToMany
    @JoinTable(name = "T_USER_ROLE",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roles = new HashSet<Role>(); // 有序的关联对象集合

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // 多对多定义
    //@ManyToMany
    //@JoinTable(name = "T_USER_ROLE", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    // Fecth策略定义
    //@Fetch(FetchMode.SUBSELECT)
    // 集合按id排序
    //@OrderBy("id ASC")
    // 缓存策略
    //@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    public Set<Role> getRoles() {
        return roles;
    }
    public List<String> getRoleList(){
        List<String> roleList = new ArrayList<>();
        for (Role role:roles){
            roleList.add(role.getCode());
        }
        return roleList;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dict getGender() {
        return gender;
    }

    public void setGender(Dict gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Constants.Status getStatus() {
        return status;
    }

    public void setStatus(Constants.Status status) {
        this.status = status;
    }


}
