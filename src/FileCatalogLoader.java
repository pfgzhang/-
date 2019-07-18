import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


public class FileCatalogLoader implements CatalogLoader {
	public Catalog loadCatalog(String filename)throws FileNotFoundException,IOException,DataFormatException{
		Catalog catalog = null;
		FileReader file = new FileReader(filename+".txt");
		BufferedReader br = new BufferedReader(file);
		String str;
		while((str=br.readLine())!=null) {
			Product p;
			if(str.startsWith("Product")) {
				p=this.readProduct(str);
			}else if(str.startsWith("Coffee")) {
				p = this.readCoffee(str);
			}else {
				p = this.readCoffeeBrewer(str);
			}
			catalog.addProduct(p);
		}
		return catalog;
	}
	
	private Product readProduct(String line) throws DataFormatException{
		StringTokenizer tknzr = new StringTokenizer(line,"_");
		String[] strs = new String[4];
		int i = 0;
		while(tknzr.hasMoreTokens()) {
			strs[i] = tknzr.nextToken();
		}
		double d = Double.parseDouble(strs[3]);
		Product p = new Product(strs[1],strs[2],d);
		return p;
	}
	
	private Coffee readCoffee(String line) throws DataFormatException{
		StringTokenizer tknzr = new StringTokenizer(line,"_");
		String[] strs = new String[10];
		int i = 0;
		while(tknzr.hasMoreTokens()) {
			strs[i] = tknzr.nextToken();
		}
		double d = Double.parseDouble(strs[3]);
		Coffee p = new Coffee(strs[1],strs[2],d,strs[4],strs[5],strs[6],strs[7],strs[8],strs[9]);
		return p;
	}
	
	private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException{
		StringTokenizer tknzr = new StringTokenizer(line,"_");
		String[] strs = new String[7];
		int i = 0;
		while(tknzr.hasMoreTokens()) {
			strs[i] = tknzr.nextToken();
		}
		double d = Double.parseDouble(strs[3]);
		int e = Integer.parseInt(strs[6]);
		CoffeeBrewer p = new CoffeeBrewer(strs[1],strs[2],d,strs[4],strs[5],e);
		return p;
	}
}