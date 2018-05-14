# Pingdom Java API Wrapper

## Supported API's

* Find all checks
* Find Details of a check
* Add users to a check to notify
* Bulk add - users to all checks. see #addUserToAllChecks in AlertServiceImplTest

## How to use the wrapper ?
 
* clone this project https://github.com/jayeshgangadharan/pingdom-java-api.git
* add pingdom.properties to your classpath
* add following entries into pingdom.properties
* add AlertService as a dependency and start using it
>sample pingdom.properties
```
    pingdom.application.key=<YourApplicationKey>
    pingdom.url=https://api.pingdom.com/api/2.1
    pingdom.credentials=<username:password>
    pingdom.admin.user=<YourAdminEmail>
```        

## Pingdom API Version
```
2.1
```

## Pingdom API Documentations
```
https://www.pingdom.com/resources/api/2.1
```