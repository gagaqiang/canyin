package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.mapper.ActEvtLogMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 ACT_EVT_LOG
 * 
 * @author ruoyi
 * @date 2020-10-20
 */
public class ActEvtLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long logNr;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String procDefId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String procInstId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String executionId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String taskId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date timeStamp;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String lockOwner;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date lockTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long isProcessed;

    public void setLogNr(Long logNr) 
    {
        this.logNr = logNr;
    }

    public Long getLogNr() 
    {
        return logNr;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setProcDefId(String procDefId) 
    {
        this.procDefId = procDefId;
    }

    public String getProcDefId() 
    {
        return procDefId;
    }
    public void setProcInstId(String procInstId) 
    {
        this.procInstId = procInstId;
    }

    public String getProcInstId() 
    {
        return procInstId;
    }
    public void setExecutionId(String executionId) 
    {
        this.executionId = executionId;
    }

    public String getExecutionId() 
    {
        return executionId;
    }
    public void setTaskId(String taskId) 
    {
        this.taskId = taskId;
    }

    public String getTaskId() 
    {
        return taskId;
    }
    public void setTimeStamp(Date timeStamp) 
    {
        this.timeStamp = timeStamp;
    }

    public Date getTimeStamp() 
    {
        return timeStamp;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLockOwner(String lockOwner)
    {
        this.lockOwner = lockOwner;
    }

    public String getLockOwner() 
    {
        return lockOwner;
    }
    public void setLockTime(Date lockTime) 
    {
        this.lockTime = lockTime;
    }

    public Date getLockTime() 
    {
        return lockTime;
    }
    public void setIsProcessed(Long isProcessed) 
    {
        this.isProcessed = isProcessed;
    }

    public Long getIsProcessed() 
    {
        return isProcessed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("logNr", getLogNr())
            .append("type", getType())
            .append("procDefId", getProcDefId())
            .append("procInstId", getProcInstId())
            .append("executionId", getExecutionId())
            .append("taskId", getTaskId())
            .append("timeStamp", getTimeStamp())
            .append("userId", getUserId())
            .append("data", getData())
            .append("lockOwner", getLockOwner())
            .append("lockTime", getLockTime())
            .append("isProcessed", getIsProcessed())
            .toString();
    }
}
