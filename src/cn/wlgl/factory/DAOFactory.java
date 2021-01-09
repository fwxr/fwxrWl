package cn.wlgl.factory;

import java.sql.Connection;


import cn.wlgl.dao.IManageDao;
import cn.wlgl.dao.INewPackageDao;
import cn.wlgl.dao.IPackageDao;
import cn.wlgl.dao.IPersonDao;
import cn.wlgl.dao.impl.ManageDaoImpl;
import cn.wlgl.dao.impl.NewPackageDaoImpl;
import cn.wlgl.dao.impl.PackageDaoImpl;
import cn.wlgl.dao.impl.PersonDaoImpl;

public class DAOFactory {
	public static IPersonDao getIPersonDaoInstance(Connection conn) {
		return new PersonDaoImpl(conn);
	}

	public static INewPackageDao getINewPackageDaoInstance(Connection conn) {
		return new NewPackageDaoImpl(conn);
	}

	public static IPackageDao getIPackageDaoInstance(Connection conn) {
		return new PackageDaoImpl(conn);
	}


	public static IManageDao getIManageDaoInstance(Connection conn) {
		return new ManageDaoImpl(conn);
	}
}
