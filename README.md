# or-task
Task for OpenResearch


========================================================================================================================
2. Explain why providing the password as plaintext in a GET parameter is not secure and
   propose a more standardised way for authentication. You don’t need to implement it but
   include your answer in the README.md. 

2. Sending any kind of sensitive data over GET is dangerous, even if it is HTTPS. 
   These data might end up in log files at the server and will be included in the Referer header in links to or includes 
   from other sides. 
   They will also be saved in the history of the browser so an attacker might try to guess and verify the original 
   contents of the link with an attack against the history. Also, passwords sent as plaintext are the worst, because 
   everyone can read them. We should not even store passwords as plaintext in the database, because that gives the 
   ability to read them by the DB administrator and that should not be allowed. According to w3:
   "The convention has been established that the GET and HEAD methods SHOULD NOT have the significance of taking an 
   action other than retrieval. These methods ought to be considered "safe". This allows user agents to represent other
   methods, such as POST, PUT and DELETE, in a special way, so that the user is made aware of the fact that a possibly 
   unsafe action is being requested."
   An authentication using tokens would be much more better and safer, like OAuth 2.0 for example.
   It does not send passwords as plaintext, it does not send them over GET requests so that they are not visible, 
   and nowhere else does it use them again except for the first time when authenticating and generating the token.