package Extend;

/**
 * Created by LSL on 2017/10/21
 * @introduce:根据父类的类文件获取所以的子类类文件集合，要求父类和子类在同一个包中，或者子类在子包中
 */
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtil
{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Class> getSonClass(Class fatherClass) {
		List<Class> sonClassList = new ArrayList<Class>();
		String packageName = fatherClass.getPackage().getName();
		List<Class> packageClassList = getPackageClass("ForTest");
		for (Class clazz : packageClassList) {
			if (fatherClass.isAssignableFrom(clazz) && !fatherClass.equals(clazz)) {
				sonClassList.add(clazz);
			}
		}
		return sonClassList;
	}

	@SuppressWarnings({ "rawtypes" })
	private static List<Class> getPackageClass(String packageName) {
		ClassLoader loader = ClassUtil.class.getClassLoader();
		String path = packageName.replace(".", "/");
		Enumeration<URL> resources = null;
		try {
			resources = loader.getResources(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<File> fileList = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			fileList.add(new File(resource.getFile()));
		}
		ArrayList<Class> classList = new ArrayList<Class>();
		for (File file : fileList) {
			classList.addAll(findClass(file, packageName));
		}
		return classList;
	}

	@SuppressWarnings({ "rawtypes" })
	private static List<Class> findClass(File file, String packageName) {
		List<Class> classList = new ArrayList<Class>();
		if (!file.exists()) {
			return classList;
		}
		File[] fileArray = file.listFiles();
		for (File subFile : fileArray) {
			if (subFile.isDirectory()) {
				assert !file.getName().contains(".");
				classList.addAll(findClass(subFile, packageName + "." + subFile.getName()));
			} else if (subFile.getName().endsWith(".class")) {
				try {
					classList.add(Class.forName(packageName + "." + subFile.getName().split(".class")[0]));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return classList;
	}
}