package com.panacea.service;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panacea.model.hrm.LeaveRegister;
import com.panacea.repository.leave.LeaveRegisterRepo;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class EmployeeReportService {

	@Autowired
	private LeaveRegisterRepo reportRepository;

	public void generateReport() {
		try {

			List<LeaveRegister> employees = reportRepository.findAll();

		
			JasperReport compileReport = JasperCompileManager
					.compileReport(new FileInputStream("src/main/resources/employee-rpt-database.jrxml"));
			
			
			JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(employees);

			// Add parameters
			Map<String, Object> parameters = new HashMap<>();

			parameters.put("createdBy", "Websparrow.org");

			// Fill the report
			JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, parameters,
					jrBeanCollectionDataSource);

			// Export the report to a PDF file
			JasperExportManager.exportReportToPdfFile(jasperPrint,"\\scr\\main\\resources\\Emp-Rpt-Database.pdf");

			System.out.println("Done");

			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
