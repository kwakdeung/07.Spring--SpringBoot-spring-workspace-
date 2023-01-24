--지갑 DB
create table wallet_db (
    id varchar(20)  -- 추후 저장할 때 개행문자도 포함되어야 하면 21로 변경해야함
,   name varchar(50)
,   publicKey varchar(50)
,   privateKey varchar(50)
,   address varchar(50)
,   timestamp date
,   charge_his varchar(50)      -- 충전이력 어떤식으로 할지 고민필요
,   purchase_his varchar(50)    -- 구매이력 어떤식으로 할지 고민필요
)

-- 거래 DB
create table transaction_db (
    blockID varchar(50)
,   txID varchar(50)
,   toAdd varchar(50)
,   fromAdd varchar(50)
,   productName varchar(50)
,   coin number(10)
,   timestamp date      -- 스토리보드에 date로 되어있는데 ...실제 데이터 보고 변경해야 할 수도...
)

-- 회원 DB
create table member_db (
    id varchar(20)  PRIMARY KEY
,   pw varchar(30)  -- 스토리보드에 number(10)으로 되어 있는데 확인 후 바꿔야 할 수도...
)

-- 코인 DB
create table coin_db (
    id varchar(20)
,   address varchar(50)
,   coin number(10)
,   date date       -- 이건 뭐에 쓰는건지 ..? 나중에 확인 필요
)

-- 상품 DB
create table product_db (
    name varchar(20)
,   price number(10)
)