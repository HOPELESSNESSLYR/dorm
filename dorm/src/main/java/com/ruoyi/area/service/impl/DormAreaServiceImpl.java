package com.ruoyi.area.service.impl;

import java.util.List;

import com.ruoyi.area.domain.DormArea;
import com.ruoyi.area.mapper.DormAreaMapper;
import com.ruoyi.area.service.IDormAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 区域信息Service业务层处理
 * 
 * @author qqq
 * @date 2022-03-30
 */
@Service
public class DormAreaServiceImpl implements IDormAreaService
{
    @Autowired
    private DormAreaMapper dormAreaMapper;

    /**
     * 查询区域信息
     * 
     * @param areaNumber 区域信息主键
     * @return 区域信息
     */
    @Override
    public DormArea selectDormAreaByAreaNumber(String areaNumber)
    {
        return dormAreaMapper.selectDormAreaByAreaNumber(areaNumber);
    }

    /**
     * 查询区域信息列表
     * 
     * @param dormArea 区域信息
     * @return 区域信息
     */
    @Override
    public List<DormArea> selectDormAreaList(DormArea dormArea)
    {
        return dormAreaMapper.selectDormAreaList(dormArea);
    }

    /**
     * 新增区域信息
     * 
     * @param dormArea 区域信息
     * @return 结果
     */
    @Override
    public int insertDormArea(DormArea dormArea)
    {
        return dormAreaMapper.insertDormArea(dormArea);
    }

    /**
     * 修改区域信息
     * 
     * @param dormArea 区域信息
     * @return 结果
     */
    @Override
    public int updateDormArea(DormArea dormArea)
    {
        return dormAreaMapper.updateDormArea(dormArea);
    }

    /**
     * 批量删除区域信息
     * 
     * @param areaNumbers 需要删除的区域信息主键
     * @return 结果
     */
    @Override
    public int deleteDormAreaByAreaNumbers(String[] areaNumbers)
    {
        return dormAreaMapper.deleteDormAreaByAreaNumbers(areaNumbers);
    }

    /**
     * 删除区域信息信息
     * 
     * @param areaNumber 区域信息主键
     * @return 结果
     */
    @Override
    public int deleteDormAreaByAreaNumber(String areaNumber)
    {
        return dormAreaMapper.deleteDormAreaByAreaNumber(areaNumber);
    }

}
