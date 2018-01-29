# Spring Boot中使用Swagger2构建RESTful APIs


<a name="overview"></a>
## Overview
更多Spring Boot相关文章请关注：http://blog.didispace.com/


### Version information
*Version* : 1.0


### Contact information
*Contact* : wujun  
*Contact Email* : wujun2412@163.com


### License information
*Terms of service* : http://blog.didispace.com/


### URI scheme
*Host* : 127.0.0.1:8080  
*BasePath* : /


### Tags

* city-controller : City Controller




<a name="paths"></a>
## Paths

<a name="findcityusingget"></a>
### 获取的用户信息
```
GET /city/get
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**id**  <br>*required*|用户ID|[Integer](#integer)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ApiResult](#apiresult)|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* city-controller


<a name="hellousingget"></a>
### hello
```
GET /city/hello
```


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|string|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* city-controller


<a name="savecityusingpost"></a>
### saveCity
```
POST /city/save
```


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**cityRequest**  <br>*required*|cityRequest|[CityRequest](#cityrequest)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**200**|OK|[ApiResult](#apiresult)|
|**201**|Created|No Content|
|**401**|Unauthorized|No Content|
|**403**|Forbidden|No Content|
|**404**|Not Found|No Content|


#### Consumes

* `application/json`


#### Produces

* `*/*`


#### Tags

* city-controller




<a name="definitions"></a>
## Definitions

<a name="apiresult"></a>
### ApiResult

|Name|Schema|
|---|---|
|**data**  <br>*optional*|object|
|**errCode**  <br>*optional*|string|
|**msg**  <br>*optional*|string|
|**status**  <br>*optional*|string|


<a name="cityrequest"></a>
### CityRequest

|Name|Schema|
|---|---|
|**cityName**  <br>*optional*|string|
|**currentPage**  <br>*optional*|integer (int32)|
|**description**  <br>*optional*|string|
|**pageSize**  <br>*optional*|integer (int32)|
|**provinceId**  <br>*optional*|integer (int32)|





