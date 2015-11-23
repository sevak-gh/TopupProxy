
SET MODE MySQL;

insert into info_topup_operators values(1,'MTN','active');
insert into info_topup_operators values(2,'MCI','active');
insert into info_topup_operators values(3,'Jiring','active');

insert into info_topup_payment_channel values('59','Y');
insert into info_topup_payment_channel values('14','Y');
insert into info_topup_payment_channel values('05','Y');

insert into info_topup_operator_last_status values(1,'READY', '2015-03-01 18:00:00');
insert into info_topup_operator_last_status values(2,'READY', '2015-03-01 18:00:00');
insert into info_topup_operator_last_status values(3,'READY', '2015-03-01 18:00:00');

delete from info_topup_transactions;
delete from info_topup_clients;
delete from info_topup_client_ips;

/* add client: username=root, password=123456, active='Y', ips: 1.1.1.1, 2.2.2.2   */
insert into info_topup_clients(id,client,pin,name,contact,tel,vendor,created,active) values(1, 'root', 
      'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 
      'name', 'contact', 'tel', 'vendor', '2014-01-01 13:05:23','Y');

insert into info_topup_client_ips values(1,'1.1.1.1');
insert into info_topup_client_ips values(1,'2.2.2.2');
delete from info_topup_audit;
update info_topup_operator_last_status set status='READY', timestamp=now() where id=2;

insert into info_topup_balance values(0,0,0,0,0,0,0,0,0,0,
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',
       '2015-03-01 01:00:00',1);
