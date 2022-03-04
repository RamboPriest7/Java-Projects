import java.util.*;


class Appointment {
	
	 String [] months = {null, "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	 String month = "", message = ""; 
	 int day, hour,minute, monthnum;

	public  void setMonth(String a) {
		if ((a.equals("")) ^ a.length() != 3) {
       		System.out.println("Not valid length, please enter a 3 character string for month.");
       		UserInput.getString(0,3);
             } else {
            month = a;
        }//else ends
        for (int i = 1; i < months.length; i++) {
       // System.out.println(a.equalsIgnoreCase(months[i]) + "" + i);
        	if (a.equalsIgnoreCase(months[i]) && !(month.equals("nod"))) {
        		
        		monthnum = i;
        		

        	}

        } //for ends
	}//set month ends
	public  void setMessage(String b) {
		if (b.length() < 41)
		message = b;
	else 
		System.out.println("Data is invalid, message must be shorter than 40 characters.");
	}//Set Message ends
	public  void setDay(int c) {day = c;}
	public  void setHour(int d) {hour = d;}
	public  void setMinute(int e) {minute = e;}

	public  String getMonth() {return  month;}
	public  String getMessage() {return message;}
	public  int getDay() {return day;}
	public  int getHour() {return hour;}
	public  int getMinute() {return minute;}
	public  int getMonthNum() {return  monthnum;}
	

public Appointment() {
	setMonth("nod");
	setMessage("nod");
	setDay(0);
	setHour(0);
	setMinute(0);
}//Appointment ends
public Appointment(String a, int c, int d, int e, String b) {
	setMonth(a);
	setMessage(b);
	setDay(c);
	setHour(d);
	setMinute(e);
}//Appointment-2 ends


public  String toString() {
if (minute > 9) 
return "Date: " + month +" " + day +  ", - Time: " + hour  + ":" + minute + ", " + message;
else 
return "Date: " + month +" " + day +  ", - Time: " + hour  + ":0" + minute + ", " + message;

}


public  void inputAppointment() {
System.out.println("Create your Appointment.");

System.out.println("Month(3-letter)?");
setMonth(UserInput.getString(0, 3));
System.out.println("Day(number date)?");
setDay(UserInput.getInt(1, 31));
System.out.println("Hour?");
setHour(UserInput.getInt(0, 24));
System.out.println("minute?");
setMinute(UserInput.getInt(0, 60));
System.out.println("What is the Appointment for?");
setMessage(UserInput.getString(0, 40));

//--------------------------
/*System.out.println("Month(3-letter)?");

setMonth(UserInput.getString(0, 3));


//------------------

System.out.println("Day(number date)?");
setDay(UserInput.getInt(1, 31));
//---------------
System.out.println("Hour?");
setHour(UserInput.getInt(0, 24));
//--------------
System.out.println("minute?");
setMinute(UserInput.getInt(0, 60));

System.out.println("What is the Appointment for?");
setMessage(UserInput.getString(0, 40));
//--------------
*/


toString();
}


//main ends

}//class ends

