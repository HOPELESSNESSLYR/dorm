package com.ruoyi.wardrobe.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.wardrobe.domain.DormWardrobe;

/**
 * 柜子信息Mapper接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface DormWardrobeMapper 
{
    /**
     * 查询柜子信息
     * 
     * @param id 柜子信息主键
     * @return 柜子信息
     */
    public DormWardrobe selectDormWardrobeById(Long id);

    /**
     * 查询柜子信息列表
     * 
     * @param dormWardrobe 柜子信息
     * @return 柜子信息集合
     */
    public List<DormWardrobe> selectDormWardrobeList(DormWardrobe dormWardrobe);

    /**
     * 新增柜子信息
     * 
     * @param dormWardrobe 柜子信息
     * @return 结果
     */
    public int insertDormWardrobe(DormWardrobe dormWardrobe);

    /**
     * 修改柜子信息
     * 
     * @param dormWardrobe 柜子信息
     * @return 结果
     */
    public int updateDormWardrobe(DormWardrobe dormWardrobe);

    /**
     * 删除柜子信息
     * 
     * @param id 柜子信息主键
     * @return 结果
     */
    public int deleteDormWardrobeById(Long id);

    /**
     * 批量删除柜子信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormWardrobeByIds(Long[] ids);

    public DormWardrobe selectDormWardrobeBymap(Map<String, String> wmap);

    public DormWardrobe selectDormWardrobeByJobnumber(String jobnumber);
}
