import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

public class MahonIanTestTask1
{

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
		BigDecimal nRate = new BigDecimal(1) ,rRate = new BigDecimal(0.5);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,6);
	}
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
		BigDecimal nRate = new BigDecimal(0) ,rRate = new BigDecimal(0);
		
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
		
		CarParkKind kind= CarParkKind.STAFF ;
		BigDecimal nRate = new BigDecimal(0) ,rRate = new BigDecimal(-0.5);
		
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
		BigDecimal nRate = new BigDecimal(-0.5) ,rRate = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,new IllegalArgumentException());
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
		BigDecimal nRate = new BigDecimal(0.5) ,rRate = new BigDecimal(1);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,6);
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
		BigDecimal nRate = new BigDecimal(1) ,rRate = new BigDecimal(0);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,4);
	}
	@Test
	public void ZeroNormalWholeReduced() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.VISITOR ;
		BigDecimal nRate = new BigDecimal(0) ,rRate = new BigDecimal(1);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,4);
	}
	@Test
	public void ReducedRateNeg() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.STAFF ;
		BigDecimal nRate = new BigDecimal(0) ,rRate = new BigDecimal(-1);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) , new IllegalArgumentException() );
	}
	@Test
	public void NormalRateNeg() 
	{
		Period rPeriod,nPeriod ;
		rPeriod = new Period(4,8) ;
		nPeriod = new Period(8,12) ;
		
		ArrayList<Period> ReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> NormalPeriod = new ArrayList<Period>();
		
		ReducedPeriod.add(rPeriod); 
		NormalPeriod.add(nPeriod);
		
		CarParkKind kind= CarParkKind.MANAGEMENT ;
		BigDecimal nRate = new BigDecimal(-1) ,rRate = new BigDecimal(1);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,new IllegalArgumentException());
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
		BigDecimal nRate = new BigDecimal(1) ,rRate = new BigDecimal(0.5);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,6.0);
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
		
		CarParkKind kind= CarParkKind.VISITOR ;
		BigDecimal nRate = new BigDecimal(0.5) ,rRate = new BigDecimal(1);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) ,6.0);
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
		
		CarParkKind kind= CarParkKind.VISITOR ;
		BigDecimal nRate = new BigDecimal(1);
		BigDecimal rRate = new BigDecimal(0);
		
		BigDecimal ExpectedResult = new BigDecimal(4);
		
		Rate TestRate = new Rate(kind,nRate,rRate,NormalPeriod,ReducedPeriod);
		
		assertEquals(TestRate.calculate(rPeriod).add(TestRate.calculate(nPeriod)) , ExpectedResult);
	}
	
}
