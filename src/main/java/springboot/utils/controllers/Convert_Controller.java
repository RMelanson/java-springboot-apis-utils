package springboot.utils.controllers;

import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.utils.services.Convert_Service;

@CrossOrigin("*")
@RestController
public class Convert_Controller {
	static final String CMD = "CMD";

	// GET MAPPINGS
	@GetMapping(value = "/convert/xmltojson", produces = "application/json")
	public String getXMLtoJSON(@RequestParam String requestParms) {
		return Convert_Service.xmlToJson(requestParms);
	}

	@GetMapping(value = "/convert/jsontoxml", produces = "application/xml")
	public String getJSONtoXML(@RequestParam String requestParms) {
		return Convert_Service.jsonToXml(requestParms);
	}

	// POST MAPPINGS
	@PostMapping(value = "/convert/xmltojson", consumes = "application/xml", produces = "application/json")
	public String postXMLtoJSON(@RequestParam LinkedHashMap<String, Object> requestParms,
			@RequestBody String requestBody) {
		return Convert_Service.xmlToJson(requestBody);
	}

	@PostMapping(value = "/convert/jsontoxml", consumes = "application/json", produces = "application/xml")
	public String postJSONtoXML(@RequestParam LinkedHashMap<String, Object> requestParms,
			@RequestBody String requestBody) {
		return Convert_Service.xmlToJson(requestBody);
	}
}
