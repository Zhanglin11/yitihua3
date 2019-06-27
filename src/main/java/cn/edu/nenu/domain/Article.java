package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Article Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2019-04-23 17:13
 */
@Entity
@Table(name = "T_ARTICLE")
public class Article extends IdEntity {

    @Column(length = 128)
    private String title;//标题
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String content;//内容
    @ManyToOne
    @JoinColumn(name = "creator_id",referencedColumnName = "id",nullable = false)
    private User creator;//创建者
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id",nullable = false)
    private Category category;//文章栏目
    private LocalDateTime createdAt;//创建时间
    private LocalDateTime lasteditAt;//最后编辑时间
    private String status;//状态(9：草稿、0：未发布、1：已发布、2：私密)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLasteditAt() {
        return lasteditAt;
    }

    public void setLasteditAt(LocalDateTime lasteditAt) {
        this.lasteditAt = lasteditAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
