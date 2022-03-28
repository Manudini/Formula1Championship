import java.io.Serializable;

public class Formula1Driver extends Driver implements Serializable {
    private static final long serialVersionUID=1L;
    private int fPositions;  //no of first positions won by a driver
    private int sPositions;  //no of second positions won by a driver
    private int tPositions;  //no of third positions won by a driver
    private int currentNoOfPoints;  //current no of points won by a driver
    private int numberOfRaces;  //no of races a driver participated

    public Formula1Driver() {

    }


    public int getfPositions() {
        return fPositions;
    }

    public void setfPositions(int fPositions) {
        this.fPositions += fPositions;
    }

    public int getsPositions() {
        return sPositions;
    }

    public void setsPositions(int sPositions) {
        this.sPositions += sPositions;
    }

    public int gettPositions() {
        return tPositions;
    }

    public void settPositions(int tPositions) {
        this.tPositions += tPositions;
    }

    public int getCurrentNoOfPoints() {
        return currentNoOfPoints;
    }

    public void setCurrentNoOfPoints(int currentNoOfPoints) {
        this.currentNoOfPoints += currentNoOfPoints;

    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces += numberOfRaces;
    }



    public Formula1Driver(String name,String location,String team,int fPositions, int sPositions, int tPositions, int currentNoOfPoints, int numberOfRaces) {
        super(name,location,team);
        this.fPositions = fPositions;
        this.sPositions = sPositions;
        this.tPositions = tPositions;
        this.currentNoOfPoints = currentNoOfPoints;
        this.numberOfRaces = numberOfRaces;
    }



    @Override
    public String toString() {
        return
                "name="+getName()+
                ", location="+getLocation()+
                ", team="+getTeam()+
                ", fPositions=" + fPositions +
                ", sPositions=" + sPositions +
                ", tPositions=" + tPositions +
                ", currentNoOfPoints=" + currentNoOfPoints +
                ", numberOfRaces=" + numberOfRaces
                ;
    }



}
