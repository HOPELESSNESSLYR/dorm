package com.ruoyi.fixedassets.service;

import java.util.List;

import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.fixedassets.domain.DormFixedassets;

/**
 * 宿舍固定资产Service接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface IDormFixedassetsService 
{
    /**
     * 查询宿舍固定资产
     * 
     * @param id 宿舍固定资产主键
     * @return 宿舍固定资产
     */
    public DormFixedassets selectDormFixedassetsById(Long id);

    /**
     * 查询宿舍固定资产列表
     * 
     * @param dormFixedassets 宿舍固定资产
     * @return 宿舍固定资产集合
     */
    public List<DormFixedassets> selectDormFixedassetsList(DormFixedassets dormFixedassets);

    /**
     * 新增宿舍固定资产
     * 
     * @param dormFixedassets 宿舍固定资产
     * @return 结果
     */
    public int insertDormFixedassets(DormFixedassets dormFixedassets);

    /**
     * 修改宿舍固定资产
     * 
     * @param dormFixedassets 宿舍固定资产
     * @return 结果
     */
    public int updateDormFixedassets(DormFixedassets dormFixedassets);

    /**
     * 批量删除宿舍固定资产
     * 
     * @param ids 需要删除的宿舍固定资产主键集合
     * @return 结果
     */
    public int deleteDormFixedassetsByIds(Long[] ids);

    /**
     * 删除宿舍固定资产信息
     * 
     * @param id 宿舍固定资产主键
     * @return 结果
     */
    public int deleteDormFixedassetsById(Long id);

    /**
     * 导入宿舍固定资产信息数据
     *
     * @param dormFixedassetsList 宿舍固定资产信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormFixedassets(List<DormFixedassets> dormFixedassetsList, Boolean isUpdateSupport, String operName);

}
