package com.ruoyi.hydropower.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间水电记录对象 dorm_room_hydropower
 * 
 * @author qqq
 * @date 2022-05-03
 */
public class DormRoomHydropower extends BaseEntity
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
    private Long dormFloor;

    /** 宿舍房间号 */
    @Excel(name = "宿舍房间号")
    private String roomNumber;

    /** 房间热水表 */
    @Excel(name = "房间热水表")
    private Long roomHotwater;

    /** 房间冷水表 */
    @Excel(name = "房间冷水表")
    private Long roomColdwater;

    /** 房间电表 */
    @Excel(name = "房间电表")
    private Long roomElectric;

    /** 房间类型 */
    @Excel(name = "房间类型")
    private Long type;

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
    public void setRoomHotwater(Long roomHotwater) 
    {
        this.roomHotwater = roomHotwater;
    }

    public Long getRoomHotwater() 
    {
        return roomHotwater;
    }
    public void setRoomColdwater(Long roomColdwater) 
    {
        this.roomColdwater = roomColdwater;
    }

    public Long getRoomColdwater() 
    {
        return roomColdwater;
    }
    public void setRoomElectric(Long roomElectric) 
    {
        this.roomElectric = roomElectric;
    }

    public Long getRoomElectric() 
    {
        return roomElectric;
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
            .append("date", getDate())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("roomHotwater", getRoomHotwater())
            .append("roomColdwater", getRoomColdwater())
            .append("roomElectric", getRoomElectric())
            .append("type", getType())
            .toString();
    }
}
