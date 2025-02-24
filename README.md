# 작업환경 세팅

### docker 설치
brew install docker  
brew link docker  
docker version  


### mysql 설치 및 실행
docker pull mysql  
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mysql mysql   
docker ps  

### my sql 데이터베이스 생성
docker exec -it mysql bash  
mysql -u root -p  
create database stock_example;  
use stock_example;  


### Redis 설치 및 실행
docker pull redis
docker run --name myredis -d -p 6379:6379 redis
docker exec -it [redis-container-id] redis-cli
### Lettuce Test
setnx 1 lock  
setnx 1 lock  
del 1  
setnx 1 lock  

### Redisson Test
(Terminal 1) subscribe ch1
(Terminal 2) publish ch1 hello
