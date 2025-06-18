package com.ruoyi.DormBed.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.room.domain.DormRoominfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.DormBed.mapper.DormBedMapper;
import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.DormBed.service.IDormBedService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 床位信息Service业务层处理
 * 
 * @author qqq
 * @date 2022-04-14
 */
@Service
public class DormBedServiceImpl implements IDormBedService 
{
    @Autowired
    private DormBedMapper dormBedMapper;

    @Autowired
    protected Validator validator;

    /**
     * 查询床位信息
     * 
     * @param id 床位信息主键
     * @return 床位信息
     */
    @Override
    public DormBed selectDormBedById(Long id)
    {
        return dormBedMapper.selectDormBedById(id);
    }


    /**
     * 查询空余床位信息
     *
     * @param bed 床位信息map
     * @return 床位信息
     */
    @Override
    public List<DormBed> selectkongbed(Map<String,String> bed)
    {
        return dormBedMapper.selectkongbed(bed);
    }

    /**
     * 查询床位信息列表
     * 
     * @param dormBed 床位信息
     * @return 床位信息
     */
    @Override
    public List<DormBed> selectDormBedList(DormBed dormBed)
    {
        return dormBedMapper.selectDormBedList(dormBed);
    }

    /**
     * 新增床位信息
     * 
     * @param dormBed 床位信息
     * @return 结果
     */
    @Override
    public int insertDormBed(DormBed dormBed)
    {
        return dormBedMapper.insertDormBed(dormBed);
    }

    /**
     * 修改床位信息
     * 
     * @param dormBed 床位信息
     * @return 结果
     */
    @Override
    public int updateDormBed(DormBed dormBed)
    {
        return dormBedMapper.updateDormBed(dormBed);
    }

    /**
     * 批量删除床位信息
     * 
     * @param ids 需要删除的床位信息主键
     * @return 结果
     */
    @Override
    public int deleteDormBedByIds(Long[] ids)
    {
        return dormBedMapper.deleteDormBedByIds(ids);
    }

    /**
     * 删除床位信息信息
     * 
     * @param id 床位信息主键
     * @return 结果
     */
    @Override
    public int deleteDormBedById(Long id)
    {
        return dormBedMapper.deleteDormBedById(id);
    }

    /**
     * 根据身份证号查询床位信息
     */
    @Override
    public DormBed selectDormBedByIDnumber(String iDnumbwer) {
        return dormBedMapper.selectDormBedByIDnumber(iDnumbwer);
    };
    @Override
    public DormBed selectDormBedByMap(Map<String, String> map){
        return dormBedMapper.selectDormBedByMap(map);
    }
    @Override
    public List<DormBed> selectDormBedByMap2(Map<String, String> map){
        return dormBedMapper.selectDormBedByMap2(map);
    };
    @Override
    public List<DormBed> selectDormBedByIDnumber2(String IDnumber){
        return dormBedMapper.selectDormBedByIDnumber2(IDnumber);
    }
    /**
     * 导入床位信息数据
     *
     * @param dormBedList 床位信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormBedinfor(List<DormBed> dormBedList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormBedList) || dormBedList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormBed dormBed : dormBedList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormBed);

                    dormBed.setCreateBy(operName);
                    this.insertDormBed(dormBed);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、房间号 " + dormBed.getRoomNumber() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormBed);
                    dormBed.setUpdateBy(operName);
                    this.updateDormBed(dormBed);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、房间号 " + dormBed.getRoomNumber() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、房间号 " + dormBed.getRoomNumber() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + dormBed.getRoomNumber() + " 导入失败：";
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
