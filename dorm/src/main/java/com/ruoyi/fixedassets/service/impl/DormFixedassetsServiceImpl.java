package com.ruoyi.fixedassets.service.impl;

import java.util.List;

import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.fixedassets.mapper.DormFixedassetsMapper;
import com.ruoyi.fixedassets.domain.DormFixedassets;
import com.ruoyi.fixedassets.service.IDormFixedassetsService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 宿舍固定资产Service业务层处理
 * 
 * @author qqq
 * @date 2022-05-03
 */
@Service
public class DormFixedassetsServiceImpl implements IDormFixedassetsService 
{
    @Autowired
    private DormFixedassetsMapper dormFixedassetsMapper;

    @Autowired
    protected Validator validator;
    /**
     * 查询宿舍固定资产
     * 
     * @param id 宿舍固定资产主键
     * @return 宿舍固定资产
     */
    @Override
    public DormFixedassets selectDormFixedassetsById(Long id)
    {
        return dormFixedassetsMapper.selectDormFixedassetsById(id);
    }

    /**
     * 查询宿舍固定资产列表
     * 
     * @param dormFixedassets 宿舍固定资产
     * @return 宿舍固定资产
     */
    @Override
    public List<DormFixedassets> selectDormFixedassetsList(DormFixedassets dormFixedassets)
    {
        return dormFixedassetsMapper.selectDormFixedassetsList(dormFixedassets);
    }

    /**
     * 新增宿舍固定资产
     * 
     * @param dormFixedassets 宿舍固定资产
     * @return 结果
     */
    @Override
    public int insertDormFixedassets(DormFixedassets dormFixedassets)
    {
        return dormFixedassetsMapper.insertDormFixedassets(dormFixedassets);
    }

    /**
     * 修改宿舍固定资产
     * 
     * @param dormFixedassets 宿舍固定资产
     * @return 结果
     */
    @Override
    public int updateDormFixedassets(DormFixedassets dormFixedassets)
    {
        return dormFixedassetsMapper.updateDormFixedassets(dormFixedassets);
    }

    /**
     * 批量删除宿舍固定资产
     * 
     * @param ids 需要删除的宿舍固定资产主键
     * @return 结果
     */
    @Override
    public int deleteDormFixedassetsByIds(Long[] ids)
    {
        return dormFixedassetsMapper.deleteDormFixedassetsByIds(ids);
    }

    /**
     * 删除宿舍固定资产信息
     * 
     * @param id 宿舍固定资产主键
     * @return 结果
     */
    @Override
    public int deleteDormFixedassetsById(Long id)
    {
        return dormFixedassetsMapper.deleteDormFixedassetsById(id);
    }

    /**
     * 导入宿舍固定资产信息数据
     *
     * @param dormFixedassetsList 宿舍固定资产信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormFixedassets(List<DormFixedassets> dormFixedassetsList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormFixedassetsList) || dormFixedassetsList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormFixedassets dormFixedassets : dormFixedassetsList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormFixedassets);

                    dormFixedassets.setCreateBy(operName);
                    this.insertDormFixedassets(dormFixedassets);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、房间号 " + dormFixedassets.getRoomNumber() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormFixedassets);
                    dormFixedassets.setUpdateBy(operName);
                    this.updateDormFixedassets(dormFixedassets);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、房间号 " + dormFixedassets.getRoomNumber() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、房间号 " + dormFixedassets.getRoomNumber() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、房间号 " + dormFixedassets.getRoomNumber() + " 导入失败：";
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
