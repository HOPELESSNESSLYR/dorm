package com.ruoyi.DormBed.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 床位信息对象 dorm_bed
 * 
 * @author qqq
 * @date 2022-04-14
 */
public class DormBed extends BaseEntity
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

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnumber;

    /** 工号 */
    @Excel(name = "工号")
    private String jobnumber;

    /** 一级部门 */
    @Excel(name = "一级部门")
    private String department1;

    /** 二级部门 */
    @Excel(name = "二级部门")
    private String department2;

    /** 三级部门 */
    @Excel(name = "三级部门")
    private String department3;

    /** 岗位 */
    @Excel(name = "岗位")
    private String job;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 床位状态 1:开启 0:关闭 */
    @Excel(name = "床位状态 1:开启 0:关闭")
    private Long bedstatus;

    /** 床位是否住人 */
    @Excel(name = "床位是否住人")
    private Long checkInwhether;

    /** 床位号 */
    @Excel(name = "床位号")
    private String bednumber;

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
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setIdnumber(String idnumber) 
    {
        this.idnumber = idnumber;
    }

    public String getIdnumber() 
    {
        return idnumber;
    }
    public void setJobnumber(String jobnumber) 
    {
        this.jobnumber = jobnumber;
    }

    public String getJobnumber() 
    {
        return jobnumber;
    }
    public void setDepartment1(String department1) 
    {
        this.department1 = department1;
    }

    public String getDepartment1() 
    {
        return department1;
    }
    public void setDepartment2(String department2) 
    {
        this.department2 = department2;
    }

    public String getDepartment2() 
    {
        return department2;
    }
    public void setDepartment3(String department3) 
    {
        this.department3 = department3;
    }

    public String getDepartment3() 
    {
        return department3;
    }
    public void setJob(String job) 
    {
        this.job = job;
    }

    public String getJob() 
    {
        return job;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setBedstatus(Long bedstatus) 
    {
        this.bedstatus = bedstatus;
    }

    public Long getBedstatus() 
    {
        return bedstatus;
    }
    public void setCheckInwhether(Long checkInwhether) 
    {
        this.checkInwhether = checkInwhether;
    }

    public Long getCheckInwhether() 
    {
        return checkInwhether;
    }
    public void setBednumber(String bednumber) 
    {
        this.bednumber = bednumber;
    }

    public String getBednumber() 
    {
        return bednumber;
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
            .append("sex", getSex())
            .append("idnumber", getIdnumber())
            .append("jobnumber", getJobnumber())
            .append("department1", getDepartment1())
            .append("department2", getDepartment2())
            .append("department3", getDepartment3())
            .append("job", getJob())
            .append("phone", getPhone())
            .append("bedstatus", getBedstatus())
            .append("checkInwhether", getCheckInwhether())
            .append("bednumber", getBednumber())
            .append("remarks", getRemarks())
            .toString();
    }
}
