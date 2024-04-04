
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
import java.time.*;

class Filters implements Serializable{

   private int typeId;
   private String roomName;
   private int cop;
   private Date startdate;
   private Date enddate;
   private int stars;
   private int reviews;
   private String area;
   private ArrayList<Room> rooms=new ArrayList<>(cop);


   public Filters(int id,String r,int count,Date sd, Date ed ,int s, int re, String a){
       this.typeId=id;
       this.roomName=r;
       this.cop=count;
       this.startdate=sd;
       this.enddate=ed;
       this.stars=s;
       this.reviews=re;
       this.area=a;
       rooms=new ArrayList<>(count);
   }
   
   public Filters(Filters object){
       this.typeId=object.getId();
       this.roomName=object.getRoomName();
       this.cop=object.getCop();
       this.stars= object.getStars();
       this.reviews=object.getNoOfReviews();
       this.area=object.getArea();
   }



   public int getId(){     
       return typeId;
   }
   public void setId(int id){
       this.typeId = id;
   }

   public String getRoomName(){
       return roomName;
   }
   public void setRoomName(String roomName){
       this.roomName = roomName;
   }
    public String getArea(){
       return area;
   }
    public Date getStarDate(){
        return startdate;
    }
    public void setStartDate(Date sd){
        this.startdate=sd;
    }

    public Date getEndDate(){
        return enddate;
    }
    public void setEndDate(Date ed){
        this.enddate=ed;
    }

    public void setArea(String area){
        this.area = area;
    }
    public int getCop(){
       return cop;
    }
    public void setCop(int c){
       this.cop = c;
    }
    public int getStars(){
       return stars;
    }
    public void setStars(int stars){
       this.stars = stars;
    }
    public int getNoOfReviews(){
       return reviews;
    }
   public void setNoOfReviews(int reviews){
       this.reviews = reviews;
    }




   

}