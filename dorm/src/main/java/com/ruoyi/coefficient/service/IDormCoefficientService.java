package com.ruoyi.coefficient.service;

import java.util.List;

import com.ruoyi.article.domain.DormArticle;
import com.ruoyi.coefficient.domain.DormCoefficient;

/**
 * 每人天公摊费用Service接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface IDormCoefficientService 
{
    /**
     * 查询每人天公摊费用
     * 
     * @param id 每人天公摊费用主键
     * @return 每人天公摊费用
     */
    public DormCoefficient selectDormCoefficientById(Long id);

    /**
     * 查询每人天公摊费用列表
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 每人天公摊费用集合
     */
    public List<DormCoefficient> selectDormCoefficientList(DormCoefficient dormCoefficient);

    /**
     * 新增每人天公摊费用
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 结果
     */
    public int insertDormCoefficient(DormCoefficient dormCoefficient);

    /**
     * 修改每人天公摊费用
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 结果
     */
    public int updateDormCoefficient(DormCoefficient dormCoefficient);

    /**
     * 批量删除每人天公摊费用
     * 
     * @param ids 需要删除的每人天公摊费用主键集合
     * @return 结果
     */
    public int deleteDormCoefficientByIds(Long[] ids);

    /**
     * 删除每人天公摊费用信息
     * 
     * @param id 每人天公摊费用主键
     * @return 结果
     */
    public int deleteDormCoefficientById(Long id);

    /**
     * 导入每人天公摊费用信息数据
     *
     * @param dormCoefficientList 每人天公摊费用信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormCoefficient(List<DormCoefficient> dormCoefficientList, Boolean isUpdateSupport, String operName);
}
