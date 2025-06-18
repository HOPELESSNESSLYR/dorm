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
import com.ruoyi.cost.domain.DormHydropwerCost;
import com.ruoyi.cost.service.IDormHydropwerCostService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 个人费用明细Controller
 * 
 * @author qqq
 * @date 2022-05-03
 */
@RestController
@RequestMapping("/feemanage/cost")
public class DormHydropwerCostController extends BaseController
{
    @Autowired
    private IDormHydropwerCostService dormHydropwerCostService;

    /**
     * 查询个人费用明细列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:cost:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormHydropwerCost dormHydropwerCost)
    {
        startPage();
        List<DormHydropwerCost> list = dormHydropwerCostService.selectDormHydropwerCostList(dormHydropwerCost);
        return getDataTable(list);
    }

    /**
     * 导出个人费用明细列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:cost:export')")
    @Log(title = "个人费用明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormHydropwerCost dormHydropwerCost)
    {
        List<DormHydropwerCost> list = dormHydropwerCostService.selectDormHydropwerCostList(dormHydropwerCost);
        ExcelUtil<DormHydropwerCost> util = new ExcelUtil<DormHydropwerCost>(DormHydropwerCost.class);
        util.exportExcel(response, list, "个人费用明细数据");
    }

    /**
     * 获取个人费用明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('feemanage:cost:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormHydropwerCostService.selectDormHydropwerCostById(id));
    }

    /**
     * 新增个人费用明细
     */
    @PreAuthorize("@ss.hasPermi('feemanage:cost:add')")
    @Log(title = "个人费用明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormHydropwerCost dormHydropwerCost)
    {
        return toAjax(dormHydropwerCostService.insertDormHydropwerCost(dormHydropwerCost));
    }

    /**
     * 修改个人费用明细
     */
    @PreAuthorize("@ss.hasPermi('feemanage:cost:edit')")
    @Log(title = "个人费用明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormHydropwerCost dormHydropwerCost)
    {
        return toAjax(dormHydropwerCostService.updateDormHydropwerCost(dormHydropwerCost));
    }

    /**
     * 删除个人费用明细
     */
    @PreAuthorize("@ss.hasPermi('feemanage:cost:remove')")
    @Log(title = "个人费用明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormHydropwerCostService.deleteDormHydropwerCostByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormHydropwerCost> util = new ExcelUtil<DormHydropwerCost>(DormHydropwerCost.class);
        util.importTemplateExcel(response, "个人费用数据");
    }

    @Log(title = "个人费用信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('feemanage:cost:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormHydropwerCost> util = new ExcelUtil<DormHydropwerCost>(DormHydropwerCost.class);
        List<DormHydropwerCost> dormHydropwerCostList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormHydropwerCostService.importDormHydropwerCost(dormHydropwerCostList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
