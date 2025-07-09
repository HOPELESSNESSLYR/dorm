package com.ruoyi.feeconfig.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 费用配置对象 fee_config
 * 
 * @author lyr
 * @date 2025-07-01
 */
public class FeeConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 费用配置ID */
    private Long congifId;

    /** 年份月份 */
//    @JsonFormat(pattern = "yyyy-MM")
//    @Excel(name = "年份月份")
//    private String nianyue;

    /** 年份 */
    @Excel(name = "年份")
    private String nian;

    /** 月份 */
    @Excel(name = "月份")
    private String yue;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String areaNumber;

    /** 宿舍楼层号 */
    @Excel(name = "楼层号")
    private String dormFloor;

    /** 电费单价 */
    @Excel(name = "电费单价")
    private BigDecimal electricityPrice;

    /** 热水费单价 */
    @Excel(name = "热水费单价")
    private BigDecimal hotwaterPrice;

    /** 冷水费单价 */
    @Excel(name = "冷水费单价")
    private BigDecimal coolwaterPrice;

    /** 公共电费单价 */
    @Excel(name = "公共电费单价")
    private BigDecimal publicElectricityPrice;

    /** 公共热水费单价 */
    @Excel(name = "公共热水费单价")
    private BigDecimal publicHotwaterPrice;

    /** 公共冷水费单价 */
    @Excel(name = "公共冷水费单价")
    private BigDecimal publicCoolwaterPrice;

    /** 公共洗衣机费 */
    @Excel(name = "公共洗衣机费")
    private BigDecimal publicWashingPrice;

    public void setCongifId(Long congifId) 
    {
        this.congifId = congifId;
    }

    public Long getCongifId() 
    {
        return congifId;
    }
//    public void setNianyue(String nianyue)
//    {
//        this.nianyue = nianyue;
//    }
//
//    public String getNianyue()
//    {
//        return nianyue;
//    }
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
    public void setDormFloor(String dormFloor)
    {
        this.dormFloor = dormFloor;
    }

    public String getDormFloor()
    {
        return dormFloor;
    }
    public void setElectricityPrice(BigDecimal electricityPrice) 
    {
        this.electricityPrice = electricityPrice;
    }

    public BigDecimal getElectricityPrice() 
    {
        return electricityPrice;
    }
    public void setHotwaterPrice(BigDecimal hotwaterPrice) 
    {
        this.hotwaterPrice = hotwaterPrice;
    }

    public BigDecimal getHotwaterPrice() 
    {
        return hotwaterPrice;
    }
    public void setCoolwaterPrice(BigDecimal coolwaterPrice) 
    {
        this.coolwaterPrice = coolwaterPrice;
    }

    public BigDecimal getCoolwaterPrice() 
    {
        return coolwaterPrice;
    }
    public void setPublicElectricityPrice(BigDecimal publicElectricityPrice) 
    {
        this.publicElectricityPrice = publicElectricityPrice;
    }

    public BigDecimal getPublicElectricityPrice() 
    {
        return publicElectricityPrice;
    }
    public void setPublicHotwaterPrice(BigDecimal publicHotwaterPrice) 
    {
        this.publicHotwaterPrice = publicHotwaterPrice;
    }

    public BigDecimal getPublicHotwaterPrice() 
    {
        return publicHotwaterPrice;
    }
    public void setPublicCoolwaterPrice(BigDecimal publicCoolwaterPrice) 
    {
        this.publicCoolwaterPrice = publicCoolwaterPrice;
    }

    public BigDecimal getPublicCoolwaterPrice() 
    {
        return publicCoolwaterPrice;
    }
    public void setPublicWashingPrice(BigDecimal publicWashingPrice) 
    {
        this.publicWashingPrice = publicWashingPrice;
    }

    public BigDecimal getPublicWashingPrice() 
    {
        return publicWashingPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("congifId", getCongifId())
//            .append("nianyue", getNianyue())
                .append("nian", getNian())
                .append("yue", getYue())
            .append("areaNumber", getAreaNumber())
                .append("dormFloor", getDormFloor())
            .append("electricityPrice", getElectricityPrice())
            .append("hotwaterPrice", getHotwaterPrice())
            .append("coolwaterPrice", getCoolwaterPrice())
            .append("publicElectricityPrice", getPublicElectricityPrice())
            .append("publicHotwaterPrice", getPublicHotwaterPrice())
            .append("publicCoolwaterPrice", getPublicCoolwaterPrice())
            .append("publicWashingPrice", getPublicWashingPrice())
            .toString();
    }
}
