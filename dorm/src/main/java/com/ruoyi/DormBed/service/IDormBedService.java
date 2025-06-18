package com.ruoyi.DormBed.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.room.domain.DormRoominfor;

/**
 * 床位信息Service接口
 * 
 * @author qqq
 * @date 2022-04-14
 */
public interface IDormBedService 
{
    /**
     * 查询床位信息
     * 
     * @param id 床位信息主键
     * @return 床位信息
     */
    public DormBed selectDormBedById(Long id);

    /**
     * 查询空余床位信息
     *
     * @param bed MAP床位信息
     * @return 床位信息
     */
    public List<DormBed> selectkongbed(Map<String, String> bed);

    /**
     * 查询床位信息列表
     * 
     * @param dormBed 床位信息
     * @return 床位信息集合
     */
    public List<DormBed> selectDormBedList(DormBed dormBed);

    /**
     * 新增床位信息
     * 
     * @param dormBed 床位信息
     * @return 结果
     */
    public int insertDormBed(DormBed dormBed);

    /**
     * 修改床位信息
     * 
     * @param dormBed 床位信息
     * @return 结果
     */
    public int updateDormBed(DormBed dormBed);

    /**
     * 批量删除床位信息
     * 
     * @param ids 需要删除的床位信息主键集合
     * @return 结果
     */
    public int deleteDormBedByIds(Long[] ids);

    /**
     * 删除床位信息信息
     * 
     * @param id 床位信息主键
     * @return 结果
     */
    public int deleteDormBedById(Long id);

    /**
     * 导入床位信息数据
     *
     * @param dormBedList 床位信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormBedinfor(List<DormBed> dormBedList, Boolean isUpdateSupport, String operName);

    /**
     * 根据身份证号查询床位信息
     */
    public DormBed selectDormBedByIDnumber(String iDnumbwer);

    public DormBed selectDormBedByMap(Map<String, String> map);
    public List<DormBed> selectDormBedByMap2(Map<String, String> map);
    public List<DormBed> selectDormBedByIDnumber2(String IDnumber);
}
