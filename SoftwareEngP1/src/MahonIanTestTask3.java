package cm;

import static org.junit.Assert.*;


import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class MahonIanTestTask3
{
	@Test
	public void TwoZeros() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STAFF ;
		
		BigDecimal nRate = new BigDecimal(0) ;
		BigDecimal rRate = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,0);
	}
	@Test
	public void ReducedRateNegDec() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.MANAGEMENT ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(-0.5);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) , new IllegalArgumentException() );
	}
	@Test
	public void NormalRateNegDec() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STUDENT ;
		BigDecimal nRate = new BigDecimal(-0.5) ;
		BigDecimal rRate = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,new IllegalArgumentException());
	}
	@Test
	public void ReducedDecimal() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR  ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0.5);
		
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) , ExpectedResult);
	}
	@Test
	public void NormalDecimal() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.MANAGEMENT ;
		BigDecimal nRate = new BigDecimal(1.5) ;
		BigDecimal rRate = new BigDecimal(1);
		
		BigDecimal ExpectedResult = new BigDecimal(10);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)).stripTrailingZeros() , ExpectedResult.stripTrailingZeros());
	}
	@Test
	public void WholeNormalZeroReduced() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STUDENT ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(4);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,ExpectedResult);
	}
	@Test
	public void WholeNormalDecimalReduced() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0.5);
		
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)).stripTrailingZeros() , ExpectedResult.stripTrailingZeros());
		}
	@Test
	public void DecimalNormalWholeReduced() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.MANAGEMENT ;
		BigDecimal nRate = new BigDecimal(1.5) ;
		BigDecimal rRate = new BigDecimal(1);
		
		BigDecimal ExpectedResult = new BigDecimal(10);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)).stripTrailingZeros() , ExpectedResult.stripTrailingZeros());
	}
	@Test
	public void reducedPeriodOverlap() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(3,6) ;
		nPeriod = new Period(4,9) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STAFF ;
		BigDecimal nRate = new BigDecimal(4),rRate = new BigDecimal(3);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,new IllegalArgumentException());
	}
	@Test
	public void normalPeriodOverlap() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(7,9) ;
		nPeriod = new Period(5,8) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STUDENT ;
		BigDecimal nRate = new BigDecimal(4),rRate = new BigDecimal(3);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,new IllegalArgumentException());
	}
	@Test
	public void Success() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STAFF ;
		BigDecimal nRate = new BigDecimal(1);
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(4);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) , ExpectedResult);
	}
	@Test
	public void MultipleReducedP() 
	{
		Period rPeriod1,rPeriod2,rPeriod3,nPeriod ;
		rPeriod1 = new Period(1,2) ;
		rPeriod2 = new Period(2,3);
		rPeriod3 = new Period(3,4);
		nPeriod = new Period(4,5) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod1);
		ReducedPeriod.add(rPeriod2);
		ReducedPeriod.add(rPeriod3);
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR  ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod1).add(TestRate.calculate(nPeriod)) , ExpectedResult);
		assertEquals(TestRate.calculate(rPeriod2).add(TestRate.calculate(nPeriod)) , ExpectedResult);
		assertEquals(TestRate.calculate(rPeriod3).add(TestRate.calculate(nPeriod)) , ExpectedResult);
		
	}
	@Test
	public void MultipleNormalP() 
	{
		Period rPeriod,nPeriod1,nPeriod2,nPeriod3 ;
		rPeriod = new Period(1,2);
		nPeriod1 = new Period(4,5);
		nPeriod2 = new Period(5,6);
		nPeriod3 = new Period(6,7);
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod);
		NormalPeriod.add(nPeriod1);
		NormalPeriod.add(nPeriod2);
		NormalPeriod.add(nPeriod3);
		
		CarParkKind kind= CarParkKind.VISITOR  ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod1)) , ExpectedResult);
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod2)) , ExpectedResult);
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod3)) , ExpectedResult);
		
	}
	@Test
	public void MultipleBothP() 
	{
		Period rPeriod1,rPeriod2,rPeriod3,nPeriod1,nPeriod2,nPeriod3 ;
		rPeriod1 = new Period(1,2) ;
		rPeriod2 = new Period(2,3);
		rPeriod3 = new Period(3,4);
		nPeriod1 = new Period(4,5);
		nPeriod2 = new Period(5,6);
		nPeriod3 = new Period(6,7);
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod1);
		ReducedPeriod.add(rPeriod2);
		ReducedPeriod.add(rPeriod3);
		NormalPeriod.add(nPeriod1);
		NormalPeriod.add(nPeriod2);
		NormalPeriod.add(nPeriod3);
		
		CarParkKind kind= CarParkKind.STAFF  ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(1);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod1).add(TestRate.calculate(nPeriod1)) , ExpectedResult);
		assertEquals(TestRate.calculate(rPeriod2).add(TestRate.calculate(nPeriod2)) , ExpectedResult);
		assertEquals(TestRate.calculate(rPeriod3).add(TestRate.calculate(nPeriod3)) , ExpectedResult);
		
	}
	@Test
	public void MultipleOverlap() 
	{
		Period rPeriod1,rPeriod2,rPeriod3,nPeriod1,nPeriod2,nPeriod3 ;
		rPeriod1 = new Period(1,4) ;
		rPeriod2 = new Period(2,6);
		rPeriod3 = new Period(3,8);
		nPeriod1 = new Period(2,5);
		nPeriod2 = new Period(3,7);
		nPeriod3 = new Period(7,10);
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod1);
		ReducedPeriod.add(rPeriod2);
		ReducedPeriod.add(rPeriod3);
		NormalPeriod.add(nPeriod1);
		NormalPeriod.add(nPeriod2);
		NormalPeriod.add(nPeriod3);
		
		CarParkKind kind= CarParkKind.VISITOR  ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(1);
		
		
		
		try {
			Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
			}
			catch(IllegalArgumentException Error) 
		{
			}
		
	}
	@Test
	public void NullCarPark() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind = null;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(1);
		
		try {
			Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
			}
			catch(IllegalArgumentException Error) 
		{
			}
	}
	@Test
	public void NullNormalPeriod() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod = null;
		
		CarParkKind kind= CarParkKind.VISITOR  ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		
		
		try {
			Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
			}
			catch(IllegalArgumentException Error) 
		{
			}
	}
	@Test
	public void NullReducedPeriod() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod = null; 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR  ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		
		
		try {
			Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
			}
			catch(IllegalArgumentException Error) 
		{
			}
	}
	@Test
	public void NullReducedRate() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR  ;
		BigDecimal nRate = new BigDecimal(1) ;
		BigDecimal rRate = null;
		
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		
		
		try {
			Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
			}
			catch(IllegalArgumentException Error) 
		{
			}
	}
	@Test
	public void NullNormalRate() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR  ;
		BigDecimal nRate = null;
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		
		
		try {
			Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
			}
			catch(IllegalArgumentException Error) 
		{
			}
	}
	
	//TESTS USING ORIGINAL CALCULATE METHOD
	@Test
	public void RateVisitor() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR ;
		BigDecimal nRate = new BigDecimal(4);
		BigDecimal rRate = new BigDecimal(0);
		
		//FIRST 8 IS FREE THEN 50% OFF
		BigDecimal ExpectedResult = new BigDecimal(4);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) , ExpectedResult);
	}
	@Test
	public void RateStudent() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STUDENT ;
		BigDecimal nRate = new BigDecimal(4);
		BigDecimal rRate = new BigDecimal(0);
		
		// 25% OFF COSTS OVER 5.50
		BigDecimal ExpectedResult = new BigDecimal(12);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)).stripTrailingZeros(), ExpectedResult);
	}
	@Test
	public void RateStaff() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STAFF ;
		BigDecimal nRate = new BigDecimal(5);
		BigDecimal rRate = new BigDecimal(0);
		
		//COST SHOULD BE 20 BUT MAX FOR STAFF IS 16
		BigDecimal ExpectedResult = new BigDecimal(16);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) , ExpectedResult);
	}
	@Test
	public void RateManagement() 
	{
		Period rPeriod,nPeriod ;
		
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.MANAGEMENT ;
		BigDecimal nRate = new BigDecimal(0.50);
		BigDecimal rRate = new BigDecimal(0);
		
		//DUE TO TAKING THE TWO PERIODS SEPERATELY THIS WILL BE 6
		//MINIMUM PAYABLE IS 3
		BigDecimal ExpectedResult = new BigDecimal(6);
				
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		//System.out.print(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)));
		//System.out.print(TestRate.calculate(rPeriod));
		//System.out.print(TestRate.calculate(nPeriod));
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) , ExpectedResult);
	}
	//TESTS USING NEW CALCULATE METHOD
	@Test
	public void newRateVisitor1() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR ;
		BigDecimal nRate = new BigDecimal(2);
		BigDecimal rRate = new BigDecimal(0);
		
		//FIRST 8 IS FREE THEN 50% OFF
		BigDecimal ExpectedResult = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.newCalculate(rPeriod,nPeriod) , ExpectedResult);
	}	
	@Test
	public void newRateVisitor2() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR ;
		BigDecimal nRate = new BigDecimal(5);
		BigDecimal rRate = new BigDecimal(4);
		
		//FIRST 8 IS FREE THEN 50% OFF
		BigDecimal ExpectedResult = new BigDecimal(14);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.newCalculate(rPeriod,nPeriod) , ExpectedResult);
	}	
	@Test
	public void newRateStudent1() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STUDENT ;
		BigDecimal nRate = new BigDecimal(4);
		BigDecimal rRate = new BigDecimal(0);
		
		// 25% OFF COSTS OVER 5.50
		BigDecimal ExpectedResult = new BigDecimal(12);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.newCalculate(rPeriod,nPeriod).stripTrailingZeros(), ExpectedResult);
}
	@Test
	public void newRateStudent2() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STUDENT ;
		BigDecimal nRate = new BigDecimal(1);
		BigDecimal rRate = new BigDecimal(0);
		
		// 25% OFF COSTS OVER 5.50
		BigDecimal ExpectedResult = new BigDecimal(4);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.newCalculate(rPeriod,nPeriod).stripTrailingZeros(), ExpectedResult);
}
	@Test
	public void newRateStaff1() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STAFF ;
		BigDecimal nRate = new BigDecimal(5);
		BigDecimal rRate = new BigDecimal(0);
		
		//COST SHOULD BE 20 BUT MAX FOR STAFF IS 16
		BigDecimal ExpectedResult = new BigDecimal(16);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.newCalculate(rPeriod, nPeriod) , ExpectedResult);
}
	@Test
	public void newRateStaff2() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STAFF ;
		BigDecimal nRate = new BigDecimal(3);
		BigDecimal rRate = new BigDecimal(0);
		
		//COST SHOULD BE 12
		BigDecimal ExpectedResult = new BigDecimal(12);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.newCalculate(rPeriod, nPeriod) , ExpectedResult);
}
	@Test
	public void newRateManagement1() 
	{
		Period rPeriod,nPeriod ;
		
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.MANAGEMENT ;
		BigDecimal nRate = new BigDecimal(0.50);
		BigDecimal rRate = new BigDecimal(0);
		
		//MINIMUM PAYABLE IS 3
		BigDecimal ExpectedResult = new BigDecimal(3);
				
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.newCalculate(rPeriod, nPeriod) , ExpectedResult);
}
	@Test
	public void newRateManagement2() 
	{
		Period rPeriod,nPeriod ;
		
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.MANAGEMENT ;
		BigDecimal nRate = new BigDecimal(2);
		BigDecimal rRate = new BigDecimal(0);
		
		//MINIMUM PAYABLE IS 3
		BigDecimal ExpectedResult = new BigDecimal(8);
				
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.newCalculate(rPeriod, nPeriod) , ExpectedResult);
}
}
