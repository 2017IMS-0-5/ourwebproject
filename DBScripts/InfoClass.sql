DROP TABLE IF EXISTS `infoclass`;
create table infoclass
(
    id       bigint auto_increment
        primary key,
    field    varchar(20) not null,
    subValue varchar(20) not null,
    subject  varchar(20) not null
);

INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (2, 'job', 'sxxx', '实习信息');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (3, 'job', 'xdxx', '选调信息');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (4, 'job', 'zphxx', '招聘会信息');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (5, 'job', 'wnjyxx', '往届就业信息');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (6, 'policy', 'byzc', '保研政策');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (7, 'policy', 'zszc', '招生政策');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (8, 'policy', 'pyzc', '培养政策');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (9, 'policy', 'qtzc', '其它政策');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (10, 'notice', 'kyxm', '科研项目通知');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (11, 'notice', 'jsbs', '竞赛比赛通知');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (12, 'notice', 'jztz', '讲座通知');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (13, 'notice', 'hytz', '会议通知');
INSERT INTO mis.infoclass (id, field, subValue, subject) VALUES (14, 'other', 'qtxx', '其它信息');