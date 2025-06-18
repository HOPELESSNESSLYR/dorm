package com.ruoyi.dorm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dorm.mapper.DormSslmanageMapper;
import com.ruoyi.dorm.domain.DormSslmanage;
import com.ruoyi.dorm.service.IDormSslmanageService;

/**
 * 宿舍楼信息Service业务层处理
 * 
 * @author qqq
 * @date 2022-04-07
 */
@Service
public class DormSslmanageServiceImpl implements IDormSslmanageService 
{
    @Autowired
    private DormSslmanageMapper dormSslmanageMapper;

    /**
     * 查询宿舍楼信息
     * 
     * @param id 宿舍楼信息主键
     * @return 宿舍楼信息
     */
    @Override
    public DormSslmanage selectDormSslmanageById(Long id)
    {
        return dormSslmanageMapper.selectDormSslmanageById(id);
    }

    /**
     * 查询宿舍楼信息列表
     * 
     * @param dormSslmanage 宿舍楼信息
     * @return 宿舍楼信息
     */
    @Override
    public List<DormSslmanage> selectDormSslmanageList(DormSslmanage dormSslmanage)
    {
        return dormSslmanageMapper.selectDormSslmanageList(dormSslmanage);
    }

    /**
     * 新增宿舍楼信息
     * 
     * @param dormSslmanage 宿舍楼信息
     * @return 结果
     */
    @Override
    public int insertDormSslmanage(DormSslmanage dormSslmanage)
    {
        return dormSslmanageMapper.insertDormSslmanage(dormSslmanage);
    }

    /**
     * 修改宿舍楼信息
     * 
     * @param dormSslmanage 宿舍楼信息
     * @return 结果
     */
    @Override
    public int updateDormSslmanage(DormSslmanage dormSslmanage)
    {
        return dormSslmanageMapper.updateDormSslmanage(dormSslmanage);
    }

    /**
     * 批量删除宿舍楼信息
     * 
     * @param ids 需要删除的宿舍楼信息主键
     * @return 结果
     */
    @Override
    public int deleteDormSslmanageByIds(Long[] ids)
    {
        return dormSslmanageMapper.deleteDormSslmanageByIds(ids);
    }

    /**
     * 删除宿舍楼信息信息
     * 
     * @param id 宿舍楼信息主键
     * @return 结果
     */
    @Override
    public int deleteDormSslmanageById(Long id)
    {
        return dormSslmanageMapper.deleteDormSslmanageById(id);
    }
}
