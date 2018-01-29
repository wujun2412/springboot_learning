package com.wujun.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringbootMybatisWriteReadApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void generateAsciiDocs() throws Exception{
		/*Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
				.build();

		Swagger2MarkupConverter.from(new URL("http://127.0.0.1:8080/v2/api-docs"))
				.withConfig(config)
				.build()
				.toFolder(Paths.get("src/docs/asciidoc/generated"));*/

	}

}
