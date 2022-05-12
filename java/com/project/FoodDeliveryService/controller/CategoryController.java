package com.project.FoodDeliveryService.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.project.FoodDeliveryService.Model.Categorydata;
import com.project.FoodDeliveryService.Model.ItemsData;
import com.project.FoodDeliveryService.Model.RestaurantData;
import com.project.FoodDeliveryService.Service.CategoryDetailsService;
import com.project.FoodDeliveryService.Service.ItemsDetailsService;
import com.project.FoodDeliveryService.dto.Categorydto;
import com.project.FoodDeliveryService.repository.CategoryRepository;
import com.project.FoodDeliveryService.repository.ItemsRepository;
import com.project.FoodDeliveryService.repository.RestaurantRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class CategoryController {
	@Autowired
	private CategoryDetailsService categoryDetailsService;
	@Autowired
	private ItemsDetailsService itemsDetailsService;
	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ItemsRepository itemrepo;

	@Autowired
	private RestaurantRepository restaurantRepo;

	@PostMapping("/addcategory")
	public ResponseEntity<?>  additems(@RequestParam("myFile") MultipartFile file, @RequestParam String category)
			throws IOException {
		if(category==null) {
			return ResponseEntity.badRequest().body("Not allowed");
		}
//		if (this.categoryRepo.existsBycategoryname(category)) {
//			return ResponseEntity.badRequest().body("already exists");
//		} 
		else {
			Categorydata img = new Categorydata(category, file.getBytes());

			System.out.println(file.getBytes().length);

			final Categorydata categorydata = categoryRepo.save(img);
			return ResponseEntity.ok(categorydata);
		}

	}
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	@GetMapping ("/categorypic")
	public List categorypics() {
	List<String> list=new ArrayList<String>();
	
		 for(Categorydata category:categoryRepo.findAll())
		 {
			 byte[] file=category.getCategorypicture();
			 String encodebase64=null;
			 encodebase64=Base64.getEncoder().encodeToString(file);
			 list.add("data:image/jpeg;base64,"+encodebase64);
			 
		 }
		 System.out.println("hii");
		 return list;
	}

	
	@GetMapping("/categorypic/{categoryname}" )
	public Categorydata getImage(@PathVariable String categoryname) throws IOException {
		if(categoryname==null) {
			return null;
		}
		
		final Categorydata retrievedImage = categoryRepo.findBycategoryname(categoryname);
		if(retrievedImage.getCategorypicture()==null)
			return null;
		System.out.println(categoryname);
		Categorydata img = new Categorydata(retrievedImage.getCategoryname(),
				retrievedImage.getCategorypicture());
		
//		byte[] img =
//				decompressBytes(retrievedImage.getCategorypicture());
		System.out.println(img);
		return retrievedImage;
	}


	@PutMapping("/updatecategory")
	public ResponseEntity<?> updatecategory(@RequestBody Categorydto category) {
		if (this.categoryRepo.existsBycategoryname(category.getCategoryname())) {
			categoryDetailsService.save(category);

		} else {
			return ResponseEntity.badRequest().body("Error: category is not included!");

		}
		return ResponseEntity.ok(category);

	}

	@GetMapping("/findAllcategories")
	public List<Categorydata> findallitems() {
		return categoryRepo.findAll();

	}

//	@GetMapping("/finditemsincategories/{categoryid}")
//	public Set<ItemsData> findallitemsincategories(@PathVariable Long categoryid) {
//		Categorydata categorydata = categoryRepo.findAllByID(categoryid);
//		return categorydata.getCategory_ItemsDatas();
//
//	}

	@GetMapping("/allcategory")
	public List<String> allcategory() {
		List<Categorydata> categorydata = categoryRepo.findAll();
		List<String> categoryname = new ArrayList<String>();
		for (Categorydata temp : categorydata) {
			categoryname.add(temp.getCategoryname());
		}
		return categoryname;

	}

	@DeleteMapping("/deletecategory/{categoryname}")
	public String deletecategory(@PathVariable Long categoryname) {
		if (categoryRepo.existsById(categoryname)) {
			Categorydata categorydata = categoryRepo.findByID(categoryname);
			categoryRepo.delete(categorydata);
			return categoryname + " category deleted";
		} else {
			return "category not found";
		}

	}
//	@GetMapping("/allcategorywithpic")
//	public HashMap<String, byte[]> allcategorywithpic() {
//	   List<Categorydata> categorydata= categoryRepo.findAll();
//	   
//	   HashMap<String, byte[]> categorydetails = new HashMap<>();
//	   for (Categorydata temp : categorydata) { 
//          categorydetails.put(temp.getCategoryname(),temp.getCategorypicture());
//         }
//	return categorydetails;
//	 
//	}


	@GetMapping("/findcategorydetails/{categoryid}")
	public Categorydata findcategorydetails(@PathVariable Long categoryid) {
		return categoryRepo.findAllByID(categoryid);

	}
	@PutMapping("/additemstocategory")
	public ResponseEntity<?> additemstocategory(@PathVariable Long categoryid, @PathVariable Long itemid) {

		Categorydata category = categoryRepo.findAllByID(categoryid);

		ItemsData itemsData = itemrepo.findAllByID(itemid);

		if (category == null) {
			return ResponseEntity.badRequest().body("category not found");
		}

		if (itemsData == null) {
			return ResponseEntity.badRequest().body("item not found");
		}
		category.category_items(itemsData);

		categoryRepo.save(category);

		return ResponseEntity.ok(category);

	}

}