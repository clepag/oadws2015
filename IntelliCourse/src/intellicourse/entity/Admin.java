package intellicourse.entity;
// Generated 29.11.2015 23:06:33 by Hibernate Tools 4.3.1



/**
 * Admin generated by hbm2java
 */
public class Admin  implements java.io.Serializable {


     private Integer uid;
     private User user;

    public Admin() {
    }

    public Admin(User user) {
       this.user = user;
    }
   
    public Integer getUid() {
        return this.uid;
    }
    
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }




}

