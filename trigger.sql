CREATE TRIGGER tr_userinfo_tid BEFORE INSERT ON userinfo
FOR EACH ROW BEGIN
declare n int;
select IFNULL(max(right(tid,5)),0) into n from  userinfo where mid(tid,4,8)=DATE_FORMAT(CURDATE(),'%Y%m%d');
set NEW.tid=concat('SGB',DATE_FORMAT(CURDATE(),'%Y%m%d'),right(100001+n,5));
END;