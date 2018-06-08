/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

package com.github.houbb.tech.validation.easypoi;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/8 下午5:34  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */

public class Easypoi {

    public static void main(String[] args) throws IOException {
        Student student = Student.builder()
                .id("XXX")
                .name("ryo")
                .registrationDate(new Date())
                .birthday(new Date())
                .sex(2)
                .build();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生"),
                Student.class, Arrays.asList(student));
        OutputStream outputStream = new FileOutputStream("student.xls");
        workbook.write(outputStream);
    }

}
