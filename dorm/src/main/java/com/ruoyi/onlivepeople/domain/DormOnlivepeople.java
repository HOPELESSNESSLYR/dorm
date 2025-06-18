package com.ruoyi.onlivepeople.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 登记入住人员对象 dorm_onlivepeople
 *
 * @author qqq
 * @date 2022-04-14
 */
public class DormOnlivepeople extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 民族 */
    @Excel(name = "民族")
    private String native1;

    /** 出生日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 居住地址 */
    @Excel(name = "居住地址")
    private String address;

    /** 公民身份证号 */
    @Excel(name = "公民身份证号")
    private String idnumber;

    /** 签发机关 */
    @Excel(name = "签发机关")
    private String company;

    /** 有效起始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效起始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date begindate;

    /** 有效截止日期 */
    @Excel(name = "有效截止日期")
    private String enddate;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phone;

    /** 创建录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建录入时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    /** 是否入住标识 0未入住 1已入住 */
    @Excel(name = "是否入住标识 0未入住 1已入住")
    private String flag;

    /** 远程地址 */
    @Excel(name = "远程地址")
    private String remotepath;


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
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setNative1(String native1)
    {
        this.native1 = native1;
    }

    public String getNative1()
    {
        return native1;
    }
    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Date getBirthday()
    {
        return birthday;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setIdnumber(String idnumber)
    {
        this.idnumber = idnumber;
    }

    public String getIdnumber()
    {
        return idnumber;
    }
    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getCompany()
    {
        return company;
    }
    public void setBegindate(Date begindate)
    {
        this.begindate = begindate;
    }

    public Date getBegindate()
    {
        return begindate;
    }
    public void setEnddate(String enddate)
    {
        this.enddate = enddate;
    }

    public String getEnddate()
    {
        return enddate;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }
    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public String getFlag()
    {
        return flag;
    }
    public void setRemotepath(String remotepath)
    {
        this.remotepath = remotepath;
    }

    public String getRemotepath()
    {
        return remotepath;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("sex", getSex())
                .append("native1", getNative1())
                .append("birthday", getBirthday())
                .append("address", getAddress())
                .append("idnumber", getIdnumber())
                .append("company", getCompany())
                .append("begindate", getBegindate())
                .append("enddate", getEnddate())
                .append("phone", getPhone())
                .append("createdAt", getCreatedAt())
                .append("flag", getFlag())
                .append("remotepath", getRemotepath())
                .toString();
    }
}