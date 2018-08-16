package com.github.houbb.tech.validation.reflect.util;

import com.github.houbb.paradise.common.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author houbinbin
 */
public class ClassUtil {

    /**
     * 根据一个接口返回该接口的所有类
     *
     * @param c 接口
     * @return List<Class>    实现接口的所有类
     */
    @SuppressWarnings("unchecked")
    public static List<Class> getAllClassByInterface(Class c) {
        List returnClassList = new ArrayList<Class>();
        //判断是不是接口,不是接口不作处理
        if (c.isInterface()) {
            //获得当前包名
            String packageName = c.getPackage().getName();
            try {
                //获得当前包以及子包下的所有类
                List<Class> allClass = getClasses(packageName);

                //判断是否是一个接口
                for (Class allClas : allClass) {
                    if (c.isAssignableFrom(allClas)) {
                        if (!c.equals(allClas)) {
                            returnClassList.add(allClas);
                        }
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return returnClassList;
    }

    /**
     * 根据包名获得该包以及子包下的所有类不查找jar包中的
     *
     * @param packageName 包名
     * @return List<Class>    包下所有类
     */
    private static List<Class> getClasses(String packageName) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            String newPath = resource.getFile().replace("%20", " ");
            dirs.add(new File(newPath));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClass(directory, packageName));
        }
        return classes;
    }

    private static List<Class> findClass(File directory, String packageName)
            throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if(ArrayUtil.isEmpty(files)) {
            return classes;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClass(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    @SuppressWarnings("unchecked")
    public static List<Class> getAllClassByAnnotation(Class annotationClass) {
        List returnClassList = new ArrayList<Class>();
        //判断是不是注解
        if (annotationClass.isAnnotation()) {
            //获得当前包名
            String packageName = annotationClass.getPackage().getName();
            try {
                //获得当前包以及子包下的所有类
                List<Class> allClass = getClasses(packageName);

                for (Class allClas : allClass) {
                    if (allClas.isAnnotationPresent(annotationClass)) {
                        returnClassList.add(allClas);
                    }
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return returnClassList;
    }
}
