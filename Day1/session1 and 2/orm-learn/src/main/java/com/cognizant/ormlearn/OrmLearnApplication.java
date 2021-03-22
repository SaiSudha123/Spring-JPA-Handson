package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;


@SpringBootApplication
public class OrmLearnApplication {

	
	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	
	public static void main(String[] args) throws CountryNotFoundException {
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);


		LOGGER.info("Start of test GetAllCountries");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("==========End of GetAllCountries========");
	


		LOGGER.info("find a country with code.");
		Country country1 = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country1);
		LOGGER.info("============End of find a country===============");
		
		
		
		LOGGER.info("Add a new Country Russia");
		Country country2 = new Country("RU","Russia");
		countryService.addCountry(country2);
		Country newcountry=countryService.findCountryByCode("RU");
		LOGGER.debug("Country:{}", newcountry);
		LOGGER.info("==========Adding completed=============");
		
		
		
		LOGGER.info("Adding a new country.");
		countryService.updateCountry("RU","Russian");
		Country countryupdate = countryService.findCountryByCode("RU");
		LOGGER.debug("Country:{}", countryupdate);
		LOGGER.info("===========Updating completed===========");
		
		
		
		LOGGER.info("Deletins a contry with cond name");
		Country countrydelete = countryService.findCountryByCode("RU");
		LOGGER.debug("Country:{}", countrydelete);
		countryService.deleteCountry("RU");
		LOGGER.info("========Deletion completed========");
		
		
		
		LOGGER.info("Add a new Country swraj");
		Country country4 = new Country("RU","Russia");
		countryService.addCountry(country4);
		Country newcountry1=countryService.findCountryByCode("RU");
		LOGGER.debug("Country:{}", newcountry1);
		LOGGER.info("========Adding done once again========");
		
		
		


		}
	

	
}
	
	
	
	
	
	
	
	
	

