package com.ruoyi.feeconfig.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.room.domain.DormRoominfor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.feeconfig.mapper.FeeConfigMapper;
import com.ruoyi.feeconfig.domain.FeeConfig;
import com.ruoyi.feeconfig.service.IFeeConfigService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 费用配置Service业务层处理
 * 
 * @author lyr
 * @date 2025-07-01
 */
@Service
public class FeeConfigServiceImpl implements IFeeConfigService 
{
    private static final Logger log = LoggerFactory.getLogger(FeeConfigServiceImpl.class);
    @Autowired
    private FeeConfigMapper feeConfigMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询费用配置
     * 
     * @param congifId 费用配置主键
     * @return 费用配置
     */
    @Override
    public FeeConfig selectFeeConfigByCongifId(Long congifId)
    {
        return feeConfigMapper.selectFeeConfigByCongifId(congifId);
    }

    /**
     * 查询费用配置列表
     * 
     * @param feeConfig 费用配置
     * @return 费用配置
     */
    @Override
    public List<FeeConfig> selectFeeConfigList(FeeConfig feeConfig)
    {
        return feeConfigMapper.selectFeeConfigList(feeConfig);
    }

    /**
     * 新增费用配置
     * 
     * @param feeConfig 费用配置
     * @return 结果
     */
    @Override
    public int insertFeeConfig(FeeConfig feeConfig)
    {
        return feeConfigMapper.insertFeeConfig(feeConfig);
    }

    /**
     * 修改费用配置
     * 
     * @param feeConfig 费用配置
     * @return 结果
     */
    @Override
    public int updateFeeConfig(FeeConfig feeConfig)
    {
        return feeConfigMapper.updateFeeConfig(feeConfig);
    }

    /**
     * 批量删除费用配置
     * 
     * @param congifIds 需要删除的费用配置主键
     * @return 结果
     */
    @Override
    public int deleteFeeConfigByCongifIds(Long[] congifIds)
    {
        return feeConfigMapper.deleteFeeConfigByCongifIds(congifIds);
    }

    /**
     * 删除费用配置信息
     * 
     * @param congifId 费用配置主键
     * @return 结果
     */
    @Override
    public int deleteFeeConfigByCongifId(Long congifId)
    {
        return feeConfigMapper.deleteFeeConfigByCongifId(congifId);
    }



    /**
     * 导入费用配置数据
     *
     * @param feeConfigList 费用配置数据列表
     * @param updateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importFeeConfig(List<FeeConfig> feeConfigList, boolean updateSupport, String operName)
    {
        if (StringUtils.isNull(feeConfigList) || feeConfigList.size() == 0)
        {
            throw new ServiceException("导入费用配置数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (FeeConfig feeconfig : feeConfigList)
        {
            try
            {
                if (updateSupport==false)
                {
                    BeanValidators.validateWithException(validator, feeconfig);

                    feeconfig.setCreateBy(operName);
                    this.insertFeeConfig(feeconfig);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、区域编号 " + feeconfig.getAreaNumber()+ "、楼层 " + feeconfig.getDormFloor() + " 导入成功");
                }
                else if (updateSupport)
                {
                    BeanValidators.validateWithException(validator, feeconfig);
                    feeconfig.setUpdateBy(operName);
                    this.updateFeeConfig(feeconfig);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、区域编号 " + feeconfig.getAreaNumber()+ "、楼层 " + feeconfig.getDormFloor() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、区域编号 " + feeconfig.getAreaNumber()+ "、楼层 " + feeconfig.getDormFloor() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、区域编号 " + feeconfig.getAreaNumber() + "、楼层 " + feeconfig.getDormFloor()+ " 导入失败：";
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
