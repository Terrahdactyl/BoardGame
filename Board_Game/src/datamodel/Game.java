package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  age INT NOT NULL,    
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "games")
public class Game {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "type")
   private String type;
   
   @Column(name = "minplayers")
   private Integer minplayers;
   
   @Column(name = "maxplayers")
   private Integer maxplayers;   

   public Game() {
   }

//   public Game(Integer id, String name, String type, Integer players) {
//      this.id = id;
//      this.name = name;
//      this.type = type;
//      this.players = players;
//   }

   public Game(String name, String type, Integer minplayers, Integer maxplayers) {
      this.name = name;
      this.type = type;
      this.minplayers = minplayers;
      this.maxplayers = maxplayers;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }
   
   public Integer getMinPlayers() {
	  return this.minplayers;
   }

   public Integer getMaxPlayers() {
	  return this.maxplayers;
   }
   
   public void setMinPlayers(Integer players) {
	  this.minplayers = players;
   }
   
   public void setMaxPlayers(Integer players) {
	  this.maxplayers = players;
   }

   @Override
   public String toString() {
      return "Board Game: " + this.id + ", " + this.name + ", " + this.type + ", " + this.minplayers + ", " + this.maxplayers;
   }
}
