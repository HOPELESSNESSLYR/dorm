package com.ruoyi.tune.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 入住调宿退宿申请对象 dorm_stay_retreat_tune
 * 
 * @author qqq
 * @date 2022-04-14
 */
public class DormStayRetreatTune extends BaseEntity
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

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnumber;

    /** 工号 */
    @Excel(name = "工号")
    private String jobnumber;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

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

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String location;

    /** 户籍地址 */
    @Excel(name = "户籍地址")
    private String address;

    /** 类别0:退宿:1:入住2:调宿 */
    @Excel(name = "类别0:退宿:1:入住2:调宿")
    private Long type;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyDate;

    /** 床位号 */
    @Excel(name = "床位号")
    private String bednumber;

    /** 柜子号 */
    @Excel(name = "柜子号")
    private Long wardrobe;

    /** 申请原因 */
    @Excel(name = "申请原因")
    private String reason;

    /** 入住日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date livedate;

    /** 退宿日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退宿日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date retreatdate;

    /** 退宿类型 */
    @Excel(name = "退宿类型")
    private Long retreattype;

    /** 紧急联系人 */
    @Excel(name = "紧急联系人")
    private String emergencycontact;

    /** 与紧急联系人关系 */
    @Excel(name = "与紧急联系人关系")
    private String relationship;

    /** 紧急联系人联系方式 */
    @Excel(name = "紧急联系人联系方式")
    private String emergencyphone;

    /** 变更房号 */
    @Excel(name = "变更房号")
    private String changenumber;

    /** 变更床位 */
    @Excel(name = "变更床位")
    private String changebed;

    /** 变更日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "变更日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date changedate;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 总务专员 */
    @Excel(name = "总务专员")
    private String generalCommissioner;

    /** 宿管员 */
    @Excel(name = "宿管员")
    private String adminname;

    /** 申请人 */
    @Excel(name = "申请人")
    private String applyname;

    /** 是否更新 */
    @Excel(name = "是否更新")
    private String hcmupdate;

    /** 入住天数 */
    @Excel(name = "入住天数")
    private Long liveddays;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date enddate;

    /** 请假天数 */
    @Excel(name = "请假天数")
    private String leaveoffday;
    /** 当月入住天数 */
    @Excel(name = "当月入住天数")
    private Long currentMonthLiveDays;
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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setApplyDate(Date applyDate) 
    {
        this.applyDate = applyDate;
    }

    public Date getApplyDate() 
    {
        return applyDate;
    }
    public void setBednumber(String bednumber) 
    {
        this.bednumber = bednumber;
    }

    public String getBednumber() 
    {
        return bednumber;
    }
    public void setWardrobe(Long wardrobe) 
    {
        this.wardrobe = wardrobe;
    }

    public Long getWardrobe() 
    {
        return wardrobe;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setLivedate(Date livedate) 
    {
        this.livedate = livedate;
    }

    public Date getLivedate() 
    {
        return livedate;
    }
    public void setRetreatdate(Date retreatdate) 
    {
        this.retreatdate = retreatdate;
    }

    public Date getRetreatdate() 
    {
        return retreatdate;
    }
    public void setRetreattype(Long retreattype) 
    {
        this.retreattype = retreattype;
    }

    public Long getRetreattype() 
    {
        return retreattype;
    }
    public void setEmergencycontact(String emergencycontact) 
    {
        this.emergencycontact = emergencycontact;
    }

    public String getEmergencycontact() 
    {
        return emergencycontact;
    }
    public void setRelationship(String relationship) 
    {
        this.relationship = relationship;
    }

    public String getRelationship() 
    {
        return relationship;
    }
    public void setEmergencyphone(String emergencyphone) 
    {
        this.emergencyphone = emergencyphone;
    }

    public String getEmergencyphone() 
    {
        return emergencyphone;
    }
    public void setChangenumber(String changenumber) 
    {
        this.changenumber = changenumber;
    }

    public String getChangenumber() 
    {
        return changenumber;
    }
    public void setChangebed(String changebed) 
    {
        this.changebed = changebed;
    }

    public String getChangebed() 
    {
        return changebed;
    }
    public void setChangedate(Date changedate) 
    {
        this.changedate = changedate;
    }

    public Date getChangedate() 
    {
        return changedate;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setGeneralCommissioner(String generalCommissioner) 
    {
        this.generalCommissioner = generalCommissioner;
    }

    public String getGeneralCommissioner() 
    {
        return generalCommissioner;
    }
    public void setAdminname(String adminname) 
    {
        this.adminname = adminname;
    }

    public String getAdminname() 
    {
        return adminname;
    }
    public void setApplyname(String applyname) 
    {
        this.applyname = applyname;
    }

    public String getApplyname() 
    {
        return applyname;
    }
    public void setHcmupdate(String hcmupdate) 
    {
        this.hcmupdate = hcmupdate;
    }

    public String getHcmupdate() 
    {
        return hcmupdate;
    }
    public void setLiveddays(Long liveddays)
    {
        this.liveddays = liveddays;
    }

    public Long getLiveddays()
    {
        return liveddays;
    }
    public void setEnddate(Date enddate)
    {
        this.enddate = enddate;
    }

    public Date getEnddate()
    {
        return enddate;
    }
    public void setLeaveoffday(String leaveoffday)
    {
        this.leaveoffday = leaveoffday;
    }

    public String getLeaveoffday()
    {
        return leaveoffday;
    }

    public Long getCurrentMonthLiveDays() {
        return currentMonthLiveDays;
    }

    public void setCurrentMonthLiveDays(Long currentMonthLiveDays) {
        this.currentMonthLiveDays = currentMonthLiveDays;
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
            .append("jobnumber", getJobnumber())
            .append("name", getName())
            .append("department1", getDepartment1())
            .append("department2", getDepartment2())
            .append("department3", getDepartment3())
            .append("job", getJob())
            .append("sex", getSex())
            .append("phone", getPhone())
            .append("location", getLocation())
            .append("address", getAddress())
            .append("type", getType())
            .append("applyDate", getApplyDate())
            .append("bednumber", getBednumber())
            .append("wardrobe", getWardrobe())
            .append("reason", getReason())
            .append("livedate", getLivedate())
            .append("retreatdate", getRetreatdate())
            .append("retreattype", getRetreattype())
            .append("emergencycontact", getEmergencycontact())
            .append("relationship", getRelationship())
            .append("emergencyphone", getEmergencyphone())
            .append("changenumber", getChangenumber())
            .append("changebed", getChangebed())
            .append("changedate", getChangedate())
            .append("remarks", getRemarks())
            .append("generalCommissioner", getGeneralCommissioner())
            .append("adminname", getAdminname())
            .append("applyname", getApplyname())
            .append("hcmupdate", getHcmupdate())
            .append("liveddays", getLiveddays())
            .append("enddate", getEnddate())
            .append("leaveoffday", getLeaveoffday())
                .append("currentMonthLiveDays", getCurrentMonthLiveDays())
            .toString();
    }
}
