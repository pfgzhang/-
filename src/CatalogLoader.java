import java.io.FileNotFoundException;
import java.io.*;

public interface CatalogLoader{
	public default Catalog loadCatalog(String filename) throws FileNotFoundException,
													   IOException,
													   DataFormatException{
		return null;
	}
}
