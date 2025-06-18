package com.ruoyi.DormBed.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.DormBed.domain.DormBed;

/**
 * 床位信息Mapper接口
 * 
 * @author qqq
 * @date 2022-04-14
 */
public interface DormBedMapper 
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
     * @param bed 床位信息主键
     * @return 床位信息
     */
    public List<DormBed> selectkongbed(Map<String,String> bed);

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
     * 删除床位信息
     * 
     * @param id 床位信息主键
     * @return 结果
     */
    public int deleteDormBedById(Long id);

    /**
     * 批量删除床位信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormBedByIds(Long[] ids);

    /**
     * 根据身份证号查询床位信息
     */
    public DormBed selectDormBedByIDnumber(String iDnumbwer);

    public DormBed selectDormBedByMap(Map<String, String> map);

    public List<DormBed> selectDormBedByIDnumber2(String IDnumber);

    public List<DormBed> selectDormBedByMap2(Map<String, String> map);
}
