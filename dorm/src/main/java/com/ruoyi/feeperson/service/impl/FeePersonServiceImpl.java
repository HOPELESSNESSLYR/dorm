package com.ruoyi.feeperson.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.feeconfig.service.impl.FeeConfigServiceImpl;
import com.ruoyi.feefloor.domain.FeeFloor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.feeperson.mapper.FeePersonMapper;
import com.ruoyi.feeperson.domain.FeePerson;
import com.ruoyi.feeperson.service.IFeePersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Validator;

/**
 * 个人费用Service业务层处理
 * 
 * @author lyr
 * @date 2025-07-01
 */
@Service
public class FeePersonServiceImpl implements IFeePersonService 
{
    @Autowired
    private FeePersonMapper feePersonMapper;
    @Autowired
    protected Validator validator;
    private static final Logger log = LoggerFactory.getLogger(FeePersonServiceImpl.class);

    /**
     * 查询个人费用
     * 
     * @param feepersonId 个人费用主键
     * @return 个人费用
     */
    @Override
    public FeePerson selectFeePersonByFeepersonId(Long feepersonId)
    {
        return feePersonMapper.selectFeePersonByFeepersonId(feepersonId);
    }

    /**
     * 查询个人费用列表
     * 
     * @param feePerson 个人费用
     * @return 个人费用
     */
    @Override
    public List<FeePerson> selectFeePersonList(FeePerson feePerson)
    {
        return feePersonMapper.selectFeePersonList(feePerson);
    }

    /**
     * 新增个人费用
     * 
     * @param feePerson 个人费用
     * @return 结果
     */
    @Override
    public int insertFeePerson(FeePerson feePerson)
    {
        return feePersonMapper.insertFeePerson(feePerson);
    }

    /**
     * 修改个人费用
     * 
     * @param feePerson 个人费用
     * @return 结果
     */
    @Override
    public int updateFeePerson(FeePerson feePerson)
    {
        return feePersonMapper.updateFeePerson(feePerson);
    }

    /**
     * 批量删除个人费用
     * 
     * @param feepersonIds 需要删除的个人费用主键
     * @return 结果
     */
    @Override
    public int deleteFeePersonByFeepersonIds(Long[] feepersonIds)
    {
        return feePersonMapper.deleteFeePersonByFeepersonIds(feepersonIds);
    }

    /**
     * 删除个人费用信息
     * 
     * @param feepersonId 个人费用主键
     * @return 结果
     */
    @Override
    public int deleteFeePersonByFeepersonId(Long feepersonId)
    {
        return feePersonMapper.deleteFeePersonByFeepersonId(feepersonId);
    }

    /**
     * 导入
     *
     * @param feePersonList 费用配置数据列表
     * @param updateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importFeePerson(List<FeePerson> feePersonList, boolean updateSupport, String operName)
        {
            if (StringUtils.isNull(feePersonList) || feePersonList.size() == 0)
            {
                throw new ServiceException("导入个人费用数据不能为空！");
            }
            int successNum = 0;
            int failureNum = 0;
            StringBuilder successMsg = new StringBuilder();
            StringBuilder failureMsg = new StringBuilder();
            for (FeePerson feeperson: feePersonList)
            {
                try
                {
                    if (updateSupport==false)
                    {
                        BeanValidators.validateWithException(validator, feeperson);

                        feeperson.setCreateBy(operName);
                        this.insertFeePerson(feeperson);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、区域编号 " + feeperson.getAreaNumber()+ "、工号 " + feeperson.getJobnumber() + " 导入成功");
                    }
                    else if (updateSupport)
                    {
                        BeanValidators.validateWithException(validator, feeperson);
                        feeperson.setUpdateBy(operName);
                        this.updateFeePerson(feeperson);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、区域编号 " + feeperson.getAreaNumber()+ "、工号 " + feeperson.getJobnumber() + " 更新成功");
                    }
                    else
                    {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、区域编号 " + feeperson.getAreaNumber()+ "、工号 " + feeperson.getJobnumber() + " 导入失败");
                    }
                }
                catch (Exception e)
                {
                    failureNum++;
                    String msg = "<br/>" + failureNum + "、区域编号 " + feeperson.getAreaNumber() + "、工号 " + feeperson.getJobnumber()+ " 导入失败：";
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
