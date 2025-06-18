package com.ruoyi.coefficient.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 每人天公摊费用对象 dorm_coefficient
 * 
 * @author qqq
 * @date 2022-05-03
 */
public class DormCoefficient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String areaNumber;

    /** 宿舍楼编号 */
    @Excel(name = "宿舍楼编号")
    private String floorNumber;

    /** 宿舍楼层号 */
    @Excel(name = "宿舍楼层号")
    private String dormFloor;

    /** 每人天公共冷水费 */
    @Excel(name = "每人天公共冷水费")
    private BigDecimal publicColdwater;

    /** 每人天公共热水费 */
    @Excel(name = "每人天公共热水费")
    private BigDecimal publicHotwater;

    /** 热水单价 */
    @Excel(name = "热水单价")
    private BigDecimal hotwaterPrice;

    /** 每人天公共电费 */
    @Excel(name = "每人天公共电费")
    private BigDecimal publicElectric;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
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
    public void setDormFloor(String dormFloor) 
    {
        this.dormFloor = dormFloor;
    }

    public String getDormFloor() 
    {
        return dormFloor;
    }
    public void setPublicColdwater(BigDecimal publicColdwater) 
    {
        this.publicColdwater = publicColdwater;
    }

    public BigDecimal getPublicColdwater() 
    {
        return publicColdwater;
    }
    public void setPublicHotwater(BigDecimal publicHotwater) 
    {
        this.publicHotwater = publicHotwater;
    }

    public BigDecimal getPublicHotwater() 
    {
        return publicHotwater;
    }
    public void setHotwaterPrice(BigDecimal hotwaterPrice) 
    {
        this.hotwaterPrice = hotwaterPrice;
    }

    public BigDecimal getHotwaterPrice() 
    {
        return hotwaterPrice;
    }
    public void setPublicElectric(BigDecimal publicElectric) 
    {
        this.publicElectric = publicElectric;
    }

    public BigDecimal getPublicElectric() 
    {
        return publicElectric;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("date", getDate())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("dormFloor", getDormFloor())
            .append("publicColdwater", getPublicColdwater())
            .append("publicHotwater", getPublicHotwater())
            .append("hotwaterPrice", getHotwaterPrice())
            .append("publicElectric", getPublicElectric())
            .toString();
    }
}
