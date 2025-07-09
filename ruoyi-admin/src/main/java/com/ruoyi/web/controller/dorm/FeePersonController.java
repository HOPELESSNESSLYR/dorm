package com.ruoyi.web.controller.dorm;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.feeconfig.domain.FeeConfig;
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
import com.ruoyi.feeperson.domain.FeePerson;
import com.ruoyi.feeperson.service.IFeePersonService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 个人费用Controller
 * 
 * @author lyr
 * @date 2025-07-01
 */
@RestController
@RequestMapping("/fee/person")
public class FeePersonController extends BaseController
{
    @Autowired
    private IFeePersonService feePersonService;

    /**
     * 查询个人费用列表
     */
    @PreAuthorize("@ss.hasPermi('fee:person:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeePerson feePerson)
    {
        startPage();
        List<FeePerson> list = feePersonService.selectFeePersonList(feePerson);
        return getDataTable(list);
    }

    /**
     * 导出个人费用列表
     */
    @PreAuthorize("@ss.hasPermi('fee:person:export')")
    @Log(title = "个人费用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FeePerson feePerson)
    {
        List<FeePerson> list = feePersonService.selectFeePersonList(feePerson);
        ExcelUtil<FeePerson> util = new ExcelUtil<FeePerson>(FeePerson.class);
        util.exportExcel(response, list, "个人费用数据");
    }

    /**
     * 获取个人费用详细信息
     */
    @PreAuthorize("@ss.hasPermi('fee:person:query')")
    @GetMapping(value = "/{feepersonId}")
    public AjaxResult getInfo(@PathVariable("feepersonId") Long feepersonId)
    {
        return AjaxResult.success(feePersonService.selectFeePersonByFeepersonId(feepersonId));
    }

    /**
     * 新增个人费用
     */
    @PreAuthorize("@ss.hasPermi('fee:person:add')")
    @Log(title = "个人费用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeePerson feePerson)
    {
        return toAjax(feePersonService.insertFeePerson(feePerson));
    }

    /**
     * 修改个人费用
     */
    @PreAuthorize("@ss.hasPermi('fee:person:edit')")
    @Log(title = "个人费用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeePerson feePerson)
    {
        return toAjax(feePersonService.updateFeePerson(feePerson));
    }

    /**
     * 删除个人费用
     */
    @PreAuthorize("@ss.hasPermi('fee:person:remove')")
    @Log(title = "个人费用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{feepersonIds}")
    public AjaxResult remove(@PathVariable Long[] feepersonIds)
    {
        return toAjax(feePersonService.deleteFeePersonByFeepersonIds(feepersonIds));
    }


    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<FeePerson> util = new ExcelUtil<FeePerson>(FeePerson.class);
        util.importTemplateExcel(response, "个人费用数据");
    }
    /**
     * 导入费用配置
     */
    @Log(title = "个人费用", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('fee:person:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<FeePerson> util = new ExcelUtil<FeePerson>(FeePerson.class);
        List<FeePerson> feeConfigList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = feePersonService.importFeePerson(feeConfigList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
