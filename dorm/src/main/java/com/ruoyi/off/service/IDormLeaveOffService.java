package com.ruoyi.off.service;

import java.util.List;

import com.ruoyi.livepeople.domain.DormLivepeople;
import com.ruoyi.off.domain.DormLeaveOff;

/**
 * 免扣销假记录Service接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface IDormLeaveOffService 
{
    /**
     * 查询免扣销假记录
     * 
     * @param id 免扣销假记录主键
     * @return 免扣销假记录
     */
    public DormLeaveOff selectDormLeaveOffById(Long id);

    /**
     * 查询免扣销假记录列表
     * 
     * @param dormLeaveOff 免扣销假记录
     * @return 免扣销假记录集合
     */
    public List<DormLeaveOff> selectDormLeaveOffList(DormLeaveOff dormLeaveOff);

    /**
     * 新增免扣销假记录
     * 
     * @param dormLeaveOff 免扣销假记录
     * @return 结果
     */
    public int insertDormLeaveOff(DormLeaveOff dormLeaveOff);

    /**
     * 修改免扣销假记录
     * 
     * @param dormLeaveOff 免扣销假记录
     * @return 结果
     */
    public int updateDormLeaveOff(DormLeaveOff dormLeaveOff);

    /**
     * 批量删除免扣销假记录
     * 
     * @param ids 需要删除的免扣销假记录主键集合
     * @return 结果
     */
    public int deleteDormLeaveOffByIds(Long[] ids);

    /**
     * 删除免扣销假记录信息
     * 
     * @param id 免扣销假记录主键
     * @return 结果
     */
    public int deleteDormLeaveOffById(Long id);

    /**
     * 导入免扣销假信息数据
     *
     * @param dormLeaveOffList 免扣销假信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormLeaveOff(List<DormLeaveOff> dormLeaveOffList, Boolean isUpdateSupport, String operName);

    public Long selectSumOffdaysByIDnumber(String jobnumber);
}
