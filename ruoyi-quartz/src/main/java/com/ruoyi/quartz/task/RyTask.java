package com.ruoyi.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.DormBed.service.IDormBedService;
import com.ruoyi.DormBed.service.impl.DormBedServiceImpl;
import com.ruoyi.article.domain.DormArticle;
import com.ruoyi.article.service.IDormArticleService;
import com.ruoyi.article.service.impl.DormArticleServiceImpl;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.livepeople.domain.DormLivepeople;
import com.ruoyi.livepeople.mapper.DormLivepeopleMapper;
import com.ruoyi.livepeople.service.IDormLivepeopleService;
import com.ruoyi.livepeople.service.impl.DormLivepeopleServiceImpl;
import com.ruoyi.off.domain.DormLeaveOff;
import com.ruoyi.off.service.IDormLeaveOffService;
import com.ruoyi.off.service.impl.DormLeaveOffServiceImpl;
import com.ruoyi.quartz.util.AbstractQuartzJob;
import com.ruoyi.quartz.util.SpringContextUtil;
import com.ruoyi.room.service.IDormRoominforService;
import com.ruoyi.tune.domain.DormStayRetreatTune;
import com.ruoyi.tune.service.IDormStayRetreatTuneService;
import com.ruoyi.tune.service.impl.DormStayRetreatTuneServiceImpl;
import com.ruoyi.wardrobe.domain.DormWardrobe;
import com.ruoyi.wardrobe.service.IDormWardrobeService;
import com.ruoyi.wardrobe.service.impl.DormWardrobeServiceImpl;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

