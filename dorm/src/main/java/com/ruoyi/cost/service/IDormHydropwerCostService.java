package com.ruoyi.cost.service;

import java.util.List;

import com.ruoyi.article.domain.DormArticle;
import com.ruoyi.cost.domain.DormHydropwerCost;

/**
 * 个人费用明细Service接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface IDormHydropwerCostService 
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
     * 批量删除个人费用明细
     * 
     * @param ids 需要删除的个人费用明细主键集合
     * @return 结果
     */
    public int deleteDormHydropwerCostByIds(Long[] ids);

    /**
     * 删除个人费用明细信息
     * 
     * @param id 个人费用明细主键
     * @return 结果
     */
    public int deleteDormHydropwerCostById(Long id);

    /**
     * 导入个人费用信息数据
     *
     * @param dormHydropwerCostList 个人费用信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormHydropwerCost(List<DormHydropwerCost> dormHydropwerCostList, Boolean isUpdateSupport, String operName);
}
