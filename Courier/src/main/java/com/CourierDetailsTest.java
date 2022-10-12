package com;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.courier.CourierDetails;
import com.dao.CalculateDao;

class CourierDetailsTest {

	@Test
	void testInsertTransaction() throws SQLException {
		CourierDetails courierDetails = new CourierDetails();
		CalculateDao calculateDao = new CalculateDao();
		courierDetails.setCustomerName("Sahil");
		courierDetails.setMobile("9986161723");
		courierDetails.setFromCity("bengaluru");
		courierDetails.setToCity("lucknow");
		courierDetails.setWeight(560.0);
		courierDetails.setPrice(622.0);
		courierDetails.setShipmentDate(LocalDate.now());
		calculateDao.calculateDateAndPrice(courierDetails);
		int r=calculateDao.insertTransaction(courierDetails);
		assertEquals(1, r);
	}

	@Test
	void testSelectAllTransactions() {
		CalculateDao calculateDao = new CalculateDao();

		List<CourierDetails> list = calculateDao.selectAllTransactions("9986161723");
		assertNotNull(list);
	}

}
