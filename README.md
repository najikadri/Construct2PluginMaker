# Construct2PluginMaker
plugin maker for Construct 2 developers

##Useful Code Snippet
**Copy any file in Java :**
```java
public static void copyFiles (File in, File out) {
		try {
			InputStream input = new FileInputStream(in);
			OutputStream output = new FileOutputStream(out);
			
			byte [] buffer = new byte[1024];
			
			int length;
			
			 while ((length = input.read(buffer)) > 0){
				 
	    	    	output.write(buffer, 0, length);
	 
	    	    }
			 
			 input.close();
			 output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
```
