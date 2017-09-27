package com.pkfare.controller;

import com.pkfare.entity.ReqDataEntity;
import com.pkfare.entity.ShoppingSolution;
import com.pkfare.service.SolutionService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

/**
 * Created by Admin on 2017/8/18 0018.
 */
@Controller
public class SolutionController {

    @Autowired
    private SolutionService service;


    @RequestMapping("/1111")
    public String home() {
        List<ShoppingSolution> list = service.getResult();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Pyton sheet");
        String[] cellNames = new String[]{"请求", "航司", "起飞", "到达", "航班号", "请求类型", "航程时间", "价格", "resultCode", "接口用时", "请求时间"};
        //表头
        Row row = sheet.createRow(0);
        for (int i1 = 0; i1 < cellNames.length; i1++) {
            Cell cell = row.createCell(i1);
            cell.setCellValue(cellNames[i1]);
        }
        //内容
        for (int i = 0; i < list.size(); i++) {
            Row content = sheet.createRow(i + 1);
            ShoppingSolution ss = list.get(i);
            content.createCell(1).setCellValue("1");
            content.createCell(2).setCellValue("2");
            content.createCell(3).setCellValue("3");
            content.createCell(4).setCellValue("4");
            content.createCell(5).setCellValue("5");
            content.createCell(6).setCellValue("6");
            content.createCell(7).setCellValue("7");
            content.createCell(8).setCellValue("8");
            content.createCell(9).setCellValue("9");
            content.createCell(10).setCellValue("0");
        }

        try {
            FileOutputStream out =
                    new FileOutputStream(new File("D:\\new.xls"));
//            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "index";
    }

    @RequestMapping(value = "/base64", method = {RequestMethod.POST})
    @ResponseBody
    public String base64(@RequestBody String str) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodedString);
        return encodedString;


    }



    public static void main(String[] args) {
    }
}
