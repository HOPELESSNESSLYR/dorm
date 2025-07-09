package com.ruoyi.feefloor.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.feeconfig.domain.FeeConfig;
import com.ruoyi.feeconfig.service.impl.FeeConfigServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.feefloor.mapper.FeeFloorMapper;
import com.ruoyi.feefloor.domain.FeeFloor;
import com.ruoyi.feefloor.service.IFeeFloorService;
import javax.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 楼层费用Service业务层处理
 * 
 * @author lyr
 * @date 2025-07-01
 */
@Service
public class FeeFloorServiceImpl implements IFeeFloorService 
{
    private static final Logger log = LoggerFactory.getLogger(FeeFloorServiceImpl.class);
    @Autowired
    private FeeFloorMapper feeFloorMapper;
    @Autowired
    protected Validator validator;

    /**
     * 查询楼层费用
     * 
     * @param floorfeeId 楼层费用主键
     * @return 楼层费用
     */
    @Override
    public FeeFloor selectFeeFloorByFloorfeeId(Long floorfeeId)
    {
        return feeFloorMapper.selectFeeFloorByFloorfeeId(floorfeeId);
    }

    /**
     * 查询楼层费用列表
     * 
     * @param feeFloor 楼层费用
     * @return 楼层费用
     */
    @Override
    public List<FeeFloor> selectFeeFloorList(FeeFloor feeFloor)
    {
        return feeFloorMapper.selectFeeFloorList(feeFloor);
    }

    /**
     * 新增楼层费用
     * 
     * @param feeFloor 楼层费用
     * @return 结果
     */
    @Override
    public int insertFeeFloor(FeeFloor feeFloor)
    {
        return feeFloorMapper.insertFeeFloor(feeFloor);
    }

    /**
     * 修改楼层费用
     * 
     * @param feeFloor 楼层费用
     * @return 结果
     */
    @Override
    public int updateFeeFloor(FeeFloor feeFloor)
    {
        return feeFloorMapper.updateFeeFloor(feeFloor);
    }

    /**
     * 批量删除楼层费用
     * 
     * @param floorfeeIds 需要删除的楼层费用主键
     * @return 结果
     */
    @Override
    public int deleteFeeFloorByFloorfeeIds(Long[] floorfeeIds)
    {
        return feeFloorMapper.deleteFeeFloorByFloorfeeIds(floorfeeIds);
    }

    /**
     * 删除楼层费用信息
     * 
     * @param floorfeeId 楼层费用主键
     * @return 结果
     */
    @Override
    public int deleteFeeFloorByFloorfeeId(Long floorfeeId)
    {
        return feeFloorMapper.deleteFeeFloorByFloorfeeId(floorfeeId);
    }

    /**
     * 导入
     *
     * @param feeFloorList 费用配置数据列表
     * @param updateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importFeeFloor(List<FeeFloor> feeFloorList, boolean updateSupport, String operName)
    {
        if (StringUtils.isNull(feeFloorList) || feeFloorList.size() == 0)
        {
            throw new ServiceException("导入楼层信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (FeeFloor feefloor : feeFloorList)
        {
            try
            {
                if (updateSupport==false)
                {
                    BeanValidators.validateWithException(validator, feefloor);

                    feefloor.setCreateBy(operName);
                    this.insertFeeFloor(feefloor);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、区域编号 " + feefloor.getAreaNumber()+ "、宿舍楼 " + feefloor.getFloorName() + " 导入成功");
                }
                else if (updateSupport)
                {
                    BeanValidators.validateWithException(validator, feefloor);
                    feefloor.setUpdateBy(operName);
                    this.updateFeeFloor(feefloor);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、区域编号 " + feefloor.getAreaNumber()+ "、宿舍楼 " + feefloor.getFloorName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、区域编号 " + feefloor.getAreaNumber()+ "、宿舍楼 " + feefloor.getFloorName() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、区域编号 " + feefloor.getAreaNumber() + "、宿舍楼 " + feefloor.getFloorName()+ " 导入失败：";
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
