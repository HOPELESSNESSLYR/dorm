package com.ruoyi.fixedassets.mapper;

import java.util.List;
import com.ruoyi.fixedassets.domain.DormFixedassets;

/**
 * 宿舍固定资产Mapper接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface DormFixedassetsMapper 
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
     * 删除宿舍固定资产
     * 
     * @param id 宿舍固定资产主键
     * @return 结果
     */
    public int deleteDormFixedassetsById(Long id);

    /**
     * 批量删除宿舍固定资产
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormFixedassetsByIds(Long[] ids);
}
