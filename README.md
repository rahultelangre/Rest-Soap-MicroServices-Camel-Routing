# Rest-Soap-MicroServices-Camel-Routing
POC of how to perform conditional based routing using Apache-Camel.

Steps::
1==> run rest project with proper port no. and URL
      8080 and  jdbc:h2:~/test1

2==> run MS project with proper port no. and URL
      8081 and  jdbc:h2:~/test
      
3==> run soap project with proper port no. and URL     
      9090 
 NOTE::check in MS DB no data available.
 
 send request by POSTMAN Tool.
 method==post
  URL  == http://localhost:8081/getStatus
  Body in json == {
                	"name" :"Spain"
                  }
  
