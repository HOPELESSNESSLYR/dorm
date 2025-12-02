package com.ruoyi.kanban.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kanban.mapper.KanBanMapper;
import com.ruoyi.kanban.domain.KanBan;
import com.ruoyi.kanban.service.IKanBanService;

/**
 * kbService业务层处理
 * 
 * @author yara
 * @date 2025-11-18
 */
@Service
public class KanBanServiceImpl implements IKanBanService 
{
    @Autowired
    private KanBanMapper kanBanMapper;

    /**
     * 查询kb
     * 
     * @param kbid kb主键
     * @return kb
     */
    @Override
    public KanBan selectKanBanByKbid(Long kbid)
    {
        return kanBanMapper.selectKanBanByKbid(kbid);
    }

    /**
     * 查询kb列表
     * 
     * @param kanBan kb
     * @return kb
     */
    @Override
    public List<KanBan> selectKanBanList(KanBan kanBan)
    {
        return kanBanMapper.selectKanBanList(kanBan);
    }

    /**
     * 新增kb
     * 
     * @param kanBan kb
     * @return 结果
     */
    @Override
    public int insertKanBan(KanBan kanBan)
    {
        return kanBanMapper.insertKanBan(kanBan);
    }

    /**
     * 修改kb
     * 
     * @param kanBan kb
     * @return 结果
     */
    @Override
    public int updateKanBan(KanBan kanBan)
    {
        return kanBanMapper.updateKanBan(kanBan);
    }

    /**
     * 批量删除kb
     * 
     * @param kbids 需要删除的kb主键
     * @return 结果
     */
    @Override
    public int deleteKanBanByKbids(Long[] kbids)
    {
        return kanBanMapper.deleteKanBanByKbids(kbids);
    }

    /**
     * 删除kb信息
     * 
     * @param kbid kb主键
     * @return 结果
     */
    @Override
    public int deleteKanBanByKbid(Long kbid)
    {
        return kanBanMapper.deleteKanBanByKbid(kbid);
    }
}
