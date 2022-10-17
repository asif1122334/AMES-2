package com.marlabs.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marlabs.dao.AssociateDetailsRepository;
import com.marlabs.export.ExportPdf;
import com.marlabs.model.AssociateDetails;

@Controller
public class AssoiciateDetailsController {
	@Autowired
	AssociateDetailsRepository associateRepo;

	@GetMapping("/get")
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = { "/allDetails" }, method = RequestMethod.GET)
	public String viewList(Model model) {

		Iterable<AssociateDetails> all = associateRepo.findAll();
		model.addAttribute("details", all);

		return "details";
	}

	@GetMapping(value = "/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {

		List<AssociateDetails> list = associateRepo.findAll();

		ByteArrayInputStream bis = ExportPdf.employeesReport(list);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=associateMaster.pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

}
