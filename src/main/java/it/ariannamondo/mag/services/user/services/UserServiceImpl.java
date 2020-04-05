/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ariannamondo.mag.services.user.services;

import it.ariannamondo.mag.MagServiceInitializer;
import it.ariannamondo.mag.entity.UserLog;
import it.ariannamondo.mag.entity.User;
import it.ariannamondo.mag.entity.utils.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService,UserDetailsService {

    @PersistenceContext(unitName =MagServiceInitializer.PERSISTENCE_UNIT)
    private EntityManager em;
    /**
	 * Configure the entity manager to be used.
	 *
	 * @param em the {@link EntityManager} to set.
	 */
    public void setEntityManager(EntityManager em) {
		this.em = em;
     }
    @Override
    public void create(User users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(User users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(User users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        if(em==null){
            
        }
        Query q = em.createQuery("SELECT u FROM Users u");
        return q.getResultList();
    }

    @Override
    public List<User> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response getuserByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<User> getLogin(String login, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<UserLog> createLog(String address, String useragent, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<UserLog> updateLog(UserLog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<User> DisableUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<UserLog> getLastgLog(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException{
       User u  = null;
       try{ 
        TypedQuery<User> q =(TypedQuery<User>) em.createQuery("SELECT u FROM User u WHERE u.username = :login",User.class);
        q.setParameter("login", username);
        u = q.getSingleResult();
        Logger.getAnonymousLogger().log(Level.INFO, " User: {0}", u.getFirstName());
       }catch(NoResultException | NonUniqueResultException ex){
           throw new UsernameNotFoundException(username, ex);
       }
       return u;
    }
    
}
