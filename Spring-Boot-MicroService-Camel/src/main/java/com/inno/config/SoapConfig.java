
package com.inno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshall = new Jaxb2Marshaller();
		marshall.setPackagesToScan("com.inno.xml");
		return marshall;
	}
}
