package com.ruoyi.off.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 免扣销假记录对象 dorm_leave_off
 * 
 * @author qqq
 * @date 2022-05-03
 */
public class DormLeaveOff extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 申请人 */
    @Excel(name = "申请人")
    private String name;

    /** 工号 */
    @Excel(name = "工号")
    private String jobnumber;

    /** 部门 */
    @Excel(name = "部门")
    private String department;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String areaNumber;

    /** 宿舍楼编号 */
    @Excel(name = "宿舍楼编号")
    private String floorNumber;

    /** 宿舍房间号 */
    @Excel(name = "宿舍房间号")
    private String roomNumber;

    /** 申请日期开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyBegindate;

    /** 申请日期结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyEnddate;

    /** 申请天数 */
    @Excel(name = "申请天数")
    private Long applyDays;

    /** 申请类别 */
    @Excel(name = "申请类别")
    private Long applyType;

    /** 原因说明 */
    @Excel(name = "原因说明")
    private String reason;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
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
    public void setRoomNumber(String roomNumber) 
    {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() 
    {
        return roomNumber;
    }
    public void setApplyBegindate(Date applyBegindate) 
    {
        this.applyBegindate = applyBegindate;
    }

    public Date getApplyBegindate() 
    {
        return applyBegindate;
    }
    public void setApplyEnddate(Date applyEnddate) 
    {
        this.applyEnddate = applyEnddate;
    }

    public Date getApplyEnddate() 
    {
        return applyEnddate;
    }
    public void setApplyDays(Long applyDays) 
    {
        this.applyDays = applyDays;
    }

    public Long getApplyDays() 
    {
        return applyDays;
    }
    public void setApplyType(Long applyType) 
    {
        this.applyType = applyType;
    }

    public Long getApplyType() 
    {
        return applyType;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("jobnumber", getJobnumber())
            .append("department", getDepartment())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("roomNumber", getRoomNumber())
            .append("applyBegindate", getApplyBegindate())
            .append("applyEnddate", getApplyEnddate())
            .append("applyDays", getApplyDays())
            .append("applyType", getApplyType())
            .append("reason", getReason())
            .append("remark", getRemark())
            .toString();
    }
}
