# springboot-product-ms

create table brands( id int primary key, name varchar(25) not null )

create table categories( id int primary key, name varchar(25) not null )

create table products( 
	id int primary key, 		  
	name varchar(25) not null,
	unit_price numeric(5,2) not null,
	amount int not null,  
	date_added date not null,  
	description varchar(100), 
	brand_id int, foreign key (brand_id) references brands(id),
	category_id int, foreign key (category_id) references categories(id)
)
