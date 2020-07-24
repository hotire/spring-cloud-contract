# Spring Cloud Contact 

multi module project 

Contract Test는 서비스 제공자와 사용자간의 계약(Contract)을 검증하는 것이다


## Background
MSA 시대를 맞으면서 아래와 같은 변화가 생겨났다.

- Service 크기가 작아짐
- API contract 개선이 많아짐
- 다른 시간대(Timezone)의 팀간의 협업이 요구됨

점점 빠르게 변경되는 어플리케이션이 생기고 있고, 어플리케이션은 점점 더 작은 단위의 서비스로 분리되고 있다. 


### Consumer-Driven Contracts (CDC)
소비자 주도 계약 패턴는 소비자(Consumer)의 요구사항 중심으로 제공자(Producer) 서비스를 진화시키기 위한 협업 패턴이다. 

Producer는 불필요한 서비스 개발을 줄일 수 있다는 장점이 있다. 

CDC가 성공하기 위해서 스펙 정의, 문서화, 테스트 등 많은 것들이 필요하다. 그 중에서도 서로 간의 커뮤니케이션이 가장 핵심이다. 

rest-doc / swagger 등 다양하 도구를 사용하지만 부족한 것들이 많다. 

E2E(End to End)은 확실한 전략이지만, 많은 시간과 테스트 자원이 소모하기 때문에 비효율적이다. 

그래서 대게 Mock 테스트 전략이 일반적이다. 하지만 스펙으로 정의해놓은 데이터 파일의 관리가 어렵다. 


: 결국 CDC를 성공시키기 위해선 정합성 유지와 테스트 코드가 필요하다. 이를 해결해주는 것이 Spring Cloud Contract이다. 


### Spring Cloud Contract Workflow

1. 소비자(Consumer)는 Contract를 정의하여 제공자(Producer) 에게 요청 (Pull Request)

2. 제공자(Producer)는 Contract를 구현

3. 제공자(Producer)의 Contract 구현으로 생성된 stub.jar 를 업로드한다. (Nexus or Spring Cloud Eureka 등)

4. 소비자(Consumer)는 자신이 요청한 Contract 기반으로 구현된 stub.jar 를 다운로드 받아 테스트한다.


**reference** 

- https://spring.io/projects/spring-cloud-contract
- https://spring.io/guides/gs/contract-rest/
- https://blog.kingbbode.com/posts/cdc-srping-cloud-contract
- https://oookawesome.github.io/Contract-Test

### Getting Started 

