package com.ctb.pilot.common.util.whois;

import java.io.IOException;
import java.io.InputStream;

import org.jdom.Element;
import org.jdom.JDOMException;

import com.ctb.pilot.common.util.HttpUtils;
import com.ctb.pilot.common.util.JDOMUtils;

public class WhoisUtils {

	private static final String KISA_WHOIS = "http://whois.kisa.or.kr/openapi/whois.jsp?key=2012072109230007989735&query=";
	private static final String KISA_COUNTRY_CODE = "countryCode";
	private static final String KISA_KOREAN = "korean";
	private static final String KISA_ENGLISH = "english";
	private static final String KISA_PI = "PI";
	private static final String KISA_ISP = "ISP";
	private static final String KISA_USER = "user";
	private static final String KISA_NET_INFO = "netInfo";
	private static final String KISA_ORG_NAME = "orgName";
	private static final String KISA_ADDR = "addr";
	private static final String KISA_KR = "kr";

	public static Whois ipToWhois(String ipAddress) throws WhoisException {
		String url = KISA_WHOIS + ipAddress;
		try {
			InputStream is = HttpUtils.urlToInputStream(url);
			Element root = JDOMUtils.inputStreamToRoot(is);
			Element countryCode = root.getChild(KISA_COUNTRY_CODE);

			Whois whois = new Whois();
			whois.setIpAddress(ipAddress);

			String countryCodeText = countryCode.getText();
			whois.setCountryCode(countryCodeText);

			if (countryCodeText.equals(KISA_KR)) {
				Element korean = root.getChild(KISA_KOREAN);
				Element koreanIsp = korean.getChild(KISA_ISP);
				if (koreanIsp == null) {
					koreanIsp = korean.getChild(KISA_PI);
				}
				Element koreanIspNetInfo = koreanIsp.getChild(KISA_NET_INFO);
				Element koreanIspOrgName = koreanIspNetInfo
						.getChild(KISA_ORG_NAME);
				Element koreanIspAddr = koreanIspNetInfo.getChild(KISA_ADDR);

				Element english = root.getChild(KISA_ENGLISH);
				Element englishIsp = english.getChild(KISA_ISP);
				if (englishIsp == null) {
					englishIsp = english.getChild(KISA_PI);
				}
				Element englishIspNetInfo = englishIsp.getChild(KISA_NET_INFO);
				Element englishIspOrgName = englishIspNetInfo
						.getChild(KISA_ORG_NAME);
				Element englishIspAddr = englishIspNetInfo.getChild(KISA_ADDR);

				whois.setKoreanIspOrgName(koreanIspOrgName.getText());
				whois.setKoreanIspAddr(koreanIspAddr.getText());
				whois.setEnglishIspOrgName(englishIspOrgName.getText());
				whois.setEnglishIspAddr(englishIspAddr.getText());

				Element user = korean.getChild(KISA_USER);
				if (user != null) {
					Element koreanUserNetInfo = user.getChild(KISA_NET_INFO);
					Element koreanUserOrgName = koreanUserNetInfo
							.getChild(KISA_ORG_NAME);
					Element koreanUserAddr = koreanUserNetInfo
							.getChild(KISA_ADDR);

					Element englishUserNetInfo = english.getChild(KISA_USER)
							.getChild(KISA_NET_INFO);
					Element englishUserOrgName = englishUserNetInfo
							.getChild(KISA_ORG_NAME);
					Element englishUserAddr = englishUserNetInfo
							.getChild(KISA_ADDR);

					whois.setKoreanUserOrgName(koreanUserOrgName.getText());
					whois.setKoreanUserAddr(koreanUserAddr.getText());
					whois.setEnglishUserOrgName(englishUserOrgName.getText());
					whois.setEnglishUserAddr(englishUserAddr.getText());
				}
			}
			return whois;
		} catch (IOException e) {
			e.printStackTrace();
			throw new WhoisException("Failed to whois for " + ipAddress, e);
		} catch (JDOMException e) {
			e.printStackTrace();
			throw new WhoisException("Failed to whois for " + ipAddress, e);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new WhoisException("Failed to whois for " + ipAddress, t);
		}
	}

}
