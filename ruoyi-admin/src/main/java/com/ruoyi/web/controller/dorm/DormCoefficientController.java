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
import com.ruoyi.coefficient.domain.DormCoefficient;
import com.ruoyi.coefficient.service.IDormCoefficientService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 每人天公摊费用Controller
 * 
 * @author qqq
 * @date 2022-05-03
 */
@RestController
@RequestMapping("/feemanage/coefficient")
public class DormCoefficientController extends BaseController
{
    @Autowired
    private IDormCoefficientService dormCoefficientService;

    /**
     * 查询每人天公摊费用列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:coefficient:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormCoefficient dormCoefficient)
    {
        startPage();
        List<DormCoefficient> list = dormCoefficientService.selectDormCoefficientList(dormCoefficient);
        return getDataTable(list);
    }

    /**
     * 导出每人天公摊费用列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:coefficient:export')")
    @Log(title = "每人天公摊费用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormCoefficient dormCoefficient)
    {
        List<DormCoefficient> list = dormCoefficientService.selectDormCoefficientList(dormCoefficient);
        ExcelUtil<DormCoefficient> util = new ExcelUtil<DormCoefficient>(DormCoefficient.class);
        util.exportExcel(response, list, "每人天公摊费用数据");
    }

    /**
     * 获取每人天公摊费用详细信息
     */
    @PreAuthorize("@ss.hasPermi('feemanage:coefficient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormCoefficientService.selectDormCoefficientById(id));
    }

    /**
     * 新增每人天公摊费用
     */
    @PreAuthorize("@ss.hasPermi('feemanage:coefficient:add')")
    @Log(title = "每人天公摊费用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormCoefficient dormCoefficient)
    {
        return toAjax(dormCoefficientService.insertDormCoefficient(dormCoefficient));
    }

    /**
     * 修改每人天公摊费用
     */
    @PreAuthorize("@ss.hasPermi('feemanage:coefficient:edit')")
    @Log(title = "每人天公摊费用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormCoefficient dormCoefficient)
    {
        return toAjax(dormCoefficientService.updateDormCoefficient(dormCoefficient));
    }

    /**
     * 删除每人天公摊费用
     */
    @PreAuthorize("@ss.hasPermi('feemanage:coefficient:remove')")
    @Log(title = "每人天公摊费用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormCoefficientService.deleteDormCoefficientByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormCoefficient> util = new ExcelUtil<DormCoefficient>(DormCoefficient.class);
        util.importTemplateExcel(response, "每人天公摊费用数据");
    }

    @Log(title = "每人天公摊费用信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('feemanage:coefficient:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormCoefficient> util = new ExcelUtil<DormCoefficient>(DormCoefficient.class);
        List<DormCoefficient> dormCoefficientList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormCoefficientService.importDormCoefficient(dormCoefficientList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
