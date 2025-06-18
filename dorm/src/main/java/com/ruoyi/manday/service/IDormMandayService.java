package com.ruoyi.manday.service;

import java.util.List;

import com.ruoyi.livepeople.domain.DormLivepeople;
import com.ruoyi.manday.domain.DormManday;

/**
 * 每月入住天数临时Service接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface IDormMandayService 
{
    /**
     * 查询每月入住天数临时
     * 
     * @param id 每月入住天数临时主键
     * @return 每月入住天数临时
     */
    public DormManday selectDormMandayById(Long id);

    /**
     * 查询每月入住天数临时列表
     * 
     * @param dormManday 每月入住天数临时
     * @return 每月入住天数临时集合
     */
    public List<DormManday> selectDormMandayList(DormManday dormManday);

    /**
     * 新增每月入住天数临时
     * 
     * @param dormManday 每月入住天数临时
     * @return 结果
     */
    public int insertDormManday(DormManday dormManday);

    /**
     * 修改每月入住天数临时
     * 
     * @param dormManday 每月入住天数临时
     * @return 结果
     */
    public int updateDormManday(DormManday dormManday);

    /**
     * 批量删除每月入住天数临时
     * 
     * @param ids 需要删除的每月入住天数临时主键集合
     * @return 结果
     */
    public int deleteDormMandayByIds(Long[] ids);

    /**
     * 删除每月入住天数临时信息
     * 
     * @param id 每月入住天数临时主键
     * @return 结果
     */
    public int deleteDormMandayById(Long id);

    /**
     * 导入每月入住天数数据
     *
     * @param dormMandayList 每月入住天数数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormManday(List<DormManday> dormMandayList, Boolean isUpdateSupport, String operName);
}
