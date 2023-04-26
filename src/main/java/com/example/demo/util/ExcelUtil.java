package com.example.demo.util;

import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author gxx
 * @Date 2023年04月25日15时05分
 * @desc 导出数据到Excel工具
 */
@Component
public class ExcelUtil {

    private static final String TEMPLATE_PATH="template";

    public static void exportExcel(InputStream is, OutputStream os, Map<String, Object> model) throws IOException {
        Context context = new Context();
        if (model != null) {
            for (String key : model.keySet()) {
                context.putVar(key, model.get(key));
            }
        }
        //获取jxls对象
        JxlsHelper jxlsHelper = JxlsHelper.getInstance();
        //创建流工具
        Transformer transformer = jxlsHelper.createTransformer(is, os);

        JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator) transformer.getTransformationConfig()
                .getExpressionEvaluator();

        Map<String, Object> funcs = new HashMap<String, Object>();
//        funcs.put("utils", new ExcelUtil()); // 添加自定义功能
//        evaluator.setJexlEngine(new JexlBuilder().namespaces(funcs).create());
        jxlsHelper.processTemplate(context, transformer);
    }

    public static void exportExcel(File xls, File out, Map<String, Object> model) throws IOException {
        exportExcel(new FileInputStream(xls), new FileOutputStream(out), model);
    }

    public static void exportExcel(String templateName, OutputStream os, Map<String, Object> model) throws IOException {
        File template = getTemplate(templateName);
        if(template!=null){
            exportExcel(new FileInputStream(template), os, model);
        }
    }

    /**
     * @param templateName 导出的Excel模板位置
     * @param outPath 导出Excel存放的位置
     * @param model 导出到Excel的数据
     * @throws IOException
     */
    public static void exportExcel(String templateName, String outPath, Map<String, Object> model) throws IOException {
        OutputStream os = new FileOutputStream(outPath);
        File template = getTemplate(templateName);
        if(template!=null){
            exportExcel(new FileInputStream(template), os, model);
        }
        os.close();
    }


    /**
     * 获取jxls模版文件
     * @param name
     * @return
     */
    public static File getTemplate(String name){
        String templatePath = ExcelUtil.class.getClassLoader().getResource(TEMPLATE_PATH).getPath();
        File template = new File(templatePath, name);
        if(template.exists()){
            return template;
        }
        return null;
    }

    // 日期格式化
    public String dateFmt(Date date, String fmt) {
        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat dateFmt = new SimpleDateFormat(fmt);
            return dateFmt.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
