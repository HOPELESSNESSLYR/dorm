package com.ruoyi.area.service;

import java.util.List;
import com.ruoyi.area.domain.DormArea;

/**
 * 区域信息Service接口
 * 
 * @author qqq
 * @date 2022-03-30
 */
public interface IDormAreaService 
{
    /**
     * 查询区域信息
     * 
     * @param areaNumber 区域信息主键
     * @return 区域信息
     */
    public DormArea selectDormAreaByAreaNumber(String areaNumber);

    /**
     * 查询区域信息列表
     * 
     * @param dormArea 区域信息
     * @return 区域信息集合
     */
    public List<DormArea> selectDormAreaList(DormArea dormArea);

    /**
     * 新增区域信息
     * 
     * @param dormArea 区域信息
     * @return 结果
     */
    public int insertDormArea(DormArea dormArea);

    /**
     * 修改区域信息
     * 
     * @param dormArea 区域信息
     * @return 结果
     */
    public int updateDormArea(DormArea dormArea);

    /**
     * 批量删除区域信息
     * 
     * @param areaNumbers 需要删除的区域信息主键集合
     * @return 结果
     */
    public int deleteDormAreaByAreaNumbers(String[] areaNumbers);

    /**
     * 删除区域信息信息
     * 
     * @param areaNumber 区域信息主键
     * @return 结果
     */
    public int deleteDormAreaByAreaNumber(String areaNumber);

}
