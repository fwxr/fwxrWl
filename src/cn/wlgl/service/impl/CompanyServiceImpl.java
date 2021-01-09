package cn.wlgl.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import cn.wlgl.dao.IManageDao;
import cn.wlgl.dao.INewPackageDao;
import cn.wlgl.dao.IPackageDao;
import cn.wlgl.dbc.DataBaseConnection;
import cn.wlgl.factory.DAOFactory;
import cn.wlgl.factory.ServiceFactory;
import cn.wlgl.service.ICompanyService;
import cn.wlgl.vo.Manage;
import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Package;
import cn.wlgl.vo.Person;
/**
 * 当取得了本类就可以进行数据库和IO操作了
 * @author Administrator
 *
 */
public class CompanyServiceImpl implements ICompanyService {
	private DataBaseConnection dbc = new DataBaseConnection();

	@Override
	public boolean Login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		try {
			IManageDao imd = DAOFactory.getIManageDaoInstance(dbc.getConnection());
			Manage m = imd.findByUsername(username);
			if (m != null && m.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

	@Override
	public List<NewPackage> SelectNewAll() throws Exception {
		// TODO Auto-generated method stub
		try {
			INewPackageDao inp = DAOFactory.getINewPackageDaoInstance(dbc.getConnection());
			List<NewPackage> list = inp.findAll();
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

	

	@Override
	public boolean AssignNewPackage(int[] enumber) throws Exception {
		// TODO Auto-generated method stub
		try {
			for (int i = 0; i < enumber.length; i++) {
				NewPackage np = DAOFactory.getINewPackageDaoInstance(dbc.getConnection()).findByEnumber(enumber[i]);
				if(np == null) {
					continue;
				}
				Package p = new Package();
				p.setEnumber(np.getEnumber());
				p.setPnumber(np.getPnumber());
				p.setSendaddress(np.getSendaddress());
				p.setGetaddress(np.getGetaddress());
				p.setSendtime(np.getSendtime());
				p.setPhone(np.getPhone());
				p.setSign(false);
				DAOFactory.getIPackageDaoInstance(dbc.getConnection()).doCreate(p);
				DAOFactory.getINewPackageDaoInstance(dbc.getConnection()).doRemove(enumber[i]);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
		return true;
	}

	@Override
	public List<Package> findAll() throws Exception {
		// TODO Auto-generated method stub
		try {
			IPackageDao ipd = DAOFactory.getIPackageDaoInstance(dbc.getConnection());
			List<Package> list = ipd.findAll();
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

	@Override
	public List<Package> findFalse() throws Exception {
		// TODO Auto-generated method stub
		try {
			IPackageDao ipd = DAOFactory.getIPackageDaoInstance(dbc.getConnection());
			List<Package> list = ipd.findFalse();
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

	@Override
	public List<Package> findByNumber(int flag, int number) throws Exception {
		// TODO Auto-generated method stub
		try {
			if (flag == 0) {
				List<Package> list = new ArrayList<Package>();
				if(DAOFactory.getIPackageDaoInstance(dbc.getConnection()).findByEnumber(number)==null) {
					return list;
				}
				Package p = DAOFactory.getIPackageDaoInstance(dbc.getConnection()).findByEnumber(number);
				list.add(p);
				return list;
			} else if (flag == 1) {
				List<Package> list = DAOFactory.getIPackageDaoInstance(dbc.getConnection()).findByPnumber(number);
				return list;
			} else {
				List<Package> list = DAOFactory.getIPackageDaoInstance(dbc.getConnection()).findByCnumber(number);
				return list;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}
	
	@Override
	public boolean updatePackage(int[] enumber,int c) throws Exception {
		// TODO Auto-generated method stub
		try {
			IPackageDao ipd = DAOFactory.getIPackageDaoInstance(dbc.getConnection());
			NewPackage np = ServiceFactory.getICompanyServiceInstance().findByEnumber(c);
			
			Package p = new Package();
			p.setEnumber(c);
			p.setPnumber(np.getPnumber());
			p.setSendaddress(np.getSendaddress());
			p.setGetaddress(np.getGetaddress());
			p.setSendtime(np.getSendtime());
			p.setGettime(new Date(System.currentTimeMillis()));
			p.setMoney(100);
			p.setPhone(np.getPhone());
			p.setSign(true);

			ipd.doCreate(p);
			ipd.doRemoveNew(c);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
		return true;
	}

	@Override
	public int countPackage(int enumber) throws Exception {
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIPackageDaoInstance(dbc.getConnection()).countPackage(enumber);
		}finally {
			dbc.close();
		}
		
	}
	
	@Override
	public NewPackage findByEnumber(int enumber) throws Exception {
		// TODO Auto-generated method stub
		try {
			INewPackageDao ip = DAOFactory.getINewPackageDaoInstance(dbc.getConnection());
			NewPackage np = ip.findByEnumber(enumber);
			return np;
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

	@Override
	public void doRemovePackage(int enumber) throws Exception {
		// TODO Auto-generated method stub
		DAOFactory.getIPackageDaoInstance(dbc.getConnection()).doRemove(enumber);
	}
}
