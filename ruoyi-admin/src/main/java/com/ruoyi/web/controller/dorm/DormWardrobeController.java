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
import com.ruoyi.wardrobe.domain.DormWardrobe;
import com.ruoyi.wardrobe.service.IDormWardrobeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 柜子信息Controller
 * 
 * @author qqq
 * @date 2022-05-03
 */
@RestController
@RequestMapping("/dorm/wardrobe")
public class DormWardrobeController extends BaseController
{
    @Autowired
    private IDormWardrobeService dormWardrobeService;

    /**
     * 查询柜子信息列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:wardrobe:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormWardrobe dormWardrobe)
    {
        startPage();
        List<DormWardrobe> list = dormWardrobeService.selectDormWardrobeList(dormWardrobe);
        return getDataTable(list);
    }

    /**
     * 导出柜子信息列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:wardrobe:export')")
    @Log(title = "柜子信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormWardrobe dormWardrobe)
    {
        List<DormWardrobe> list = dormWardrobeService.selectDormWardrobeList(dormWardrobe);
        ExcelUtil<DormWardrobe> util = new ExcelUtil<DormWardrobe>(DormWardrobe.class);
        util.exportExcel(response, list, "柜子信息数据");
    }

    /**
     * 获取柜子信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:wardrobe:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormWardrobeService.selectDormWardrobeById(id));
    }

    /**
     * 新增柜子信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:wardrobe:add')")
    @Log(title = "柜子信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormWardrobe dormWardrobe)
    {
        return toAjax(dormWardrobeService.insertDormWardrobe(dormWardrobe));
    }

    /**
     * 修改柜子信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:wardrobe:edit')")
    @Log(title = "柜子信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormWardrobe dormWardrobe)
    {
        return toAjax(dormWardrobeService.updateDormWardrobe(dormWardrobe));
    }

    /**
     * 删除柜子信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:wardrobe:remove')")
    @Log(title = "柜子信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormWardrobeService.deleteDormWardrobeByIds(ids));
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormWardrobe> util = new ExcelUtil<DormWardrobe>(DormWardrobe.class);
        util.importTemplateExcel(response, "柜子数据");
    }

    @Log(title = "柜子管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('dorm:wardrobe:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormWardrobe> util = new ExcelUtil<DormWardrobe>(DormWardrobe.class);
        List<DormWardrobe> dormWardrobeList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormWardrobeService.importDormWardrobe(dormWardrobeList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
