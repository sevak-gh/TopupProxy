package com.infotech.isg.repository.jpa;

import com.infotech.isg.domain.Client;
import com.infotech.isg.repository.ClientRepository;

import java.util.List;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jpa implementation for Client repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JpaClientRepositoryImpl implements ClientRepository {

    private final Logger LOG = LoggerFactory.getLogger(JpaClientRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;    

    @Override
    @SuppressWarnings("unchecked")        
    public Client findByUsername(String username) {
        Query query =  em.createNamedQuery("findClientByUsername", Client.class);
        query.setParameter("username", username);
        List<Client> clients = query.getResultList();
        if (clients.isEmpty()) {
            return null;
        }        
        return clients.get(0);
    }
}
