DROP TABLE IF EXISTS `Admin`;
create table Admin
(
    id       bigint auto_increment primary key,
    account    varchar(20) not null,
    password varchar(50) not null,
    name  varchar(20) not null,
	role varchar(40) not null
);

INSERT INTO mis.Admin (id, account, password, name,role) VALUES (6,'201611260234','肖战','1234','manager');
INSERT INTO mis.Admin (id, account, password, name,role) VALUES (2,'201711260225','孙晓彤','123','manager');
INSERT INTO mis.Admin (id, account, password, name,role) VALUES (8,'11260589','陈翀','11260589','supermanager');
INSERT INTO mis.Admin (id, account, password, name,role) VALUES (7,'201711260256','魏无羡','12306','manager');
