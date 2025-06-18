package com.ruoyi.article.service.impl;

import java.util.List;

import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.article.mapper.DormArticleMapper;
import com.ruoyi.article.domain.DormArticle;
import com.ruoyi.article.service.IDormArticleService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 个人物品Service业务层处理
 * 
 * @author qqq
 * @date 2022-04-28
 */
@Service
public class DormArticleServiceImpl implements IDormArticleService 
{
    @Autowired
    private DormArticleMapper dormArticleMapper;
    @Autowired
    protected Validator validator;
    /**
     * 查询个人物品
     * 
     * @param id 个人物品主键
     * @return 个人物品
     */
    @Override
    public DormArticle selectDormArticleById(Long id)
    {
        return dormArticleMapper.selectDormArticleById(id);
    }

    /**
     * 查询个人物品
     *
     * @param IDnumber 个人物品主键
     * @return 个人物品
     */
    @Override
    public List<DormArticle>  selectDormArticleByIDnumber(String IDnumber)
    {
        return dormArticleMapper.selectDormArticleByIDnumber(IDnumber);
    }


    /**
     * 查询个人物品列表
     * 
     * @param dormArticle 个人物品
     * @return 个人物品
     */
    @Override
    public List<DormArticle> selectDormArticleList(DormArticle dormArticle)
    {
        return dormArticleMapper.selectDormArticleList(dormArticle);
    }

    /**
     * 新增个人物品
     * 
     * @param dormArticle 个人物品
     * @return 结果
     */
    @Override
    public int insertDormArticle(DormArticle dormArticle)
    {
        return dormArticleMapper.insertDormArticle(dormArticle);
    }

    /**
     * 修改个人物品
     * 
     * @param dormArticle 个人物品
     * @return 结果
     */
    @Override
    public int updateDormArticle(DormArticle dormArticle)
    {
        return dormArticleMapper.updateDormArticle(dormArticle);
    }

    /**
     * 批量删除个人物品
     * 
     * @param ids 需要删除的个人物品主键
     * @return 结果
     */
    @Override
    public int deleteDormArticleByIds(Long[] ids)
    {
        return dormArticleMapper.deleteDormArticleByIds(ids);
    }

    /**
     * 删除个人物品信息
     * 
     * @param id 个人物品主键
     * @return 结果
     */
    @Override
    public int deleteDormArticleById(Long id)
    {
        return dormArticleMapper.deleteDormArticleById(id);
    }
    /**
     * 导入个人物品信息数据
     *
     * @param dormArticleList 个人物品信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormArticleinfor(List<DormArticle> dormArticleList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormArticleList) || dormArticleList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormArticle dormArticle : dormArticleList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, dormArticle);

                    dormArticle.setCreateBy(operName);
                    this.insertDormArticle(dormArticle);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、人员 " + dormArticle.getName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, dormArticle);
                    dormArticle.setUpdateBy(operName);
                    this.updateDormArticle(dormArticle);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、人员 " + dormArticle.getName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、人员 " + dormArticle.getName() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、人员 " + dormArticle.getName() + " 导入失败：";
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
