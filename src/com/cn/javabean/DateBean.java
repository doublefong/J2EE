package com.cn.javabean;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateBean {
private String dateTime;
private String week;
private Calendar calendar=Calendar.getInstance();
public String getDateTime()
{
	Date currDate=Calendar.getInstance().getTime();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd�� HH��mm��ss��");
	dateTime=sdf.format(currDate);//�������ڼ�ʱ����ַ���
	return dateTime;

}

public String getWeek()
{
String[]weeks={"������","����һ","���ڶ�","������","������","������","������"};
int index=calendar.get(Calendar.DAY_OF_WEEK);
//��ȡ���ڼ�
week=weeks[index-1];
return week;
}
}
