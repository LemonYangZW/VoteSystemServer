create table userinfo(
	id int  not null auto_increment, 
	tid int not null, 			
	tname varchar(50) not null,		
	tcontent varchar(500) not null,	
	name varchar(10) not null,						
	phone varchar(20) not null,				
	wxname varchar(20) not null,				
	tm datetime  not null,				
	status varchar(10)  not null,				
	price double  not null,				
	url varchar(1000)  not null,				
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;;

