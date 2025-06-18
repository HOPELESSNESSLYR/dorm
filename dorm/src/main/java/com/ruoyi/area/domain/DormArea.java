package com.ruoyi.area.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 区域信息对象 dorm_area
 * 
 * @author qqq
 * @date 2022-03-30
 */
public class DormArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 区域编号 */
    private String areaNumber;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String areaName;

    /** 地理位置 */
    @Excel(name = "地理位置")
    private String areaLocation;

    /** 区域创建人 */
    @Excel(name = "区域创建人")
    private String areaCreateman;

    /** 区域创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "区域创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date areaCdate;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setAreaNumber(String areaNumber) 
    {
        this.areaNumber = areaNumber;
    }

    public String getAreaNumber() 
    {
        return areaNumber;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setAreaLocation(String areaLocation) 
    {
        this.areaLocation = areaLocation;
    }

    public String getAreaLocation() 
    {
        return areaLocation;
    }
    public void setAreaCreateman(String areaCreateman) 
    {
        this.areaCreateman = areaCreateman;
    }

    public String getAreaCreateman() 
    {
        return areaCreateman;
    }
    public void setAreaCdate(Date areaCdate) 
    {
        this.areaCdate = areaCdate;
    }

    public Date getAreaCdate() 
    {
        return areaCdate;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("areaNumber", getAreaNumber())
            .append("areaName", getAreaName())
            .append("areaLocation", getAreaLocation())
            .append("areaCreateman", getAreaCreateman())
            .append("areaCdate", getAreaCdate())
            .append("remarks", getRemarks())
            .toString();
    }
}
