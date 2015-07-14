package com.infotech.com.it;

import com.infotech.isg.domain.Operator;
import com.infotech.isg.domain.PaymentChannel;
import com.infotech.isg.domain.Client;
import com.infotech.isg.domain.Transaction;
import com.infotech.isg.domain.BankCodes;
import com.infotech.isg.domain.ServiceActions;
import com.infotech.isg.domain.OperatorStatus;
import com.infotech.isg.domain.Balance;
import com.infotech.isg.domain.Audit;
import com.infotech.isg.repository.OperatorRepository;
import com.infotech.isg.repository.TransactionRepository;
import com.infotech.isg.repository.ClientRepository;
import com.infotech.isg.repository.PaymentChannelRepository;
import com.infotech.isg.repository.AuditLogRepository;
import com.infotech.isg.repository.OperatorStatusRepository;
import com.infotech.isg.repository.BalanceRepository;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.notNullValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * integration test for repository
 *
 * @author Sevak Gahribian
 */
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class RepositoryIT extends AbstractTransactionalTestNGSpringContextTests {

    private static final Logger LOG = LoggerFactory.getLogger(RepositoryIT.class);

    @Autowired
    private OperatorRepository operatorRepo;

    @Autowired
    private PaymentChannelRepository paymentChannelRepo;

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private ClientRepository clientRepo;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private OperatorStatusRepository operatorStatusRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private DataSource ds;

    @DataProvider(name = "provideRegisteredOperatorIds")
    public Object[][] provideRegisteredOperatorIds () {
        return new Object[][] {
            {Operator.MTN_ID},
            {Operator.MCI_ID},
            {Operator.JIRING_ID}
        };
    }

    @DataProvider(name = "provideUnregisteredOperatorIds")
    public Object[][] provideUnregisteredOperatorIds() {
        return new Object[][] {
            {0},
            {-1},
            {5}
        };
    }

    @Test(dataProvider = "provideRegisteredOperatorIds")
    public void shouldFindRegisteredOperatorById(int operatorId) {
        // arrange
        Operator operator = null;

        // act
        operator = operatorRepo.findById(operatorId);

        // assert
        assertThat(operator, is(notNullValue()));
        assertThat(operator.getId(), is(operatorId));
    }

    @Test(dataProvider = "provideUnregisteredOperatorIds")
    public void shouldNotFindUnregisteredOperatorById(int operatorId) {
        // arrange
        Operator operator = null;

        // act
        operator = operatorRepo.findById(operatorId);

        // assert
        assertThat(operator, is(nullValue()));
    }

    @DataProvider(name = "provideRegisteredPaymentChannels")
    public Object[][] provideRegisteredPaymentChannels() {
        return new Object[][] {
            {"59"},
            {"14"},
            {"05"}
        };
    }

    @DataProvider(name = "provideUnregisteredPaymentChannels")
    public Object[][] provideUnregisteredPaymentChannels() {
        return new Object[][] {
            {""},
            {"0"},
            {"11"},
            {"-1"}
        };
    }

    @Test(dataProvider = "provideRegisteredPaymentChannels")
    public void shouldFindRegisteredPaymentChannelById(String channelId) {
        // arrange
        PaymentChannel channel = null;

        // act
        channel = paymentChannelRepo.findById(channelId);

        // assert            
        assertThat(channel, is(notNullValue()));
        assertThat(channel.getId(), is(channelId));
        assertThat(channel.getIsActive(), is(true));
    }

    @Test(dataProvider = "provideUnregisteredPaymentChannels")
    public void shouldFindUnregisteredPaymentChannelById(String channelId) {
        // arrange
        PaymentChannel channel = null;

        // act
        channel = paymentChannelRepo.findById(channelId);

        // assert            
        assertThat(channel, is(nullValue()));
    }

    @DataProvider(name = "provideRegisteredUsernames")
    public Object[][] provideRegisteredUsernames() {
        return new Object[][] {
            {"root"}
        };
    }

    @Test(dataProvider = "provideRegisteredUsernames")
    public void shouldFindRegisteredClientByUsername(String username) {
        // arrange
        Client client = null;

        // act
        client = clientRepo.findByUsername(username);

        // assert
        assertThat(client, is(notNullValue()));
        assertThat(client.getUsername(), is(username));
        assertThat(client.getVendor(), is("vendor"));
        assertThat(client.getIsActive(), is(true));
        assertThat(client.getIps(), is(notNullValue()));
        assertThat(client.getIps().size(), is(2));
        assertThat(client.getIps().get(0), is("1.1.1.1"));
        assertThat(client.getIps().get(1), is("2.2.2.2"));
    }
 
    @DataProvider(name = "provideUnregisteredUsernames")
    public Object[][] provideUnregisteredUsernames() {
        return new Object[][] {
            {""},
            {null},
            {"test"}
        };
    }

    @Test(dataProvider = "provideUnregisteredUsernames")
    public void shouldNotFindUnregisteredClientByUsername(String username) {
        // arrange
        Client client = null;

        // act
        client = clientRepo.findByUsername(username);

        // assert
        assertThat(client, is(nullValue()));
    } 

    @Test
    public void shouldGetEmptyListWhenTransactionNotFound() {
        // arrange
        String refNum = "ref123456";
        String bankCode = BankCodes.SAMAN;
        int clientId = 3;
        List<Transaction> transactions = null;

        // act
        transactions = transactionRepo.findByRefNumBankCodeClientId(refNum, bankCode, clientId);

        // assert
        assertThat(transactions, is(notNullValue()));
        assertThat(transactions.size(), is(0));
    }

    @Test
    public void shouldRegisterAndThenFindTheTransaction() {
        // arrange
        Transaction transaction = null;
        String refNum = "ref123456";
        String bankCode = BankCodes.SAMAN;
        int clientId = 3;
        long amount = 10000L;
        String consumer = "09125067064";
        int stf = 1;
        String operatorTId = "opr123456"; 
        transaction = new Transaction();
        transaction.setProvider(Operator.MCI_ID);
        transaction.setAction(ServiceActions.TOP_UP);
        transaction.setState("trstate");
        transaction.setResNum("res123456");
        transaction.setRefNum(refNum);
        transaction.setRemoteIp("10.30.180.38");
        transaction.setAmount(amount);
        transaction.setChannel("54");
        transaction.setConsumer(consumer);
        transaction.setBankCode(bankCode);
        transaction.setClientId(clientId);
        transaction.setCustomerIp("10.1.1.1");
        transaction.setTrDateTime(new Date());
        transaction.setStatus(-1);
        transaction.setBankVerify(new Integer(10000));
        transaction.setVerifyDateTime(new Date());
        transaction.setStf(stf);
        transaction.setOperatorTId(operatorTId);
        List<Transaction> transactions = null;

        // act
        transactionRepo.save(transaction);
        transactions = transactionRepo.findByRefNumBankCodeClientId(refNum, bankCode, clientId);
        transaction = transactionRepo.findByProviderOperatorTId(Operator.MCI_ID, operatorTId);
        
        // assert
        assertThat(transactions, is(notNullValue()));
        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0).getRefNum(), is(refNum));
        assertThat(transactions.get(0).getBankCode(), is(bankCode));
        assertThat(transactions.get(0).getClientId(), is(clientId));
        assertThat(transactions.get(0).getAmount(), is(amount));
        assertThat(transactions.get(0).getConsumer(), is(consumer));
        assertThat(transaction, is(notNullValue()));
        assertThat(transaction.getProvider(), is(Operator.MCI_ID));
        assertThat(transaction.getOperatorTId(), is(operatorTId));
    }

    @Test
    public void shouldRegisterAndThenFindTheTransactionByStf() {
        // arrange
        Transaction transaction = null;
        String refNum = "ref123456";
        String bankCode = BankCodes.SAMAN;
        int clientId = 3;
        long amount = 10000L;
        String consumer = "09125067064";
        int stf = 1;
        String operatorTId = "opr123456"; 
        transaction = new Transaction();
        transaction.setProvider(Operator.MCI_ID);
        transaction.setAction(ServiceActions.TOP_UP);
        transaction.setState("trstate");
        transaction.setResNum("res123456");
        transaction.setRefNum(refNum);
        transaction.setRemoteIp("10.30.180.38");
        transaction.setAmount(amount);
        transaction.setChannel("54");
        transaction.setConsumer(consumer);
        transaction.setBankCode(bankCode);
        transaction.setClientId(clientId);
        transaction.setCustomerIp("10.1.1.1");
        transaction.setTrDateTime(new Date());
        transaction.setStatus(-1);
        transaction.setBankVerify(new Integer(10000));
        transaction.setVerifyDateTime(new Date());
        transaction.setStf(stf);
        transaction.setOperatorTId(operatorTId);
        List<Transaction> transactions = null;

        // act
        transactionRepo.save(transaction);
        transactions = transactionRepo.findByStfProvider(stf, Operator.MCI_ID);
        
        // assert
        assertThat(transactions, is(notNullValue()));
        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0).getRefNum(), is(refNum));
        assertThat(transactions.get(0).getBankCode(), is(bankCode));
        assertThat(transactions.get(0).getClientId(), is(clientId));
        assertThat(transactions.get(0).getAmount(), is(amount));
        assertThat(transactions.get(0).getConsumer(), is(consumer));
        assertThat(transactions.get(0).getStf(), is(stf));
        assertThat(transactions.get(0).getProvider(), is(Operator.MCI_ID));
    }

    @Test
    public void shouldUpdateAndThenFindTheTransaction() {
        // arrange
        Transaction transaction = null;
        String refNum = "ref123456";
        String refNumUpdate = "ref111111";
        String bankCode = BankCodes.SAMAN;
        int clientId = 3;
        long amount = 10000L;
        String consumer = "09125067064";
        int stf = 1;
        String operatorTId = "opr123456"; 
        transaction = new Transaction();
        transaction.setProvider(Operator.MCI_ID);
        transaction.setAction(ServiceActions.TOP_UP);
        transaction.setState("trstate");
        transaction.setResNum("res123456");
        transaction.setRefNum(refNum);
        transaction.setRemoteIp("10.30.180.38");
        transaction.setAmount(amount);
        transaction.setChannel("54");
        transaction.setConsumer(consumer);
        transaction.setBankCode(bankCode);
        transaction.setClientId(clientId);
        transaction.setCustomerIp("10.1.1.1");
        transaction.setTrDateTime(new Date());
        transaction.setStatus(-1);
        transaction.setBankVerify(new Integer(10000));
        transaction.setVerifyDateTime(new Date());
        transaction.setStf(stf);
        transaction.setOperatorTId(operatorTId);
        List<Transaction> transactions = null;

        // act
        transactionRepo.save(transaction);
        transaction.setRefNum(refNumUpdate);
        transaction.setStatus(1);
        transaction.setOperatorDateTime(new Date());
        transaction.setOperatorResponseCode(0);
        transaction.setOperatorResponse("sim card charged");
        transaction.setToken("MCI-TOKEN:ABC12356");
        transaction.setOperatorTId("T123456789");
        transactionRepo.save(transaction);    
        transactions = transactionRepo.findByRefNumBankCodeClientId(refNumUpdate, bankCode, clientId);
        
        // assert
        assertThat(transactions, is(notNullValue()));
        assertThat(transactions.size(), is(1));
        assertThat(transactions.get(0).getRefNum(), is(refNumUpdate));
        assertThat(transactions.get(0).getBankCode(), is(bankCode));
        assertThat(transactions.get(0).getClientId(), is(clientId));
        assertThat(transactions.get(0).getAmount(), is(amount));
        assertThat(transactions.get(0).getConsumer(), is(consumer));
        assertThat(transactions.get(0).getStatus(), is(1));
        assertThat(transactions.get(0).getToken(), is("MCI-TOKEN:ABC12356"));
    }

    @Test
    public void shouldInsertAuditLog() {
        // arrange
        String username = "username";
        String bankCode = "bankCode";
        String amount = "10000";
        String channel = "59";
        String state = "state";
        String bankReceipt = "receipt";
        String orderId = "order";
        String consumer = "09125067064";
        String customerIp = "1.1.1.1";
        String remoteIp = "10.20.30.40";
        String action = "action";
        int operatorId = 1;
        String status = "Error";
        long isgDoc = -5;
        String oprDoc = "";
        Date timestamp = new Date();
        long responseTime = 125;
        Audit audit = new Audit();
        audit.setUsername(username);
        audit.setBankCode(bankCode);
        audit.setAmount(amount);
        audit.setChannel(channel);
        audit.setState(state);
        audit.setBankReceipt(bankReceipt);
        audit.setOrderId(orderId);
        audit.setConsumer(consumer);
        audit.setCustomerIp(customerIp);
        audit.setRemoteIp(remoteIp);
        audit.setAction(action);
        audit.setOperatorId(operatorId);
        audit.setStatus(status);
        audit.setIsgDoc(isgDoc);
        audit.setOprDoc(oprDoc);
        audit.setTimestamp(timestamp);
        audit.setResponseTime(responseTime);

        // act
        auditLogRepository.save(audit);

        // assert
    }

    @Test(dataProvider = "provideRegisteredOperatorIds")
    public void shouldFindRegisteredOperatorStatus(int operatorId) {
        // arrange
        OperatorStatus status = null;

        // act
        status = operatorStatusRepository.findById(operatorId);

        // assert
        assertThat(status, is(notNullValue()));
        assertThat(status.getId(), is(operatorId));
        assertThat(status.getIsAvailable(), is(true));
    }

    @Test(dataProvider = "provideUnregisteredOperatorIds")
    public void shouldNotFindUnregisteredOperatorStatus(int operatorId) {
        // arrange
        OperatorStatus status = null;

        // act
        status = operatorStatusRepository.findById(operatorId);

        // assert
        assertThat(status, is(nullValue()));
    }
      
    @Test(dataProvider = "provideRegisteredOperatorIds")
    public void shouldFindAndUpdateOperatorStatus(int operatorId) {
        // arrange
        OperatorStatus status = null;

        // act 
        status = operatorStatusRepository.findById(operatorId);
        status.setIsAvailable(false);
        status.setTimestamp(new Date());
        operatorStatusRepository.save(status);

        // assert
        status = operatorStatusRepository.findById(operatorId);
        assertThat(status, is(notNullValue()));
        assertThat(status.getId(), is(operatorId));
        assertThat(status.getIsAvailable(), is(false));
    }   

    @Test
    public void shouldUpdateBalance() {
        // arrange
        long amount = 123456L;
        Date timestamp = new Date();

        // act
        balanceRepository.updateMCI10000(amount, timestamp);        
        balanceRepository.updateMCI20000(amount, timestamp);        
        balanceRepository.updateMCI50000(amount, timestamp);        
        balanceRepository.updateMCI100000(amount, timestamp);        
        balanceRepository.updateMCI200000(amount, timestamp);        
        balanceRepository.updateMCI500000(amount, timestamp);        
        balanceRepository.updateMCI1000000(amount, timestamp);        
        balanceRepository.updateMTN(amount, timestamp);        
        balanceRepository.updateJiring(amount, timestamp);        
        balanceRepository.updateRightel(amount, timestamp);        

        // assert        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        Balance balance = this.jdbcTemplate.queryForObject(
                            "select * from info_topup_balance where id = ?",
                            new Object[]{1},
                            new RowMapper<Balance>() {
                            public Balance mapRow(ResultSet rs, int rowNum) throws SQLException {
                                Balance balance = new Balance();
                                balance.setMci10000(rs.getLong("MCI10000"));
                                balance.setMci10000Timestamp(rs.getTimestamp("MCI10000Timestamp"));
                                balance.setMci20000(rs.getLong("MCI20000"));
                                balance.setMci20000Timestamp(rs.getTimestamp("MCI20000Timestamp"));
                                balance.setMci50000(rs.getLong("MCI50000"));
                                balance.setMci50000Timestamp(rs.getTimestamp("MCI50000Timestamp"));
                                balance.setMci100000(rs.getLong("MCI100000"));
                                balance.setMci100000Timestamp(rs.getTimestamp("MCI100000Timestamp"));
                                balance.setMci200000(rs.getLong("MCI200000"));
                                balance.setMci200000Timestamp(rs.getTimestamp("MCI200000Timestamp"));
                                balance.setMci500000(rs.getLong("MCI500000"));
                                balance.setMci500000Timestamp(rs.getTimestamp("MCI500000Timestamp"));
                                balance.setMci1000000(rs.getLong("MCI1000000"));
                                balance.setMci1000000Timestamp(rs.getTimestamp("MCI1000000Timestamp"));
                                balance.setMtn(rs.getLong("MTN"));
                                balance.setMtnTimestamp(rs.getTimestamp("MTNTimestamp"));
                                balance.setJiring(rs.getLong("Jiring"));
                                balance.setJiringTimestamp(rs.getTimestamp("JiringTimestamp"));
                                balance.setRightel(rs.getLong("Rightel"));
                                balance.setRightelTimestamp(rs.getTimestamp("RightelTimestamp"));
                               return balance;
                            }
                        });
        assertThat(balance, is(notNullValue()));
        assertThat(balance.getMci10000(), is(amount));
        assertThat(balance.getMci10000Timestamp().compareTo(timestamp), is(0));
        assertThat(balance.getMci20000(), is(amount));
        assertThat(balance.getMci20000Timestamp().compareTo(timestamp), is(0));
        assertThat(balance.getMci50000(), is(amount));
        assertThat(balance.getMci50000Timestamp().compareTo(timestamp), is(0));
        assertThat(balance.getMci100000(), is(amount));
        assertThat(balance.getMci100000Timestamp().compareTo(timestamp), is(0));
        assertThat(balance.getMci200000(), is(amount));
        assertThat(balance.getMci200000Timestamp().compareTo(timestamp), is(0));
        assertThat(balance.getMci500000(), is(amount));
        assertThat(balance.getMci200000Timestamp().compareTo(timestamp), is(0));
        assertThat(balance.getMci1000000(), is(amount));
        assertThat(balance.getMci1000000Timestamp().compareTo(timestamp), is(0));
        assertThat(balance.getMtn(), is(amount));
        assertThat(balance.getMtnTimestamp().compareTo(timestamp), is(0));
        assertThat(balance.getJiring(), is(amount));
        assertThat(balance.getJiringTimestamp().compareTo(timestamp), is(0));
        assertThat(balance.getRightel(), is(amount));
        assertThat(balance.getRightelTimestamp().compareTo(timestamp), is(0));
   }
}
