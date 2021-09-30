package eCommerceSite.dataAccess.concretes;

import java.util.List;

import eCommerceSite.dataAccess.abstracts.UserDao;
import eCommerceSite.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+" eklendi.");
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName()+" silindi.");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName()+" güncellendi.");
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
