package com.app.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Product;
import com.app.service.IProductService;

@RestController
@RequestMapping("product")
public class ProductRestController {

	@Autowired
	private IProductService service;

	@GetMapping("show")
	public String show() {
		return "Hellow , This is Product service";
	}

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> uploadProduct(
			@RequestParam(value = "prodId",required = false) String prodId,
			@RequestParam(value = "prodCode",required = false) String prodCode,
			@RequestParam(value = "prodImg",required = false) MultipartFile img ,
			@RequestParam(value = "prodCost",required = false) Double prodCost,
			@RequestParam(value = "prodDes",required = false) String prodDes,
			@RequestParam(value = "prodQuantities",required = false) Integer prodQuantities,
			@RequestParam(value = "prodStatus",required = false) String prodStatus
			) throws IOException{
		ResponseEntity<String> resp = null;
		Product p = new Product();
		p.setProdCode(prodCode);
		p.setProdImg(img.getBytes());
		p.setProdCost(prodCost);
		p.setProdDes(prodDes);
		p.setProdQuantities(prodQuantities);
		String s=(0<prodQuantities) ? "Is Available":"Is Not Available";
		p.setProdStatus(s);

		try {
			service.saveProduct(p);
			resp = new ResponseEntity<String>("Product uploaded succesfully",HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	@SuppressWarnings("unchecked")
	@GetMapping("get/{code}")
	public ResponseEntity<String> getProductByCode(@PathVariable("code") String prodCode) {
		ResponseEntity<?> resp = null;
		Product product = service.findProduct(prodCode);
		try {
			if(product!=null) {
				resp = new ResponseEntity<Product>(product,HttpStatus.OK);
			}
			else {
				resp = new ResponseEntity<String>("Invalid product code...",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ResponseEntity<String>) resp;
	}

	@GetMapping("allprods")
	public ResponseEntity<?> getAllItems() {
		ResponseEntity<?> resp = null;
		try {
			List<Product> list = service.getAllProducts();
			if(list!=null && !list.isEmpty())
				resp = new ResponseEntity<List<Product>>(list,HttpStatus.OK);	
		} catch (Exception e) {
			resp = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

}
