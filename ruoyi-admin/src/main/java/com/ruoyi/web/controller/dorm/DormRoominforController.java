package com.ruoyi.web.controller.dorm;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletResponse;

//import com.ruoyi.common.utils.Convert;
//import net.sf.json.JSONObject;
import cn.hutool.json.XML;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.DormBed.service.IDormBedService;
import com.ruoyi.area.service.IDormAreaService;
import com.ruoyi.article.domain.DormArticle;
import com.ruoyi.article.service.IDormArticleService;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.livepeople.domain.DormLivepeople;
import com.ruoyi.livepeople.service.IDormLivepeopleService;
import com.ruoyi.off.domain.DormLeaveOff;
import com.ruoyi.off.service.IDormLeaveOffService;
import com.ruoyi.onlivepeople.domain.DormOnlivepeople;
import com.ruoyi.onlivepeople.service.IDormOnlivepeopleService;
import com.ruoyi.tune.domain.DormStayRetreatTune;
import com.ruoyi.tune.service.IDormStayRetreatTuneService;
import com.ruoyi.wardrobe.domain.DormWardrobe;
import com.ruoyi.wardrobe.service.IDormWardrobeService;
import org.apache.commons.io.IOUtils;
//import org.dom4j.Document;
//import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.http.RequestEntity;
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
import com.ruoyi.room.domain.DormRoominfor;
import com.ruoyi.room.service.IDormRoominforService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
//import sun.net.www.http.HttpClient;
//import weaver.conn.RecordSet;
//import weaver.general.Util;
//import com.sap.mw.jco.IFunctionTemplate;
//import com.sap.mw.jco.JCO;
//import com.sap.mw.jco.JCO.Client;
//import com.sap.mw.jco.JCO.Function;
//import com.sap.mw.jco.JCO.ParameterList;
//import com.sap.mw.jco.JCO.Repository;
//import com.sap.mw.jco.JCO.Structure;
//import com.sap.mw.jco.JCO.Table;


import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;
import org.xml.sax.InputSource;

/**
 * 房间信息Controller
 * 
 * @author qqq
 * @date 2022-04-13
 * @author yara
 * @date 2025-06-10，12
 *
 */
