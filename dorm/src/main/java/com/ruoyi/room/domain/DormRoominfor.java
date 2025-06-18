package com.ruoyi.room.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间信息对象 dorm_roominfor
 * 
 * @author qqq
 * @date 2022-04-13
 */
public class DormRoominfor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String areaNumber;

    /** 区域名称 */
    @Excel(name = "区域名称")
    private String areaName;

    /** 宿舍楼编号 */
    @Excel(name = "宿舍楼编号")
    private String floorNumber;

    /** 宿舍楼名称 */
    @Excel(name = "宿舍楼名称")
    private String floorName;

    /** 宿舍楼位置 */
    @Excel(name = "宿舍楼位置")
    private String floorLocation;

    /** 宿舍楼层号 */
    @Excel(name = "宿舍楼层号")
    private Long dormFloor;

    /** 宿舍房间号 */
    @Excel(name = "宿舍房间号")
    private String roomNumber;

    /** 房间号前缀 */
    @Excel(name = "房间号前缀")
    private String roomPrefix;

    /** 男/女宿舍:男:1 女:0 */
    @Excel(name = "男/女宿舍:男:1 女:0")
    private Long roomSex;

    /** 宿舍可住人数 */
    @Excel(name = "宿舍可住人数")
    private Long livenumber;

    /** 宿舍实际人数 */
    @Excel(name = "宿舍实际人数")
    private Long peoplenumber;

    /** 宿舍剩余可住 */
    @Excel(name = "宿舍剩余可住")
    private Long remainnumber;

    /** 宿舍类型1:单人间2:双人间4:四人间6六人间8八人间 */
    @Excel(name = "宿舍类型1:单人间2:双人间4:四人间6六人间8八人间")
    private String roomType;

    /** 房间状态0:启用1:禁用 */
    @Excel(name = "房间状态0:启用1:禁用")
    private Long roomStatus;

    /** 柜子数量 */
    @Excel(name = "柜子数量")
    private Long cabinetNumber;

    /** 宿舍固定资产信息 */
    @Excel(name = "宿舍固定资产信息")
    private String roomProperty;

    /** 宿舍人员信息 */
    @Excel(name = "宿舍人员信息")
    private String roomPeople;

    /** 宿舍人员信息卡 */
    @Excel(name = "宿舍人员信息卡")
    private String roomCard;

    /** 是否临时0：临时，1：非临时 */
    @Excel(name = "是否临时0：临时，1：非临时")
    private Long temporary;

    /** 楼栋号 */
    @Excel(name = "楼栋号")
    private String cavenumber;

    /** 住宿费用 */
    @Excel(name = "住宿费用")
    private BigDecimal cost;

    /** 住宿费用承担人 1.员工 0.公司 */
    @Excel(name = "住宿费用承担人 1.员工 0.公司")
    private String costman;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
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
    public void setFloorLocation(String floorLocation) 
    {
        this.floorLocation = floorLocation;
    }

    public String getFloorLocation() 
    {
        return floorLocation;
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
    public void setRoomPrefix(String roomPrefix) 
    {
        this.roomPrefix = roomPrefix;
    }

    public String getRoomPrefix() 
    {
        return roomPrefix;
    }
    public void setRoomSex(Long roomSex) 
    {
        this.roomSex = roomSex;
    }

    public Long getRoomSex() 
    {
        return roomSex;
    }
    public void setLivenumber(Long livenumber) 
    {
        this.livenumber = livenumber;
    }

    public Long getLivenumber() 
    {
        return livenumber;
    }
    public void setPeoplenumber(Long peoplenumber) 
    {
        this.peoplenumber = peoplenumber;
    }

    public Long getPeoplenumber() 
    {
        return peoplenumber;
    }
    public void setRemainnumber(Long remainnumber) 
    {
        this.remainnumber = remainnumber;
    }

    public Long getRemainnumber() 
    {
        return remainnumber;
    }
    public void setRoomType(String roomType) 
    {
        this.roomType = roomType;
    }

    public String getRoomType() 
    {
        return roomType;
    }
    public void setRoomStatus(Long roomStatus) 
    {
        this.roomStatus = roomStatus;
    }

    public Long getRoomStatus() 
    {
        return roomStatus;
    }
    public void setCabinetNumber(Long cabinetNumber) 
    {
        this.cabinetNumber = cabinetNumber;
    }

    public Long getCabinetNumber() 
    {
        return cabinetNumber;
    }
    public void setRoomProperty(String roomProperty) 
    {
        this.roomProperty = roomProperty;
    }

    public String getRoomProperty() 
    {
        return roomProperty;
    }
    public void setRoomPeople(String roomPeople) 
    {
        this.roomPeople = roomPeople;
    }

    public String getRoomPeople() 
    {
        return roomPeople;
    }
    public void setRoomCard(String roomCard) 
    {
        this.roomCard = roomCard;
    }

    public String getRoomCard() 
    {
        return roomCard;
    }
    public void setTemporary(Long temporary) 
    {
        this.temporary = temporary;
    }

    public Long getTemporary() 
    {
        return temporary;
    }
    public void setCavenumber(String cavenumber) 
    {
        this.cavenumber = cavenumber;
    }

    public String getCavenumber() 
    {
        return cavenumber;
    }
    public void setCost(BigDecimal cost) 
    {
        this.cost = cost;
    }

    public BigDecimal getCost() 
    {
        return cost;
    }
    public void setCostman(String costman) 
    {
        this.costman = costman;
    }

    public String getCostman() 
    {
        return costman;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaNumber", getAreaNumber())
            .append("areaName", getAreaName())
            .append("floorNumber", getFloorNumber())
            .append("floorName", getFloorName())
            .append("floorLocation", getFloorLocation())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("roomPrefix", getRoomPrefix())
            .append("roomSex", getRoomSex())
            .append("livenumber", getLivenumber())
            .append("peoplenumber", getPeoplenumber())
            .append("remainnumber", getRemainnumber())
            .append("roomType", getRoomType())
            .append("roomStatus", getRoomStatus())
            .append("cabinetNumber", getCabinetNumber())
            .append("roomProperty", getRoomProperty())
            .append("roomPeople", getRoomPeople())
            .append("roomCard", getRoomCard())
            .append("temporary", getTemporary())
            .append("cavenumber", getCavenumber())
            .append("cost", getCost())
            .append("costman", getCostman())
            .toString();
    }
}
