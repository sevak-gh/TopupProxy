package com.infotech.isg.repository.springdatajpa;

import com.infotech.isg.domain.PaymentChannel;
import com.infotech.isg.repository.PaymentChannelRepository;
import org.springframework.data.repository.Repository;

/**
 * Spring Data Jpa specialization of PaymentChannel repository
 *
 * @author Sevak Gharibian
 */
public interface SpringDataJpaPaymentChannelRepository extends PaymentChannelRepository, Repository<PaymentChannel, String>  {
}
