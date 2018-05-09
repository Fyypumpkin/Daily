package ClassTest.ClassLoaderTest;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author fyypumpkin on 2018/5/9.
 */

public class FileClassLoaderTest extends ClassLoader {

    private String rootDir;

    public FileClassLoaderTest(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassByte(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    byte[] getClassByte(String name) {
        String path = this.classNameToDir(name);
        try {
            InputStream inputStream = new FileInputStream(path);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesNumRead = 0;
            while ((bytesNumRead = inputStream.read(buffer)) != -1) {
                System.out.println(bytesNumRead);
                byteArrayOutputStream.write(buffer, 0, bytesNumRead);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToDir(String name) {
        return rootDir + File.separatorChar + name.replace(".", "/") + ".class";
    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String rootDir = "/Users/fyypumpkin/Project/Idea/DailyTest/src/";
        FileClassLoaderTest loader = new FileClassLoaderTest(rootDir);

        Class clazz = loader.loadClass("ClassTest.ClassLoaderTest.demo");
        System.out.println(clazz.getConstructor().newInstance().toString());
        Method method = clazz.getMethod("test");
        method.invoke(clazz.getConstructor().newInstance(), null);
    }
}
