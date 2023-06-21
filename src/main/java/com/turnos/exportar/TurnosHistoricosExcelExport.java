package com.turnos.exportar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.turnos.model.Turno;


public class TurnosHistoricosExcelExport extends AbstractXlsxView {
	


	@Override
    protected void buildExcelDocument(
           Map<String, Object> model,
           Workbook workbook, 
           HttpServletRequest request,
           HttpServletResponse response) throws Exception {

       // define excel file name to be exported
       response.addHeader("Content-Disposition", "attachment;fileName=TurnosHistorico.xlsx");

       // read data provided by controller
       @SuppressWarnings("unchecked")
       List<Turno> list = (List<Turno>) model.get("turnos");

       // create one sheet 
       Sheet sheet = workbook.createSheet("Historial");

       // create row0 as a header
       Row row0 = sheet.createRow(0);
       row0.createCell(0).setCellValue("Terapista Nombre");
       row0.createCell(1).setCellValue("Terapista apellido");
       row0.createCell(2).setCellValue("Turno");
       row0.createCell(3).setCellValue("Fecha");
       row0.createCell(4).setCellValue("Hora");

       // create row1 onwards from List<T>
       int rowNum = 1;
       for(Turno spec : list) {
           Row row = sheet.createRow(rowNum++);
           row.createCell(0).setCellValue(spec.getTerapista().getNombre());
           row.createCell(1).setCellValue(spec.getTerapista().getApellido());
           row.createCell(2).setCellValue(spec.getId());
           row.createCell(3).setCellValue(spec.getFecha());
           row.createCell(4).setCellValue(spec.getHora());
       }
    }
}

