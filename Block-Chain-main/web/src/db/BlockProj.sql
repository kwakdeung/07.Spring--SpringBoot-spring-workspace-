--���� DB
create table wallet_db (
    id varchar(20)  -- ���� ������ �� ���๮�ڵ� ���ԵǾ�� �ϸ� 21�� �����ؾ���
,   name varchar(50)
,   publicKey varchar(50)
,   privateKey varchar(50)
,   address varchar(50)
,   timestamp date
,   charge_his varchar(50)      -- �����̷� ������� ���� ����ʿ�
,   purchase_his varchar(50)    -- �����̷� ������� ���� ����ʿ�
)

-- �ŷ� DB
create table transaction_db (
    blockID varchar(50)
,   txID varchar(50)
,   toAdd varchar(50)
,   fromAdd varchar(50)
,   productName varchar(50)
,   coin number(10)
,   timestamp date      -- ���丮���忡 date�� �Ǿ��ִµ� ...���� ������ ���� �����ؾ� �� ����...
)

-- ȸ�� DB
create table member_db (
    id varchar(20)  PRIMARY KEY
,   pw varchar(30)  -- ���丮���忡 number(10)���� �Ǿ� �ִµ� Ȯ�� �� �ٲ�� �� ����...
)

-- ���� DB
create table coin_db (
    id varchar(20)
,   address varchar(50)
,   coin number(10)
,   date date       -- �̰� ���� ���°��� ..? ���߿� Ȯ�� �ʿ�
)

-- ��ǰ DB
create table product_db (
    name varchar(20)
,   price number(10)
)