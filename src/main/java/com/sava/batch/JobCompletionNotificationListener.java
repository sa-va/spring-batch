package com.sava.batch;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sava.batch.model.Product;
import com.sava.batch.utils.CSVUtils;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		String csvFile = "output/cheapestProducts.csv";
		try {
			FileWriter writer = new FileWriter(csvFile);
			if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
				jdbcTemplate.query(
						"select product_id, name, condition, state, price from products p where id in (select id from products where product_id=p.product_id order by price limit 20) order by price limit 1000",
						(rs, row) -> new Product(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
								rs.getString(4), Float.parseFloat(rs.getString(5))))
						.forEach(p -> {
							try {
								CSVUtils.writeLine(writer, Arrays.asList(p.getProduct_id().toString(), p.getName(),
										p.getCondition(), p.getState(), p.getPrice().toString()));
							} catch (IOException e) {
								e.printStackTrace();
							}
						});
				writer.flush();
				writer.close();
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
