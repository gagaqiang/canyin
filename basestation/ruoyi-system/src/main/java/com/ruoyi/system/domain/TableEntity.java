package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 桌编码对象 t_table
 * 
 * @author yihao
 * @date 2020-10-24
 */
public class TableEntity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 号码 */
    @Excel(name = "号码")
    private String num;

    /** 承载人数 */
    @Excel(name = "承载人数")
    private Long bearPeople;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setBearPeople(Long bearPeople) 
    {
        this.bearPeople = bearPeople;
    }

    public Long getBearPeople() 
    {
        return bearPeople;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("num", getNum())
            .append("remark", getRemark())
            .append("bearPeople", getBearPeople())
            .toString();
    }
}
