package com.ruoyi.cost.service.impl;

import java.util.List;

import com.ruoyi.article.domain.DormArticle;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.cost.mapper.DormHydropwerCostMapper;
import com.ruoyi.cost.domain.DormHydropwerCost;
import com.ruoyi.cost.service.IDormHydropwerCostService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 个人费用明细Service业务层处理
 * 
 * @author qqq
 * @date 2022-05-03
 */
@Service
public class DormHydropwerCostServiceImpl implements IDormHydropwerCostService 
{
    @Autowired
    private DormHydropwerCostMapper dormHydropwerCostMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询个人费用明细
     * 
     * @param id 个人费用明细主键
     * @return 个人费用明细
     */
    @Override
    public DormHydropwerCost selectDormHydropwerCostById(Long id)
    {
        return dormHydropwerCostMapper.selectDormHydropwerCostById(id);
    }

    /**
     * 查询个人费用明细列表
     * 
     * @param dormHydropwerCost 个人费用明细
     * @return 个人费用明细
     */
    @Override
    public List<DormHydropwerCost> selectDormHydropwerCostList(DormHydropwerCost dormHydropwerCost)
    {
        return dormHydropwerCostMapper.selectDormHydropwerCostList(dormHydropwerCost);
    }

    /**
     * 新增个人费用明细
     * 
     * @param dormHydropwerCost 个人费用明细
     * @return 结果
     */
    @Override
    public int insertDormHydropwerCost(DormHydropwerCost dormHydropwerCost)
    {
        return dormHydropwerCostMapper.insertDormHydropwerCost(dormHydropwerCost);
    }

    /**
     * 修改个人费用明细
     * 
     * @param dormHydropwerCost 个人费用明细
     * @return 结果
     */
    @Override
    public int updateDormHydropwerCost(DormHydropwerCost dormHydropwerCost)
    {
        return dormHydropwerCostMapper.updateDormHydropwerCost(dormHydropwerCost);
    }

    /**
     * 批量删除个人费用明细
     * 
     * @param ids 需要删除的个人费用明细主键
     * @return 结果
     */
    @Override
    public int deleteDormHydropwerCostByIds(Long[] ids)
    {
        return dormHydropwerCostMapper.deleteDormHydropwerCostByIds(ids);
    }

    /**
     * 删除个人费用明细信息
     * 
     * @param id 个人费用明细主键
     * @return 结果
     */
    @Override
    public int deleteDormHydropwerCostById(Long id)
    {
        return dormHydropwerCostMapper.deleteDormHydropwerCostById(id);
    }

    /**
     * 导入个人费用信息数据
     *
     * @param dormHydropwerCostList 个人费用信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormHydropwerCost(List<DormHydropwerCost> dormHydropwerCostList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormHydropwerCostList) || dormHydropwerCostList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormHydropwerCost dormHydropwerCost : dormHydropwerCostList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormHydropwerCost);

                    dormHydropwerCost.setCreateBy(operName);
                    this.insertDormHydropwerCost(dormHydropwerCost);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、人员 " + dormHydropwerCost.getJobnumber() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormHydropwerCost);
                    dormHydropwerCost.setUpdateBy(operName);
                    this.updateDormHydropwerCost(dormHydropwerCost);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、人员 " + dormHydropwerCost.getJobnumber() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、人员 " + dormHydropwerCost.getJobnumber() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、人员 " + dormHydropwerCost.getJobnumber() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
