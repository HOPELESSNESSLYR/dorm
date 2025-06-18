package com.ruoyi.hydropower.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.livepeople.domain.DormLivepeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hydropower.mapper.DormRoomHydropowerMapper;
import com.ruoyi.hydropower.domain.DormRoomHydropower;
import com.ruoyi.hydropower.service.IDormRoomHydropowerService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 房间水电记录Service业务层处理
 * 
 * @author qqq
 * @date 2022-05-03
 */
@Service
public class DormRoomHydropowerServiceImpl implements IDormRoomHydropowerService 
{
    @Autowired
    private DormRoomHydropowerMapper dormRoomHydropowerMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询房间水电记录
     * 
     * @param id 房间水电记录主键
     * @return 房间水电记录
     */
    @Override
    public DormRoomHydropower selectDormRoomHydropowerById(Long id)
    {
        return dormRoomHydropowerMapper.selectDormRoomHydropowerById(id);
    }

    /**
     * 查询房间水电记录列表
     * 
     * @param dormRoomHydropower 房间水电记录
     * @return 房间水电记录
     */
    @Override
    public List<DormRoomHydropower> selectDormRoomHydropowerList(DormRoomHydropower dormRoomHydropower)
    {
        return dormRoomHydropowerMapper.selectDormRoomHydropowerList(dormRoomHydropower);
    }

    /**
     * 新增房间水电记录
     * 
     * @param dormRoomHydropower 房间水电记录
     * @return 结果
     */
    @Override
    public int insertDormRoomHydropower(DormRoomHydropower dormRoomHydropower)
    {
        return dormRoomHydropowerMapper.insertDormRoomHydropower(dormRoomHydropower);
    }

    /**
     * 修改房间水电记录
     * 
     * @param dormRoomHydropower 房间水电记录
     * @return 结果
     */
    @Override
    public int updateDormRoomHydropower(DormRoomHydropower dormRoomHydropower)
    {
        return dormRoomHydropowerMapper.updateDormRoomHydropower(dormRoomHydropower);
    }

    /**
     * 批量删除房间水电记录
     * 
     * @param ids 需要删除的房间水电记录主键
     * @return 结果
     */
    @Override
    public int deleteDormRoomHydropowerByIds(Long[] ids)
    {
        return dormRoomHydropowerMapper.deleteDormRoomHydropowerByIds(ids);
    }

    /**
     * 删除房间水电记录信息
     * 
     * @param id 房间水电记录主键
     * @return 结果
     */
    @Override
    public int deleteDormRoomHydropowerById(Long id)
    {
        return dormRoomHydropowerMapper.deleteDormRoomHydropowerById(id);
    }

    /**
     * 导入房间水电信息数据
     *
     * @param dormRoomHydropowerList 房间水电信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormRoomHydropower(List<DormRoomHydropower> dormRoomHydropowerList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormRoomHydropowerList) || dormRoomHydropowerList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormRoomHydropower dormRoomHydropower : dormRoomHydropowerList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormRoomHydropower);

                    dormRoomHydropower.setCreateBy(operName);
                    this.insertDormRoomHydropower(dormRoomHydropower);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、房间号 " + dormRoomHydropower.getRoomNumber() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormRoomHydropower);
                    dormRoomHydropower.setUpdateBy(operName);
                    this.updateDormRoomHydropower(dormRoomHydropower);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、房间号 " + dormRoomHydropower.getRoomNumber() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、房间号 " + dormRoomHydropower.getRoomNumber() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、房间号 " + dormRoomHydropower.getRoomNumber() + " 导入失败：";
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
