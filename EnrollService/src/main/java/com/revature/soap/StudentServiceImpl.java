package com.revature.soap;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Student;

@WebService(serviceName= "student-service", targetNamespace= "http://service.revature.com/")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Student> findAll() {
		final String URI = "/student-service?wsdl";
		final String SOAP_MESSAGE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.revature.com/\">\r\n"
				+ "   <soapenv:Header/>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <ser:findAll()>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request = new HttpEntity<>(SOAP_MESSAGE, header);
		//List<Student> a= this.restTemplate.execute(URI, request);
		return null;
		
	}

	@Override
	public String saveStudent(String name, int age) {
		final String URI = "/student-service?wsdl";
		final String SOAP_MESSAGE = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.revature.com/\">\r\n"
				+ "   <soapenv:Header/>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <ser:saveStudent>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <arg0>\r\n" 
				+ "				<age>"+age+"</age>\r\n"
				+ "				<id>10</id>\r\n"
				+ "				<name>"+name+"</name>\r\n"
				+ "			</arg0>\r\n"
				+ "      </ser:receiveMessage>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> request = new HttpEntity<>(SOAP_MESSAGE, header);
		this.restTemplate.postForLocation(URI, request);
		return name+" was added as a student";
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
