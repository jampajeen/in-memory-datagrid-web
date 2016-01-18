# In-memory data grid with EC2 supported

Since EC2 does not support broadcast protocol that mean many cluster solutions will not work on EC2.

This project is a POC about creating distributed in-memory cache on EC2 by using Infinispan with Jgroup which configured for unicast communication. 
So we can create our simple cluster on EC2 for distributed session, caching, etc.



**How to use?**

You can take a look in project source code, it's very simple and hope you all can understand it.

**Configure jgroup as you need**

Example:
```
https://github.com/jampajeen/in-memory-datagrid-web/blob/master/src/main/resources/jgroups-tcp.xml
```

**Configure infinispan**

Example:
```
https://github.com/jampajeen/in-memory-datagrid-web/blob/master/src/main/resources/infinispan.xml
```



**Coding**

To initialize **"DistributedCacheManager"** instance
```
DistributedCacheManager.getInstance().init();
```

To put data into cache
```
cache.put("key", "value");
```

To retrieve data from cache
```
cache.get("key");
```

Happy coding :)