package RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Business;


public class ServiceConsumer {
	/*
	@Autowired
	
  static RestTemplate template=new RestTemplate();
	public static void main(String[] anu) {
		getData();
		getDataById();
		creeateBusiness();
		Update();
		Delete();
	}
	
	public static void getData() {
		HttpHeaders header=new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<>("parameters",header);
		String result=template.exchange("http://localhost:8086/home", HttpMethod.GET, entity, String.class).getBody();
		System.out.println(result);
	}	
	public static void getDataById() {
		Map<String, Integer> param=new HashMap<>();
		param.put("Id",1);
		Business bs=template.getForObject("http://localhost:8086/{id}", Business.class, param);
		System.out.println(bs.getName());
		System.out.println(bs.getGoods());
		System.out.println(bs.getAmount_p_day());
		System.out.println(bs.getLocaton());
		System.out.println(bs.getOwner());
	}
	//he use constructor
	public static void creeateBusiness() {
       Business bs=new Business();
       bs.setAmount_p_day(50000);
       bs.setGoods("Malapa");
       bs.setName("Biasharaaa");
       bs.setLocaton("Namgara");
       bs.setOwner("Anuaeryy");
       ResponseEntity<Business> result=template.postForEntity("http://localhost:8086/save", bs,Business.class);
		System.out.println(result.getBody());

	}
	//he use constructor
	public static void Update() {
		Map<String, Integer> param=new HashMap<>();
		param.put("Id",1);
		 Business bs=new Business();
	       bs.setAmount_p_day(3000);
	       bs.setGoods("Ndala");
	       bs.setName("Biasharaaee");
	       bs.setLocaton("Nanaagara");
	       bs.setOwner("Anuaryy");
	      template.put("http://localhost:8086/edit/{id}", bs,param);
	}
	public static void Delete() {
		Map<String, Integer> param=new HashMap<>();
		param.put("Id",1);
		template.delete("http://localhost:8086/delete", param);
	}
	*/
}
