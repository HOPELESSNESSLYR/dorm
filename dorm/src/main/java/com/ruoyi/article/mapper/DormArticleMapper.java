package com.ruoyi.article.mapper;

import java.util.List;
import com.ruoyi.article.domain.DormArticle;

/**
 * 个人物品Mapper接口
 * 
 * @author qqq
 * @date 2022-04-28
 */
public interface DormArticleMapper 
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
     * 删除个人物品
     * 
     * @param id 个人物品主键
     * @return 结果
     */
    public int deleteDormArticleById(Long id);

    /**
     * 批量删除个人物品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormArticleByIds(Long[] ids);

    public List<DormArticle>  selectDormArticleByIDnumber(String iDnumber);
}
