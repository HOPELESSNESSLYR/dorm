package com.ruoyi.coefficient.service.impl;

import java.util.List;

import com.ruoyi.article.domain.DormArticle;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.coefficient.mapper.DormCoefficientMapper;
import com.ruoyi.coefficient.domain.DormCoefficient;
import com.ruoyi.coefficient.service.IDormCoefficientService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 每人天公摊费用Service业务层处理
 * 
 * @author qqq
 * @date 2022-05-03
 */
@Service
public class DormCoefficientServiceImpl implements IDormCoefficientService 
{
    @Autowired
    private DormCoefficientMapper dormCoefficientMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询每人天公摊费用
     * 
     * @param id 每人天公摊费用主键
     * @return 每人天公摊费用
     */
    @Override
    public DormCoefficient selectDormCoefficientById(Long id)
    {
        return dormCoefficientMapper.selectDormCoefficientById(id);
    }

    /**
     * 查询每人天公摊费用列表
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 每人天公摊费用
     */
    @Override
    public List<DormCoefficient> selectDormCoefficientList(DormCoefficient dormCoefficient)
    {
        return dormCoefficientMapper.selectDormCoefficientList(dormCoefficient);
    }

    /**
     * 新增每人天公摊费用
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 结果
     */
    @Override
    public int insertDormCoefficient(DormCoefficient dormCoefficient)
    {
        return dormCoefficientMapper.insertDormCoefficient(dormCoefficient);
    }

    /**
     * 修改每人天公摊费用
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 结果
     */
    @Override
    public int updateDormCoefficient(DormCoefficient dormCoefficient)
    {
        return dormCoefficientMapper.updateDormCoefficient(dormCoefficient);
    }

    /**
     * 批量删除每人天公摊费用
     * 
     * @param ids 需要删除的每人天公摊费用主键
     * @return 结果
     */
    @Override
    public int deleteDormCoefficientByIds(Long[] ids)
    {
        return dormCoefficientMapper.deleteDormCoefficientByIds(ids);
    }

    /**
     * 删除每人天公摊费用信息
     * 
     * @param id 每人天公摊费用主键
     * @return 结果
     */
    @Override
    public int deleteDormCoefficientById(Long id)
    {
        return dormCoefficientMapper.deleteDormCoefficientById(id);
    }

    /**
     * 导入每人天公摊费用信息数据
     *
     * @param dormCoefficientList 每人天公摊费用信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormCoefficient(List<DormCoefficient> dormCoefficientList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormCoefficientList) || dormCoefficientList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormCoefficient dormCoefficient : dormCoefficientList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormCoefficient);

                    dormCoefficient.setCreateBy(operName);
                    this.insertDormCoefficient(dormCoefficient);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、楼层 " + dormCoefficient.getDormFloor() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormCoefficient);
                    dormCoefficient.setUpdateBy(operName);
                    this.updateDormCoefficient(dormCoefficient);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、楼层 " + dormCoefficient.getDormFloor() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、楼层 " + dormCoefficient.getDormFloor() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、楼层 " + dormCoefficient.getDormFloor() + " 导入失败：";
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
