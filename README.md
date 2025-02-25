# 동시성 문제 해결 방법

### 1. **Synchronized**  
- Java의 `synchronized` 키워드를 사용한 동기화 처리  

### 2. **DB Lock**  
- **비관적 락 (Pessimistic Lock)**: 데이터 충돌을 방지하기 위해 트랜잭션이 완료될 때까지 레코드를 잠금  
- **낙관적 락 (Optimistic Lock)**: 충돌 가능성을 최소화하며 `version` 필드를 활용한 갱신 검증  
- **Named Lock**: 데이터베이스에서 제공하는 이름 기반의 명시적 락을 활용  

### 3. **Redis 기반 락**  
- **Lettuce**: Redis의 `SETNX` 명령어를 활용한 락  
- **Redisson**: 분산 환경에서 활용 가능한 고급 Redis 기반 락 라이브러리  

---

## 환경 설정

### 1️⃣ **Docker 설치**
```bash
brew install docker
brew link docker
docker version
```

### 2️⃣ **MySQL 설치 및 실행**
```bash
docker pull mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mysql mysql
docker ps
```

### 3️⃣ **MySQL 데이터베이스 생성**
```bash
docker exec -it mysql bash
mysql -u root -p
# 비밀번호 입력 (1234)
create database stock_example;
use stock_example;
```

### 4️⃣ **Redis 설치 및 실행**
```bash
docker pull redis
docker run --name myredis -d -p 6379:6379 redis
docker exec -it myredis redis-cli
```

---

## 동시성 테스트 방법

### ✅ **Lettuce 테스트**
```bash
setnx 1 lock   # 성공
setnx 1 lock   # 실패 (이미 존재)
del 1          # 삭제
setnx 1 lock   # 성공
```

### ✅ **Redisson 테스트**
#### (Terminal 1)에서 구독:
```bash
subscribe ch1
```
#### (Terminal 2)에서 메시지 발행:
```bash
publish ch1 hello
```
- `Terminal 1`에서 `hello` 메시지를 수신하면 정상 동작!
