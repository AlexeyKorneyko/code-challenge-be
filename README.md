### Objective

Your assignment is to build an internal API for a fake financial institution using Kotlin or Java and any framework.

### Brief

Your task is to build the basic REST API. Imagine you are designing a backend API for bank employees. It could be ultimately consumed by multiple frontends (web, iOS, Android etc).

### Tasks

Consider using following simplified data model:
```
Account:
- accountId - unique account identifier
- balance - account balance

Transaction:
- txId - unique transacion identifier
- amount - transferred amount
- from - source account id
- to - destination account id
```

Implement following banking APIs:
- create new account with predefined balance
- fetch account balance by `accountId`
- create transaction between two accounts 

### Requirements

- Latest **Kotlin** or **Java** 
- **Any framework**
- Stateless service with external data storage 
- Ignore authentication and authorization
- Code will be pushed to **private Github repository** and dedicated finmid members will be added as collaborators 

All the best and happy coding,

The finmid Team
