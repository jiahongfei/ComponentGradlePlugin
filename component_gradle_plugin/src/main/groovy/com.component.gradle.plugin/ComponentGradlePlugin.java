package com.component.gradle.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentGradlePlugin implements Plugin<Project> {

    private static final String MAIN_NAME = "mainName";
    private static final String LIBRARY_NAMES = "libNames";
    private static final String IS_DEBUG = "isDebug";

    @Override
    public void apply(Project project) {
        System.out.println("ComponentGradlePlugin--------- start");
        System.out.println("hello apply");

        //获取当前Module gradle.properties中的MAIN_NAME属性,这个属性表示当前Module的名字
        String mainName = "";
        if (project.hasProperty(MAIN_NAME)) {
            mainName = (String) project.getProperties().get(MAIN_NAME);
            System.out.println(MAIN_NAME + " : " + mainName);
        }

        //获取当前Module gradle.properties中的LIBRARY_NAMES属性，这个属性表示MAIN_NAME依赖的库，可以是个列表
        List<String> libNameList = new ArrayList<>();
        if (project.hasProperty(LIBRARY_NAMES)) {
            String[] libNames = ((String) project.getProperties().get(LIBRARY_NAMES)).split(",");
            System.out.println("libNames : " + Arrays.toString(libNames));
            libNameList = Arrays.asList(libNames);
        }

        //获取当前Module gradle.properties中的IS_DEBUG属性,这个属性表示当前Module是否用Debug目录下的代码和资源
        boolean isDebug = true;
        if (project.hasProperty(IS_DEBUG)) {
            isDebug = Boolean.parseBoolean((String) project.getProperties().get(IS_DEBUG));
        }

        //获取当前gradle 运行的Module 名字
        String currName = project.getName();
        System.out.println("currName : " + currName);

        //获取当前gradle 运行的Module 名字
        String mudule = project.getPath().replace(":", "");
        System.out.println("module : " + mudule);

        //获取gradle执行task列表
        List<String> taskNameList = project.getGradle().getStartParameter().getTaskNames();
        System.out.println(taskNameList);

        //获取运行的Module的名字，运行时:app:assembleRelease或者:app:assembleDebug
        String taskName = "";
        if (taskNameList.size() > 0 && taskNameList.get(0).toUpperCase().contains("ASSEMBLE")) {
            try {
                taskName = taskNameList.get(0).split(":")[1];
                System.out.println("taskName : " + taskName);
                System.out.println("taskName Arrays : " + Arrays.toString(taskName.split(":")));
            } catch (Exception e) {
                e.printStackTrace();
                taskName = "";
            }
        }

        //如果assemble的Module是app，那么app的isDebug = true，其他的libNames的isDebug = false；
        //如果assemble的Module是library 那么library的isDebug = true，其他的libNames的isDebug = false；
        if (!"".equals(taskName)
                && !taskName.equals(mainName)) {
            isDebug = false;
        }

        Map<String, String> applyMap = new HashMap<>();
        if (isDebug) {
            applyMap.clear();
            applyMap.put("plugin", "com.android.application");
            project.apply(applyMap);
            //将main的isDebug = true，build.gradle sourceSets中调试代码起作用
        } else {
            applyMap.clear();
            applyMap.put("plugin", "com.android.library");
            project.apply(applyMap);
            //将library的isDebug = false，build.gradle sourceSets中调试代码不起作用

        }
        System.out.println(currName + " : " + applyMap.get("plugin") + " : " + isDebug);

        //添加依赖库，如果不是assemble运行是不要添加依赖库的，否则会报错
        if (!"".equals(taskName)) {
            for (int i = 0; i < libNameList.size(); i++) {
                System.out.println("Dependencies add : " + libNameList.get(i));
                project.getDependencies().add("compile", project.project(":" + libNameList.get(i)));
            }
        }

        if (project.hasProperty(IS_DEBUG)) {
            project.setProperty(IS_DEBUG, isDebug);
        }

        System.out.println("ComponentGradlePlugin--------- end");
        System.out.println();

    }
}