//(months.indexOf(equalsIgnoreCase((A1.getMonth()))) < months.indexOf(equalsIgnoreCase((A1.getMonth()))))
// if the months are the same, compare by the day -> sort by the value of the day. 
//if the month and day are the same compare by time -> sort the appointment by time
class Planner {
    /*
              Mar 4, 17:30 Quiz 1
              Apr 1, 17:30 Midterm
              May 6, 17:30 Quiz 2
              Jun 3, 17:30 Final

    */
    private Appointment[] plans = new Appointment[20];
    char option = 'Z';

    private boolean compareAppointment(Appointment A1, Appointment A2) { //compare appointment begins
        //String [] months = {null, "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        if (A1.getMonthNum() < A2.getMonthNum() ^ (A1.getDay() < A2.getDay() && A1.getMonthNum() == A2.getMonthNum()) ^ (A1.getHour() < A2.getHour() && A1.getDay() == A2.getDay()) ^ (A1.getMinute() < A2.getMinute() && A1.getHour() == A2.getHour()))
            return true;
        else
            return false;


    } //compare ends

    private Planner() {

        plans[0] = new Appointment("Mar", 4, 17, 30, "Quiz 1");
        plans[1] = new Appointment("Apr", 1, 17, 30, "Midterm");
        plans[2] = new Appointment("May", 6, 17, 30, "Quiz 2");
        plans[3] = new Appointment("Jun", 3, 17, 30, "Final");


    } //planner con ends
    private int findNull() {//findNull return the index of where the first empty appointment is the array
        int str = 0;
        for (int i = 0; i < plans.length; i++) {
            if (plans[i] == null) {
                str = i;
                break;
            }
        } //for ends

        return str;

    } //findNull ends
    private void addAppointment(int q) {
        plans[q] = new Appointment();
        System.out.println("Appointment created.");
        plans[q].inputAppointment();
        System.out.println();
        insertAppointment(plans[q]);


    } //add ends
    //for the sorting, once you find the spot where the appoitment goes, move all the succeeding objects to arr[i + 1], the spot where the object goes should now be a copy of arr[i+1]
    private void insertAppointment(Appointment a) { //the paramter a is the most recent added appointment that was created by the user. which is plans[findNull()-1] 
  


        int stp = 0;
        int tempnull = 0;

        tempnull = findNull();
        for (int i = 0; i < tempnull - 1; i++) {
            //System.out.println(compareAppointment(a, plans[i]) + " the results  " + compareAppointment(plans[i + 1], a));
            if (compareAppointment(a, plans[i]) == true && (compareAppointment(plans[i + 1], a) == false)) {
                plans[findNull()] = a;
                //System.out.println("list 1 and i is: " + i);
                //listAppointments();
                //System.out.println("\n\n");
                tempnull = findNull();

                //System.out.println("list 2");
               // listAppointments();
                //System.out.println("\n\n");
                tempnull = findNull();
                for (int m = tempnull - 1; m > i; m--) {
                    plans[m] = plans[m - 1];

                } //nested for ends
                plans[i] = a;
                stp = i;
                System.out.println("appointment added");
                plans[findNull() - 1] = null;
                listAppointments();
                break;
            } //if ends

        } //for ends

        /*
        if (stp != findNull() - 1) {
        		for (int w = stp + 1; w < findNull(); w++) {
        plans[w] = plans[w+1];
        		}//for ends
        	}//if ends
        */
        //null, 9,8,7,6,5,4,3,2,1
        //9, 8, 7, 6, 5, 4, 3, 2, 1,1









    } //insertAppointment ends
    private void deleteAppointments() {
    	System.out.println("Pick a an appointment to delete");
    	for (int i = 0; i < findNull(); i++) {
    		System.out.println((i + 1) + ")" + plans[i].toString());
    	}//for ends
int di = UserInput.getInt();
//plans[di -1] = null;

for (int i = di - 1; i < (findNull()  - 1); i++) {
	System.out.println("\nreached");
plans[i] = plans[i+1]; 


}//for ends

plans[findNull() - 1] = null; 
System.out.println("\nAppointment has been deleted");
listAppointments();




	}//delete ends

    private void listAppointments() {
System.out.println("\ncurrent appointments");
        for (int i = 0; i < findNull(); i++) {
            if (plans[i].getMinute() > 9)
                System.out.println((i + 1) + ")" + plans[i].getMonth() + " " + plans[i].getDay() + ", - Time: " + plans[i].getHour() + ":" + plans[i].getMinute() + ", " + plans[i].getMessage());
            else
                System.out.println((i + 1) + ")" + plans[i].getMonth() + " " + plans[i].getDay() + ", - Time: " + plans[i].getHour() + ":0" + plans[i].getMinute() + ", " + plans[i].getMessage());
        }//for ends

    } //list ends
    private void run() {

        while (!(option == 'E' ^ option == 'e')) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("A)dd Appointment");
            System.out.println("D)elete Appointment");
            System.out.println("L)ist Appointments");
            System.out.println("E)xit");
            option = UserInput.getChar();

            switch (option) {
                case 'A':
                case 'a':
                    addAppointment(findNull());
                    break;
                case 'D':
                case 'd': deleteAppointments();
                break;
                case 'L':
                case 'l':
                    listAppointments();
                    break;
                case 'E':
                case 'e':
                    System.out.println("goodbye");
                    System.exit(0);
                    break;





            } //switch ends
            System.out.println("\n");
        } //while ends


    } //run ends
    public static void main(String[] args) {

        Planner day1 = new Planner();



        day1.listAppointments();
        day1.run();


        //tests








    } //main ends  

} //planner ends