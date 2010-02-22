package br.com.navita.mobile.console.deployable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class ZipClassLoader extends ClassLoader {
	private final String fileName;

	public ZipClassLoader(String filename, ClassLoader parent) throws IOException {
		super(parent);
		this.fileName = filename;
	}
	
	

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		ZipFile file = null;
		try {
			file = new ZipFile(fileName);
		} catch (IOException e1) {
			throw new ClassNotFoundException(fileName + "open error");
		}
		ZipEntry entry = file.getEntry(name.replace('.', '/') + ".class");
		if (entry == null) {
			throw new ClassNotFoundException(name);
		}
		InputStream in = null;
		ByteArrayOutputStream out = null;
		Class<?> result = null;
		try {
			byte[] array = new byte[1024];
			in = file.getInputStream(entry);
			out = new ByteArrayOutputStream(array.length);
			int length = in.read(array);
			while (length > 0) {
				out.write(array, 0, length);
				length = in.read(array);
			}
			result = defineClass(name, out.toByteArray(), 0, out.size());
		} catch (IOException exception) {
			throw new ClassNotFoundException(name, exception);
		}finally{
			try {
				if(in != null){
					in.close();
				}
				if(out != null){
					out.close();
				}				
				entry = null;
				file.close();
				
			} catch (IOException e) {
				//do nothing
			}

		}
		
		return result;
	}
	
	
}

