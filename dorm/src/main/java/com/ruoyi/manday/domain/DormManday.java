package com.ruoyi.manday.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 每月入住天数临时对象 dorm_manday
 * 
 * @author qqq
 * @date 2022-05-03
 */
public class DormManday extends BaseEntity
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

    /** 身份证号 */
    @Excel(name = "身份证号")
    private Long idnumber;

    /** 居住天数 */
    @Excel(name = "居住天数")
    private Long livedays;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 类别 */
    @Excel(name = "类别")
    private Long type;

    /** 工号 */
    @Excel(name = "工号")
    private String jobnumber;

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
    public void setIdnumber(Long idnumber) 
    {
        this.idnumber = idnumber;
    }

    public Long getIdnumber() 
    {
        return idnumber;
    }
    public void setLivedays(Long livedays) 
    {
        this.livedays = livedays;
    }

    public Long getLivedays() 
    {
        return livedays;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setJobnumber(String jobnumber) 
    {
        this.jobnumber = jobnumber;
    }

    public String getJobnumber() 
    {
        return jobnumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("idnumber", getIdnumber())
            .append("livedays", getLivedays())
            .append("date", getDate())
            .append("type", getType())
            .append("jobnumber", getJobnumber())
            .toString();
    }
}
