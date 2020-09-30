package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program_Product {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of products: ");
		int p = sc.nextInt();
		
		List<Product> product = new ArrayList<>();
		
		for(int i = 1; i <= p; i++) {
			System.out.println("Product #" + i +" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resp = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(resp == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, customsFee));
			}else if(resp == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, manufactureDate));
			}else {
				product.add(new Product(name, price));
			}
		}
		
		System.out.println("\nPRICE TAGS:");
	    for(Product pro : product) {
	    	System.out.println(pro.priceTag());
	    }
		
		sc.close();

	}

}
