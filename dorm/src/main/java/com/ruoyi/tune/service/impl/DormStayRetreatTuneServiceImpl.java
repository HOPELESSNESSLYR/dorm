package com.ruoyi.tune.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.room.domain.DormRoominfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tune.mapper.DormStayRetreatTuneMapper;
import com.ruoyi.tune.domain.DormStayRetreatTune;
import com.ruoyi.tune.service.IDormStayRetreatTuneService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 入住调宿退宿申请Service业务层处理
 * 
 * @author qqq
 * @date 2022-04-14
 */
@Service
public class DormStayRetreatTuneServiceImpl implements IDormStayRetreatTuneService 
{
    @Autowired
    private DormStayRetreatTuneMapper dormStayRetreatTuneMapper;

    @Autowired
    protected Validator validator;
    /**
     * 查询入住调宿退宿申请
     * 
     * @param id 入住调宿退宿申请主键
     * @return 入住调宿退宿申请
     */
    @Override
    public DormStayRetreatTune selectDormStayRetreatTuneById(Long id)
    {
        return dormStayRetreatTuneMapper.selectDormStayRetreatTuneById(id);
    }

    /**
     * 查询入住调宿退宿申请列表
     * 
     * @param dormStayRetreatTune 入住调宿退宿申请
     * @return 入住调宿退宿申请
     */
    @Override
    public List<DormStayRetreatTune> selectDormStayRetreatTuneList(DormStayRetreatTune dormStayRetreatTune)
    {
        return dormStayRetreatTuneMapper.selectDormStayRetreatTuneList(dormStayRetreatTune);
    }

    /**
     * 新增入住调宿退宿申请
     * 
     * @param dormStayRetreatTune 入住调宿退宿申请
     * @return 结果
     */
    @Override
    public int insertDormStayRetreatTune(DormStayRetreatTune dormStayRetreatTune)
    {
        return dormStayRetreatTuneMapper.insertDormStayRetreatTune(dormStayRetreatTune);
    }

    /**
     * 修改入住调宿退宿申请
     * 
     * @param dormStayRetreatTune 入住调宿退宿申请
     * @return 结果
     */
    @Override
    public int updateDormStayRetreatTune(DormStayRetreatTune dormStayRetreatTune)
    {
        return dormStayRetreatTuneMapper.updateDormStayRetreatTune(dormStayRetreatTune);
    }

    /**
     * 批量删除入住调宿退宿申请
     * 
     * @param ids 需要删除的入住调宿退宿申请主键
     * @return 结果
     */
    @Override
    public int deleteDormStayRetreatTuneByIds(Long[] ids)
    {
        return dormStayRetreatTuneMapper.deleteDormStayRetreatTuneByIds(ids);
    }

    /**
     * 删除入住调宿退宿申请信息
     * 
     * @param id 入住调宿退宿申请主键
     * @return 结果
     */
    @Override
    public int deleteDormStayRetreatTuneById(Long id)
    {
        return dormStayRetreatTuneMapper.deleteDormStayRetreatTuneById(id);
    }
    /**
     * 根据身份证号码查询流转信息
     */
    public List<DormStayRetreatTune> selectDormStayRetreatTuneByIDnumber(String IDnumbwer){
        return dormStayRetreatTuneMapper.selectDormStayRetreatTuneByIDnumber(IDnumbwer);
    };
    /**
     * 导入流转信息数据
     *
     * @param dormStayRetreatTuneList 流转息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormStayRetreatTune(List<DormStayRetreatTune> dormStayRetreatTuneList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormStayRetreatTuneList) || dormStayRetreatTuneList.size() == 0)
        {
            throw new ServiceException("导入流转信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormStayRetreatTune dormStayRetreatTune : dormStayRetreatTuneList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormStayRetreatTune);

                    dormStayRetreatTune.setCreateBy(operName);
                    this.insertDormStayRetreatTune(dormStayRetreatTune);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、身份证号 " + dormStayRetreatTune.getIdnumber() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormStayRetreatTune);
                    dormStayRetreatTune.setUpdateBy(operName);
                    this.updateDormStayRetreatTune(dormStayRetreatTune);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、身份证号 " + dormStayRetreatTune.getIdnumber() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、身份证号 " + dormStayRetreatTune.getIdnumber() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、身份证号 " + dormStayRetreatTune.getIdnumber() + " 导入失败：";
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
