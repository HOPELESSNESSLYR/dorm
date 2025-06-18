package com.ruoyi.off.mapper;

import java.util.List;
import com.ruoyi.off.domain.DormLeaveOff;

/**
 * 免扣销假记录Mapper接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface DormLeaveOffMapper 
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
     * 删除免扣销假记录
     * 
     * @param id 免扣销假记录主键
     * @return 结果
     */
    public int deleteDormLeaveOffById(Long id);

    /**
     * 批量删除免扣销假记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormLeaveOffByIds(Long[] ids);

    public Long selectSumOffdaysByIDnumber(String jobnumber);
}
