package com.ruoyi.wardrobe.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 柜子信息对象 dorm_wardrobe
 * 
 * @author qqq
 * @date 2022-05-03
 */
public class DormWardrobe extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

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

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 工号 */
    @Excel(name = "工号")
    private String jobnumber;

    /** 柜子号 */
    @Excel(name = "柜子号")
    private String wardrobe;

    /** 柜子状态 */
    @Excel(name = "柜子状态")
    private Long wardrobestatus;

    /** 柜子是否有人使用 */
    @Excel(name = "柜子是否有人使用")
    private Long whether;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setJobnumber(String jobnumber) 
    {
        this.jobnumber = jobnumber;
    }

    public String getJobnumber() 
    {
        return jobnumber;
    }
    public void setWardrobe(String wardrobe) 
    {
        this.wardrobe = wardrobe;
    }

    public String getWardrobe() 
    {
        return wardrobe;
    }
    public void setWardrobestatus(Long wardrobestatus) 
    {
        this.wardrobestatus = wardrobestatus;
    }

    public Long getWardrobestatus() 
    {
        return wardrobestatus;
    }
    public void setWhether(Long whether) 
    {
        this.whether = whether;
    }

    public Long getWhether() 
    {
        return whether;
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
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("name", getName())
            .append("jobnumber", getJobnumber())
            .append("wardrobe", getWardrobe())
            .append("wardrobestatus", getWardrobestatus())
            .append("whether", getWhether())
            .append("remarks", getRemarks())
            .toString();
    }
}
