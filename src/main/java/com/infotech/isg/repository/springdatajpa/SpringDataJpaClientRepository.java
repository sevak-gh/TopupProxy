package com.infotech.isg.repository.springdatajpa;

import com.infotech.isg.domain.Client;
import com.infotech.isg.repository.ClientRepository;
import org.springframework.data.repository.Repository;

/**
 * Spring Data Jpa specialization of Client repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaClientRepository extends ClientRepository, Repository<Client, Integer>  {
}
