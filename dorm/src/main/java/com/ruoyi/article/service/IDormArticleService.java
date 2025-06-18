package com.ruoyi.article.service;

import java.util.List;

import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.article.domain.DormArticle;

/**
 * 个人物品Service接口
 * 
 * @author qqq
 * @date 2022-04-28
 */
public interface IDormArticleService 
{
    /**
     * 查询个人物品
     * 
     * @param id 个人物品主键
     * @return 个人物品
     */
    public DormArticle selectDormArticleById(Long id);

    /**
     * 查询个人物品列表
     * 
     * @param dormArticle 个人物品
     * @return 个人物品集合
     */
    public List<DormArticle> selectDormArticleList(DormArticle dormArticle);

    /**
     * 新增个人物品
     * 
     * @param dormArticle 个人物品
     * @return 结果
     */
    public int insertDormArticle(DormArticle dormArticle);

    /**
     * 修改个人物品
     * 
     * @param dormArticle 个人物品
     * @return 结果
     */
    public int updateDormArticle(DormArticle dormArticle);

    /**
     * 批量删除个人物品
     * 
     * @param ids 需要删除的个人物品主键集合
     * @return 结果
     */
    public int deleteDormArticleByIds(Long[] ids);

    /**
     * 删除个人物品信息
     * 
     * @param id 个人物品主键
     * @return 结果
     */
    public int deleteDormArticleById(Long id);
    /**
     * 导入个人物品信息数据
     *
     * @param dormArticleList 个人物品信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormArticleinfor(List<DormArticle> dormArticleList, Boolean isUpdateSupport, String operName);

    public List<DormArticle>  selectDormArticleByIDnumber(String iDnumber);
}
