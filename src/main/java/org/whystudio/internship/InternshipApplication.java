package org.whystudio.internship;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;

@Slf4j
@SpringBootApplication
@EnableSwagger2   // 放在有 @Configuration 注解的地方
public class InternshipApplication implements ApplicationRunner {
	@Value("${server.port}")
	public int port;

	@Value("${server.servlet.context-path}")
	public String context;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Tomcat服务启动完成: http://{}:{}{}", "ruankun.xyz", port,context);
		log.info("Swagger2 API文档: http://{}:{}{}/swagger-ui.html", "ruankun.xyz", port,context);
	}

	public static void main(String[] args) {

		// 创建文件夹, 用于临时存放word文档
		File file = new File("static");
		if (!file.exists() || !file.isDirectory()){
			log.warn("initial task:create static folder for word file saving!");
			file.mkdir();
			log.info("created successfully...path:{}", file.getPath());
		}else {
			log.info("path exists, no creating：{}", file.getPath());
		}

		SpringApplication.run(InternshipApplication.class, args);
	}
}
