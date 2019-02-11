--1  Скільки яких товарів купляли (скільки штук і чого купили всього)
select or1.product, pr.description, sum(or1.qty) from products pr
join orders or1 on pr.product_id = or1.product
group by or1.product, pr.description;

--2  Вивести товари, які купили більше 3-оьх разів (були в трьох і більше замовленнях)
select or1.product, pr.description, count(or1.product) from products pr
join orders or1 on pr.product_id = or1.product
group by or1.product, pr.description having count(or1.product) > 3;

--3 Вивести офіси в яких працює більше трьох менеджерів
select of1.office, of1.city, count(s1.rep_office) from salesreps s1
join offices of1 on s1.rep_office = of1.office
group by of1.office, of1.city having count(s1.rep_office) > 3;

--4 Вивести середній вік по офісу
select of1.office, of1.city, count(s1.rep_office), avg(s1.age) from salesreps s1
join offices of1 on s1.rep_office = of1.office
group by of1.office, of1.city;

--5 Дати перелік виробників що виготовляють більше 4-ьох товарів
select mfr_id, count(product_id) from products
group by mfr_id having count(product_id) > 4;

--6 Дати загальну кільсть товарів, що зберігаються на складі по виробникам що виготовляють більше 4-ьох товарів
select mfr_id, count(product_id), sum(qty_on_hand) from products
group by mfr_id having count(product_id) > 4;

--7 Вивести ім'я компанії, скільки вона тратила в середньому на покупки товарів виробників, котрі виготовляють більше 4-ьох товарів
select cus.company, avg(or1.amount * or1.qty) from customers cus
join orders or1 on cus.cust_num = or1.cust where or1.mfr in (select mfr_id from products
group by mfr_id having count(product_id) > 4)
group by cus.company;

--8 Вивести скільки мінімально і максимально замовлень (ордерів) виконували менеджери що мають в прямому підпорядкуванні більше двух людей
select min(count(order_num)), max(count(order_num)) from orders o
join salesreps s on o.rep = s.manager
group by s.manager having (count(s.empl_num)) > 2;

--9 Знайти продукти в яких буква "а" зустрічається більше 2-ух раз
select* from products where description like '%а%а%';

-- lessons 33-36
SELECT COUNT(*), COUNT(SALES), COUNT(QUOTA)
FROM SALESREPS;
SELECT SUM(SALES), SUM(QUOTA), (SUM(SALES) - SUM(QUOTA)), (SUM(SALES - QUOTA))
FROM SALESREPS;
SELECT COUNT(DISTINCT TITLE)
FROM SALESREPS;
SELECT COUNT(DISTINCT REP_OFFICE)
FROM SALESREPS
WHERE SALES > QUOTA;
SELECT REP, AVG(AMOUNT)
FROM ORDERS
GROUP BY REP;
SELECT REP, CUST, SUM(AMOUNT)
FROM ORDERS
GROUP BY REP, CUST;
SELECT REP, CUST, SUM(AMOUNT)
FROM ORDERS
GROUP BY REP, CUST
ORDER BY REP, CUST;
SELECT EMPL_NUM, NAME, SUM(AMOUNT)
FROM ORDERS, SALESREPS
WHERE REP = EMPL_NUM
GROUP BY EMPL_NUM;
SELECT EMPL_NUM, NAME, SUM(AMOUNT)
FROM ORDERS, SALESREPS
WHERE REP = EMPL_NUM
GROUP BY EMPL_NUM, NAME;
CREATE TABLE COLORIS
    (
    NM   VARCHAR2(50),
    HAIR VARCHAR2(50),
    EYES VARCHAR2(50)
  );
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Cindy', 'Brown', 'Blue');
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Louise', NULL, 'Blue');
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Harry', NULL, 'Blue');
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Samantha', NULL, NULL);
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Joanne', NULL, NULL);
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('George', 'Brown', NULL);
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Mary', 'Brown', NULL);
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Paula', 'Brown', NULL);
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Kevin', 'Brown', NULL);
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Joel', 'Brown', 'Brown');
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Susan', 'Blonde', 'Blue');
INSERT INTO COLORIS(NM, HAIR, EYES)
	VALUES('Marie', 'Blonde', 'Blue');
 SELECT REP, AVG(AMOUNT)
FROM ORDERS
GROUP BY REP
HAVING SUM(AMOUNT) > 300;
SELECT HAIR, EYES, COUNT(*)
FROM COLORIS
GROUP BY  HAIR, EYES having count(*) >= 2;
SELECT DESCRIPTION, PRICE, QTY_ON_HAND, SUM(QTY)
FROM PRODUCTS, ORDERS
WHERE MFR = MFR_ID
GROUP BY MFR_ID, PRODUCT_ID, DESCRIPTION, PRICE, QTY_ON_HAND
HAVING SUM(QTY) > (0.75 * QTY_ON_HAND)
ORDER BY QTY_ON_HAND DESC;

-- на табличках girls|boys зробить insert|update|delete. По два запити кожного типу з різною логікою
insert into girls values(7, 'Katia', 'Vancouver');
insert into boys values(7, 'Bob', 'NY');

update girls set city = 'LA' where city = 'Vancouver';
update boys set name = 'Johan' where city = 'NY';

delete from girls where city = 'LA';
delete from boys where name = 'Johan';

-- зробити пару прикладів з селектами з під запитами, пару це три

select cust_num, company, order_num, order_date from
(select* from customers join orders on cust_num = cust where order_date = '10.02.90') where company like '%а%';

select order_num from(select* from orders join products on product = product_id where description = 'Бочка металлическая');

select name, city, hair, eyes from(select* from girls join coloris on name = coloris.nm where city = 'Chicago');