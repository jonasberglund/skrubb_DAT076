DAT076 Web Applikationer
=============

####GitHub alias
- Jonas Berglund - jonasberglund
- Olle Svensson - olvert
- Robin Törnquist - roffin
- Anders Johansson - vispen

####LoginFilter
During the demonstration the filter didn’t worked as it should, this was due to a misleading pointing in the web.xml

	<filter-class>com.skrubb.blog_front_end.LoginFilter</filter-class>

should have been

	<filter-class>com.skrubb.blog_front_end.mb.LoginFilter</filter-class>´

This was a result of us moving the classes into packages.





