package com.ruoyi.web.controller.dorm;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

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
import com.ruoyi.tune.domain.DormStayRetreatTune;
import com.ruoyi.tune.service.IDormStayRetreatTuneService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 入住调宿退宿申请Controller
 * 
 * @author qqq
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/dorm/tune")
public class DormStayRetreatTuneController extends BaseController
{
    @Autowired
    private IDormStayRetreatTuneService dormStayRetreatTuneService;

    /**
     * 查询入住调宿退宿申请列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:tune:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormStayRetreatTune dormStayRetreatTune)
    {
        startPage();
        List<DormStayRetreatTune> list = dormStayRetreatTuneService.selectDormStayRetreatTuneList(dormStayRetreatTune);
        return getDataTable(list);
    }

    /**
     * 导出入住调宿退宿申请列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:tune:export')")
    @Log(title = "入住调宿退宿申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormStayRetreatTune dormStayRetreatTune)
    {
        List<DormStayRetreatTune> list = dormStayRetreatTuneService.selectDormStayRetreatTuneList(dormStayRetreatTune);
        ExcelUtil<DormStayRetreatTune> util = new ExcelUtil<DormStayRetreatTune>(DormStayRetreatTune.class);
        util.exportExcel(response, list, "入住调宿退宿申请数据");
    }

    /**
     * 获取入住调宿退宿申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:tune:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormStayRetreatTuneService.selectDormStayRetreatTuneById(id));
    }

    /**
     * 新增入住调宿退宿申请
     */
    @PreAuthorize("@ss.hasPermi('dorm:tune:add')")
    @Log(title = "入住调宿退宿申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormStayRetreatTune dormStayRetreatTune)
    {
        return toAjax(dormStayRetreatTuneService.insertDormStayRetreatTune(dormStayRetreatTune));
    }

    /**
     * 修改入住调宿退宿申请
     */
    @PreAuthorize("@ss.hasPermi('dorm:tune:edit')")
    @Log(title = "入住调宿退宿申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormStayRetreatTune dormStayRetreatTune)
    {
        return toAjax(dormStayRetreatTuneService.updateDormStayRetreatTune(dormStayRetreatTune));
    }

    /**
     * 删除入住调宿退宿申请
     */
    @PreAuthorize("@ss.hasPermi('dorm:tune:remove')")
    @Log(title = "入住调宿退宿申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormStayRetreatTuneService.deleteDormStayRetreatTuneByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormStayRetreatTune> util = new ExcelUtil<DormStayRetreatTune>(DormStayRetreatTune.class);
        util.importTemplateExcel(response, "流动数据");
    }

    @Log(title = "流动信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('dorm:tune:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormStayRetreatTune> util = new ExcelUtil<DormStayRetreatTune>(DormStayRetreatTune.class);
        List<DormStayRetreatTune> dormStayRetreatTune = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormStayRetreatTuneService.importDormStayRetreatTune(dormStayRetreatTune, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
