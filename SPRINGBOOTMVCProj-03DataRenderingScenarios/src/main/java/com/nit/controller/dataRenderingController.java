package com.nit.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nit.model.Product;

@Controller
public class dataRenderingController {
	
	@RequestMapping("/")
	public String welcome() {
	return "welcome";
	}
	
   @GetMapping("/report")
	public String showReportData(Map<String,Object> map){
	   map.put("name","raja");
	   map.put("age",30);
	   map.put("city","Hyd");
		return "show_report";
	}
   @GetMapping("/report1")
   public String showReportDataUsingCollections(Map<String,Object> map) {
	   map.put("favColors",new String[] {"red","green","yellow","blue"});
	   map.put("nickNames",List.of("siva","haritha","sai","sumith"));
	   map.put("phoneNumbers",Set.of(9999L,999985L,8888L,7777L));
	   map.put("idDetails",Map.of("aadhar",8868585L,"voterId",178548L,"bankAc",132354L));
	   return "show_report1";
   }
   @GetMapping("/report2")
   public String showReportDataUsingModelData(Map<String,Object> map) {
	   Product pd=new Product(1000,"sivaganesh",200.0,1.0);
	 map.put("prodData", pd);
	   return "show_report2";
   }
   
   @GetMapping("/report3")
   public String showReportDataUsingModelDataList(Map<String, Object> map) {
	   List<Product> list=List.of(
			  new Product(1000,"sivaganesh",200.0,1.0),
			  new Product(100,"sai",201.0,2.0)
			   );
	   map.put("prodData", list);
	   return "show_report3";
   }
}//class
