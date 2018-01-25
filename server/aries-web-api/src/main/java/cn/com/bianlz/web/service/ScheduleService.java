package cn.com.bianlz.web.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface ScheduleService {
    HSSFWorkbook createWarningScheduleExcel();
}
