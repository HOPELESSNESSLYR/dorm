package com.ruoyi.fixedassets.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宿舍固定资产对象 dorm_fixedassets
 * 
 * @author qqq
 * @date 2022-05-03
 */
public class DormFixedassets extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private Long areaNumber;

    /** 宿舍楼编号 */
    @Excel(name = "宿舍楼编号")
    private Long floorNumber;

    /** 宿舍楼层号 */
    @Excel(name = "宿舍楼层号")
    private Long dormFloor;

    /** 宿舍房间号 */
    @Excel(name = "宿舍房间号")
    private String roomNumber;

    /** 宿舍固定资产编码 */
    @Excel(name = "宿舍固定资产编码")
    private String dormPropertyNumber;

    /** 宿舍固定资产描述 */
    @Excel(name = "宿舍固定资产描述")
    private String dormPropertyDescription;

    /** 宿舍固定资产备注 */
    @Excel(name = "宿舍固定资产备注")
    private String dormPropertyRemarks;

    /** 总数量 */
    @Excel(name = "总数量")
    private Long totalnumber;

    /** 物品单价 */
    @Excel(name = "物品单价")
    private BigDecimal price;

    /** 赔偿单价 */
    @Excel(name = "赔偿单价")
    private BigDecimal compensationPrice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAreaNumber(Long areaNumber) 
    {
        this.areaNumber = areaNumber;
    }

    public Long getAreaNumber() 
    {
        return areaNumber;
    }
    public void setFloorNumber(Long floorNumber) 
    {
        this.floorNumber = floorNumber;
    }

    public Long getFloorNumber() 
    {
        return floorNumber;
    }
    public void setDormFloor(Long dormFloor) 
    {
        this.dormFloor = dormFloor;
    }

    public Long getDormFloor() 
    {
        return dormFloor;
    }
    public void setRoomNumber(String roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() 
    {
        return roomNumber;
    }
    public void setDormPropertyNumber(String dormPropertyNumber) 
    {
        this.dormPropertyNumber = dormPropertyNumber;
    }

    public String getDormPropertyNumber() 
    {
        return dormPropertyNumber;
    }
    public void setDormPropertyDescription(String dormPropertyDescription) 
    {
        this.dormPropertyDescription = dormPropertyDescription;
    }

    public String getDormPropertyDescription() 
    {
        return dormPropertyDescription;
    }
    public void setDormPropertyRemarks(String dormPropertyRemarks) 
    {
        this.dormPropertyRemarks = dormPropertyRemarks;
    }

    public String getDormPropertyRemarks() 
    {
        return dormPropertyRemarks;
    }
    public void setTotalnumber(Long totalnumber) 
    {
        this.totalnumber = totalnumber;
    }

    public Long getTotalnumber() 
    {
        return totalnumber;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setCompensationPrice(BigDecimal compensationPrice) 
    {
        this.compensationPrice = compensationPrice;
    }

    public BigDecimal getCompensationPrice() 
    {
        return compensationPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("dormPropertyNumber", getDormPropertyNumber())
            .append("dormPropertyDescription", getDormPropertyDescription())
            .append("dormPropertyRemarks", getDormPropertyRemarks())
            .append("totalnumber", getTotalnumber())
            .append("price", getPrice())
            .append("compensationPrice", getCompensationPrice())
            .toString();
    }
}
