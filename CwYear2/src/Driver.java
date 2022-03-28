import java.io.Serializable;

public abstract class Driver implements Serializable {
    private static final long serialVersionUID=1L;
     private String name;  //name of the driver
     private String location;  //location of the driver
     private String team; //team of the driver


    public Driver(String name, String location, String team) {
        this.name = name;
        this.location = location;
        this.team = team;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }



    public Driver() {

    }



}
