package com.ruoyi.article.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 个人物品对象 dorm_article
 * 
 * @author qqq
 * @date 2022-04-28
 */
public class DormArticle extends BaseEntity
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

    /** 宿舍房间号 */
    @Excel(name = "宿舍房间号")
    private String roomNumber;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 工号 */
    @Excel(name = "工号")
    private String jobnumber;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idnnumber;

    /** 床位号 */
    @Excel(name = "床位号")
    private Long bednumber;

    /** 领用物品编码 */
    @Excel(name = "领用物品编码")
    private String articleNumber;

    /** 领用物品描述 */
    @Excel(name = "领用物品描述")
    private String articleDescription;

    /** 领用物品数量 */
    @Excel(name = "领用物品数量")
    private Long requstQuantity;

    /** 退还物品编码 */
    @Excel(name = "退还物品编码")
    private String returnNumber;

    /** 退还物品描述 */
    @Excel(name = "退还物品描述")
    private String returnDescription;

    /** 退还物品数量 */
    @Excel(name = "退还物品数量")
    private Long returnQuantity;

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
    public void setIdnnumber(String idnnumber) 
    {
        this.idnnumber = idnnumber;
    }

    public String getIdnnumber() 
    {
        return idnnumber;
    }
    public void setBednumber(Long bednumber) 
    {
        this.bednumber = bednumber;
    }

    public Long getBednumber() 
    {
        return bednumber;
    }
    public void setArticleNumber(String articleNumber) 
    {
        this.articleNumber = articleNumber;
    }

    public String getArticleNumber() 
    {
        return articleNumber;
    }
    public void setArticleDescription(String articleDescription) 
    {
        this.articleDescription = articleDescription;
    }

    public String getArticleDescription() 
    {
        return articleDescription;
    }
    public void setReturnNumber(String returnNumber) 
    {
        this.returnNumber = returnNumber;
    }

    public void setRequstQuantity(Long requstQuantity)
    {
        this.requstQuantity = requstQuantity;
    }

    public Long getRequstQuantity()
    {
        return requstQuantity;
    }

    public String getReturnNumber() 
    {
        return returnNumber;
    }
    public void setReturnDescription(String returnDescription) 
    {
        this.returnDescription = returnDescription;
    }

    public String getReturnDescription() 
    {
        return returnDescription;
    }

    public void setReturnQuantity(Long returnQuantity)
    {
        this.returnQuantity = returnQuantity;
    }

    public Long getReturnQuantity()
    {
        return returnQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaNumber", getAreaNumber())
            .append("floorNumber", getFloorNumber())
            .append("roomNumber", getRoomNumber())
            .append("name", getName())
            .append("jobnumber", getJobnumber())
            .append("idnnumber", getIdnnumber())
            .append("bednumber", getBednumber())
            .append("articleNumber", getArticleNumber())
                .append("requstQuantity", getRequstQuantity())
            .append("articleDescription", getArticleDescription())
            .append("returnNumber", getReturnNumber())
            .append("returnDescription", getReturnDescription())
                .append("returnQuantity", getReturnQuantity())
            .toString();
    }
}
