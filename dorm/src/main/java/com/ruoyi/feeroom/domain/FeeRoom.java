package com.ruoyi.feeroom.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间费用对象 fee_room
 * 
 * @author lyr
 * @date 2025-07-01
 */
public class FeeRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房间费用ID */
    private Long roomfeeId;


    /** 年份 */
    @Excel(name = "年份")
    private String nian;

    /** 月份 */
    @Excel(name = "月份")
    private String yue;

    /** 区域编号 */
    @Excel(name = "区域编号")
    private String areaNumber;

    /** 宿舍楼编号 */
    @Excel(name = "宿舍楼编号")
    private String floorNumber;

    /** 宿舍楼名称 */
    @Excel(name = "宿舍楼名称")
    private String floorName;

    /** 宿舍楼层号 */
    @Excel(name = "宿舍楼层号")
    private String dormFloor;

    /** 宿舍房间号 */
    @Excel(name = "宿舍房间号")
    private String roomNumber;

    /** 员工宿舍/公共区域 */
    @Excel(name = "员工宿舍/公共区域")
    private String isPublicArea;

    /** 热水表号 */
    @Excel(name = "热水表号")
    private String hotwatersn;

    /** 热水上月表底 */
    @Excel(name = "热水上月表底")
    private BigDecimal hotwaterTotalLastmonth;

    /** 热水本月表底 */
    @Excel(name = "热水本月表底")
    private BigDecimal hotwaterTotal;

    /** 热水用水 */
    @Excel(name = "热水用水")
    private BigDecimal hotwater;

    /** 热水费 */
    @Excel(name = "热水费")
    private BigDecimal hotwaterFee;

    /** 冷水表号 */
    @Excel(name = "冷水表号")
    private String coolwatersn;

    /** 冷水上月表底 */
    @Excel(name = "冷水上月表底")
    private BigDecimal coolwaterTotalLastmonth;

    /** 冷水本月表底 */
    @Excel(name = "冷水本月表底")
    private BigDecimal coolwaterTotal;

    /** 冷水用水 */
    @Excel(name = "冷水用水")
    private BigDecimal coolwater;

    /** 冷水费 */
    @Excel(name = "冷水费")
    private BigDecimal coolwaterFee;

    /** 电表号 */
    @Excel(name = "电表号")
    private String electricitysn;

    /** 电表上月表底 */
    @Excel(name = "电表上月表底")
    private BigDecimal electricityTotalLastmonth;

    /** 电表本月表底 */
    @Excel(name = "电表本月表底")
    private BigDecimal electricityTotal;

    /** 电表用量 */
    @Excel(name = "电表用量")
    private BigDecimal electricity;

    /** 电费 */
    @Excel(name = "电费")
    private BigDecimal electricityFee;

    public void setRoomfeeId(Long roomfeeId) 
    {
        this.roomfeeId = roomfeeId;
    }

    public Long getRoomfeeId() 
    {
        return roomfeeId;
    }
    public void setNian(String nian)
    {
        this.nian = nian;
    }

    public String getNian()
    {
        return nian;
    }
    public void setYue(String yue)
    {
        this.yue = yue;
    }

    public String getYue()
    {
        return yue;
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
    public void setFloorName(String floorName) 
    {
        this.floorName = floorName;
    }

    public String getFloorName() 
    {
        return floorName;
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
    public void setIsPublicArea(String isPublicArea) 
    {
        this.isPublicArea = isPublicArea;
    }

    public String getIsPublicArea() 
    {
        return isPublicArea;
    }
    public void setHotwatersn(String hotwatersn) 
    {
        this.hotwatersn = hotwatersn;
    }

    public String getHotwatersn() 
    {
        return hotwatersn;
    }
    public void setHotwaterTotalLastmonth(BigDecimal hotwaterTotalLastmonth) 
    {
        this.hotwaterTotalLastmonth = hotwaterTotalLastmonth;
    }

    public BigDecimal getHotwaterTotalLastmonth() 
    {
        return hotwaterTotalLastmonth;
    }
    public void setHotwaterTotal(BigDecimal hotwaterTotal) 
    {
        this.hotwaterTotal = hotwaterTotal;
    }

    public BigDecimal getHotwaterTotal() 
    {
        return hotwaterTotal;
    }
    public void setHotwater(BigDecimal hotwater) 
    {
        this.hotwater = hotwater;
    }

    public BigDecimal getHotwater() 
    {
        return hotwater;
    }
    public void setHotwaterFee(BigDecimal hotwaterFee) 
    {
        this.hotwaterFee = hotwaterFee;
    }

    public BigDecimal getHotwaterFee() 
    {
        return hotwaterFee;
    }
    public void setCoolwatersn(String coolwatersn) 
    {
        this.coolwatersn = coolwatersn;
    }

    public String getCoolwatersn() 
    {
        return coolwatersn;
    }
    public void setCoolwaterTotalLastmonth(BigDecimal coolwaterTotalLastmonth) 
    {
        this.coolwaterTotalLastmonth = coolwaterTotalLastmonth;
    }

    public BigDecimal getCoolwaterTotalLastmonth() 
    {
        return coolwaterTotalLastmonth;
    }
    public void setCoolwaterTotal(BigDecimal coolwaterTotal) 
    {
        this.coolwaterTotal = coolwaterTotal;
    }

    public BigDecimal getCoolwaterTotal() 
    {
        return coolwaterTotal;
    }
    public void setCoolwater(BigDecimal coolwater) 
    {
        this.coolwater = coolwater;
    }

    public BigDecimal getCoolwater() 
    {
        return coolwater;
    }
    public void setCoolwaterFee(BigDecimal coolwaterFee) 
    {
        this.coolwaterFee = coolwaterFee;
    }

    public BigDecimal getCoolwaterFee() 
    {
        return coolwaterFee;
    }
    public void setElectricitysn(String electricitysn) 
    {
        this.electricitysn = electricitysn;
    }

    public String getElectricitysn() 
    {
        return electricitysn;
    }
    public void setElectricityTotalLastmonth(BigDecimal electricityTotalLastmonth) 
    {
        this.electricityTotalLastmonth = electricityTotalLastmonth;
    }

    public BigDecimal getElectricityTotalLastmonth() 
    {
        return electricityTotalLastmonth;
    }
    public void setElectricityTotal(BigDecimal electricityTotal) 
    {
        this.electricityTotal = electricityTotal;
    }

    public BigDecimal getElectricityTotal() 
    {
        return electricityTotal;
    }
    public void setElectricity(BigDecimal electricity) 
    {
        this.electricity = electricity;
    }

    public BigDecimal getElectricity() 
    {
        return electricity;
    }
    public void setElectricityFee(BigDecimal electricityFee) 
    {
        this.electricityFee = electricityFee;
    }

    public BigDecimal getElectricityFee() 
    {
        return electricityFee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roomfeeId", getRoomfeeId())
                .append("nian", getNian())
                .append("yue", getYue())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("floorName", getFloorName())
            .append("dormFloor", getDormFloor())
            .append("roomNumber", getRoomNumber())
            .append("isPublicArea", getIsPublicArea())
            .append("hotwatersn", getHotwatersn())
            .append("hotwaterTotalLastmonth", getHotwaterTotalLastmonth())
            .append("hotwaterTotal", getHotwaterTotal())
            .append("hotwater", getHotwater())
            .append("hotwaterFee", getHotwaterFee())
            .append("coolwatersn", getCoolwatersn())
            .append("coolwaterTotalLastmonth", getCoolwaterTotalLastmonth())
            .append("coolwaterTotal", getCoolwaterTotal())
            .append("coolwater", getCoolwater())
            .append("coolwaterFee", getCoolwaterFee())
            .append("electricitysn", getElectricitysn())
            .append("electricityTotalLastmonth", getElectricityTotalLastmonth())
            .append("electricityTotal", getElectricityTotal())
            .append("electricity", getElectricity())
            .append("electricityFee", getElectricityFee())
            .toString();
    }
}
