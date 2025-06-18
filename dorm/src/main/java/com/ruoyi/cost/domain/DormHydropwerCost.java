package com.ruoyi.cost.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人费用明细对象 dorm_hydropwer_cost
 * 
 * @author qqq
 * @date 2022-05-03
 */
public class DormHydropwerCost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date costDate;

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

    /** 工号 */
    @Excel(name = "工号")
    private String jobnumber;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnumber;

    /** 本月人天数 */
    @Excel(name = "本月人天数")
    private Long monthDayall;

    /** 个人热水费 */
    @Excel(name = "个人热水费")
    private BigDecimal personHotwater;

    /** 个人冷水费 */
    @Excel(name = "个人冷水费")
    private BigDecimal personColdwater;

    /** 个人电费 */
    @Excel(name = "个人电费")
    private BigDecimal personElectric;

    /** 公共热水费 */
    @Excel(name = "公共热水费")
    private BigDecimal publicHotwater;

    /** 公共冷水费 */
    @Excel(name = "公共冷水费")
    private BigDecimal publicColdwater;

    /** 公共电费 */
    @Excel(name = "公共电费")
    private BigDecimal publicElectric;

    /** 总费用 */
    @Excel(name = "总费用")
    private BigDecimal costall;

    /** 类别 */
    @Excel(name = "类别")
    private Long type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCostDate(Date costDate) 
    {
        this.costDate = costDate;
    }

    public Date getCostDate() 
    {
        return costDate;
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
    public void setJobnumber(String jobnumber) 
    {
        this.jobnumber = jobnumber;
    }

    public String getJobnumber() 
    {
        return jobnumber;
    }
    public void setIdnumber(String idnumber) 
    {
        this.idnumber = idnumber;
    }

    public String getIdnumber() 
    {
        return idnumber;
    }
    public void setMonthDayall(Long monthDayall) 
    {
        this.monthDayall = monthDayall;
    }

    public Long getMonthDayall() 
    {
        return monthDayall;
    }
    public void setPersonHotwater(BigDecimal personHotwater) 
    {
        this.personHotwater = personHotwater;
    }

    public BigDecimal getPersonHotwater() 
    {
        return personHotwater;
    }
    public void setPersonColdwater(BigDecimal personColdwater) 
    {
        this.personColdwater = personColdwater;
    }

    public BigDecimal getPersonColdwater() 
    {
        return personColdwater;
    }
    public void setPersonElectric(BigDecimal personElectric) 
    {
        this.personElectric = personElectric;
    }

    public BigDecimal getPersonElectric() 
    {
        return personElectric;
    }
    public void setPublicHotwater(BigDecimal publicHotwater) 
    {
        this.publicHotwater = publicHotwater;
    }

    public BigDecimal getPublicHotwater() 
    {
        return publicHotwater;
    }
    public void setPublicColdwater(BigDecimal publicColdwater) 
    {
        this.publicColdwater = publicColdwater;
    }

    public BigDecimal getPublicColdwater() 
    {
        return publicColdwater;
    }
    public void setPublicElectric(BigDecimal publicElectric) 
    {
        this.publicElectric = publicElectric;
    }

    public BigDecimal getPublicElectric() 
    {
        return publicElectric;
    }
    public void setCostall(BigDecimal costall) 
    {
        this.costall = costall;
    }

    public BigDecimal getCostall() 
    {
        return costall;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("costDate", getCostDate())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("jobnumber", getJobnumber())
            .append("idnumber", getIdnumber())
            .append("monthDayall", getMonthDayall())
            .append("personHotwater", getPersonHotwater())
            .append("personColdwater", getPersonColdwater())
            .append("personElectric", getPersonElectric())
            .append("publicHotwater", getPublicHotwater())
            .append("publicColdwater", getPublicColdwater())
            .append("publicElectric", getPublicElectric())
            .append("costall", getCostall())
            .append("type", getType())
            .toString();
    }
}
