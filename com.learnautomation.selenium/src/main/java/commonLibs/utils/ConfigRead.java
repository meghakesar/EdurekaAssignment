package commonLibs.utils;


	import java.io.FileInputStream;
	import java.io.InputStream;
	import java.util.Properties;

	public class ConfigRead {
		
		public static Properties getProperties(String filename) throws Exception{
			
			filename = filename.trim();
			
			InputStream fileReader = new FileInputStream(filename);
			
			Properties property = new Properties();
			
			property.load(fileReader);
			
			return property;
		}

	}


