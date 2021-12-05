import java.nio.file.Path


public class FileUtils {
	
	public static boolean deleteDirectory(Path dir) {
		return dir.toFile().deleteDir();   // Groovy extends File class to implement deleteDir()
	}
}
