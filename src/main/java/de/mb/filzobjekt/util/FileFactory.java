package de.mb.filzobjekt.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileFactory {
	private static final JSONMapper mapper = new JSONMapper();
	private static final Charset encoding = Charset.forName("UTF-8");

	public static <T> T readFile(final String path, final Class<T> cls) throws IOException {
		System.out.println(path);
		final byte[] encoded = Files.readAllBytes(Paths.get(path));
		final String stringJson = encoding.decode(ByteBuffer.wrap(encoded)).toString();
		if (!stringJson.equals("")) {
			return mapper.readValue(stringJson, cls);
		}
		return null;
	}

	public static void updateFile(final Object obj, final String mainPath, final String fileName)
			throws IOException {
		System.out.println(mainPath);
		final File dir = new File(mainPath);
		if (!dir.exists() || !dir.isDirectory()) {
			if(!dir.mkdirs()){
				System.out.println("Folder not created");
				return;
			}
		}
		System.out.println("Folder: "+ dir);
		final File file = new File(dir, fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		System.out.println("File created");
		try (FileWriter fw = new FileWriter(file.getAbsoluteFile())) {
			try (BufferedWriter bw = new BufferedWriter(fw)) {
				bw.write(mapper.writeValueAsString(obj));
				bw.close();
			}
		}
	}
}
