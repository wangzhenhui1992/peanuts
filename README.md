[![License](https://img.shields.io/badge/license-Apache%202-brightgreen.svg)](https://github.com/wangzhenhui1992/peanuts/blob/master/LICENSE)
[![buddy pipeline](https://app.buddy.works/wangzhenhui1992-1/peanuts/pipelines/pipeline/154004/badge.svg?token=b7331631676aff048d52e85732235017aefb152c7c1a6b0afd60fd08b7b2df46 "buddy pipeline")](https://app.buddy.works/wangzhenhui1992-1/peanuts/pipelines/pipeline/154004)
[![Slack](https://img.shields.io/badge/slack-peanuts--community-green.svg)](https://join.slack.com/t/peanuts-community/shared_invite/enQtNDQ5MzE1ODg3NzM0LTRiNDRhYTIyMmFmZWRiNWE2Nzk4MzBmZGYyZWNlY2Y0ODRkM2U0OWIxMTI2ZmJjY2FlNjQ4NzNjMDllMjM1MTE)

```
|  _ \ ___  __ _ _ __  _   _| |_ ___ 
| |_) / _ \/ _` | '_ \| | | | __/ __|
|  __/  __/ (_| | | | | |_| | |_\__ \
|_|   \___|\__,_|_| |_|\__,_|\__|___/
```
# Peanuts
Peanuts is an open-source project for exchange community system which is aimed to create a community simply and quickly.
We use popular languages , frameworks as well as cloud platform to implement it, such as SpringBoot, Elasticsearch, Redis and etc.
It is still under development but joining is always welcome.This repository is just the backend of the system while [peanuts-front](/wangzhenhui1992/peanuts-front) is the frontend.

# Language,Frameworks and Environments
### Frontend
- [Angular](https://angular.io/)
- [Bootstrap](https://getbootstrap.com/) 
- [Font-Awesome](https://fontawesome.com/)
### Backend
- Java(8+)
- [SpringBoot(2.x)](http://spring.io/projects/spring-boot)
- [SpringData](https://spring.io/projects/spring-data)
- [Redis](https://redis.io/)
- [ElasticSearch](https://www.elastic.co/)
- [MySQL](https://www.mysql.com/)
- [Nginx](http://nginx.org/)
- [Docker](https://www.docker.com/) [Kubernetes optional](https://kubernetes.io/)
### CICD
- [Buddy](https://buddy.works/)
- [AWS CLI](https://aws.amazon.com/)
- [AWS CodeDeploy](https://aws.amazon.com/)
- [AWS CodePipeline](https://aws.amazon.com/)
### Sample Website Environment
- [AWS EC2](https://aws.amazon.com/)
- [AWS S3](https://aws.amazon.com/)
- [AWS CloudFront](https://aws.amazon.com/)
- [AWS ElasticCache](https://aws.amazon.com/)
- [AWS ElasticSearchService](https://aws.amazon.com/)
- [AWS Lambda(Optional)](https://aws.amazon.com/)
### IDE
- [SpringToolSuit](http://spring.io/tools)


# Packages of Project
### com.soaringroad.api  API Module
define interfaces and abstract classes of apis
##### com.soaringroad.api.validate 
define the interface of validators which are used to check the parameters of apis

### com.soaringroad.common Common Module
define classes with common functions
##### com.soaringroad.common.config
define common configuration for springboot
##### com.soaringroad.common.dao
define interface of DAOs
##### com.soaringroad.common.entity
define interfaces of entities
##### com.soaringroad.common.query
define classes related to query which is used to execute search 
##### com.soaringroad.common.repository
define interfaces of repositories
##### com.soaringroad.common.util
define utility classes with common functions
##### com.soaringroad.common.vo
define VOs especially enums

### com.soaringroad.dao DAO Module
##### com.soaringroad.dao.aggregation
define interface of aggregation which is used to do an aggregation to data
##### com.soaringroad.dao.impl
define implemented classes of basic DAOs.

### com.soaringroad.data Data Modlue
define classes related to lower level of datasources.
##### com.soaringroad.data.es
define classes related to Elasticsearch including configuration,repository,client and etc
##### com.soaringroad.data.rdb
define classes related to Elasticsearch including configuration,repository,client and etc
##### com.soaringroad.data.redis
define classes related to Redis including configuration,repository and etc
##### com.soaringroad.data.rdb
define classes related to Rdb including configuration,repository,druid and etc

### com.soaringroad.peanuts Peanuts Biz Module
##### com.soaringroad.peanuts.api
peanuts biz apis
##### com.soaringroad.peanuts.dao
peanuts biz DAOs
##### com.soaringroad.peanuts.dao.aggregation
peanuts biz aggreations of DAOs
##### com.soaringroad.peanuts.entity
peanuts biz entites
##### com.soaringroad.peanuts.repository
peanuts biz repository
##### com.soaringroad.peanuts.service
peanuts biz interfaces of services
##### com.soaringroad.peanuts.service.impl
peanuts biz implemented services
##### com.soaringroad.peanuts.vo
peanuts biz VO

