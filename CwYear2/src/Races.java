import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Races extends Formula1ChampionshipManager implements Serializable{
      private static final long serialVersionUID=1L;
      private String raceName;
      private Date result = null;
      private String fPositon;
      private String sPosition;
      private String tPosition;
      private String foPosition;
      private String fiPosition;
      private String siPosition;
      private String sePosition;
      private String eiPosition;
      private String niPosition;
      private String tePosition;

      public Races(){

      }
      public Races(String raceName, Date result, String fPositon, String sPosition, String tPosition, String foPosition, String fiPosition, String siPosition, String sePosition, String eiPosition, String niPosition, String tePosition) {
            this.raceName = raceName;
            this.result = result;
            this.fPositon = fPositon;
            this.sPosition = sPosition;
            this.tPosition = tPosition;
            this.foPosition = foPosition;
            this.fiPosition = fiPosition;
            this.siPosition = siPosition;
            this.sePosition = sePosition;
            this.eiPosition = eiPosition;
            this.niPosition = niPosition;
            this.tePosition = tePosition;


      }

      public String getRaceName() {
            return raceName;
      }

      public void setRaceName(String raceName) {
            this.raceName = raceName;
      }

      public Date getResult() {
            return result;
      }

      public void setResult(Date result) {
            this.result = result;
      }

      public String getfPositon() {
            return fPositon;
      }

      public void setfPositon(String fPositon) {
            this.fPositon = fPositon;
      }

      public String getsPosition() {
            return sPosition;
      }

      public void setsPosition(String sPosition) {
            this.sPosition = sPosition;
      }

      public String gettPosition() {
            return tPosition;
      }

      public void settPosition(String tPosition) {
            this.tPosition = tPosition;
      }

      public String getFoPosition() {
            return foPosition;
      }

      public void setFoPosition(String foPosition) {
            this.foPosition = foPosition;
      }

      public String getFiPosition() {
            return fiPosition;
      }

      public void setFiPosition(String fiPosition) {
            this.fiPosition = fiPosition;
      }

      public String getSiPosition() {
            return siPosition;
      }

      public void setSiPosition(String siPosition) {
            this.siPosition = siPosition;
      }

      public String getSePosition() {
            return sePosition;
      }

      public void setSePosition(String sePosition) {
            this.sePosition = sePosition;
      }

      public String getEiPosition() {
            return eiPosition;
      }

      public void setEiPosition(String eiPosition) {
            this.eiPosition = eiPosition;
      }

      public String getNiPosition() {
            return niPosition;
      }

      public void setNiPosition(String niPosition) {
            this.niPosition = niPosition;
      }

      public String getTePosition() {
            return tePosition;
      }

      public void setTePosition(String tePosition) {
            this.tePosition = tePosition;
      }

      @Override
      public String toString() {
            return "Races{" +
                    "raceName='" + raceName + '\'' +
                    ", result=" + result +
                    ", fPositon='" + fPositon + '\'' +
                    ", sPosition='" + sPosition + '\'' +
                    ", tPosition='" + tPosition + '\'' +
                    ", foPosition='" + foPosition + '\'' +
                    ", fiPosition='" + fiPosition + '\'' +
                    ", siPosition='" + siPosition + '\'' +
                    ", sePosition='" + sePosition + '\'' +
                    ", eiPosition='" + eiPosition + '\'' +
                    ", niPosition='" + niPosition + '\'' +
                    ", tePosition='" + tePosition + '\'' +
                    '}';
      }

      public void saveRace(){
            try{
                  FileOutputStream writeData = new FileOutputStream("Formula1RaceTable.ser");
                  ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                  writeStream.writeObject(raceDetails);

                  writeStream.flush();
                  writeStream.close();
                  System.out.println("Saved to file");
            }catch (IOException e) {
                  e.printStackTrace();
            }
      }

      public void loadRace(){
            try {
                  FileInputStream readData = new FileInputStream("Formula1RaceTable.ser");
                  ObjectInputStream readStream = new ObjectInputStream(readData);
                  System.out.println("file loaded");

                  ArrayList<Races> races = (ArrayList<Races>) readStream.readObject();
                  readStream.close();
                  System.out.println(races.toString());

                  raceDetails.addAll(races);
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }
}
