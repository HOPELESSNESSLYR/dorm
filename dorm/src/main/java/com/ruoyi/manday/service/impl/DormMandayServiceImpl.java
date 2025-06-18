package com.ruoyi.manday.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.livepeople.domain.DormLivepeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manday.mapper.DormMandayMapper;
import com.ruoyi.manday.domain.DormManday;
import com.ruoyi.manday.service.IDormMandayService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 每月入住天数临时Service业务层处理
 * 
 * @author qqq
 * @date 2022-05-03
 */
@Service
public class DormMandayServiceImpl implements IDormMandayService 
{
    @Autowired
    private DormMandayMapper dormMandayMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询每月入住天数临时
     * 
     * @param id 每月入住天数临时主键
     * @return 每月入住天数临时
     */
    @Override
    public DormManday selectDormMandayById(Long id)
    {
        return dormMandayMapper.selectDormMandayById(id);
    }

    /**
     * 查询每月入住天数临时列表
     * 
     * @param dormManday 每月入住天数临时
     * @return 每月入住天数临时
     */
    @Override
    public List<DormManday> selectDormMandayList(DormManday dormManday)
    {
        return dormMandayMapper.selectDormMandayList(dormManday);
    }

    /**
     * 新增每月入住天数临时
     * 
     * @param dormManday 每月入住天数临时
     * @return 结果
     */
    @Override
    public int insertDormManday(DormManday dormManday)
    {
        return dormMandayMapper.insertDormManday(dormManday);
    }

    /**
     * 修改每月入住天数临时
     * 
     * @param dormManday 每月入住天数临时
     * @return 结果
     */
    @Override
    public int updateDormManday(DormManday dormManday)
    {
        return dormMandayMapper.updateDormManday(dormManday);
    }

    /**
     * 批量删除每月入住天数临时
     * 
     * @param ids 需要删除的每月入住天数临时主键
     * @return 结果
     */
    @Override
    public int deleteDormMandayByIds(Long[] ids)
    {
        return dormMandayMapper.deleteDormMandayByIds(ids);
    }

    /**
     * 删除每月入住天数临时信息
     * 
     * @param id 每月入住天数临时主键
     * @return 结果
     */
    @Override
    public int deleteDormMandayById(Long id)
    {
        return dormMandayMapper.deleteDormMandayById(id);
    }

    /**
     * 导入住客信息数据
     *
     * @param dormMandayList 住客信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormManday(List<DormManday> dormMandayList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormMandayList) || dormMandayList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormManday dormManday : dormMandayList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormManday);

                    dormManday.setCreateBy(operName);
                    this.insertDormManday(dormManday);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、工号 " + dormManday.getJobnumber() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormManday);
                    dormManday.setUpdateBy(operName);
                    this.updateDormManday(dormManday);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、工号 " + dormManday.getJobnumber() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、工号 " + dormManday.getJobnumber() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、工号 " + dormManday.getJobnumber() + " 导入失败：";
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
