package com.ruoyi.cost.mapper;

import java.util.List;
import com.ruoyi.cost.domain.DormHydropwerCost;

/**
 * 个人费用明细Mapper接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface DormHydropwerCostMapper 
{
    /**
     * 查询个人费用明细
     * 
     * @param id 个人费用明细主键
     * @return 个人费用明细
     */
    public DormHydropwerCost selectDormHydropwerCostById(Long id);

    /**
     * 查询个人费用明细列表
     * 
     * @param dormHydropwerCost 个人费用明细
     * @return 个人费用明细集合
     */
    public List<DormHydropwerCost> selectDormHydropwerCostList(DormHydropwerCost dormHydropwerCost);

    /**
     * 新增个人费用明细
     * 
     * @param dormHydropwerCost 个人费用明细
     * @return 结果
     */
    public int insertDormHydropwerCost(DormHydropwerCost dormHydropwerCost);

    /**
     * 修改个人费用明细
     * 
     * @param dormHydropwerCost 个人费用明细
     * @return 结果
     */
    public int updateDormHydropwerCost(DormHydropwerCost dormHydropwerCost);

    /**
     * 删除个人费用明细
     * 
     * @param id 个人费用明细主键
     * @return 结果
     */
    public int deleteDormHydropwerCostById(Long id);

    /**
     * 批量删除个人费用明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormHydropwerCostByIds(Long[] ids);
}
