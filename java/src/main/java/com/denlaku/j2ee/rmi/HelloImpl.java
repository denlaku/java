package com.denlaku.j2ee.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 2，创建远程方法接口实现类：
 * UnicastRemoteObject类的构造函数抛出了RemoteException，
 * 故其继承类不能使用默认构造函数，继承类的构造函数必须也抛出RemoteException
 * 由于方法参数与返回值最终都将在网络上传输，故必须是可序列化的
 * @author User
 *
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

	private static final long serialVersionUID = 689077511487271690L;

	public HelloImpl() throws RemoteException {
		super();
	}

	@Override
	public String sayHello(String name) throws RemoteException {
		return null;
	}

	@Override
	public String run(int speed) throws RemoteException {
		return null;
	}

}
