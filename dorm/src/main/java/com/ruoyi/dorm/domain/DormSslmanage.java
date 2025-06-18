package com.ruoyi.dorm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍楼信息对象 dorm_sslmanage
 * 
 * @author qqq
 * @date 2022-04-07
 */
public class DormSslmanage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String areaName;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String areaNumber;

    /** 宿舍楼名称 */
    @Excel(name = "宿舍楼名称")
    private String floorName;

    /** 宿舍楼编号 */
    @Excel(name = "宿舍楼编号")
    private String floorNumber;

    /** 宿舍楼栋号 */
    @Excel(name = "宿舍楼栋号")
    private Long cavenumber;

    /** 宿舍楼地址 */
    @Excel(name = "宿舍楼地址")
    private String floorLocation;

    /** 宿舍楼层数 */
    @Excel(name = "宿舍楼层数")
    private Long floornumber;

    /** 创建人 */
    @Excel(name = "创建人")
    private String floorCname;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date floorCdate;

    /** 宿管员姓名 */
    @Excel(name = "宿管员姓名")
    private String adminname;

    /** 入住人数 */
    @Excel(name = "入住人数")
    private Long livenumber;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setAreaNumber(String areaNumber) 
    {
        this.areaNumber = areaNumber;
    }

    public String getAreaNumber() 
    {
        return areaNumber;
    }
    public void setFloorName(String floorName) 
    {
        this.floorName = floorName;
    }

    public String getFloorName() 
    {
        return floorName;
    }
    public void setFloorNumber(String floorNumber) 
    {
        this.floorNumber = floorNumber;
    }

    public String getFloorNumber() 
    {
        return floorNumber;
    }
    public void setCavenumber(Long cavenumber) 
    {
        this.cavenumber = cavenumber;
    }

    public Long getCavenumber() 
    {
        return cavenumber;
    }
    public void setFloorLocation(String floorLocation) 
    {
        this.floorLocation = floorLocation;
    }

    public String getFloorLocation() 
    {
        return floorLocation;
    }
    public void setFloornumber(Long floornumber) 
    {
        this.floornumber = floornumber;
    }

    public Long getFloornumber() 
    {
        return floornumber;
    }
    public void setFloorCname(String floorCname) 
    {
        this.floorCname = floorCname;
    }

    public String getFloorCname() 
    {
        return floorCname;
    }
    public void setFloorCdate(Date floorCdate) 
    {
        this.floorCdate = floorCdate;
    }

    public Date getFloorCdate() 
    {
        return floorCdate;
    }
    public void setAdminname(String adminname) 
    {
        this.adminname = adminname;
    }

    public String getAdminname() 
    {
        return adminname;
    }
    public void setLivenumber(Long livenumber) 
    {
        this.livenumber = livenumber;
    }

    public Long getLivenumber() 
    {
        return livenumber;
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
            .append("id", getId())
            .append("areaName", getAreaName())
            .append("areaNumber", getAreaNumber())
            .append("floorName", getFloorName())
            .append("floorNumber", getFloorNumber())
            .append("cavenumber", getCavenumber())
            .append("floorLocation", getFloorLocation())
            .append("floornumber", getFloornumber())
            .append("floorCname", getFloorCname())
            .append("floorCdate", getFloorCdate())
            .append("adminname", getAdminname())
            .append("livenumber", getLivenumber())
            .append("remarks", getRemarks())
            .toString();
    }
}
