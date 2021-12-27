package com.thuctapcovid.thuctapcovid.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JasperUtils {
    public static byte[] getReport(List<Map<String, Object>> list,String path) {
        JasperReport jasperReport = null;
        try {

            jasperReport = JasperCompileManager.compileReport(new ClassPathResource(path).getInputStream());
//            String sourceFileName = "E:\\thuctap\\src\\main\\resources\\templates\\Blank_A4.jrxml";
//            JasperCompileManager.compileReportToFile(sourceFileName);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(jasperReport);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list, false);
        Map<String, Object> parameters = new HashMap<>();
        try {
            return (JasperExportManager.exportReportToPdf(JasperFillManager.fillReport(jasperReport, parameters, dataSource)));
        } catch (JRException e) {
            e.printStackTrace();
        }
        return null;
    }
}
