package com.ruoyi.kanban.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * kb对象 kanban
 * 
 * @author yara
 * @date 2025-11-18
 */
public class KanBan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 看板id */
    private Long kbid;

    /** 新入住人数 */
    @Excel(name = "新入住人数")
    private Long checkin;

    /** 退宿人数 */
    @Excel(name = "退宿人数")
    private Long checkout;

    /** 调宿人数 */
    @Excel(name = "调宿人数")
    private Long changed;

    public void setKbid(Long kbid) 
    {
        this.kbid = kbid;
    }

    public Long getKbid() 
    {
        return kbid;
    }
    public void setCheckin(Long checkin) 
    {
        this.checkin = checkin;
    }

    public Long getCheckin() 
    {
        return checkin;
    }
    public void setCheckout(Long checkout) 
    {
        this.checkout = checkout;
    }

    public Long getCheckout() 
    {
        return checkout;
    }
    public void setChanged(Long changed)
    {
        this.changed = changed;
    }

    public Long getChanged()
    {
        return changed;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("kbid", getKbid())
            .append("checkin", getCheckin())
            .append("checkout", getCheckout())
            .append("changed", getChanged())
            .toString();
    }
}
