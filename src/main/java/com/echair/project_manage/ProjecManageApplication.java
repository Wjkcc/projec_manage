package com.echair.project_manage;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ProjecManageApplication {

    public static void main(String[] args) {
//        DocsConfig config = new DocsConfig();
//        config.setProjectPath("E:\\projec_manage"); // 项目根目录
//        config.setProjectName("ProjectName"); // 项目名称
//        config.setApiVersion("V1.0");       // 声明该API的版本
//        config.setDocsPath("E:\\2020_07-07"); // 生成API 文档所在目录
//        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
//        Docs.buildHtmlDocs(config); // 执行生成文档
//        System.out.println("你好");
        SpringApplication.run(ProjecManageApplication.class, args);
    }

}
