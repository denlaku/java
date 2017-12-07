package com.denlaku.j2ee.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * 远程方法接口
 * 1，创建远程方法接口，该接口必须继承自Remote接口
 * 2,由于远程方法调用的本质依然是网络通信，只不过隐藏了底层实现，
 *   网络通信是经常会出现异常的，所以接口的所有方法都必须抛出
 *   RemoteException以说明该方法是有风险的
 * @author User
 *
 */
public interface IHello extends Remote {
	/**
	 * 
	 * @param name
	 * @return
	 * @throws java.rmi.RemoteException
	 */
	public String sayHello(String name) throws RemoteException;

	public String run(int speed) throws RemoteException;
}