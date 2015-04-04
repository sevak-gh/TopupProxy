CREATE TABLE `info_topup_operators` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `STATUS` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `info_topup_transactions` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `PROVIDER` tinyint unsigned NOT NULL,
  `TOKEN` varchar(50),
  `TYPE` tinyint NOT NULL,
  `STATE` varchar(100) NOT NULL,
  `RESNUM` varchar(50) NOT NULL,
  `REFNUM` varchar(50) NOT NULL,
  `REVNUM` bigint unsigned,
  `CLIENTIP` varchar(50) NOT NULL,
  `AMOUNT` bigint unsigned NOT NULL,
  `CHANNEL` tinyint NOT NULL,
  `CONSUMER` varchar(50) NOT NULL,
  `BANKCODE` varchar(10) NOT NULL,
  `CLIENT` int unsigned NOT NULL,
  `CUSTOMERIP` varchar(50) NOT NULL,
  `TRTIME` datetime NOT NULL,
  `BANKVERIFY` int,
  `VERIFYTIME` datetime,
  `STATUS` tinyint,
  `OPERATOR` int,
  `OPRCOMMAND` varchar(100),
  `OPRRESPONSE` varchar(500),
  `OPRTID` varchar(50),
  `OPERATORTIME` datetime,
  `STF` tinyint,
  `STFRESULT` tinyint,
  `OPREVERSE` tinyint,
  `BKREVERSE` tinyint,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `info_topup_clients` (
  `ID` int unsigned NOT NULL AUTO_INCREMENT,
  `CLIENT` varchar(20) NOT NULL,
  `PIN` varchar(150) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `CONTACT` varchar(100) NOT NULL,
  `TEL` varchar(50) NOT NULL,
  `VENDOR` varchar(100),
  `CREATED` datetime NOT NULL,
  `FIRSTLOGIN` datetime,
  `LASTLOGIN` datetime,
  `ACTIVE` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
);

CREATE TABLE `info_topup_client_ips` (
  `CLIENT` int unsigned NOT NULL,
  `IP` varchar(20) NOT NULL,
  PRIMARY KEY(`CLIENT`,`IP`)  
);

CREATE TABLE `info_topup_audit` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50),
  `bankCode` varchar(50),
  `amount` int unsigned,
  `channel` int unsigned,
  `state` varchar(100),
  `bankReceipt` varchar(50),
  `orderId` varchar(50),
  `consumer` varchar(50),
  `customerIp` varchar(50),
  `remoteIp` varchar(50),
  `action` varchar(50),
  `operator` int unsigned,
  `status` varchar(50),
  `isgDoc` bigint,
  `oprDoc` varchar(50),
  `timestamp` datetime NOT NULL,
  `responseTime` bigint NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `info_topup_operator_last_status` (
  `id` int unsigned NOT NULL,
  `status` varchar(50) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `info_topup_payment_channel` (
  `CHANNEL` varchar(50) NOT NULL,
  `ACTIVE` varchar(50) NOT NULL,
  PRIMARY KEY (`CHANNEL`)
);

CREATE TABLE `info_topup_balance` (
  `MCI10000` bigint unsigned,
  `MCI20000` bigint unsigned,
  `MCI50000` bigint unsigned,
  `MCI100000` bigint unsigned,
  `MCI200000` bigint unsigned,
  `MCI500000` bigint unsigned,
  `MCI1000000` bigint unsigned,
  `MTN` bigint unsigned,
  `Jiring` bigint unsigned,
  `MCI10000Timestamp` datetime,
  `MCI20000Timestamp` datetime,
  `MCI50000Timestamp` datetime,
  `MCI100000Timestamp` datetime,
  `MCI200000Timestamp` datetime,
  `MCI500000Timestamp` datetime,
  `MCI1000000Timestamp` datetime,
  `MTNTimestamp` datetime,
  `JiringTimestamp` datetime,
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
);

