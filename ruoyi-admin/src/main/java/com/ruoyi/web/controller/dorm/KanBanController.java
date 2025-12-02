package com.ruoyi.kanban.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.kanban.domain.KanBan;
import com.ruoyi.kanban.service.IKanBanService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * kbController
 * 
 * @author yara
 * @date 2025-11-18
 */
@RestController
@RequestMapping("/kanban/kanban")
public class KanBanController extends BaseController
{
    @Autowired
    private IKanBanService kanBanService;

    /**
     * 查询kb列表
     */
//    @PreAuthorize("@ss.hasPermi('kanban:kanban:list')")
    @GetMapping("/list")
    public TableDataInfo list(KanBan kanBan)
    {
//        startPage();
        List<KanBan> list = kanBanService.selectKanBanList(kanBan);
        return getDataTable(list);
    }

    /**
     * 导出kb列表
     */
//    @PreAuthorize("@ss.hasPermi('kanban:kanban:export')")
    @Log(title = "kb", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, KanBan kanBan)
    {
        List<KanBan> list = kanBanService.selectKanBanList(kanBan);
        ExcelUtil<KanBan> util = new ExcelUtil<KanBan>(KanBan.class);
        util.exportExcel(response, list, "kb数据");
    }

    /**
     * 获取kb详细信息
     */
//    @PreAuthorize("@ss.hasPermi('kanban:kanban:query')")
    @GetMapping(value = "/{kbid}")
    public AjaxResult getInfo(@PathVariable("kbid") Long kbid)
    {
        return AjaxResult.success(kanBanService.selectKanBanByKbid(kbid));
    }

    /**
     * 新增kb
     */
//    @PreAuthorize("@ss.hasPermi('kanban:kanban:add')")
    @Log(title = "kb", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KanBan kanBan)
    {
        return toAjax(kanBanService.insertKanBan(kanBan));
    }

    /**
     * 修改kb
     */
//    @PreAuthorize("@ss.hasPermi('kanban:kanban:edit')")
    @Log(title = "kb", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KanBan kanBan)
    {
        return toAjax(kanBanService.updateKanBan(kanBan));
    }

    /**
     * 删除kb
     */
//    @PreAuthorize("@ss.hasPermi('kanban:kanban:remove')")
    @Log(title = "kb", businessType = BusinessType.DELETE)
	@DeleteMapping("/{kbids}")
    public AjaxResult remove(@PathVariable Long[] kbids)
    {
        return toAjax(kanBanService.deleteKanBanByKbids(kbids));
    }
}
