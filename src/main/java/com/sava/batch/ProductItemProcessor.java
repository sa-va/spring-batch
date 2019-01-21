package com.sava.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.sava.batch.model.Product;

public class ProductItemProcessor implements ItemProcessor<Product, Product> {
	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);

	@Override
	public Product process(final Product product) throws Exception {
		log.info("Processing - " + product);
		return product;
	}

}
