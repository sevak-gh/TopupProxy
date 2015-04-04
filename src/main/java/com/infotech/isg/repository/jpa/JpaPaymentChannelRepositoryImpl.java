package com.infotech.isg.repository.jpa;

import com.infotech.isg.domain.PaymentChannel;
import com.infotech.isg.repository.PaymentChannelRepository;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * jpa implementation for PaymentChannel repository.
 *
 * @author Sevak Gharibian
 */
@Repository
public class JpaPaymentChannelRepositoryImpl implements PaymentChannelRepository {

    private final Logger LOG = LoggerFactory.getLogger(JpaPaymentChannelRepositoryImpl.class);

    @PersistenceContext
    EntityManager em;    

    @Override
    public PaymentChannel findById(String id) {
       return em.find(PaymentChannel.class, id);
    }
}
