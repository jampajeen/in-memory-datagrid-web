# In-memory data grid EC2 supported

Since EC2 does not support broadcast protocol that mean many cluster solutions will not work on EC2.

This project is a POC about creating distributed in-memory cache on EC2 by using Infinispan with Jgroup which configured for unicast communication. 
So we can create our simple cluster on EC2 for distributed session, caching, etc.


