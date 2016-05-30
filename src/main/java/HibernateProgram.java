

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class HibernateProgram {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//Example of loading a User by id
		User loadedUser = (User) session.get(User.class, 3);
		System.out.println(loadedUser.toString());
		
		//Example of saving a new User to our aws db
		session.beginTransaction();
		User saveNewUser = new User("JohnDoe", "password6");
		session.save(saveNewUser);
		session.getTransaction().commit();
		
		//Example of SQL query and retrieval of User by username
		//Easy to substitute iduser or password as your search parameter but you need to
		//switch setString to setParameter
		Query query = session.createQuery("from User where username = :name")
				.setString("name", "JohnDoe");
		//I'm not sure if there is a better way to do this - creating a list to get the single entry
		//seems slightly overkill
		List<User> results =  query.list();
		for(User user: results){
			System.out.println(user.toString());
		}
		//Answer to above question: I looked it up - yes there is a better way to do this
		//for a unique result. See below.
		System.out.println("More efficient way for a single result:\n" + query.uniqueResult().toString());
		
		//Now if we want to delete the user we just entered we can do so as follows
		//We need to start a new transaction as we committed the last one
		session.beginTransaction();
		Query deleteQuery = session.createQuery("delete from User where username = :username")
			.setParameter("username", "JohnDoe");
		int rowCount = deleteQuery.executeUpdate();
		session.getTransaction().commit();
        System.out.println("Total number of entries deleted: " + rowCount);
        
        //What if we want to check if a username is already taken? Hibernate seems pretty ugly here.
        //There are a few ways to do this, none of them are pretty in my opinion. Here is the least
        //worst option I have found.
        String toCheck = "lucky";
		Query usernameCheck = session.createQuery("from User where username = :name")
				.setString("name", toCheck);
		if(usernameCheck.uniqueResult() == null){
			System.out.println("Username " + toCheck + " available.");
		}else{
			System.out.println("Username " + toCheck + " NOT available.");
		}
		
		//Here I show accessing all the data given a random user id
		int randomNum = 1 + (int)(Math.random() * 4); 
		Query getUserInfo = session.createQuery("from User where iduser = :id")
				.setParameter("id", randomNum);
		System.out.println(((User)getUserInfo.uniqueResult()).getUsername());
		Query getUserLists = session.createQuery("from ShoppingList where iduser = :id")
				.setParameter("id", randomNum);
		List<ShoppingList> shoppinglist = getUserLists.list();
		Query itemsList;
		List<Item> items;
		for(ShoppingList sl: shoppinglist){
			System.out.println(sl.getShoppinglistname());
			itemsList = session.createQuery("from Item where idshoppinglist = :id")
					.setParameter("id", sl.getIdshoppinglist());
			items = itemsList.list();
			for(Item it: items){
				System.out.println(it.getName());
			}
		}
		
        session.close();
		HibernateUtil.getSessionFactory().close();
	}
	

}
