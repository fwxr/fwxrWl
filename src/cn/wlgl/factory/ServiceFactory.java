package cn.wlgl.factory;

import cn.wlgl.service.impl.CompanyServiceImpl;
import cn.wlgl.service.impl.PersonServiceImpl;

public class ServiceFactory {
	public static PersonServiceImpl getIPersonServiceInstance() {
		return new PersonServiceImpl();
	}

	public static CompanyServiceImpl getICompanyServiceInstance() {
		return new CompanyServiceImpl();
	}
	
}
