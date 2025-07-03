package com.ruoyi.web.controller.dorm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.room.domain.DormRoominfor;
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
import com.ruoyi.feeconfig.domain.FeeConfig;
import com.ruoyi.feeconfig.service.IFeeConfigService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 费用配置Controller
 * 
 * @author lyr
 * @date 2025-07-01
 */
@RestController
@RequestMapping("/fee/config")
public class FeeConfigController extends BaseController
{
    @Autowired
    private IFeeConfigService feeConfigService;

    /**
     * 查询费用配置列表
     */
    @PreAuthorize("@ss.hasPermi('fee:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeeConfig feeConfig)
    {
        startPage();
        List<FeeConfig> list = feeConfigService.selectFeeConfigList(feeConfig);
        return getDataTable(list);
    }

    /**
     * 导出费用配置列表
     */
    @PreAuthorize("@ss.hasPermi('fee:config:export')")
    @Log(title = "费用配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FeeConfig feeConfig)
    {
        List<FeeConfig> list = feeConfigService.selectFeeConfigList(feeConfig);
        ExcelUtil<FeeConfig> util = new ExcelUtil<FeeConfig>(FeeConfig.class);
        util.exportExcel(response, list, "费用配置数据");
    }

    /**
     * 获取费用配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('fee:config:query')")
    @GetMapping(value = "/{congifId}")
    public AjaxResult getInfo(@PathVariable("congifId") Long congifId)
    {
        return AjaxResult.success(feeConfigService.selectFeeConfigByCongifId(congifId));
    }

    /**
     * 新增费用配置
     */
    @PreAuthorize("@ss.hasPermi('fee:config:add')")
    @Log(title = "费用配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeeConfig feeConfig)
    {
//        Date date = new Date(String.valueOf(feeConfig.getNianyue()));
//        System.out.println(date);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//        System.out.println(sdf.format(date));
//        feeConfig.setNianyue(sdf.format(date));
//        log.info("{}",feeConfig);
        return toAjax(feeConfigService.insertFeeConfig(feeConfig));
    }

    /**
     * 修改费用配置
     */
    @PreAuthorize("@ss.hasPermi('fee:config:edit')")
    @Log(title = "费用配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeeConfig feeConfig)
    {
        return toAjax(feeConfigService.updateFeeConfig(feeConfig));
    }

    /**
     * 删除费用配置
     */
    @PreAuthorize("@ss.hasPermi('fee:config:remove')")
    @Log(title = "费用配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{congifIds}")
    public AjaxResult remove(@PathVariable Long[] congifIds)
    {
        return toAjax(feeConfigService.deleteFeeConfigByCongifIds(congifIds));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<FeeConfig> util = new ExcelUtil<FeeConfig>(FeeConfig.class);
        util.importTemplateExcel(response, "费用配置数据");
    }
    /**
     * 导入费用配置
     */
    @Log(title = "费用配置", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('fee:config:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<FeeConfig> util = new ExcelUtil<FeeConfig>(FeeConfig.class);
        List<FeeConfig> feeConfigList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = feeConfigService.importFeeConfig(feeConfigList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
