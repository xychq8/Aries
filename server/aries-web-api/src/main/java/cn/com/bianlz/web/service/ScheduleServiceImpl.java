package cn.com.bianlz.web.service;

import cn.com.bianlz.common.utils.DateUtils;
import cn.com.bianlz.common.vo.Result;
import cn.com.bianlz.data.delivery.api.vo.ScheduleWarning;
import cn.com.bianlz.web.client.DeliveryServiceClient;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ScheduleServiceImpl implements ScheduleService{
    @Autowired
    private DeliveryServiceClient deliveryServiceClient;

    @Override
    public HSSFWorkbook createWarningScheduleExcel() {
        String date = DateUtils.getYYMMDD(new Date());
        List<ScheduleWarning> scheduleWarningList = null;
        Result<List<ScheduleWarning>> result = deliveryServiceClient.getWarnning(date);
        if(result!=null&&result.getData()!=null){
            scheduleWarningList = result.getData();
        }else{
            scheduleWarningList = new ArrayList<ScheduleWarning>();
        }

        return createExcel(scheduleWarningList);
    }

    //数据量不大，不考虑65535
    private HSSFWorkbook createExcel(List<ScheduleWarning> scheduleWarningList){
        int counter = 0;
        String[] headers = new String[]{"uuid","栏目","位置","cpm","实际曝光","曝光百分比","原因"};
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = workbook.createSheet("aries");
        HSSFRow hssfRow = hssfSheet.createRow(0);
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell hssfCell = null;
        for (int i = 0; i < headers.length; i++) {
            hssfCell = hssfRow.createCell(i);//列索引从0开始
            hssfCell.setCellValue(headers[i]);//列名1
            hssfCell.setCellStyle(hssfCellStyle);//列居中显示
        }

        for (int i = 0; i < scheduleWarningList.size(); i++) {
            hssfRow = hssfSheet.createRow(i+1);
            ScheduleWarning scheduleWarning = scheduleWarningList.get(i);
            hssfRow.createCell(0).setCellValue(scheduleWarning.getUuid());
            hssfRow.createCell(1).setCellValue(StringUtils.defaultIfEmpty(scheduleWarning.getCategory(),""));
            hssfRow.createCell(2).setCellValue(StringUtils.defaultIfEmpty(scheduleWarning.getLocation(),""));
            hssfRow.createCell(3).setCellValue(scheduleWarning.getCpm()==null?0:scheduleWarning.getCpm());
            hssfRow.createCell(4).setCellValue(scheduleWarning.getActualConsume()==null?0:scheduleWarning.getActualConsume());
            hssfRow.createCell(5).setCellValue(scheduleWarning.getPercent()==null?0:scheduleWarning.getPercent());
            hssfRow.createCell(6).setCellValue(StringUtils.defaultIfEmpty(scheduleWarning.getReason(),""));
        }
        return workbook;
    }
}
