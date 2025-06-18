package com.ruoyi.off.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.livepeople.domain.DormLivepeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.off.mapper.DormLeaveOffMapper;
import com.ruoyi.off.domain.DormLeaveOff;
import com.ruoyi.off.service.IDormLeaveOffService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 免扣销假记录Service业务层处理
 * 
 * @author qqq
 * @date 2022-05-03
 */
@Service
public class DormLeaveOffServiceImpl implements IDormLeaveOffService 
{
    @Autowired
    private DormLeaveOffMapper dormLeaveOffMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询免扣销假记录
     * 
     * @param id 免扣销假记录主键
     * @return 免扣销假记录
     */
    @Override
    public DormLeaveOff selectDormLeaveOffById(Long id)
    {
        return dormLeaveOffMapper.selectDormLeaveOffById(id);
    }

    /**
     * 查询免扣销假记录列表
     * 
     * @param dormLeaveOff 免扣销假记录
     * @return 免扣销假记录
     */
    @Override
    public List<DormLeaveOff> selectDormLeaveOffList(DormLeaveOff dormLeaveOff)
    {
        return dormLeaveOffMapper.selectDormLeaveOffList(dormLeaveOff);
    }

    /**
     * 新增免扣销假记录
     * 
     * @param dormLeaveOff 免扣销假记录
     * @return 结果
     */
    @Override
    public int insertDormLeaveOff(DormLeaveOff dormLeaveOff)
    {
        return dormLeaveOffMapper.insertDormLeaveOff(dormLeaveOff);
    }

    /**
     * 修改免扣销假记录
     * 
     * @param dormLeaveOff 免扣销假记录
     * @return 结果
     */
    @Override
    public int updateDormLeaveOff(DormLeaveOff dormLeaveOff)
    {
        return dormLeaveOffMapper.updateDormLeaveOff(dormLeaveOff);
    }

    /**
     * 批量删除免扣销假记录
     * 
     * @param ids 需要删除的免扣销假记录主键
     * @return 结果
     */
    @Override
    public int deleteDormLeaveOffByIds(Long[] ids)
    {
        return dormLeaveOffMapper.deleteDormLeaveOffByIds(ids);
    }

    /**
     * 删除免扣销假记录信息
     * 
     * @param id 免扣销假记录主键
     * @return 结果
     */
    @Override
    public int deleteDormLeaveOffById(Long id)
    {
        return dormLeaveOffMapper.deleteDormLeaveOffById(id);
    }

    @Override
    public Long selectSumOffdaysByIDnumber(String jobnumber)
    {
        return dormLeaveOffMapper.selectSumOffdaysByIDnumber(jobnumber);
    }
    /**
     * 导入免扣销假信息数据
     *
     * @param dormLeaveOffList 免扣销假信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormLeaveOff(List<DormLeaveOff> dormLeaveOffList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormLeaveOffList) || dormLeaveOffList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormLeaveOff dormLeaveOff : dormLeaveOffList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormLeaveOff);

                    dormLeaveOff.setCreateBy(operName);
                    this.insertDormLeaveOff(dormLeaveOff);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、姓名 " + dormLeaveOff.getName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormLeaveOff);
                    dormLeaveOff.setUpdateBy(operName);
                    this.updateDormLeaveOff(dormLeaveOff);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、姓名 " + dormLeaveOff.getName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、姓名 " + dormLeaveOff.getName() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、姓名 " + dormLeaveOff.getName() + " 导入失败：";
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
