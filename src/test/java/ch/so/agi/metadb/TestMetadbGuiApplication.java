package ch.so.agi.metadb;

import org.springframework.boot.SpringApplication;

public class TestMetadbGuiApplication {

	public static void main(String[] args) {
		SpringApplication.from(MetadbGuiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
