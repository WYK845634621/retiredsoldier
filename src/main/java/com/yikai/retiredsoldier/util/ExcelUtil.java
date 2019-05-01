package com.yikai.retiredsoldier.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.yikai.retiredsoldier.Vo.ResultVo;
import com.yikai.retiredsoldier.entity.Business;
import com.yikai.retiredsoldier.entity.ExcelPropertyIndexModelBusiness;
import com.yikai.retiredsoldier.entity.ExcelPropertyIndexModelSoldier;
import com.yikai.retiredsoldier.entity.Soldier;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description     生成Excel
 * @Tips
 * @Author yikai.wang
 * @Date 2019/3/21 16:01
 */
public class ExcelUtil {
    private static Log logger = LogFactory.getLog(ExcelUtil.class);


    /**
     * @Note: 导出企业信息的Excel
     * @Date:2019/3/24 14:17 @Auth:yikai.wang @Desc(V/B):〈〉
     */
    public static ResultVo<String> generateExcel(HttpServletResponse response, List<Business> logs){
        OutputStream outputStream = null;
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            long start = System.nanoTime();
            outputStream = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(outputStream,ExcelTypeEnum.XLSX);

            String fileName = new String(("BusinessInfo" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                    .getBytes(), "UTF-8");

            //设置Sheet
            Sheet sheet = new Sheet(1,0,ExcelPropertyIndexModelBusiness.class);
            sheet.setSheetName("企业信息列表");
//            //设置标题
//            Table table = new Table(1);
//            List<List<String>> titles = new ArrayList<>();
//            for (int i = 0; i < headers.length; i++){
//                titles.add(Arrays.asList(headers[i]));
//            }
//            table.setHead(titles);

            //正则表达式
//            Pattern pattern = Pattern.compile("[^\u4E00-\u9FA5]");
            //日期
            SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
            List<List<String>> dateList = new ArrayList<>();
            for (int i = 0; i < logs.size(); i++) {
                if (logs.get(i) == null){
                    continue;
                }
                Business business = logs.get(i);
                if (StringUtils.isEmpty(business.getCreateTime())){
                    continue;
                }
                dateList.add(Arrays.asList(
                        "NO." + (i + 1),
                        business.getName(),
                        business.getAge()+"",
                        business.getPhone(),
                        business.getEmail(),
                        business.getLocation(),
                        business.getTrade()+"",
                        business.getKind(),
                        dateFormat.format(business.getCreateTime())
                ));
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName + ".xlsx");
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            writer.write0(dateList, sheet);
            writer.finish();
            response.getOutputStream().flush();


            long end = System.nanoTime();
            System.out.println("生成Excel总耗时:" + (end - start));
            resultVo.setMsg(ResultVo.MSG_SUCCESS);
            resultVo.setCode(ResultVo.CODE_SUCCESS);
            resultVo.setResult("生成完毕");
        }catch (Exception e){
            resultVo.setMsg(ResultVo.MSG_FAIL);
            resultVo.setCode(ResultVo.CODE_FAIL);
            resultVo.setResult("抛出了异常");
            logger.error("error in ExcelUtil.generateExcel",e);
        }finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                resultVo.setMsg(ResultVo.MSG_FAIL);
                resultVo.setCode(ResultVo.CODE_FAIL);
                resultVo.setResult("关闭流异常");
                logger.error("error in ExcelUtil.generateExcel 关闭Outputstream",e);
            }
        }
        return resultVo;
    }



/**
 * @Note: 导出士兵信息Excel
 * @Date:2019/3/24 14:17 @Auth:yikai.wang @Desc(V/B):〈〉
 */
    public static ResultVo<String> generateExcel2(HttpServletResponse response, List<Soldier> logs){
        OutputStream outputStream = null;
        ResultVo<String> resultVo = new ResultVo<>();
        try {
            long start = System.nanoTime();
            outputStream = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(outputStream,ExcelTypeEnum.XLSX);

            String fileName = new String(("SoldierInfo" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                    .getBytes(), "UTF-8");

            //设置Sheet
            Sheet sheet = new Sheet(1,0,ExcelPropertyIndexModelSoldier.class);
            sheet.setSheetName("退役士兵信息列表");

            //正则表达式
//            Pattern pattern = Pattern.compile("[^\u4E00-\u9FA5]");
            //日期
            SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
            List<List<String>> dateList = new ArrayList<>();
            for (int i = 0; i < logs.size(); i++) {
                if (logs.get(i) == null){
                    continue;
                }
                Soldier soldier = logs.get(i);
                if (StringUtils.isEmpty(soldier.getCreateTime())){
                    continue;
                }

                dateList.add(Arrays.asList(
                        soldier.getId().substring(0,15),
                        soldier.getName(),
                        soldier.getAge()+"",
                        soldier.getGender()+"",
                        soldier.getPhone(),
                        soldier.getEmail(),
                        soldier.getIdCard(),
                        soldier.getNationality(),
                        soldier.getNation(),
                        soldier.getKind(),
                        soldier.getServiceArea(),
                        soldier.getLocation(),
                        dateFormat.format(soldier.getCreateTime())
                ));
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName + ".xlsx");
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            writer.write0(dateList, sheet);
            writer.finish();
            response.getOutputStream().flush();


            long end = System.nanoTime();
            System.out.println("生成Excel总耗时:" + (end - start));
            resultVo.setMsg(ResultVo.MSG_SUCCESS);
            resultVo.setCode(ResultVo.CODE_SUCCESS);
            resultVo.setResult("生成完毕");
        }catch (Exception e){
            resultVo.setMsg(ResultVo.MSG_FAIL);
            resultVo.setCode(ResultVo.CODE_FAIL);
            resultVo.setResult("抛出了异常");
            logger.error("error in ExcelUtil.generateExcel",e);
        }finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                resultVo.setMsg(ResultVo.MSG_FAIL);
                resultVo.setCode(ResultVo.CODE_FAIL);
                resultVo.setResult("关闭流异常");
                logger.error("error in ExcelUtil.generateExcel 关闭Outputstream",e);
            }
        }
        return resultVo;
    }
}
