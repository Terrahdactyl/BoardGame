/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

import datamodel.Feedback;
import datamodel.Game;

import org.hibernate.HibernateException;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }
   
   public static List<Feedback> listFeedback() {
	      List<Feedback> resultList = new ArrayList<Feedback>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         List<?> teams = session.createQuery("FROM Feedback").list();
	         for (Iterator<?> iterator = teams.iterator(); iterator.hasNext();) {
	        	 Feedback feedback = (Feedback) iterator.next();
	            resultList.add(feedback);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
   
   public static void createFeedback(String gameName, String rating, String review) {
	   
	   
	   // Format input
	   gameName = formatInfo(gameName);
	   review = formatInfo(review);
	   
	   // Check for any missing info
	   if (hasMissingFeedbackInfo(gameName, review)) {
		   System.out.println(gameName + " REVIEW HAD MISSING INPUT");
		   return; 
	   }
	   
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(new Feedback(gameName, Integer.valueOf(rating), review));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }

   public static List<Game> listGames() {
      List<Game> resultList = new ArrayList<Game>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> teams = session.createQuery("FROM Game").list();
         for (Iterator<?> iterator = teams.iterator(); iterator.hasNext();) {
            Game game = (Game) iterator.next();
            resultList.add(game);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static void createGames(String name, String description, String type, String minplayers, String maxplayers) {
	   

	   // Format input
	   name = formatInfo(name);
	   description = formatInfo(description);
	   type = formatInfo(type);
	   
	   // Check for any missing info
	   if (hasMissingGameInfo(name, description, type, minplayers, maxplayers)) {
		   System.out.println(name + " HAD MISSING INPUT OR INPUT HAD |");
		   return; 
	   }
		  
	   // Check if game already exists
	   if (doesGameExist(name)) 
	   {
		   System.out.println(name + " ALREADY EXISTS");
		   return;  
	   }
	   

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(new Game(name, description, type, Integer.valueOf(minplayers), Integer.valueOf(maxplayers)));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }
   
   public static List<Game> listGames(String keyword) {
      List<Game> resultList = new ArrayList<Game>();
      keyword = formatInfo(keyword);

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> games = session.createQuery("FROM Game").list();
         for (Iterator<?> iterator = games.iterator(); iterator.hasNext();) {
            Game game = (Game) iterator.next();
            if (game.getName().toLowerCase().equals((keyword.toLowerCase()))) {
               resultList.add(game);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }
   
   private static boolean hasMissingGameInfo(String name, String description, String type, String minplayers, String maxplayers) {
	   
	   if (name.isEmpty() || description.isEmpty() || type.isEmpty() || minplayers.isEmpty() || maxplayers.isEmpty())
		   return true;
	   
	   return false;
   }
   
   public static String formatInfo(String field) {
	   
	   field = field.replace("\"", "&quot;");
	   field = field.replace("|", "");
	   field = field.replace("<", "&lt;");
	   field = field.replace(">", "&gt;");
	   
	   return field;
   }
   
   public static boolean doesGameExist(String name) {
	   return !listGames(name).isEmpty();
   }
   
   private static boolean hasMissingFeedbackInfo(String gameName, String review) {
	   
	   if (gameName.isEmpty() || review.isEmpty())
		   return true;
	   
	   return false;
   }
   
}
