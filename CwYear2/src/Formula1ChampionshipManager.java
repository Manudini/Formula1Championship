import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Formula1ChampionshipManager implements ChampionshipManager {
    Scanner input=new Scanner(System.in);

    static List<Formula1Driver> driverDetails= new ArrayList<>();
    static List<Races> raceDetails= new ArrayList<>();

    @Override
    public void createNewDriver() { // method to create a new driver
        int fPositions=0;  // initializing fPositons,sPositins,tPositions,currentNoOfPoints,numberOfRaces to zero
        int sPositions=0;
        int tPositions=0;
        int currentNoOfPoints=0;
        int numberOfRaces=0;
        System.out.println("Enter the driver's name: ");
        String name = input.nextLine();
        System.out.println("Enter the location: ");
        String location = input.nextLine();
        System.out.println("Enter the team: ");
        String team = input.nextLine();
        Formula1Driver d1=new Formula1Driver(name,location,team,fPositions,sPositions,tPositions,currentNoOfPoints,numberOfRaces);//creating the formula1driver object
        driverDetails.add(d1);  //adding the created object to the arraylist
        System.out.println("added to the list");
       // System.out.println(d1);

    }

    @Override
    public void deleteDriver() {   //method to delete an existing driver with the team

        System.out.println("Enter the driver's name you want to remove: ");
        String name=input.nextLine();

        for(int i=0; i < driverDetails.size(); i++) {
            if (driverDetails.get(i).getName().equals(name)) {
                driverDetails.remove(i);
                //System.out.println(driverDetails);
                System.out.println("removed " + name + " from the match");
            }
        }
    }

    @Override
    public void changeDriver() { //method to change a driver from a team.
        System.out.println("Enter the team name you want to change the driver: ");
        String team= input.nextLine();
        System.out.println("Enter the driver you want to add: ");
        String name=input.next();


        for(int i=0; i < driverDetails.size(); i++) {
            if (driverDetails.get(i).getTeam().equals(team)) {
               // System.out.println(driverDetails.remove(i));
                driverDetails.get(i).setName(name);
                driverDetails.get(i).setCurrentNoOfPoints(0);
                driverDetails.get(i).setfPositions(0);
                driverDetails.get(i).setsPositions(0);
                driverDetails.get(i).settPositions(0);
                driverDetails.get(i).setNumberOfRaces(0);
            }
        }
        System.out.println(name+" added to the "+team+" team.");
    }

    @Override
    public void displayStatistics() {      //method to display statistics of a selected driver.
        System.out.println("Enter the driver's name to see his statistics: ");
        String name = input.nextLine();
        for (int i = 0; i < driverDetails.size(); i++) {
            if (driverDetails.get(i).getName().equals(name)) {
                System.out.println(driverDetails.get(i));

            }
        }
    }

    @Override
    public void displayDriverTable() {

       Comparator<Formula1Driver> byNoOfPoints=new Comparator<Formula1Driver>() {   //https://stackoverflow.com/questions/4258700/collections-sort-with-multiple-fields
            @Override
            public int compare(Formula1Driver st1,Formula1Driver st2) {
                if(st1.getfPositions()== st2.getfPositions()) {                //comparing first positions
                    return st2.getfPositions()-st1.getfPositions();
                }else {
                    return -1;
                }


            }
        };

        Collections.sort(driverDetails, new Comparator<Formula1Driver>() {
            @Override
            public int compare(Formula1Driver st1,Formula1Driver st2) {        //comparing current no of points
                return st2.getCurrentNoOfPoints()-st1.getCurrentNoOfPoints();
            }}.thenComparing(byNoOfPoints));

            //printing the table

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %20s %15s %15s %15s %15s", "NAME", "LOCATION", "TEAM", "1ST POSITIONS","2ND POSITIONS","3RD POSITIONS","POINTS","RACES");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        for(Formula1Driver drivers: driverDetails){
            System.out.format("%10s %20s %20s %20s %15s %15s %15s %15s",
                    drivers.getName(), drivers.getLocation(), drivers.getTeam(), drivers.getfPositions(), drivers.getsPositions(), drivers.gettPositions(), drivers.getCurrentNoOfPoints(), drivers.getNumberOfRaces());
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");


    }    //https://www.delftstack.com/howto/java/print-a-table-in-java/

    @Override
    public void addRace() {   //method to add a race's details

        System.out.println("Enter date: ");
        String sDate1=input.nextLine();
        Date date1= null;          // https://www.javatpoint.com/java-string-to-date
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //System.out.println(sDate1+"\t"+date1);
        System.out.println("");
        System.out.println("Enter the race: ");
        String race = input.nextLine();
        System.out.println("Enter the driver who won first position: ");
        String name1 = input.nextLine();
        System.out.println("Enter the driver who won second position: ");
        String name2 = input.nextLine();
        System.out.println("Enter the driver who won third position: ");
        String name3 = input.nextLine();
        System.out.println("Enter the driver who won fourth position: ");
        String name4 = input.nextLine();
        System.out.println("Enter the driver who won fifth position: ");
        String name5 = input.nextLine();
        System.out.println("Enter the driver who won sixth position: ");
        String name6 = input.nextLine();
        System.out.println("Enter the driver who won seventh position: ");
        String name7 = input.nextLine();
        System.out.println("Enter the driver who won eighth position: ");
        String name8 = input.nextLine();
        System.out.println("Enter the driver who won ninth position: ");
        String name9 = input.nextLine();
        System.out.println("Enter the driver who won tenth position: ");
        String name10 = input.nextLine();

        Races r1=new Races(race,date1,name1,name2,name3,name4,name5,name6,name7,name8,name9,name10);//creating an object from Races class
        raceDetails.add(r1); //adding the created object to raceDetails arraylist
        r1.saveRace(); //saving the object to the file
        //r1.loadRace();

        for(int i=0; i < driverDetails.size(); i++) {
            if (driverDetails.get(i).getName().equals(name1)) {

                driverDetails.get(i).setfPositions(1);
                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(25);

            }else if (driverDetails.get(i).getName().equals(name2)) {

                driverDetails.get(i).setsPositions(1);
                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(18);

            }else  if (driverDetails.get(i).getName().equals(name3)) {

                driverDetails.get(i).settPositions(1);
                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(15);

            }else if (driverDetails.get(i).getName().equals(name4)) {
                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(12);

            }else if (driverDetails.get(i).getName().equals(name5)) {

                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(10);

            }else  if (driverDetails.get(i).getName().equals(name6)) {

                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(8);

            }else if (driverDetails.get(i).getName().equals(name7)) {

                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(6);

            }else if (driverDetails.get(i).getName().equals(name8)) {

                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(4);

            }else  if (driverDetails.get(i).getName().equals(name9)) {

                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(2);

            }else if (driverDetails.get(i).getName().equals(name10)) {
                driverDetails.get(i).setNumberOfRaces(1);
                driverDetails.get(i).setCurrentNoOfPoints(1);

            }
        }
    }


    @Override
    public void saveToFile() { // method to save all the driver details to the file.
                                //https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java

       try{
            FileOutputStream writeData = new FileOutputStream("Formula1DriverTable.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(driverDetails);

            writeStream.flush();
            writeStream.close();
           System.out.println("Saved to file");
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void loadFile() {  //method to load data from the saved file
        try {
            FileInputStream readData = new FileInputStream("Formula1DriverTable.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            System.out.println("file loaded");

            ArrayList<Formula1Driver> f1Driver = (ArrayList<Formula1Driver>) readStream.readObject();
            readStream.close();
            System.out.println(f1Driver.toString());

            driverDetails.addAll(f1Driver);   //adding the saved arraylist of objects to the driverDetails arraylist so that everytime the program starts,the previously saved driver details will be added to the arraylist.

        } catch (Exception e) {
            e.printStackTrace();
        }


    }      //https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java
}
