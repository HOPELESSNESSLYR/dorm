package com.ruoyi.web.controller.dorm;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.DormBed.domain.DormBed;
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
import com.ruoyi.fixedassets.domain.DormFixedassets;
import com.ruoyi.fixedassets.service.IDormFixedassetsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 宿舍固定资产Controller
 * 
 * @author qqq
 * @date 2022-05-03
 */
@RestController
@RequestMapping("/feemanage/fixedassets")
public class DormFixedassetsController extends BaseController
{
    @Autowired
    private IDormFixedassetsService dormFixedassetsService;

    /**
     * 查询宿舍固定资产列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:fixedassets:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormFixedassets dormFixedassets)
    {
        startPage();
        List<DormFixedassets> list = dormFixedassetsService.selectDormFixedassetsList(dormFixedassets);
        return getDataTable(list);
    }

    /**
     * 导出宿舍固定资产列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:fixedassets:export')")
    @Log(title = "宿舍固定资产", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormFixedassets dormFixedassets)
    {
        List<DormFixedassets> list = dormFixedassetsService.selectDormFixedassetsList(dormFixedassets);
        ExcelUtil<DormFixedassets> util = new ExcelUtil<DormFixedassets>(DormFixedassets.class);
        util.exportExcel(response, list, "宿舍固定资产数据");
    }

    /**
     * 获取宿舍固定资产详细信息
     */
    @PreAuthorize("@ss.hasPermi('feemanage:fixedassets:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormFixedassetsService.selectDormFixedassetsById(id));
    }

    /**
     * 新增宿舍固定资产
     */
    @PreAuthorize("@ss.hasPermi('feemanage:fixedassets:add')")
    @Log(title = "宿舍固定资产", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormFixedassets dormFixedassets)
    {
        return toAjax(dormFixedassetsService.insertDormFixedassets(dormFixedassets));
    }

    /**
     * 修改宿舍固定资产
     */
    @PreAuthorize("@ss.hasPermi('feemanage:fixedassets:edit')")
    @Log(title = "宿舍固定资产", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormFixedassets dormFixedassets)
    {
        return toAjax(dormFixedassetsService.updateDormFixedassets(dormFixedassets));
    }

    /**
     * 删除宿舍固定资产
     */
    @PreAuthorize("@ss.hasPermi('feemanage:fixedassets:remove')")
    @Log(title = "宿舍固定资产", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormFixedassetsService.deleteDormFixedassetsByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormFixedassets> util = new ExcelUtil<DormFixedassets>(DormFixedassets.class);
        util.importTemplateExcel(response, "宿舍固定资产数据");
    }

    @Log(title = "宿舍固定资产信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('feemanage:fixedassets:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormFixedassets> util = new ExcelUtil<DormFixedassets>(DormFixedassets.class);
        List<DormFixedassets> dormFixedassetsList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormFixedassetsService.importDormFixedassets(dormFixedassetsList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
