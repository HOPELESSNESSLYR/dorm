package com.ruoyi.feefloor.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 楼层费用对象 fee_floor
 * 
 * @author lyr
 * @date 2025-07-01
 */
public class FeeFloor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 楼层费用ID */
    @Excel(name = "楼层费用ID")
    private Long floorfeeId;


    /** 年份 */
    @Excel(name = "年份")
    private String nian;

    /** 月份 */
    @Excel(name = "月份")
    private String yue;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String areaNumber;

    /** 宿舍楼编号 */
    @Excel(name = "宿舍楼编号")
    private String floorNumber;

    /** 宿舍楼名称 */
    @Excel(name = "宿舍楼名称")
    private String floorName;

    /** 宿舍楼层号 */
    @Excel(name = "宿舍楼层号")
    private String dormFloor;

    /** 楼层热水费 */
    @Excel(name = "楼层热水费")
    private BigDecimal floorHotwaterFee;

    /** 楼层冷水费 */
    @Excel(name = "楼层冷水费")
    private BigDecimal floorCoolwaterFee;

    /** 楼层电费 */
    @Excel(name = "楼层电费")
    private BigDecimal floorElectricityFee;

    public void setFloorfeeId(Long floorfeeId) 
    {
        this.floorfeeId = floorfeeId;
    }

    public Long getFloorfeeId() 
    {
        return floorfeeId;
    }
    public void setNian(String nian)
    {
        this.nian = nian;
    }

    public String getNian()
    {
        return nian;
    }
    public void setYue(String yue)
    {
        this.yue = yue;
    }

    public String getYue()
    {
        return yue;
    }
    public void setAreaNumber(String areaNumber) 
    {
        this.areaNumber = areaNumber;
    }

    public String getAreaNumber() 
    {
        return areaNumber;
    }
    public void setFloorNumber(String floorNumber) 
    {
        this.floorNumber = floorNumber;
    }

    public String getFloorNumber() 
    {
        return floorNumber;
    }
    public void setFloorName(String floorName) 
    {
        this.floorName = floorName;
    }

    public String getFloorName() 
    {
        return floorName;
    }
    public void setDormFloor(String dormFloor) 
    {
        this.dormFloor = dormFloor;
    }

    public String getDormFloor() 
    {
        return dormFloor;
    }
    public void setFloorHotwaterFee(BigDecimal floorHotwaterFee) 
    {
        this.floorHotwaterFee = floorHotwaterFee;
    }

    public BigDecimal getFloorHotwaterFee() 
    {
        return floorHotwaterFee;
    }
    public void setFloorCoolwaterFee(BigDecimal floorCoolwaterFee) 
    {
        this.floorCoolwaterFee = floorCoolwaterFee;
    }

    public BigDecimal getFloorCoolwaterFee() 
    {
        return floorCoolwaterFee;
    }
    public void setFloorElectricityFee(BigDecimal floorElectricityFee) 
    {
        this.floorElectricityFee = floorElectricityFee;
    }

    public BigDecimal getFloorElectricityFee() 
    {
        return floorElectricityFee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("floorfeeId", getFloorfeeId())
                .append("nian", getNian())
                .append("yue", getYue())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("floorName", getFloorName())
            .append("dormFloor", getDormFloor())
            .append("floorHotwaterFee", getFloorHotwaterFee())
            .append("floorCoolwaterFee", getFloorCoolwaterFee())
            .append("floorElectricityFee", getFloorElectricityFee())
            .toString();
    }
}