import java.io.*;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.xml.sax.InputSource;
import org.jdom2.Document;
import com.alibaba.fastjson.JSONObject;
/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{
    private static final Logger log = LoggerFactory.getLogger(RyTask.class);
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }
    public void HCMUpdate(){
        IDormLivepeopleService dormLivepeopleService = (IDormLivepeopleService)SpringContextUtil.getBean(DormLivepeopleServiceImpl.class);
        IDormBedService iDormBedService = (IDormBedService)SpringContextUtil.getBean(DormBedServiceImpl.class);
        IDormArticleService iDormArticleService = (IDormArticleService)SpringContextUtil.getBean(DormArticleServiceImpl.class);
        IDormWardrobeService iDormWardrobeService = (IDormWardrobeService)SpringContextUtil.getBean(DormWardrobeServiceImpl.class);
        IDormLeaveOffService iDormLeaveOffService = (IDormLeaveOffService)SpringContextUtil.getBean(DormLeaveOffServiceImpl.class);
        IDormStayRetreatTuneService iDormStayRetreatTuneService = (IDormStayRetreatTuneService)SpringContextUtil.getBean(DormStayRetreatTuneServiceImpl.class);
        log.info("HCM同步到宿舍管理系统");
        // HttpClient发送SOAP请求
        String url = "http://172.16.14.118:8811/sap/bc/srt/rfc/sap/zhr_o_employee_informationws/800/zhr_o_employee_informationws/zhr_o_employee_informationws";
//        String url = "http://172.16.14.118:8811/sap/bc/srt/wsdl/flv_10002A111AD1/srvc_url/sap/bc/srt/rfc/sap/zhr_o_employee_informationws/800/zhr_o_employee_informationws/zhr_o_employee_informationws?sap-client=800";
        int timeout = 100000000;
        log.info("HttpClient 发送SOAP请求");
        HttpClient client = new HttpClient();
        //如果需要用户名密码验证；不需要验证登录则不需要以下4行
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("L20891", "882158");
        client.getState().setCredentials(AuthScope.ANY, creds);
        //webservice 地址
        PostMethod postMethod = new PostMethod(url);
        // 设置连接超时
        client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
        // 设置读取时间超时
        client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
        // 然后把Soap请求数据添加到PostMethod中
        org.apache.commons.httpclient.methods.RequestEntity  requestEntity = null;
        List<DormLivepeople> list = dormLivepeopleService.selectDormLivepeopleList(new DormLivepeople());
        for(DormLivepeople dormlp : list){
            try {
//                if(dormlp.getIdnumber()!=null){
//                    requestEntity = new StringRequestEntity(getXML(dormlp.getIdnumber()),"text/xml", "UTF-8");
//                }else{
//                    continue;
//                }
                requestEntity = new StringRequestEntity(getXML(dormlp.getIdnumber()),"text/xml", "UTF-8");
            } catch (UnsupportedEncodingException e) {
                log.error(e.toString());
            }

            // 设置请求头部，否则可能会报 “no SOAPAction header” 的错误
            postMethod.setRequestHeader("SOAPAction", "");
            // 设置请求体
            postMethod.setRequestEntity(requestEntity);
            int status = 0;
            try {
                status = client.executeMethod(postMethod);
                if (status == 200) {// 成功
                    InputStream is = postMethod.getResponseBodyAsStream();
                    // 获取请求结果字符串
                    String result = IOUtils.toString(is);
                    Document document = strXmlToDocument(result);
                    String res = getValueByElementName(document,"E_TYPE");
                    if(res.equals("S")) {
                        String BEGDA = getValueByElementName(document, "BEGDA");
                        String guyongstatus = "";
                        if (BEGDA != null) {
                            if (BEGDA.equals("0000-00-00")) {
                                guyongstatus = "在职";
                            } else {
                                guyongstatus = "离职";
                            }
                        } else {
                            guyongstatus = "在职";
                        }
                        String jobnumber = getValueByElementName(document, "PERNR");
                        String department1 = getValueByElementName(document, "ZONE_STEXT");
                        String department2 = getValueByElementName(document, "ZTWO_STEXT");
                        String department3 = getValueByElementName(document, "ZTHREE_STEXT");
                        String phone = getValueByElementName(document, "TEL");
                        String job = getValueByElementName(document, "ZPLANS_TEXT");
                        String name = getValueByElementName(document, "NACHN");
                        String sex = getValueByElementName(document, "GESCH");
                        String IDnumber = getValueByElementName(document, "ICNUM");

                        //DormLivepeople dormLivepeople = dormLivepeopleService.selectDormLivepeopleByIDnumber(IDnumber.get(i));
                        try {
                            dormlp.setOutjobdate(new SimpleDateFormat("yyyy-MM-dd").parse(BEGDA));
                        } catch (ParseException e) {
                            log.error(e.toString());
                        }
                        dormlp.setName(name);
                        dormlp.setJob(job);
                        dormlp.setPhone(phone);
                        dormlp.setDepartment1(department1);
                        dormlp.setDepartment2(department2);
                        dormlp.setDepartment3(department3);
                        dormlp.setJobnumber(jobnumber);
                        dormlp.setGuyongstatus(guyongstatus);
                        if (sex != null) {
                            dormlp.setSex(sex.replace("\\s*|\r|\n|\t", "").equals("男") ? 1L : 0L);
                        }
                        dormLivepeopleService.updateDormLivepeople(dormlp);
                        //更新床位表
                        DormBed dormBed = new DormBed();
                        dormBed.setIdnumber(IDnumber);
                        List<DormBed> dormBedList = iDormBedService.selectDormBedList(dormBed);
                        if (dormBedList.size() > 0) {
                            dormBedList.get(0).setJob(job);
                            dormBedList.get(0).setName(name);
                            dormBedList.get(0).setPhone(phone);
                            dormBedList.get(0).setDepartment2(department2);
                            dormBedList.get(0).setDepartment3(department3);
                            dormBedList.get(0).setJobnumber(jobnumber);
                            dormBedList.get(0).setDepartment1(department1);
                            dormBedList.get(0).setJob(job);
                            dormBedList.get(0).setSex(sex.replace("\\s*|\r|\n|\t", ""));
                            iDormBedService.updateDormBed(dormBedList.get(0));
                        }
                        //更新物品表
                        DormArticle dormArticle = new DormArticle();
                        dormArticle.setIdnnumber(IDnumber);
                        List<DormArticle> dormArticleList = iDormArticleService.selectDormArticleList(dormArticle);
                        if (dormArticleList.size() > 0) {
                            dormArticleList.get(0).setName(name);
                            dormArticleList.get(0).setJobnumber(jobnumber);
                            iDormArticleService.updateDormArticle(dormArticleList.get(0));
                        }
                        //更新柜子表
                        DormWardrobe dormWardrobe = new DormWardrobe();
                        dormWardrobe.setName(name);
                        List<DormWardrobe> dormWardrobeList = iDormWardrobeService.selectDormWardrobeList(dormWardrobe);
                        if (dormWardrobeList.size() > 0) {
                            dormWardrobeList.get(0).setJobnumber(jobnumber);
                            iDormWardrobeService.updateDormWardrobe(dormWardrobeList.get(0));
                        }
                        //更新请假出差表
                        DormLeaveOff dormLeaveOff = new DormLeaveOff();
                        dormLeaveOff.setName(name);
                        List<DormLeaveOff> dormLeaveOffList = iDormLeaveOffService.selectDormLeaveOffList(dormLeaveOff);
                        if (dormLeaveOffList.size() > 0) {
                            dormLeaveOffList.get(0).setJobnumber(jobnumber);
                            iDormLeaveOffService.updateDormLeaveOff(dormLeaveOffList.get(0));
                        }
                        log.info("请求成功！" + "\n" + "返回结果:" + result);
                    }
                } else {
                    log.info("请求失败！"+"\n"+"错误代码："+status+"\n"+"返回报文:"+"\n"+postMethod.getResponseBodyAsString());
                }
            } catch (IOException e) {
                log.error(e.toString());
            }
        }



    }
    public void HCMsubmit(){
        IDormLivepeopleService dormLivepeopleService = (IDormLivepeopleService)SpringContextUtil.getBean(DormLivepeopleServiceImpl.class);
        IDormStayRetreatTuneService dormStayRetreatTuneService = (IDormStayRetreatTuneService)SpringContextUtil.getBean(DormStayRetreatTuneServiceImpl.class);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String MT = "";
        if(month < 10){
            MT = "0"+month;
        }else{
            MT = String.valueOf(month);
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String YM = year+"-"+MT+"-"+"01 00:00:00";

        DormLivepeople DLp = new DormLivepeople();
        try {
            DLp.setLivedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(YM));
            log.info(DLp.getLivedate().toString());
        } catch (ParseException e) {
            log.error(e.toString());
        }
        List<DormLivepeople> list1 = dormLivepeopleService.selectDormLivepeopleList(DLp);

        DormLivepeople DLp2 = new DormLivepeople();
        try {
            DLp2.setRetreatdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(YM));
            log.info(DLp2.getRetreatdate().toString());
        } catch (ParseException e) {
            log.error(e.toString());
        }
        List<DormLivepeople> list2 = dormLivepeopleService.selectDormLivepeopleList(DLp2);

        //合并去重

        List<DormLivepeople> list = Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());


        List<sushe4SAP> listadd = new ArrayList<>();
        //定义接收数据
        JSONObject result = new JSONObject();

        String url = "http://172.16.14.118:8811/sap/zdemo?sap-client=800";
        for(DormLivepeople dormlp : list){
            List<DormStayRetreatTune> dormStayRetreatTune = dormStayRetreatTuneService.selectDormStayRetreatTuneByIDnumber(dormlp.getIdnumber());
            //定义发送数据
            sushe4SAP param = new sushe4SAP();
            param.setPERNR(dormlp.getJobnumber());
            param.setNACHN(dormlp.getName());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            if(dormlp.getLivedate()!=null){
                param.setBEGDA(sdf.format(dormlp.getLivedate()));
            }else{
                param.setBEGDA("99991231");
            }
            if(dormlp.getRetreatdate()!=null){
                param.setZBETRG(sdf.format(dormlp.getRetreatdate()));
            }else{
                param.setZBETRG("99991231");
            }

            param.setZTYPE(dormlp.getLivecheck().equals("X") ? "1" : "2");
            int j = 0;
            for(int i=0;i<dormStayRetreatTune.size();i++){
                if(dormStayRetreatTune.get(i).getType()==1){
                    j++;
                }
            }
            param.setZREPETITIONCHECK( j>1 ? "1" : "");
            listadd.add(param);
        }
        try {
            JSONObject jo = postMap(url,listadd);
            log.info("上传SAP",jo.toString());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("error", "连接错误！");
        }
    }
    public void HCMsubmit4Lastmonth(){
        IDormLivepeopleService dormLivepeopleService = (IDormLivepeopleService)SpringContextUtil.getBean(DormLivepeopleServiceImpl.class);
        IDormStayRetreatTuneService dormStayRetreatTuneService = (IDormStayRetreatTuneService)SpringContextUtil.getBean(DormStayRetreatTuneServiceImpl.class);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        String MT = "";
        if(month < 10){
            MT = "0"+month;
        }else{
            MT = String.valueOf(month);
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String YM = year+"-"+MT+"-"+"01 00:00:00";

        DormLivepeople DLp = new DormLivepeople();
        try {
            DLp.setLivedate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(YM));
            log.info(DLp.getLivedate().toString());
        } catch (ParseException e) {
            log.error(e.toString());
        }
        List<DormLivepeople> list1 = dormLivepeopleService.selectDormLivepeopleList(DLp);

        DormLivepeople DLp2 = new DormLivepeople();
        try {
            DLp2.setRetreatdate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(YM));
            log.info(DLp2.getRetreatdate().toString());
        } catch (ParseException e) {
            log.error(e.toString());
        }
        List<DormLivepeople> list2 = dormLivepeopleService.selectDormLivepeopleList(DLp2);

        //合并去重

        List<DormLivepeople> list = Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());


        List<sushe4SAP> listadd = new ArrayList<>();
        //定义接收数据
        JSONObject result = new JSONObject();

        String url = "http://172.16.14.118:8811/sap/zdemo?sap-client=800";
        for(DormLivepeople dormlp : list){
            List<DormStayRetreatTune> dormStayRetreatTune = dormStayRetreatTuneService.selectDormStayRetreatTuneByIDnumber(dormlp.getIdnumber());
            //定义发送数据
            sushe4SAP param = new sushe4SAP();
            param.setPERNR(dormlp.getJobnumber());
            param.setNACHN(dormlp.getName());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            if(dormlp.getLivedate()!=null){
                param.setBEGDA(sdf.format(dormlp.getLivedate()));
            }else{
                param.setBEGDA("99991231");
            }
            if(dormlp.getRetreatdate()!=null){
                param.setZBETRG(sdf.format(dormlp.getRetreatdate()));
            }else{
                param.setZBETRG("99991231");
            }

            param.setZTYPE(dormlp.getLivecheck().equals("X") ? "1" : "2");
            int j = 0;
            for(int i=0;i<dormStayRetreatTune.size();i++){
                if(dormStayRetreatTune.get(i).getType()==1){
                    j++;
                }
            }
            param.setZREPETITIONCHECK( j>1 ? "1" : "");
            listadd.add(param);
        }
        try {
            JSONObject jo = postMap(url,listadd);
            log.info("上传SAP",jo.toString());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("error", "连接错误！");
        }
    }
    /**
     * 发送post请求，参数用map接收
     * @param url 地址
     * @param object 请求的对象
     * @return 返回值
     */

    public static JSONObject postMap(String url,Object object) {
        //获取json字符串
        String json= JSON.toJSONString(object);
        log.info(json);
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        CloseableHttpResponse response;
//        try {
//            StringEntity stringEntity=new StringEntity(json, ContentType.APPLICATION_JSON);
//            httpPost.setEntity(stringEntity);
//            response = httpClient.execute(httpPost);
//            if (response != null && response.getStatusLine().getStatusCode() == 200) {
//                HttpEntity entity = response.getEntity();
//                String jsonString= EntityUtils.toString(entity);
//                JSONObject jsonObject=JSONObject.parseObject(jsonString);
//                return jsonObject;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭连接,释放资源
//            try {
//                httpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
        int timeout = 100000000;
        HttpClient client = new HttpClient();
        //如果需要用户名密码验证；不需要验证登录则不需要以下4行
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("L20891", "882158");
        client.getState().setCredentials(AuthScope.ANY, creds);
        //webservice 地址
        PostMethod postMethod = new PostMethod(url);
        // 设置连接超时
        client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
        // 设置读取时间超时
        client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
        // 然后把Soap请求数据添加到PostMethod中
        org.apache.commons.httpclient.methods.RequestEntity  requestEntity = null;
        try {
            requestEntity = new StringRequestEntity(json,"application/json", "UTF-8");
        } catch(Exception e){
            log.error(e.toString());
        }
        // 设置请求头部，否则可能会报 “no SOAPAction header” 的错误
        //postMethod.setRequestHeader("SOAPAction", "");
        // 设置请求体
        postMethod.setRequestEntity(requestEntity);
        JSONObject jsonObject= null;
        try{
            int status = client.executeMethod(postMethod);
            if (status == 200) {// 成功
                InputStream is = postMethod.getResponseBodyAsStream();
                // 获取请求结果字符串
                String result = IOUtils.toString(is);
                log.info("返回消息： "+result);
                jsonObject=JSONObject.parseObject(result);
            }
        }catch(Exception e){
            log.error(e.toString());
        }
        return jsonObject;
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

    public class sushe4SAP{
        @JSONField(name = "PERNR")
        String PERNR;
        @JSONField(name = "NACHN")
        String NACHN;
        @JSONField(name = "BEGDA")
        String BEGDA;
        @JSONField(name = "ZBETRG")
        String ZBETRG;
        @JSONField(name = "ZTYPE")
        String ZTYPE;
        @JSONField(name = "ZREPETITIONCHECK")
        String ZREPETITIONCHECK;
        public String getPERNR() {
            return PERNR;
        }

        public void setPERNR(String PERNR) {
            this.PERNR = PERNR;
        }

        public String getNACHN() {
            return NACHN;
        }

        public void setNACHN(String NACHN) {
            this.NACHN = NACHN;
        }

        public String getBEGDA() {
            return BEGDA;
        }

        public void setBEGDA(String BEGDA) {
            this.BEGDA = BEGDA;
        }

        public String getZBETRG() {
            return ZBETRG;
        }

        public void setZBETRG(String ZBETRG) {
            this.ZBETRG = ZBETRG;
        }

        public String getZTYPE() {
            return ZTYPE;
        }

        public void setZTYPE(String ZTYPE) {
            this.ZTYPE = ZTYPE;
        }

        public String getZREPETITIONCHECK() {
            return ZREPETITIONCHECK;
        }

        public void setZREPETITIONCHECK(String ZREPETITIONCHECK) {
            this.ZREPETITIONCHECK = ZREPETITIONCHECK;
        }


    }

}
