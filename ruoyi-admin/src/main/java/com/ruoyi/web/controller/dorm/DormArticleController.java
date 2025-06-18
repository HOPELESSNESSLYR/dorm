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
import com.ruoyi.article.domain.DormArticle;
import com.ruoyi.article.service.IDormArticleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 个人物品Controller
 * 
 * @author qqq
 * @date 2022-04-28
 */
@RestController
@RequestMapping("/dorm/article")
public class DormArticleController extends BaseController
{
    @Autowired
    private IDormArticleService dormArticleService;

    /**
     * 查询个人物品列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormArticle dormArticle)
    {
        startPage();
        List<DormArticle> list = dormArticleService.selectDormArticleList(dormArticle);
        return getDataTable(list);
    }

    /**
     * 导出个人物品列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:article:export')")
    @Log(title = "个人物品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormArticle dormArticle)
    {
        List<DormArticle> list = dormArticleService.selectDormArticleList(dormArticle);
        ExcelUtil<DormArticle> util = new ExcelUtil<DormArticle>(DormArticle.class);
        util.exportExcel(response, list, "个人物品数据");
    }

    /**
     * 获取个人物品详细信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:article:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormArticleService.selectDormArticleById(id));
    }

    /**
     * 新增个人物品
     */
    @PreAuthorize("@ss.hasPermi('dorm:article:add')")
    @Log(title = "个人物品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormArticle dormArticle)
    {
        return toAjax(dormArticleService.insertDormArticle(dormArticle));
    }

    /**
     * 修改个人物品
     */
    @PreAuthorize("@ss.hasPermi('dorm:article:edit')")
    @Log(title = "个人物品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormArticle dormArticle)
    {
        return toAjax(dormArticleService.updateDormArticle(dormArticle));
    }

    /**
     * 删除个人物品
     */
    @PreAuthorize("@ss.hasPermi('dorm:article:remove')")
    @Log(title = "个人物品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormArticleService.deleteDormArticleByIds(ids));
    }
    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormArticle> util = new ExcelUtil<DormArticle>(DormArticle.class);
        util.importTemplateExcel(response, "个人物品数据");
    }

    @Log(title = "个人物品信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('dorm:article:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormArticle> util = new ExcelUtil<DormArticle>(DormArticle.class);
        List<DormArticle> dormArticleList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormArticleService.importDormArticleinfor(dormArticleList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
