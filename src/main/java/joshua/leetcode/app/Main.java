package joshua.leetcode.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Main {

	//"Tue Jan 07 08:09:25 CST 2014"
	DateTimeFormatter mdyFormatter=DateTimeFormat.forPattern("EEE MMM dd hh:mm:ss z yyyy");  
	
	public static void testJDKDate(){
		try {
			String target1="28 Mar 2015 22:45 CST";
			DateFormat df=new SimpleDateFormat("dd MMM yyyy hh:mm z", Locale.ENGLISH);
		    Date result1=df.parse(target1);
//		    System.out.println(result1);
		    Calendar cal = Calendar.getInstance();
		    cal.setTime(result1);
		    int year = cal.get(Calendar.YEAR);
		    int month = cal.get(Calendar.MONTH);
		    int day = cal.get(Calendar.DAY_OF_MONTH);
		    int hh=cal.get(Calendar.HOUR_OF_DAY);
		    int mm=cal.get(Calendar.MINUTE);
		    int second=cal.get(Calendar.SECOND);
		    String formatted=String.format("%d %d %d %d:%d:%d", year,month,day,hh,mm,second);
		    
		    DateTime dt=new DateTime(year,month+1,day,hh,mm,second,DateTimeZone.forOffsetHours(-4));
		    DateTime dtNow=dt.withZone(DateTimeZone.forOffsetHours(+8));
		    System.out.println(dtNow.toDate().toString());
		    
		    
//		    String target2 = "Thu Sep 28 20:29:30 JST 2000";
//		    DateFormat df2 = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
//		    Date result2=df2.parse(target2);
//		    System.out.println(result2);
		    
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public static void main(String[] args) {
		
		testJDKDate();
		
		
		
//		Date jdkDate=new Date();
//		System.out.println(jdkDate);
//		DateTime jodaTimeNow=new DateTime(jdkDate);
//		DateTime tokyoDateNow=jodaTimeNow.withZone(DateTimeZone.forID("Asia/Tokyo"));
//		System.out.println(tokyoDateNow);
//		DateTime testTime=new DateTime(
//	            2015,
//	            3,
//	            28,
//	            23,
//	            0,
//	            DateTimeZone.forID("Europe/London"));
//		System.out.println("Ldn time:"+testTime);
//		
//		DateTime toTokyoDate=testTime.withZone(DateTimeZone.forID("Asia/Tokyo"));
//		System.out.println("Tokyo Time:"+toTokyoDate);
//		
//		if(tokyoDateNow.getYear()==tokyoDateNow.getYear()&&
//		   tokyoDateNow.getMonthOfYear()==toTokyoDate.getMonthOfYear()&&
//		   tokyoDateNow.getDayOfMonth()==toTokyoDate.getDayOfMonth()
//		   )
//			System.out.println("Same day");
//		System.out.println(testTime);
	}

	public long timeToUTC(String theSourceTime, int sourceWbxTZID)
			throws Exception {
		
		DateTime targDate;
		if (sourceWbxTZID == (-1)) {
			targDate = mdyFormatter.withZone(DateTimeZone.UTC).parseDateTime(
					theSourceTime);//
		} else {
			targDate = mdyFormatter.withZone(
					DateTimeZone.forID("Asia/Tokyo"))
					.parseDateTime(theSourceTime);
		}
		return targDate.getMillis();
	}

	public String UTCToTime(long theUTCTime, int targetWbxTZID)
			throws Exception {
		DateTime theSourceTime = new DateTime(theUTCTime);
		if (targetWbxTZID == (-1)) {
			return mdyFormatter.withZone(DateTimeZone.UTC).print(theSourceTime);
		} else {
			return mdyFormatter.withZone(
					DateTimeZone.forID("Asia/Tokyo")).print(
					theSourceTime);
		}
	}
}
