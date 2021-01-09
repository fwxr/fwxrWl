package cn.wlgl.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import cn.wlgl.dao.INewPackageDao;
import cn.wlgl.dao.IPackageDao;
import cn.wlgl.dao.IPersonDao;
import cn.wlgl.dao.impl.PersonDaoImpl;
import cn.wlgl.dbc.DataBaseConnection;
import cn.wlgl.factory.DAOFactory;
import cn.wlgl.service.IPersonService;
import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Person;
import cn.wlgl.vo.Package;

public class PersonServiceImpl implements IPersonService {
	private DataBaseConnection dbc = new DataBaseConnection();

	@Override
	public Person Login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		try {
			IPersonDao ip = new PersonDaoImpl(dbc.getConnection());
			Person p = ip.findByUsername(username);
			if (p != null && p.getPassword().equals(password)) {
				return p;
			}
			return null;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean Regist(Person p) throws Exception {
		// TODO Auto-generated method stub
		try {
			IPersonDao ip = new PersonDaoImpl(dbc.getConnection());
			if (ip.findByUsername(p.getUsername()) != null) {
				return false;
			}
			p.setPnumber(new Random().nextInt(1000));
			return ip.doCreate(p);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}

	}

	@Override
	public boolean update(Person p) throws Exception {
		// TODO Auto-generated method stub
		try {
			IPersonDao ip = new PersonDaoImpl(dbc.getConnection());
			return ip.doUpdate(p);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}

	public boolean Create(NewPackage np) throws Exception {
		// TODO Auto-generated method stub
		try {
			INewPackageDao inp = DAOFactory.getINewPackageDaoInstance(dbc.getConnection());
			np.setEnumber(new Random().nextInt(100000));
			np.setSendtime(new Date(System.currentTimeMillis()));
			return inp.doCreate(np);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

	public List<NewPackage> SelectNew(int pnumber) throws Exception {
		// TODO Auto-generated method stub
		try {
			INewPackageDao ipd = DAOFactory.getINewPackageDaoInstance(dbc.getConnection());
			List<NewPackage> list = ipd.findByPnumber(pnumber);
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

	@Override
	public List<Package> SelectPack(int pnumber) throws Exception {
		// TODO Auto-generated method stub
		try {
			IPackageDao ipd = DAOFactory.getIPackageDaoInstance(dbc.getConnection());
			List<Package> list = ipd.findByPnumber(pnumber);
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

	

	@Override
	public Set<Person> findByAll() throws Exception {
		// TODO Auto-generated method stub
		return DAOFactory.getIPersonDaoInstance(dbc.getConnection()).findByAll();
	}
	
	
}
