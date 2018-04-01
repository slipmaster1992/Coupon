package Connections;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.DBDAO.CouponRepo;
import com.example.demo.entities.Coupon;

public class DailyService {


	
	// Coupon Repository
		@Autowired
		private CouponRepo coupdb;
		
		/***
		 * Getting All Expired Coupons
		 * @return
		 * @throws NoCouponsException
		 */
		public List<Coupon> getExpired()
		{
		
			// Making date object to compare
			Date date = new Date();
			date.setTime(System.currentTimeMillis());
		
			// Making a Coupon's list
			List<Coupon> coupons;
			coupons = coupdb.findExpiredCoupons(date);
		
			// Checking what we have got
			if(coupons.isEmpty() || coupons == null)
			{
				coupons = new ArrayList<>();
			}
			// Return Coupons
			return coupons;
		}
		
		/***
		 * Removing the expired Coupons
		 * @param coupons
		 */
		public synchronized void removeExpired(List<Coupon> coupons)
		{
			// Checking the list
			if(coupons.isEmpty() || coupons == null) return;
			
			// Removing
			for (Coupon coupon : coupons) {
				coupdb.removeCoupon(coupon.getId());
			}
			
		}
}
