
import java.io.ArrayList;
import java.io.Serializable;

class Filters implements Serializable{

   private int typeId;
   private String roomName;
   private int cop;
   private int stars;
   private int reviews;
   private String area;
   private ArrayList<Room> rooms=new ArrayList<>;

   public Filters(int id,String r,int count ,int s, int re, String a){
       this.typeId=id;
       this.roomName=r;
       this.cop=count;
       this.stars=s;
       this.reviews=re;
       this.area=a;
       rooms=new ArrayList<>;
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