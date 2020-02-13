DROP TABLE IF EXISTS `Admin`;
create table Admin
(
    id       bigint auto_increment
        primary key,
    account  varchar(20) not null,
    password varchar(50) not null,
    name     varchar(20) not null,
    role     varchar(40) not null
);

INSERT INTO mis.admin (id, account, password, name, role) VALUES (2, 'dzuzhi', '123', '组织部', 'manager');
INSERT INTO mis.admin (id, account, password, name, role) VALUES (6, 'dtuancu', '123', '团促部', 'manager');
INSERT INTO mis.admin (id, account, password, name, role) VALUES (7, 'dwenhuatiyu', '123', '文化体育部', 'manager');
INSERT INTO mis.admin (id, account, password, name, role) VALUES (8, 'dxueshushijian', '123', '学术实践部', 'supermanager');
INSERT INTO mis.admin (id, account, password, name, role) VALUES (9, 'dkexuechuangxin', '123', '科学创新部', 'manager');
INSERT INTO mis.admin (id, account, password, name, role) VALUES (10, 'dxuanchuan', '123', '宣传部', 'manager');