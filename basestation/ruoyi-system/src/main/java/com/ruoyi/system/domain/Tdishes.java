package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 菜品对象 t_dishes
 * 
 * @author yihao
 * @date 2020-10-24
 */
public class Tdishes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 类别ID */
    @Excel(name = "类别ID")
    private Integer categoryId;

    /** 菜名 */
    @Excel(name = "菜名")
    private String name;

    /** 简介 */
    @Excel(name = "简介")
    private String descp;

    /** 价格 */
    @Excel(name = "价格")
    private Integer price;

    /** 图片URL */
    @Excel(name = "图片URL")
    private String image;

    /** 状态 1:上架，2:下架 */
    @Excel(name = "状态 1:上架，2:下架")
    private Integer status;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setCategoryId(Integer categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() 
    {
        return categoryId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public Integer getPrice() 
    {
        return price;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("name", getName())
            .append("descp", getDescp())
            .append("price", getPrice())
            .append("image", getImage())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
