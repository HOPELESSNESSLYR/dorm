package com.ruoyi.livepeople.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员信息对象 dorm_livepeople
 * 
 * @author qqq
 * @date 2022-04-14
 */
public class DormLivepeople extends BaseEntity
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

    /** 入住位置 */
    @Excel(name = "入住位置")
    private String checkInaddress;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnumber;

    /** 工号 */
    @Excel(name = "工号")
    private String jobnumber;

    /** 雇佣状态 */
    @Excel(name = "雇佣状态")
    private String guyongstatus;

    /** 离职日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date outjobdate;

    /** 离职原因 */
    @Excel(name = "离职原因")
    private String retreatreason;


    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

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

    /** 籍贯 */
    @Excel(name = "籍贯")
    private String location;

    /** 户籍地址 */
    @Excel(name = "户籍地址")
    private String address;

    /** 职级 */
    @Excel(name = "职级")
    private String level;

    /** 班次 */
    @Excel(name = "班次")
    private String classes;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 紧急联系人 */
    @Excel(name = "紧急联系人")
    private String emergencycontact;

    /** 与紧急联系人关系 */
    @Excel(name = "与紧急联系人关系")
    private String relationship;

    /** 紧急联系人联系方式 */
    @Excel(name = "紧急联系人联系方式")
    private String emergencyphone;

    /** 原因 */
    @Excel(name = "原因")
    private String reason;

    /** 是否已入住 */
    @Excel(name = "是否已入住")
    private String livecheck;

    /** 入住日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入住日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date livedate;

    /** 是否已退宿 */
    @Excel(name = "是否已退宿")
    private String quitcheck;

    /** 退宿类型 */
    @Excel(name = "退宿类型")
    private String retreattype;

    /** 退宿日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退宿日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date retreatdate;

    /** 是否调宿 */
    @Excel(name = "是否调宿")
    private String tuneIncheck;

    /** 调宿日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "调宿日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tuneIndate;

    /** 是否重复入住 */
    @Excel(name = "是否重复入住")
    private String repetitioncheck;

    /** 是否入黑名单 */
    @Excel(name = "是否入黑名单")
    private Integer blacklistcheck;

    /** 床位号 */
    @Excel(name = "床位号")
    private String bednumber;

    /** 柜子号 */
    @Excel(name = "柜子号")
    private String wardrobe;

    /** 是否免水电 */
    @Excel(name = "是否免水电")
    private Integer freecheck;

    /** 免水电天数 */
    @Excel(name = "免水电天数")
    private Long freedays;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 住宿费用 */
    @Excel(name = "住宿费用")
    private BigDecimal cost;

    /** 是否临时 */
    @Excel(name = "是否临时")
    private Long temporary;

    /** 领用物品 */
    @Excel(name = "领用物品")
    private String usearticle;

    /** 人员照片 */
    @Excel(name = "人员照片")
    private String photo;

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
    public void setCheckInaddress(String checkInaddress) 
    {
        this.checkInaddress = checkInaddress;
    }

    public String getCheckInaddress() 
    {
        return checkInaddress;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
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
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setClasses(String classes) 
    {
        this.classes = classes;
    }

    public String getClasses() 
    {
        return classes;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
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
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setLivecheck(String livecheck) 
    {
        this.livecheck = livecheck;
    }

    public String getLivecheck() 
    {
        return livecheck;
    }
    public void setLivedate(Date livedate) 
    {
        this.livedate = livedate;
    }

    public Date getLivedate() 
    {
        return livedate;
    }
    public void setQuitcheck(String quitcheck) 
    {
        this.quitcheck = quitcheck;
    }

    public String getQuitcheck() 
    {
        return quitcheck;
    }
    public void setRetreattype(String retreattype) 
    {
        this.retreattype = retreattype;
    }

    public String getRetreattype() 
    {
        return retreattype;
    }
    public void setRetreatdate(Date retreatdate) 
    {
        this.retreatdate = retreatdate;
    }

    public Date getRetreatdate() 
    {
        return retreatdate;
    }
    public void setTuneIncheck(String tuneIncheck) 
    {
        this.tuneIncheck = tuneIncheck;
    }

    public String getTuneIncheck() 
    {
        return tuneIncheck;
    }
    public void setTuneIndate(Date tuneIndate) 
    {
        this.tuneIndate = tuneIndate;
    }

    public Date getTuneIndate() 
    {
        return tuneIndate;
    }
    public void setRepetitioncheck(String repetitioncheck) 
    {
        this.repetitioncheck = repetitioncheck;
    }

    public String getRepetitioncheck() 
    {
        return repetitioncheck;
    }
    public void setBlacklistcheck(Integer blacklistcheck) 
    {
        this.blacklistcheck = blacklistcheck;
    }

    public Integer getBlacklistcheck() 
    {
        return blacklistcheck;
    }
    public void setBednumber(String bednumber) 
    {
        this.bednumber = bednumber;
    }

    public String getBednumber() 
    {
        return bednumber;
    }
    public void setWardrobe(String wardrobe) 
    {
        this.wardrobe = wardrobe;
    }

    public String getWardrobe() 
    {
        return wardrobe;
    }
    public void setFreecheck(Integer freecheck) 
    {
        this.freecheck = freecheck;
    }

    public Integer getFreecheck() 
    {
        return freecheck;
    }
    public void setFreedays(Long freedays) 
    {
        this.freedays = freedays;
    }

    public Long getFreedays() 
    {
        return freedays;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setCost(BigDecimal cost) 
    {
        this.cost = cost;
    }

    public BigDecimal getCost() 
    {
        return cost;
    }
    public void setTemporary(Long temporary) 
    {
        this.temporary = temporary;
    }

    public Long getTemporary() 
    {
        return temporary;
    }
    public void setUsearticle(String usearticle) 
    {
        this.usearticle = usearticle;
    }

    public String getUsearticle() 
    {
        return usearticle;
    }

    public String getGuyongstatus() {
        return guyongstatus;
    }

    public void setGuyongstatus(String guyongstatus) {
        this.guyongstatus = guyongstatus;
    }

    public Date getOutjobdate() {
        return outjobdate;
    }

    public void setOutjobdate(Date outjobdate) {
        this.outjobdate = outjobdate;
    }

    public String getRetreatreason() {
        return retreatreason;
    }

    public void setRetreatreason(String retreatreason) {
        this.retreatreason = retreatreason;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("checkInaddress", getCheckInaddress())
            .append("name", getName())
            .append("idnumber", getIdnumber())
            .append("jobnumber", getJobnumber())
            .append("sex", getSex())
            .append("department1", getDepartment1())
            .append("department2", getDepartment2())
            .append("department3", getDepartment3())
            .append("job", getJob())
            .append("location", getLocation())
            .append("address", getAddress())
            .append("level", getLevel())
            .append("classes", getClasses())
            .append("phone", getPhone())
            .append("emergencycontact", getEmergencycontact())
            .append("relationship", getRelationship())
            .append("emergencyphone", getEmergencyphone())
            .append("reason", getReason())
            .append("livecheck", getLivecheck())
            .append("livedate", getLivedate())
            .append("quitcheck", getQuitcheck())
            .append("retreattype", getRetreattype())
            .append("retreatdate", getRetreatdate())
            .append("tuneIncheck", getTuneIncheck())
            .append("tuneIndate", getTuneIndate())
            .append("repetitioncheck", getRepetitioncheck())
            .append("blacklistcheck", getBlacklistcheck())
            .append("bednumber", getBednumber())
            .append("wardrobe", getWardrobe())
            .append("freecheck", getFreecheck())
            .append("freedays", getFreedays())
            .append("remarks", getRemarks())
            .append("cost", getCost())
            .append("temporary", getTemporary())
            .append("usearticle", getUsearticle())
                .append("guyongstatus", getGuyongstatus())
                .append("outjobdate", getOutjobdate())
                .append("retreatreason", getRetreatreason())
                .append("photo", getPhoto())
            .toString();
    }
}
