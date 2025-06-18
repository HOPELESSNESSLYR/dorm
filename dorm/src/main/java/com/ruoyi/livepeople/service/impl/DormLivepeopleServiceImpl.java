package com.ruoyi.livepeople.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.room.domain.DormRoominfor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.livepeople.mapper.DormLivepeopleMapper;
import com.ruoyi.livepeople.domain.DormLivepeople;
import com.ruoyi.livepeople.service.IDormLivepeopleService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 人员信息Service业务层处理
 * 
 * @author qqq
 * @date 2022-04-14
 */
@Service
public class DormLivepeopleServiceImpl implements IDormLivepeopleService 
{
    @Autowired
    private DormLivepeopleMapper dormLivepeopleMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询人员信息
     * 
     * @param id 人员信息主键
     * @return 人员信息
     */
    @Override
    public DormLivepeople selectDormLivepeopleById(Long id)
    {
        return dormLivepeopleMapper.selectDormLivepeopleById(id);
    }

    /**
     * 查询人员信息列表
     * 
     * @param dormLivepeople 人员信息
     * @return 人员信息
     */
    @Override
    public List<DormLivepeople> selectDormLivepeopleList(DormLivepeople dormLivepeople)
    {
        return dormLivepeopleMapper.selectDormLivepeopleList(dormLivepeople);
    }
    /**
     * 查询已住人员信息列表
     *
     * @param dormLivepeople 人员信息
     * @return 人员信息
     */
    @Override
    public List<DormLivepeople> selectDormLivepeopleList2(DormLivepeople dormLivepeople)
    {
        return dormLivepeopleMapper.selectDormLivepeopleList2(dormLivepeople);
    }
    @Override
    public List<DormLivepeople> selectDormLivepeopleList3()
    {
        return dormLivepeopleMapper.selectDormLivepeopleList3();
    }
    /**
     * 根据身份证查询人员信息列表
     *
     * @param IDnumber 身份证
     * @return 人员信息
     */
    @Override
    public DormLivepeople selectDormLivepeopleByIDnumber(String IDnumber)
    {
        return dormLivepeopleMapper.selectDormLivepeopleByIDnumber(IDnumber);
    }
    /**
     * 根据身份证查询人员信息列表
     *
     * @param IDnumber 身份证
     * @return 人员信息
     */
    @Override
    public List<DormLivepeople> selectDormLivepeopleListByIDnumber(String IDnumber)
    {
        return dormLivepeopleMapper.selectDormLivepeopleListByIDnumber(IDnumber);
    }
    /**
     * 新增人员信息
     * 
     * @param dormLivepeople 人员信息
     * @return 结果
     */
    @Override
    public int insertDormLivepeople(DormLivepeople dormLivepeople)
    {
        return dormLivepeopleMapper.insertDormLivepeople(dormLivepeople);
    }

    /**
     * 修改人员信息
     * 
     * @param dormLivepeople 人员信息
     * @return 结果
     */
    @Override
    public int updateDormLivepeople(DormLivepeople dormLivepeople)
    {
        return dormLivepeopleMapper.updateDormLivepeople(dormLivepeople);
    }

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的人员信息主键
     * @return 结果
     */
    @Override
    public int deleteDormLivepeopleByIds(Long[] ids)
    {
        return dormLivepeopleMapper.deleteDormLivepeopleByIds(ids);
    }

    /**
     * 删除人员信息信息
     * 
     * @param id 人员信息主键
     * @return 结果
     */
    @Override
    public int deleteDormLivepeopleById(Long id)
    {
        return dormLivepeopleMapper.deleteDormLivepeopleById(id);
    }


    /**
     * 导入住客信息数据
     *
     * @param dormLivepeopleList 住客信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormLivepeople(List<DormLivepeople> dormLivepeopleList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormLivepeopleList) || dormLivepeopleList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormLivepeople dormLivepeople : dormLivepeopleList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormLivepeople);

                    dormLivepeople.setCreateBy(operName);
                    this.insertDormLivepeople(dormLivepeople);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、姓名 " + dormLivepeople.getName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormLivepeople);
                    dormLivepeople.setUpdateBy(operName);
                    this.updateDormLivepeople(dormLivepeople);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、姓名 " + dormLivepeople.getName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、姓名 " + dormLivepeople.getName() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、姓名 " + dormLivepeople.getName() + " 导入失败：";
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
