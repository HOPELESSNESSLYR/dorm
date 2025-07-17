package com.ruoyi.feeperson.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人费用对象 fee_person
 * 
 * @author lyr
 * @date 2025-07-01
 */
public class FeePerson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 个人费用 */
    private Long feepersonId;


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

    /** 宿舍楼层号 */
    @Excel(name = "宿舍楼层号")
    private String dormFloor;

    /** 宿舍房间号 */
    @Excel(name = "宿舍房间号")
    private String roomNumber;

    /** 工号 */
    @Excel(name= "工号")
    private String jobnumber;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;


    /** 入住天数 */
    @Excel(name = "入住天数")
    private Long days;

    /** 入住/退宿 */
    @Excel(name = "入住/退宿")
    private Long status;

    /** 个人热水费 */
    @Excel(name = "个人热水费")
    private BigDecimal hotwaterFee;

    /** 个人冷水费 */
    @Excel(name = "个人冷水费")
    private BigDecimal coolwaterFee;

    /** 个人电费 */
    @Excel(name = "个人电费")
    private BigDecimal electricityFee;

    /** 公共电费 */
    @Excel(name = "公共电费")
    private BigDecimal publicElectricity;

    /** 公共热水费 */
    @Excel(name = "公共热水费")
    private BigDecimal publicHotwater;

    /** 公共冷水费 */
    @Excel(name = "公共冷水费")
    private BigDecimal publicCoolwater;
    /** 合计 */
    @Excel(name = "合计")
    private BigDecimal feetotal;

    public void setFeepersonId(Long feepersonId) 
    {
        this.feepersonId = feepersonId;
    }

    public Long getFeepersonId() 
    {
        return feepersonId;
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
    public void setDormFloor(String dormFloor) 
    {
        this.dormFloor = dormFloor;
    }

    public String getDormFloor() 
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
    public void setJobnumber(String jobnumber) 
    {
        this.jobnumber = jobnumber;
    }

    public String getJobnumber() 
    {
        return jobnumber;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDays(Long days) 
    {
        this.days = days;
    }

    public Long getDays() 
    {
        return days;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setHotwaterFee(BigDecimal hotwaterFee) 
    {
        this.hotwaterFee = hotwaterFee;
    }

    public BigDecimal getHotwaterFee() 
    {
        return hotwaterFee;
    }
    public void setCoolwaterFee(BigDecimal coolwaterFee) 
    {
        this.coolwaterFee = coolwaterFee;
    }

    public BigDecimal getCoolwaterFee() 
    {
        return coolwaterFee;
    }
    public void setElectricityFee(BigDecimal electricityFee) 
    {
        this.electricityFee = electricityFee;
    }

    public BigDecimal getElectricityFee() 
    {
        return electricityFee;
    }
    public void setPublicElectricity(BigDecimal publicElectricity) 
    {
        this.publicElectricity = publicElectricity;
    }

    public BigDecimal getPublicElectricity() 
    {
        return publicElectricity;
    }
    public void setPublicHotwater(BigDecimal publicHotwater) 
    {
        this.publicHotwater = publicHotwater;
    }

    public BigDecimal getPublicHotwater() 
    {
        return publicHotwater;
    }
    public void setPublicCoolwater(BigDecimal publicCoolwater) 
    {
        this.publicCoolwater = publicCoolwater;
    }

    public BigDecimal getPublicCoolwater() 
    {
        return publicCoolwater;
    }
    public void setFeetotal(BigDecimal feetotal)
    {
        this.feetotal = feetotal;
    }

    public BigDecimal getFeetotal()
    {
        return feetotal;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("feepersonId", getFeepersonId())
                .append("nian", getNian())
                .append("yue", getYue())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("jobnumber", getJobnumber())
            .append("name", getName())
            .append("days", getDays())
            .append("status", getStatus())
            .append("hotwaterFee", getHotwaterFee())
            .append("coolwaterFee", getCoolwaterFee())
            .append("electricityFee", getElectricityFee())
            .append("publicElectricity", getPublicElectricity())
            .append("publicHotwater", getPublicHotwater())
            .append("publicCoolwater", getPublicCoolwater())
                .append("feetotal", getFeetotal())
            .toString();
    }
}
