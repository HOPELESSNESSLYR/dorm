package com.ruoyi.wardrobe.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.tune.domain.DormStayRetreatTune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wardrobe.mapper.DormWardrobeMapper;
import com.ruoyi.wardrobe.domain.DormWardrobe;
import com.ruoyi.wardrobe.service.IDormWardrobeService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 柜子信息Service业务层处理
 * 
 * @author qqq
 * @date 2022-05-03
 */
@Service
public class DormWardrobeServiceImpl implements IDormWardrobeService 
{
    @Autowired
    private DormWardrobeMapper dormWardrobeMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询柜子信息
     * 
     * @param id 柜子信息主键
     * @return 柜子信息
     */
    @Override
    public DormWardrobe selectDormWardrobeById(Long id)
    {
        return dormWardrobeMapper.selectDormWardrobeById(id);
    }

    /**
     * 查询柜子信息列表
     * 
     * @param dormWardrobe 柜子信息
     * @return 柜子信息
     */
    @Override
    public List<DormWardrobe> selectDormWardrobeList(DormWardrobe dormWardrobe)
    {
        return dormWardrobeMapper.selectDormWardrobeList(dormWardrobe);
    }
    @Override
    public DormWardrobe selectDormWardrobeByJobnumber(String jobnumber){
        return dormWardrobeMapper.selectDormWardrobeByJobnumber(jobnumber);
    };
    /**
     * 新增柜子信息
     * 
     * @param dormWardrobe 柜子信息
     * @return 结果
     */
    @Override
    public int insertDormWardrobe(DormWardrobe dormWardrobe)
    {
        return dormWardrobeMapper.insertDormWardrobe(dormWardrobe);
    }

    /**
     * 修改柜子信息
     * 
     * @param dormWardrobe 柜子信息
     * @return 结果
     */
    @Override
    public int updateDormWardrobe(DormWardrobe dormWardrobe)
    {
        return dormWardrobeMapper.updateDormWardrobe(dormWardrobe);
    }

    /**
     * 批量删除柜子信息
     * 
     * @param ids 需要删除的柜子信息主键
     * @return 结果
     */
    @Override
    public int deleteDormWardrobeByIds(Long[] ids)
    {
        return dormWardrobeMapper.deleteDormWardrobeByIds(ids);
    }

    /**
     * 删除柜子信息信息
     * 
     * @param id 柜子信息主键
     * @return 结果
     */
    @Override
    public int deleteDormWardrobeById(Long id)
    {
        return dormWardrobeMapper.deleteDormWardrobeById(id);
    }

    @Override
    public DormWardrobe selectDormWardrobeBymap(Map<String, String> wmap){
        return dormWardrobeMapper.selectDormWardrobeBymap(wmap);
    }

    /**
     * 导入柜子信息数据
     *
     * @param dormWardrobeList 柜子信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormWardrobe(List<DormWardrobe> dormWardrobeList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormWardrobeList) || dormWardrobeList.size() == 0)
        {
            throw new ServiceException("导入柜子信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormWardrobe dormWardrobe : dormWardrobeList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormWardrobe);

                    dormWardrobe.setCreateBy(operName);
                    this.insertDormWardrobe(dormWardrobe);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、柜子号 " + dormWardrobe.getWardrobe() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormWardrobe);
                    dormWardrobe.setUpdateBy(operName);
                    this.updateDormWardrobe(dormWardrobe);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、柜子号 " + dormWardrobe.getWardrobe() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、柜子号 " + dormWardrobe.getWardrobe() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、柜子号 " + dormWardrobe.getWardrobe() + " 导入失败：";
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