@RestController
@RequestMapping("/dorm/roominfor")
public class DormRoominforController extends BaseController
{
    @Autowired
    private IDormRoominforService dormRoominforService;
    @Autowired
    private IDormAreaService dormAreaService;
    @Autowired
    private IDormOnlivepeopleService dormOnlivepeopleService;
    @Autowired
    private IDormStayRetreatTuneService dormStayRetreatTuneService;
    @Autowired
    private IDormBedService dormBedService;
    @Autowired
    private IDormLivepeopleService dormLivepeopleService;
    @Autowired
    private IDormArticleService dormArticleService;
    @Autowired
    private IDormLeaveOffService dormLeaveOffService;
    @Autowired
    private IDormWardrobeService dormWardrobeService;
    /**
     * 查询房间信息列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormRoominfor dormRoominfor)
    {
        startPage();
        List<DormRoominfor> list = dormRoominforService.selectDormRoominforList(dormRoominfor);
        return getDataTable(list);
    }

    /**
     * 导出房间信息列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:export')")
    @Log(title = "房间信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormRoominfor dormRoominfor)
    {
        List<DormRoominfor> list = dormRoominforService.selectDormRoominforList(dormRoominfor);
        ExcelUtil<DormRoominfor> util = new ExcelUtil<DormRoominfor>(DormRoominfor.class);
        util.exportExcel(response, list, "房间信息数据");
    }

    /**
     * 获取房间信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormRoominforService.selectDormRoominforById(id));
    }

    /**
     * 新增房间信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:add')")
    @Log(title = "房间信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormRoominfor dormRoominfor)
    {
        return toAjax(dormRoominforService.insertDormRoominfor(dormRoominfor));
    }

    /**
     * 修改房间信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:edit')")
    @Log(title = "房间信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormRoominfor dormRoominfor)
    {
        return toAjax(dormRoominforService.updateDormRoominfor(dormRoominfor));
    }

    /**
     * 批量修改房间信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:edits')")
    @Log(title = "房间信息", businessType = BusinessType.UPDATE)
    @PutMapping("/batchUpdate")
    public AjaxResult batchUpdate(@RequestBody Map<String, Object> params) {
        // 获取ids数组并转换为Long[]
        List<Integer> idList = (List<Integer>) params.get("ids");
        Long[] ids = idList.stream()
                          .map(Long::valueOf)
                          .toArray(Long[]::new);
        
        DormRoominfor dormRoominfor = new DormRoominfor();
        // 性别转换：男=1，女=0
        String sex = (String) params.get("roomSex");
        dormRoominfor.setRoomSex(sex != null ? ("男".equals(sex) ? 1L : 0L) : null);
        // 房间类型直接设置字符串
        dormRoominfor.setRoomType(params.get("roomType") != null ? params.get("roomType").toString() : null);
        
        return toAjax(dormRoominforService.batchUpdate(ids, dormRoominfor));
    }

    /**
     * 删除房间信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:remove')")
    @Log(title = "房间信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormRoominforService.deleteDormRoominforByIds(ids));
    }

    /**
     * 入住确认
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:ruzhuconfirm')")
    @PostMapping(value = "/ruzhuConfirm")
    public AjaxResult ruzhuConfirm(@RequestBody JSONObject data)
    {
        Long id = data.getLong("rowid");
        DormRoominfor dormRoominfor = dormRoominforService.selectDormRoominforById(id);
        String IDnumber = data.getString("IDnumber");
        DormOnlivepeople dormonlivepeople = dormOnlivepeopleService.selectDormOnlivepeopleByIDnumber(IDnumber);
        List<DormLivepeople> dormLivepeopleList = dormLivepeopleService.selectDormLivepeopleListByIDnumber(IDnumber);
        DormLivepeople dormLivepeople;
        boolean isinsert=true;
        if(dormLivepeopleList.size()==0){
            dormLivepeople = new DormLivepeople();
        }else{
            dormLivepeople = dormLivepeopleList.get(0);
            isinsert=false;
        }


        String bednumber = data.getString("bednumber");
        Map<String,String> map = new HashMap<>();
        map.put("area_number",dormRoominfor.getAreaNumber());
        map.put("floor_number",dormRoominfor.getFloorNumber());
        map.put("dorm_floor",dormRoominfor.getDormFloor().toString());
        map.put("room_number",dormRoominfor.getRoomNumber());
        map.put("bednumber",data.getString("bednumber"));
        DormBed dormBed = dormBedService.selectDormBedByMap(map);
        List<DormBed> dormBed1 = dormBedService.selectDormBedByIDnumber2(IDnumber);
        //这里调取HCM的接口拿到具体人员信息数据
//        String authenticationUrl = "http://119.13.89.192:8811/sap/bc/srt/wsdl/flv_10002A101AD1/bndg_url/sap/bc/srt/rfc/sap/zhr_o_employee_informationws/800/zhr_o_employee_informationws/zhr_o_employee_informationws?sap-client=800";
        String authenticationUrl = "http://172.16.14.118:8811/sap/bc/srt/rfc/sap/zhr_o_employee_informationws/800/zhr_o_employee_informationws/zhr_o_employee_informationws";
        try {
            //httpConnSap(authenticationUrl,"L20891","882158",IDnumber);
            // HttpClient发送SOAP请求
            int timeout = 10000;
            System.out.println("HttpClient 发送SOAP请求");
            HttpClient client = new HttpClient();
            //如果需要用户名密码验证；不需要验证登录则不需要以下4行
            UsernamePasswordCredentials creds = new UsernamePasswordCredentials("L20891", "882158");
            client.getState().setCredentials(AuthScope.ANY, creds);
            //webservice 地址
            PostMethod postMethod = new PostMethod(authenticationUrl);
            // 设置连接超时
            client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
            // 设置读取时间超时
            client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
            // 然后把Soap请求数据添加到PostMethod中
            org.apache.commons.httpclient.methods.RequestEntity requestEntity = new StringRequestEntity(getXML(IDnumber),"text/xml", "UTF-8");

            // 设置请求头部，否则可能会报 "no SOAPAction header" 的错误
            postMethod.setRequestHeader("SOAPAction", "");
            // 设置请求体
            postMethod.setRequestEntity(requestEntity);
            int status = client.executeMethod(postMethod);
            if (status == 200) {// 成功
                InputStream is = postMethod.getResponseBodyAsStream();
                // 获取请求结果字符串
                String result = IOUtils.toString(is);
                System.out.println("请求成功！"+"\n"+"返回结果:"+result);
                Document document = strXmlToDocument(result);
                String jobnumber = getValueByElementName(document, "PERNR");
                System.out.println(jobnumber);
                String department2 = getValueByElementName(document,"ZTWO_STEXT");
                String department3 =getValueByElementName(document,"ZTHREE_STEXT");
                String phone = getValueByElementName(document,"TEL");
                String job = getValueByElementName(document,"ZPLANS_TEXT");
                //房间住人数量增加
                if(dormRoominfor.getPeoplenumber()>=dormRoominfor.getLivenumber()){
                    return AjaxResult.success("入住失败，房间已满");
                }else if(dormBed1.size()>=1){
                    return AjaxResult.success("入住失败，已入住，区域："+dormBed1.get(0).getAreaNumber()+" 房间号："+dormBed1.get(0).getRoomNumber());
                }
                dormRoominfor.setPeoplenumber(dormRoominfor.getPeoplenumber()+1);
                dormRoominfor.setRemainnumber(dormRoominfor.getLivenumber()-dormRoominfor.getPeoplenumber());
                dormRoominforService.updateDormRoominfor(dormRoominfor);
                //更新onlivepeople这张表
                dormonlivepeople.setFlag("1");
                dormOnlivepeopleService.updateDormOnlivepeople(dormonlivepeople);
                //先新增dorm_livepeople这张表
                if(isinsert){
                    dormLivepeople.setAreaNumber(dormRoominfor.getAreaNumber());
                    dormLivepeople.setFloorNumber(dormRoominfor.getFloorNumber());
                    dormLivepeople.setDormFloor(dormRoominfor.getDormFloor().toString());
                    dormLivepeople.setRoomNumber(dormRoominfor.getRoomNumber());
                    dormLivepeople.setCheckInaddress(dormRoominfor.getAreaNumber()+"-"+dormRoominfor.getFloorNumber()+"-"+dormRoominfor.getDormFloor().toString()+"-"+dormRoominfor.getRoomNumber()+"-"+bednumber);
                    dormLivepeople.setName(dormonlivepeople.getName());
                    dormLivepeople.setIdnumber(IDnumber);
                    dormLivepeople.setJobnumber(jobnumber);
                    dormLivepeople.setSex(dormonlivepeople.getSex().replace("\\s*|\r|\n|\t","").equals("男") ? 1L : 0L);
                    dormLivepeople.setDepartment2(department2);
                    dormLivepeople.setDepartment3(department3);
                    dormLivepeople.setJob(job);
                    dormLivepeople.setLocation(dormonlivepeople.getAddress());
                    dormLivepeople.setAddress(dormonlivepeople.getAddress());
                    dormLivepeople.setPhone(phone);
                    dormLivepeople.setReason("入住");
                    dormLivepeople.setLivecheck("X");
                    dormLivepeople.setLivedate(new Date());
                    dormLivepeople.setBednumber(bednumber);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd");
                    dormLivepeople.setPhoto("/profile/upload/images/"+dormLivepeople.getName()+"_"+dormLivepeople.getIdnumber()+".bmp");
                    dormLivepeopleService.insertDormLivepeople(dormLivepeople);
                }else{
                    dormLivepeople.setAreaNumber(dormRoominfor.getAreaNumber());
                    dormLivepeople.setFloorNumber(dormRoominfor.getFloorNumber());
                    dormLivepeople.setDormFloor(dormRoominfor.getDormFloor().toString());
                    dormLivepeople.setRoomNumber(dormRoominfor.getRoomNumber());
                    dormLivepeople.setCheckInaddress(dormRoominfor.getAreaNumber()+"-"+dormRoominfor.getFloorNumber()+"-"+dormRoominfor.getDormFloor().toString()+"-"+dormRoominfor.getRoomNumber()+"-"+bednumber);
                    dormLivepeople.setName(dormonlivepeople.getName());
                    dormLivepeople.setIdnumber(IDnumber);
                    dormLivepeople.setJobnumber(jobnumber);
                    dormLivepeople.setSex(dormonlivepeople.getSex().replace("\\s*|\r|\n|\t","").equals("男") ? 1L : 0L);
                    dormLivepeople.setDepartment2(department2);
                    dormLivepeople.setDepartment3(department3);
                    dormLivepeople.setJob(job);
                    dormLivepeople.setLocation(dormonlivepeople.getAddress());
                    dormLivepeople.setAddress(dormonlivepeople.getAddress());
                    dormLivepeople.setPhone(phone);
                    dormLivepeople.setReason("入住");
                    dormLivepeople.setLivecheck("X");
                    dormLivepeople.setLivedate(new Date());
                    dormLivepeople.setBednumber(bednumber);
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
                    SimpleDateFormat sdf2 = new SimpleDateFormat("MM");
                    SimpleDateFormat sdf3 = new SimpleDateFormat("dd");
                    dormLivepeople.setPhoto("/profile/upload/images/"+dormLivepeople.getName()+"_"+dormLivepeople.getIdnumber()+".bmp");
                    dormLivepeopleService.updateDormLivepeople(dormLivepeople);
                }


                //入住床位
                dormBed.setName(dormonlivepeople.getName());
                dormBed.setIdnumber(IDnumber);
                dormBed.setSex(dormLivepeople.getSex().toString());
                dormBed.setJobnumber(dormLivepeople.getJobnumber());
                dormBed.setDepartment1(dormLivepeople.getDepartment1());
                dormBed.setDepartment2(dormLivepeople.getDepartment2());
                dormBed.setDepartment3(dormLivepeople.getDepartment3());
                dormBed.setJob(dormLivepeople.getJob());
                dormBed.setPhone(dormLivepeople.getPhone());
                dormBed.setBedstatus(1L);
                dormBed.setCheckInwhether(1L);
                dormBedService.updateDormBed(dormBed);
                //新增流转信息
                DormStayRetreatTune tunelist = new DormStayRetreatTune();
                tunelist.setAreaNumber(dormRoominfor.getAreaNumber());
                tunelist.setFloorNumber(dormRoominfor.getFloorNumber());
                tunelist.setDormFloor(dormRoominfor.getDormFloor().toString());
                tunelist.setRoomNumber(dormRoominfor.getRoomNumber());
                tunelist.setIdnumber(IDnumber);
                tunelist.setJobnumber(jobnumber);
                tunelist.setName(dormonlivepeople.getName());
                tunelist.setDepartment2(department2);
                tunelist.setDepartment3(department3);
                tunelist.setJob(job);
                tunelist.setSex(dormonlivepeople.getSex().replace("\\s*|\r|\n|\t","").equals("男") ? "1" : "0");
                tunelist.setPhone(phone);
                tunelist.setLocation(dormLivepeople.getLocation());
                tunelist.setAddress(dormLivepeople.getAddress());
                tunelist.setType(1L);//类别0:退宿:1:入住2:调宿
                tunelist.setApplyDate(new Date());
                tunelist.setBednumber(bednumber);
                Long Wardrobe =0L;
                if(dormLivepeople.getWardrobe()!=null && !dormLivepeople.getWardrobe().equals("")){
                    Wardrobe = Long.parseLong(dormLivepeople.getWardrobe());
                }
                tunelist.setWardrobe(Wardrobe);
                tunelist.setReason("入住");
                tunelist.setLivedate(dormLivepeople.getLivedate());
                //unelist.setRetreatdate(new Date(0L));
                tunelist.setEmergencycontact(dormLivepeople.getEmergencycontact());
                tunelist.setEmergencyphone(dormLivepeople.getEmergencyphone());
                tunelist.setRelationship(dormLivepeople.getRelationship());
                tunelist.setAdminname(SecurityUtils.getUsername());
                tunelist.setApplyname(dormonlivepeople.getName());
                tunelist.setHcmupdate("X");
                dormStayRetreatTuneService.insertDormStayRetreatTune(tunelist);
                //新增物品表
                DormArticle dormArticle = new DormArticle();
                dormArticle.setAreaNumber(dormRoominfor.getAreaNumber());
                dormArticle.setFloorNumber(dormRoominfor.getFloorNumber());
                dormArticle.setRoomNumber(dormRoominfor.getRoomNumber());
                dormArticle.setName(dormonlivepeople.getName());
                dormArticle.setJobnumber(jobnumber);
                dormArticle.setIdnnumber(IDnumber);
                dormArticle.setAreaNumber(dormRoominfor.getAreaNumber());
                dormArticle.setBednumber(Long.parseLong(bednumber));
                dormArticle.setArticleNumber("0");//钥匙
                dormArticle.setArticleDescription("钥匙");
                dormArticle.setRequstQuantity(data.getLong("keynumber"));
                dormArticleService.insertDormArticle(dormArticle);
                //修改柜子表
                Map<String,String> Wmap = new HashMap<>();
                Wmap.put("area_number",dormRoominfor.getAreaNumber());
                Wmap.put("floor_number",dormRoominfor.getFloorNumber());
                Wmap.put("dorm_floor",dormRoominfor.getDormFloor().toString());
                Wmap.put("room_number",dormRoominfor.getRoomNumber());
                Wmap.put("wardrobe", data.getString("wardrobe"));
                DormWardrobe dormWardrobe = dormWardrobeService.selectDormWardrobeBymap(Wmap);
                dormWardrobe.setName(dormonlivepeople.getName());
                dormWardrobe.setJobnumber(jobnumber);
                dormWardrobe.setWhether(1L);
                dormWardrobeService.updateDormWardrobe(dormWardrobe);



                return AjaxResult.success("入住成功");
            } else {
                System.out.println("请求失败！"+"\n"+"错误代码："+status+"\n"+"返回报文:"+"\n"+postMethod.getResponseBodyAsString());
                //房间住人数量增加
                if(dormRoominfor.getPeoplenumber()>=dormRoominfor.getLivenumber()){
                    return AjaxResult.success("入住失败，房间已满");
                }else if(dormBed1.size()>=1){
                    return AjaxResult.success("入住失败，已有床位："+dormBed1.get(0).getBednumber());
                }
                dormRoominfor.setPeoplenumber(dormRoominfor.getPeoplenumber()+1);
                dormRoominfor.setRemainnumber(dormRoominfor.getLivenumber()-dormRoominfor.getPeoplenumber());
                dormRoominforService.updateDormRoominfor(dormRoominfor);
                //更新onlivepeople这张表
                dormonlivepeople.setFlag("1");
                dormOnlivepeopleService.updateDormOnlivepeople(dormonlivepeople);
                //先新增dorm_livepeople这张表
                if(isinsert){
                    dormLivepeople.setAreaNumber(dormRoominfor.getAreaNumber());
                    dormLivepeople.setFloorNumber(dormRoominfor.getFloorNumber());
                    dormLivepeople.setDormFloor(dormRoominfor.getDormFloor().toString());
                    dormLivepeople.setRoomNumber(dormRoominfor.getRoomNumber());
                    dormLivepeople.setCheckInaddress(dormRoominfor.getAreaNumber()+"-"+dormRoominfor.getFloorNumber()+"-"+dormRoominfor.getDormFloor().toString()+"-"+dormRoominfor.getRoomNumber()+"-"+bednumber);
                    dormLivepeople.setName(dormonlivepeople.getName());
                    dormLivepeople.setIdnumber(IDnumber);
                    dormLivepeople.setJobnumber("");
                    dormLivepeople.setSex(dormonlivepeople.getSex().replace("\\s*|\r|\n|\t","").equals("男") ? 1L : 0L);
                    dormLivepeople.setDepartment2("");
                    dormLivepeople.setDepartment3("");
                    dormLivepeople.setJob("");
                    dormLivepeople.setLocation(dormonlivepeople.getAddress());
                    dormLivepeople.setAddress(dormonlivepeople.getAddress());
                    dormLivepeople.setPhone("");
                    dormLivepeople.setReason("入住");
                    dormLivepeople.setLivecheck("X");
                    dormLivepeople.setLivedate(new Date());
                    dormLivepeople.setBednumber(bednumber);
                    dormLivepeopleService.insertDormLivepeople(dormLivepeople);
                }else{
                    dormLivepeople.setAreaNumber(dormRoominfor.getAreaNumber());
                    dormLivepeople.setFloorNumber(dormRoominfor.getFloorNumber());
                    dormLivepeople.setDormFloor(dormRoominfor.getDormFloor().toString());
                    dormLivepeople.setRoomNumber(dormRoominfor.getRoomNumber());
                    dormLivepeople.setCheckInaddress(dormRoominfor.getAreaNumber()+"-"+dormRoominfor.getFloorNumber()+"-"+dormRoominfor.getDormFloor().toString()+"-"+dormRoominfor.getRoomNumber()+"-"+bednumber);
                    dormLivepeople.setName(dormonlivepeople.getName());
                    dormLivepeople.setIdnumber(IDnumber);
                    dormLivepeople.setJobnumber("");
                    dormLivepeople.setSex(dormonlivepeople.getSex().replace("\\s*|\r|\n|\t","").equals("男") ? 1L : 0L);
                    dormLivepeople.setDepartment2("");
                    dormLivepeople.setDepartment3("");
                    dormLivepeople.setJob("");
                    dormLivepeople.setLocation(dormonlivepeople.getAddress());
                    dormLivepeople.setAddress(dormonlivepeople.getAddress());
                    dormLivepeople.setPhone("");
                    dormLivepeople.setReason("入住");
                    dormLivepeople.setLivecheck("X");
                    dormLivepeople.setLivedate(new Date());
                    dormLivepeople.setBednumber(bednumber);
                    dormLivepeopleService.updateDormLivepeople(dormLivepeople);
                }


                //入住床位
                dormBed.setName(dormonlivepeople.getName());
                dormBed.setIdnumber(IDnumber);
                dormBed.setSex(dormLivepeople.getSex().toString());
                dormBed.setJobnumber(dormLivepeople.getJobnumber());
                dormBed.setDepartment1(dormLivepeople.getDepartment1());
                dormBed.setDepartment2(dormLivepeople.getDepartment2());
                dormBed.setDepartment3(dormLivepeople.getDepartment3());
                dormBed.setJob(dormLivepeople.getJob());
                dormBed.setPhone(dormLivepeople.getPhone());
                dormBed.setBedstatus(1L);
                dormBed.setCheckInwhether(1L);
                dormBedService.updateDormBed(dormBed);
                //新增流转信息
                DormStayRetreatTune tunelist = new DormStayRetreatTune();
                tunelist.setAreaNumber(dormRoominfor.getAreaNumber());
                tunelist.setFloorNumber(dormRoominfor.getFloorNumber());
                tunelist.setDormFloor(dormRoominfor.getDormFloor().toString());
                tunelist.setRoomNumber(dormRoominfor.getRoomNumber());
                tunelist.setIdnumber(IDnumber);
                tunelist.setJobnumber("");
                tunelist.setName(dormonlivepeople.getName());
                tunelist.setDepartment2("");
                tunelist.setDepartment3("");
                tunelist.setJob("");
                tunelist.setSex(dormonlivepeople.getSex().replace("\\s*|\r|\n|\t","").equals("男") ? "1" : "0");
                tunelist.setPhone("");
                tunelist.setLocation(dormLivepeople.getLocation());
                tunelist.setAddress(dormLivepeople.getAddress());
                tunelist.setType(1L);//类别0:退宿:1:入住2:调宿
                tunelist.setApplyDate(new Date());
                tunelist.setBednumber(bednumber);
                Long Wardrobe =0L;
                if(dormLivepeople.getWardrobe()!=null && !dormLivepeople.getWardrobe().equals("")){
                    Wardrobe = Long.parseLong(dormLivepeople.getWardrobe());
                }
                tunelist.setWardrobe(Wardrobe);
                tunelist.setReason("入住");
                tunelist.setLivedate(dormLivepeople.getLivedate());
                //unelist.setRetreatdate(new Date(0L));
                tunelist.setEmergencycontact(dormLivepeople.getEmergencycontact());
                tunelist.setEmergencyphone(dormLivepeople.getEmergencyphone());
                tunelist.setRelationship(dormLivepeople.getRelationship());
                tunelist.setAdminname(SecurityUtils.getUsername());
                tunelist.setApplyname(dormonlivepeople.getName());
                tunelist.setHcmupdate("X");
                dormStayRetreatTuneService.insertDormStayRetreatTune(tunelist);

                //新增物品表
                DormArticle dormArticle = new DormArticle();
                dormArticle.setAreaNumber(dormRoominfor.getAreaNumber());
                dormArticle.setFloorNumber(dormRoominfor.getFloorNumber());
                dormArticle.setRoomNumber(dormRoominfor.getRoomNumber());
                dormArticle.setName(dormonlivepeople.getName());
                dormArticle.setJobnumber("");
                dormArticle.setIdnnumber(IDnumber);
                dormArticle.setAreaNumber(dormRoominfor.getAreaNumber());
                dormArticle.setBednumber(Long.parseLong(bednumber));
                dormArticle.setArticleNumber("0");//钥匙
                dormArticle.setArticleDescription("钥匙");
                dormArticle.setRequstQuantity(data.getLong("keynumber"));
                dormArticleService.insertDormArticle(dormArticle);
                //修改柜子表
                Map<String,String> Wmap = new HashMap<>();
                Wmap.put("area_number",dormRoominfor.getAreaNumber());
                Wmap.put("floor_number",dormRoominfor.getFloorNumber());
                Wmap.put("dorm_floor",dormRoominfor.getDormFloor().toString());
                Wmap.put("room_number",dormRoominfor.getRoomNumber());
                Wmap.put("wardrobe", data.getString("wardrobe"));
                DormWardrobe dormWardrobe = dormWardrobeService.selectDormWardrobeBymap(Wmap);
                dormWardrobe.setName(dormonlivepeople.getName());
                dormWardrobe.setJobnumber("");
                dormWardrobe.setWhether(1L);
                dormWardrobeService.updateDormWardrobe(dormWardrobe);

                return AjaxResult.success("操作失败，SAP接口报错："+status+" 入住成功");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        return AjaxResult.success("入住成功");
    }
    /**
     * 将字符串类型的XML 转化成Docunent文档结构
     * @param parseStrXml 待转换的XML字符串
     * @return
     */
    public static Document strXmlToDocument(String parseStrXml) {
        StringReader read = new StringReader(parseStrXml);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        // 新建立构造器
        SAXBuilder sb = new SAXBuilder();
        Document doc = null;
        try {
            doc = sb.build(source);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;

    }

    /**
     * 根据目标节点名获取值
     * @param doc 文档结构
     * @param finalNodeName 节点名
     * @return
     */
    public static String getValueByElementName(Document doc, String finalNodeName) {
        Element root = doc.getRootElement();
        HashMap<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> resultmap = getChildAllText(doc, root, map);
        String result = (String) resultmap.get(finalNodeName);
        return result;
    }

    /**
     * 递归获得子节点的值
     * @param doc 文档结构
     * @param e 节点元素
     * @param resultmap 递归将值存入map中
     * @return
     */
    public static Map<String, Object> getChildAllText(Document doc, Element e, HashMap<String, Object> resultmap) {
        if (e != null) {
            //如果存在子节点
            if (e.getChildren() != null) {
                List<Element> list = e.getChildren();
                //循环输出
                for (Element el : list) {
                    //如果子节点还存在子节点，则递归获取
                    if (el.getChildren().size() > 0) {
                        getChildAllText(doc, el, resultmap);
                    } else {
                        //将叶子节点值压入map
                        resultmap.put(el.getName(), el.getTextTrim());
                    }
                }
            }
        }
        return resultmap;
    }
    /**http 方式直接连接sap
 * @param endPointAddress  webservice发布地址
 * @param username 用户名
 * @param password 密码
 * @Author LY
 */
public static void httpConnSap(String endPointAddress,String username,String password,String IDnumber) throws Exception {

    // HttpClient发送SOAP请求
    int timeout = 10000;
    System.out.println("HttpClient 发送SOAP请求");
    HttpClient client = new HttpClient();
    //如果需要用户名密码验证；不需要验证登录则不需要以下4行
    UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
    client.getState().setCredentials(AuthScope.ANY, creds);
    //webservice 地址
    PostMethod postMethod = new PostMethod(endPointAddress);
    // 设置连接超时
    client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
    // 设置读取时间超时
    client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
    // 然后把Soap请求数据添加到PostMethod中
    StringRequestEntity requestEntity = new StringRequestEntity(getXML(IDnumber),"text/xml", "UTF-8");

    // 设置请求头部，否则可能会报 "no SOAPAction header" 的错误
    postMethod.setRequestHeader("SOAPAction", "");
    // 设置请求体
    postMethod.setRequestEntity(requestEntity);
    int status = client.executeMethod(postMethod);

    if (status == 200) {// 成功
        InputStream is = postMethod.getResponseBodyAsStream();
        // 获取请求结果字符串
        String result = IOUtils.toString(is);
        System.out.println("请求成功！"+"\n"+"返回结果:"+result);
    } else {
        System.out.println("请求失败！"+"\n"+"错误代码："+status+"\n"+"返回报文:"+"\n"+postMethod.getResponseBodyAsString());
    }

}
    /**
     * @return 获取请求报文  这里我是直接从soapui 里面测试再把请求报文复制过来的。
     */
    public static String getXML(String IDnumber){
        String soapXML="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:sap-com:document:sap:rfc:functions\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <urn:ZHR_O_EMPLOYEE_INFORMATION>\n" +
                "         <!--Optional:-->\n" +
                "         <I_ICNUM>" + IDnumber + "</I_ICNUM>\n" +
                "         <!--Optional:-->\n" +
                "         <I_NACHN/>\n" +
                "         <!--Optional:-->\n" +
                "         <I_PERNR/>\n" +
                "         <OUT_STATUS>\n" +
                //"            <!--Zero or more repetitions:-->\n" +
                "            <item>\n" +
                "               <E_TYPE/>\n" +
                "               <E_MSG/>\n" +
                "            </item>\n" +
                "         </OUT_STATUS>\n" +
                "         <OUT_TAB>\n" +
                //"            <!--Zero or more repetitions:-->\n" +
                "            <item>\n" +
                "               <PERNR/>\n" +
                "               <NACHN/>\n" +
                "               <GESCH/>\n" +
                "               <ZONE_STEXT/>\n" +
                "               <ZTWO_STEXT/>\n" +
                "               <ZTHREE_STEXT/>\n" +
                "               <ZFOUR_STEXT/>\n" +
                "               <ZFIVE_STEXT/>\n" +
                "               <ZSIX_STEXT/>\n" +
                "               <GBDAT/>\n" +
                "               <FTEXT/>\n" +
                "               <ZRZ_DATE/>\n" +
                "               <BEGDA/>\n" +
                "               <ZGL/>\n" +
                "               <ZPLANS_TEXT/>\n" +
                "               <TEL/>\n" +
                "               <ICNUM/>\n" +
                "            </item>\n" +
                "         </OUT_TAB>\n" +
                "      </urn:ZHR_O_EMPLOYEE_INFORMATION>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        return soapXML;
    }


    /**
     * 获得空余床位
     */
    @PostMapping(value = "/getkongbed")
    public AjaxResult getkongbed(@RequestBody JSONObject data)
    {
        String area_number = data.getString("areaNumber");
        String floor_number = data.getString("floorNumber");
        String dorm_floor = data.getString("dormFloor");
        String room_number = data.getString("roomNumber");
        Map<String,String> bed = new HashMap<>();
        bed.put("area_number",area_number);
        bed.put("floor_number",floor_number);
        bed.put("dorm_floor",dorm_floor);
        bed.put("room_number",room_number);

        return AjaxResult.success(dormBedService.selectkongbed(bed));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormRoominfor> util = new ExcelUtil<DormRoominfor>(DormRoominfor.class);
        util.importTemplateExcel(response, "房间数据");
    }

    @Log(title = "房间信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormRoominfor> util = new ExcelUtil<DormRoominfor>(DormRoominfor.class);
        List<DormRoominfor> dormRoominforList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormRoominforService.importDormRoominfor(dormRoominforList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 调换确认
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:diaohuanconfirm')")
    @PostMapping(value = "/diaohuanConfirm")
    public AjaxResult diaohuanConfirm(@RequestBody JSONObject data){
        String IDnumbwer = data.getString("IDnumber1");//身份证号码
        String name = data.getString("name1");//姓名
        String areaNumber = data.getString("areaNumber1");//区域编码
        String floor = data.getString("dormFloor1");//楼层
        String room = data.getString("room1");//房间号
        String bed = data.getString("bed1");//床位号
        String remarks = data.getString("remarks");//备注
        String reason = data.getString("reason");//原因
        String floorNumber =data.getString("floorName1");//宿舍楼编号
        Long currentMonthLiveDays = data.getLong("currentMonthLiveDays");//当月入住天数
        Map<String,String> map = new HashMap<>();
        map.put("area_number",areaNumber);
        map.put("floor_number",floorNumber);
        map.put("dorm_floor",floor);
        map.put("room_number",room);
        map.put("bednumber",bed);
        Map<String,String> map2 = new HashMap<>();
        map2.put("area_number",areaNumber);
        map2.put("floor_number",floorNumber);
        map2.put("dorm_floor",floor);
        map2.put("room_number",room);
        DormRoominfor dormRoominfornew = dormRoominforService.selectDormRoominforBymap(map2);//新房间信息
        DormLivepeople dormLivepeople = dormLivepeopleService.selectDormLivepeopleByIDnumber(IDnumbwer);//原人员信息
        Map<String,String> map3 = new HashMap<>();
        map3.put("area_number",dormLivepeople.getAreaNumber());
        map3.put("floor_number",dormLivepeople.getFloorNumber());
        map3.put("dorm_floor",dormLivepeople.getDormFloor());
        map3.put("room_number",dormLivepeople.getRoomNumber());
        DormRoominfor dormRoominfor = dormRoominforService.selectDormRoominforBymap(map3);//原房间信息
        DormBed bedlist = dormBedService.selectDormBedByIDnumber(IDnumbwer);//原床位信息
        DormBed bedlistNew = dormBedService.selectDormBedByMap(map);//新床位信息
        System.out.println(floorNumber);
        if(bedlistNew==null){
            return AjaxResult.success("无床位信息，请重新选择！");
        }else if(bedlistNew.getCheckInwhether()==1){
            return AjaxResult.success("该床位已住人，姓名为"+bedlistNew.getName());
        }else if(dormRoominfornew.getLivenumber()<=dormRoominfornew.getPeoplenumber()){
            return AjaxResult.success("该宿舍床位已满，请重新选择！");
        }
        //排除相同宿舍调换
        //修改dorm_roominfor这张表
        Long idOld = dormRoominfor.getId();
        Long idNew = dormRoominfornew.getId();
        if(!idOld.equals(idNew)){
            //原先房间住人数量减少
            dormRoominfor.setPeoplenumber(dormRoominfor.getPeoplenumber()-1);
            dormRoominfor.setRemainnumber(dormRoominfor.getLivenumber()-dormRoominfor.getPeoplenumber());
            dormRoominforService.updateDormRoominfor(dormRoominfor);
            //新房间住人数量增加
            dormRoominfornew.setPeoplenumber(dormRoominfornew.getPeoplenumber()+1);
            dormRoominfornew.setRemainnumber(dormRoominfornew.getLivenumber()-dormRoominfornew.getPeoplenumber());
            dormRoominforService.updateDormRoominfor(dormRoominfornew);
        }
        //修改dorm_livepeople这张表
        dormLivepeople.setAreaNumber(areaNumber);
        dormLivepeople.setFloorNumber(floorNumber);
        dormLivepeople.setDormFloor(floor);
        dormLivepeople.setRoomNumber(room);
        dormLivepeople.setBednumber(bed);
        dormLivepeople.setCheckInaddress(areaNumber+"-"+floorNumber+"-"+floor+"-"+room+"-"+bed);
        String Remarksold = "";
        if(dormLivepeople.getRemarks()!=null){
            Remarksold = dormLivepeople.getRemarks()+", ";
        }
        dormLivepeople.setRemarks(Remarksold+remarks);
        dormLivepeople.setTuneIncheck("X");
        dormLivepeople.setTuneIndate(new Date());
        dormLivepeopleService.updateDormLivepeople(dormLivepeople);

        //先入住床位
        bedlistNew.setName(name);
        bedlistNew.setIdnumber(IDnumbwer);
        bedlistNew.setSex(dormLivepeople.getSex().toString());
        bedlistNew.setJobnumber(dormLivepeople.getJobnumber());
        bedlistNew.setDepartment1(dormLivepeople.getDepartment1());
        bedlistNew.setDepartment2(dormLivepeople.getDepartment2());
        bedlistNew.setDepartment3(dormLivepeople.getDepartment3());
        bedlistNew.setJob(dormLivepeople.getJob());
        bedlistNew.setPhone(dormLivepeople.getPhone());
        bedlistNew.setBedstatus(1L);
        bedlistNew.setCheckInwhether(1L);
        String RemarksNew = "";
        if(bedlistNew.getRemarks()!=null){
            RemarksNew = bedlistNew.getRemarks()+", ";
        }
        bedlistNew.setRemarks(RemarksNew+remarks);
        dormBedService.updateDormBed(bedlistNew);
        //再清空原床位信息
        bedlist.setName("");
        bedlist.setSex("");
        bedlist.setIdnumber("");
        bedlist.setJobnumber("");
        bedlist.setDepartment1("");
        bedlist.setDepartment2("");
        bedlist.setDepartment3("");
        bedlist.setJob("");
        bedlist.setPhone("");
        bedlist.setCheckInwhether(0L);
        String RemarksOld = "";
        if(bedlist.getRemarks()!=null){
            RemarksOld = bedlist.getRemarks()+", ";
        }
        bedlist.setRemarks(RemarksOld+remarks);
        dormBedService.updateDormBed(bedlist);


        //新增流转信息
        DormStayRetreatTune tunelist = new DormStayRetreatTune();
        tunelist.setAreaNumber(areaNumber);
        tunelist.setFloorNumber(floorNumber);
        tunelist.setDormFloor(floor);
        tunelist.setRoomNumber(room);
        tunelist.setIdnumber(IDnumbwer);
        tunelist.setJobnumber(dormLivepeople.getJobnumber());
        tunelist.setName(name);
        String department1 = "";
        if(dormLivepeople.getDepartment1()!=null){
            department1 = dormLivepeople.getDepartment1();
        }
        tunelist.setDepartment1(department1);
        String department2 = "";
        if(dormLivepeople.getDepartment2()!=null){
            department2 = dormLivepeople.getDepartment2();
        }
        tunelist.setDepartment2(department2);
        String department3 = "";
        if(dormLivepeople.getDepartment3()!=null){
            department3 = dormLivepeople.getDepartment3();
        }
        tunelist.setDepartment3(department3);
        tunelist.setJob(dormLivepeople.getJob());
        tunelist.setSex(dormLivepeople.getSex().toString());
        tunelist.setPhone(dormLivepeople.getPhone());
        tunelist.setLocation(dormLivepeople.getLocation());
        tunelist.setAddress(dormLivepeople.getAddress());
        tunelist.setType(2L);//类别0:退宿:1:入住2:调宿
        tunelist.setApplyDate(new Date());
        tunelist.setBednumber(bed);
        Long Wardrobe =0L;
        if(dormLivepeople.getWardrobe()!=null && !dormLivepeople.getWardrobe().equals("")){
            Wardrobe = Long.parseLong(dormLivepeople.getWardrobe());
        }
        tunelist.setWardrobe(Wardrobe);
        tunelist.setReason(reason);
        tunelist.setLivedate(dormLivepeople.getLivedate());
        //unelist.setRetreatdate(new Date(0L));
        tunelist.setEmergencycontact(dormLivepeople.getEmergencycontact());
        tunelist.setEmergencyphone(dormLivepeople.getEmergencyphone());
        tunelist.setRelationship(dormLivepeople.getRelationship());
        tunelist.setChangenumber(room);
        tunelist.setChangebed(bed);
        tunelist.setChangedate(new Date());
        tunelist.setRemarks(remarks);
        tunelist.setAdminname(SecurityUtils.getUsername());
        tunelist.setApplyname(name);
        tunelist.setHcmupdate("X");
        tunelist.setCurrentMonthLiveDays(currentMonthLiveDays);
        Long qingjiariqi = 0l;
        if(dormLeaveOffService.selectSumOffdaysByIDnumber(dormLivepeople.getJobnumber())!=null){
            qingjiariqi = dormLeaveOffService.selectSumOffdaysByIDnumber(dormLivepeople.getJobnumber());
        }

        tunelist.setLiveddays(getdays(dormLivepeople.getLivedate(),new Date())-qingjiariqi);
        dormStayRetreatTuneService.insertDormStayRetreatTune(tunelist);


        String message = "调换成功";
        return AjaxResult.success(message);
    }
    /**
     * 退宿确认
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:tuisuconfirm')")
    @PostMapping(value = "/tuisuConfirm")
    public AjaxResult tuisuConfirm(@RequestBody JSONObject data){
        String IDnumbwer = data.getString("IDnumber");//身份证号
        String roomnumber = data.getString("roomNumber");//房间号
        String name = data.getString("name");//姓名
        String sex = data.getString("sex");//性别
        String phone = data.getString("phone");//手机号
        String bednumber = data.getString("bedNumber");//床位号
        JSONArray articleDescription = data.getJSONArray("articleDescription");//物品详情
        String remarks =data.getString("remarks");//备注
        DormRoominfor dormRoominfor = dormRoominforService.selectDormRoominforById(data.getLong("rowid"));//退宿房间信息
        DormLivepeople dormLivepeople = dormLivepeopleService.selectDormLivepeopleByIDnumber(IDnumbwer);//原退宿人员信息
        //List<DormArticle> dormArticles = dormArticleService.selectDormArticleByIDnumber(IDnumbwer);//退宿人员物品信息
        DormBed dormBed = dormBedService.selectDormBedByIDnumber(IDnumbwer);//退宿人员床位信息
        Long currentMonthLiveDays = data.getLong("currentMonthLiveDays");//当月入住天数

        // 获取在住人员信息 06.12  新增
        DormOnlivepeople dormOnlivepeople = dormOnlivepeopleService.selectDormOnlivepeopleByIDnumber(IDnumbwer);

        if(dormRoominfor==null){
            return AjaxResult.success("该人员无房间，请重新选择");
        }else if(dormLivepeople==null){
            return AjaxResult.success("该人员未入住，请重新选择");
        }else if(dormBed==null){
            return AjaxResult.success("该人员无床位，请重新选择");
        }

        // 更新在住人员状态为已退宿 06.12  新增
        if (dormOnlivepeople != null) {
            dormOnlivepeople.setFlag("0");
            dormOnlivepeopleService.updateDormOnlivepeople(dormOnlivepeople);
            System.out.println("更新在住人员状态为0");
        }

        //更新退宿人员信息
        dormLivepeople.setLivecheck("");
        dormLivepeople.setQuitcheck("X");
        dormLivepeople.setRetreattype("0");
        dormLivepeople.setRetreatdate(new Date());
        dormLivepeopleService.updateDormLivepeople(dormLivepeople);
        //更新床位信息
        dormBed.setName("");
        dormBed.setSex("");
        dormBed.setIdnumber("");
        dormBed.setJobnumber("");
        dormBed.setDepartment1("");
        dormBed.setDepartment2("");
        dormBed.setDepartment3("");
        dormBed.setJob("");
        dormBed.setPhone("");
        dormBed.setCheckInwhether(0L);
        String RemarksOld = "";
        //因需求更改床位不需要备注，此行注释
//        if(dormBed.getRemarks()!=null){
//            RemarksOld = dormBed.getRemarks()+", ";
//        }
        dormBed.setRemarks("");
        dormBedService.updateDormBed(dormBed);
        //更新房间信息
        dormRoominfor.setPeoplenumber(dormRoominfor.getPeoplenumber()-1);
        dormRoominfor.setRemainnumber(dormRoominfor.getLivenumber()-dormRoominfor.getPeoplenumber());
        dormRoominforService.updateDormRoominfor(dormRoominfor);
        //更新柜子信息
        String jobnumber = dormLivepeople.getJobnumber();
        if(jobnumber != null){
            DormWardrobe dormWardrobe = dormWardrobeService.selectDormWardrobeByJobnumber(jobnumber);
            if(dormWardrobe !=null) {
                dormWardrobe.setName("");
                dormWardrobe.setJobnumber("");
                dormWardrobe.setWhether(0L);
                dormWardrobe.setRemarks("");
                dormWardrobeService.updateDormWardrobe(dormWardrobe);
            }
            //更新个人物品信息
            for(int i=0;i<articleDescription.size();i++){
                Long id = Long.parseLong(articleDescription.get(i).toString().split(":")[1]);//获取前端传来的ID
                DormArticle article = dormArticleService.selectDormArticleById(id);
                article.setReturnNumber(article.getAreaNumber());
                article.setReturnDescription(article.getArticleDescription());
                article.setReturnQuantity(article.getRequstQuantity());
                String remarksold = "";
                if(article.getRemark()!=null){
                    remarksold = article.getRemark()+", ";
                }
                article.setRemark(remarksold+remarks);
                dormArticleService.updateDormArticle(article);
            }
        }

        //新增流转信息
        DormStayRetreatTune tunelist = new DormStayRetreatTune();
        tunelist.setAreaNumber(dormLivepeople.getAreaNumber());
        tunelist.setFloorNumber(dormLivepeople.getFloorNumber());
        tunelist.setDormFloor(dormLivepeople.getDormFloor());
        tunelist.setRoomNumber(dormLivepeople.getRoomNumber());
        tunelist.setIdnumber(IDnumbwer);
        tunelist.setJobnumber(dormLivepeople.getJobnumber());
        tunelist.setName(name);
        String department1 = "";
        if(dormLivepeople.getDepartment1()!=null){
            department1 = dormLivepeople.getDepartment1();
        }
        tunelist.setDepartment1(department1);
        String department2 = "";
        if(dormLivepeople.getDepartment2()!=null){
            department2 = dormLivepeople.getDepartment2();
        }
        tunelist.setDepartment2(department2);
        String department3 = "";
        if(dormLivepeople.getDepartment3()!=null){
            department3 = dormLivepeople.getDepartment3();
        }
        tunelist.setDepartment3(department3);
        tunelist.setJob(dormLivepeople.getJob());
        tunelist.setSex(dormLivepeople.getSex().toString());
        tunelist.setPhone(dormLivepeople.getPhone());
        tunelist.setLocation(dormLivepeople.getLocation());
        tunelist.setAddress(dormLivepeople.getAddress());
        tunelist.setType(0L);//类别0:退宿:1:入住2:调宿
        tunelist.setApplyDate(new Date());
        tunelist.setBednumber(dormBed.getBednumber());
        Long Wardrobe =0L;
        if(dormLivepeople.getWardrobe()!=null && !dormLivepeople.getWardrobe().equals("")){
            Wardrobe = Long.parseLong(dormLivepeople.getWardrobe());
        }
        tunelist.setWardrobe(Wardrobe);
        tunelist.setReason("退宿");
        tunelist.setLivedate(dormLivepeople.getLivedate());
        tunelist.setRetreatdate(new Date());
        tunelist.setRetreattype(0L);//退宿类型
        tunelist.setEmergencycontact(dormLivepeople.getEmergencycontact());
        tunelist.setEmergencyphone(dormLivepeople.getEmergencyphone());
        tunelist.setRelationship(dormLivepeople.getRelationship());
        tunelist.setChangedate(new Date());
        tunelist.setRemarks(remarks);
        tunelist.setAdminname(SecurityUtils.getUsername());
        tunelist.setApplyname(name);
        tunelist.setHcmupdate("X");
        Long qingjiariqi = 0l;
        if(dormLeaveOffService.selectSumOffdaysByIDnumber(dormLivepeople.getJobnumber())!=null){
            qingjiariqi = dormLeaveOffService.selectSumOffdaysByIDnumber(dormLivepeople.getJobnumber());
        }

        tunelist.setLiveddays(getdays(dormLivepeople.getLivedate(),new Date())-qingjiariqi);
        tunelist.setCurrentMonthLiveDays(currentMonthLiveDays);
        dormStayRetreatTuneService.insertDormStayRetreatTune(tunelist);
        String message = "退宿成功";
        return AjaxResult.success(message);
    }
    /**
     * 出差请假确认
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:qingjiachuchaiconfirm')")
    @PostMapping(value = "/qingjiachuchaiConfirm")
    public AjaxResult qingjiachuchaiConfirm(@RequestBody JSONObject data){
        String IDnumber = data.getString("IDnumber");//身份证号
        Date startday = data.getDate("startdate");
        Date enddate = data.getDate("enddate");
        String  day = data.getString("day");
        String reason = data.getString("reason");
        String remarks = data.getString("remarks");
        DormLivepeople dormLivepeople = dormLivepeopleService.selectDormLivepeopleByIDnumber(IDnumber);//人员信息
        DormRoominfor roominfor = dormRoominforService.selectDormRoominforById(data.getLong("rowid"));//房间信息
        DormBed dormBed = dormBedService.selectDormBedByIDnumber(IDnumber);//床位信息
        DormLeaveOff dormLeaveOff = new DormLeaveOff();
        //新增DormLeaveOff记录
        dormLeaveOff.setName(dormLivepeople.getName());
        dormLeaveOff.setAreaNumber(dormLivepeople.getAreaNumber());
        dormLeaveOff.setJobnumber(dormLivepeople.getJobnumber());
        dormLeaveOff.setFloorNumber(dormLivepeople.getFloorNumber());
        dormLeaveOff.setRoomNumber(dormLivepeople.getRoomNumber());
        dormLeaveOff.setApplyBegindate(startday);
        dormLeaveOff.setApplyEnddate(enddate);
        dormLeaveOff.setApplyDays(Long.parseLong(day));
        dormLeaveOff.setDepartment(dormLivepeople.getDepartment3());
        dormLeaveOff.setReason(reason);
        dormLeaveOff.setRemark(remarks);
        dormLeaveOffService.insertDormLeaveOff(dormLeaveOff);
        //新增流转记录
        DormStayRetreatTune tunelist = new DormStayRetreatTune();
        tunelist.setAreaNumber(dormLivepeople.getAreaNumber());
        tunelist.setFloorNumber(dormLivepeople.getFloorNumber());
        tunelist.setDormFloor(dormLivepeople.getDormFloor().toString());
        tunelist.setRoomNumber(dormLivepeople.getRoomNumber());
        tunelist.setIdnumber(IDnumber);
        tunelist.setJobnumber(dormLivepeople.getJobnumber());
        tunelist.setName(dormLivepeople.getName());
        tunelist.setDepartment2(dormLivepeople.getDepartment2());
        tunelist.setDepartment3(dormLivepeople.getDepartment3());
        tunelist.setJob(dormLivepeople.getJob());
        tunelist.setSex(dormLivepeople.getSex().toString());
        tunelist.setPhone(dormLivepeople.getPhone());
        tunelist.setLocation(dormLivepeople.getLocation());
        tunelist.setAddress(dormLivepeople.getAddress());
        tunelist.setType(3L);//类别0:退宿:1:入住2:调宿3:请假出差
        tunelist.setApplyDate(new Date());
        tunelist.setBednumber(dormLivepeople.getBednumber());
        Long Wardrobe =0L;
        if(dormLivepeople.getWardrobe()!=null && !dormLivepeople.getWardrobe().equals("")){
            Wardrobe = Long.parseLong(dormLivepeople.getWardrobe());
        }
        tunelist.setWardrobe(Wardrobe);
        tunelist.setReason("请假出差");
        tunelist.setLivedate(dormLivepeople.getLivedate());
        //unelist.setRetreatdate(new Date(0L));
        tunelist.setEmergencycontact(dormLivepeople.getEmergencycontact());
        tunelist.setEmergencyphone(dormLivepeople.getEmergencyphone());
        tunelist.setRelationship(dormLivepeople.getRelationship());
        tunelist.setAdminname(SecurityUtils.getUsername());
        tunelist.setApplyname(dormLivepeople.getName());
        tunelist.setHcmupdate("X");
        tunelist.setLiveddays(getdays(dormLivepeople.getLivedate(),new Date())-dormLeaveOffService.selectSumOffdaysByIDnumber(dormLivepeople.getJobnumber()));
        tunelist.setEnddate(enddate);
        tunelist.setLeaveoffday(day);
        dormStayRetreatTuneService.insertDormStayRetreatTune(tunelist);


        String message = "操作成功";
        return AjaxResult.success(message);
    }

    public Long getdays(Date startdate, Date enddate){

        Long days = (Long) ((enddate.getTime() - startdate.getTime()) / (1000*3600*24)+1);
        return days;
    }
    /**
     * 查询宿舍楼列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:list')")
    @GetMapping("/getFloorName")
    public List<Map<String,Object>> getFloorName()
    {
        List<Map<String,Object>> list = dormRoominforService.selectFloorName();
        return list;
    }
    /**
     * 查询楼层列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:list')")
    @GetMapping("/getFloor")
    public List<Integer> getFloor()
    {
        List<Integer> list = dormRoominforService.selectFloor();
        return list;
    }
    /**
     * 查询房间号
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:list')")
    @GetMapping("/getRoomNumber")
    public List<String> getRoomNumber()
    {
        List<String> list = dormRoominforService.selectRoomNumber();
        return list;
    }
    /**
     * 查询已入住人员
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:list')")
    @PostMapping("/getlivingpeople")
    public List<Map<String,Object>> getlivingpeople(@RequestBody DormRoominfor dormRoominfor)
    {
        List<Map<String,Object>> list = dormRoominforService.selectlivingpeopleBydormRoominfor(dormRoominfor);
        return list;
    }
    /**
     * 查询入住人员信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:list')")
    @GetMapping("/getLivepeople2/{IDnumber}")
    public AjaxResult getLivepeople2(@PathVariable("IDnumber") String IDnumber)
    {
        DormLivepeople list = dormLivepeopleService.selectDormLivepeopleByIDnumber(IDnumber);
        return AjaxResult.success(list);
    }
    /**
     * 查询入住人员物品信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:roominfor:list')")
    @GetMapping("/getarticleDescription/{IDnumber}")
    public AjaxResult getarticleDescription(@PathVariable("IDnumber") String IDnumber)
    {
        List<DormArticle> list = dormArticleService.selectDormArticleByIDnumber(IDnumber);
        return AjaxResult.success(list);
    }




}
