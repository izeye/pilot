<%@page contentType="text/html; charset=utf8"%>
Your IP address is ${requestScope.whois.ipAddress}.<br>
User Address: ${requestScope.whois.koreanUserAddr} / ${requestScope.whois.englishUserAddr}<br>
User Organization Name: ${requestScope.whois.koreanUserOrgName} / ${requestScope.whois.englishUserOrgName}<br>
ISP Address: ${requestScope.whois.koreanIspAddr} / ${requestScope.whois.englishIspAddr}<br>
ISP Organization Name: ${requestScope.whois.koreanIspOrgName} / ${requestScope.whois.englishIspOrgName}<br>