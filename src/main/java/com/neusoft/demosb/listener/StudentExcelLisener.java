package com.neusoft.demosb.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.neusoft.demosb.entity.Student;
import com.neusoft.demosb.entity.StudentExcel;
import com.neusoft.demosb.service.StudentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 16:23 2020/5/29
 */
public class StudentExcelLisener extends AnalysisEventListener<Student> {
    private List<Student> data = new ArrayList<>();

    private StudentService studentService;

    public StudentExcelLisener(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void invoke(Student studentExcel, AnalysisContext analysisContext) {
        //解析数据保存到studentExcel
        data.add(studentExcel);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //当Excel解析完毕后，执行
        System.out.println(data);
        if (studentService != null) {
            studentService.insert(data);
        }
    }
}
