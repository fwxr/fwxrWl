package cn.wlgl.Companywindows;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Person;
import cn.wlgl.vo.Package;

class PackageTest {

	@Test
	void test() {
		Set<Person> lp = null;
		List<Person> lp1 = new ArrayList<Person>();
		List<NewPackage> lnp = null;
		try {
			lp = ServiceFactory.getIPersonServiceInstance().findByAll();
			for(Person p :lp) {
				lp1.add(p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int k = 0; k < 10; k++) {
			int randomp = (int) (Math.random() * lp.size());
			NewPackage np = new NewPackage();
			np.setPnumber(lp1.get(randomp).getPnumber());
			np.setSendaddress(RandomValue.getRoad());
			np.setGetaddress(RandomValue.getRoad());
			np.setPhone(RandomValue.getTel());
			try {
				ServiceFactory.getIPersonServiceInstance().Create(np);
				lnp = ServiceFactory.getICompanyServiceInstance().SelectNewAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int[] enumber = new int[lnp.size()];
			int i = 0;
			for (NewPackage np1 : lnp) {
				enumber[i++] = np1.getEnumber();
			}
			try {
				ServiceFactory.getICompanyServiceInstance().AssignNewPackage(enumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
