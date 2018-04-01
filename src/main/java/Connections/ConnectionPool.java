package Connections;


import java.util.ArrayList;
import java.util.List;



public class ConnectionPool {

	private static ConnectionPool _instance = null;
	private List<Connection> connections;
	private static final int numberOfConnections =5;


	/**
	 * 
	 * @return the instance
	 */
	public static synchronized ConnectionPool getInstance() {
		if(_instance == null)
			_instance = new ConnectionPool();
		return _instance;
	}


	private ConnectionPool() {
		this.connections = new ArrayList<>();
		for(int i=0;i<numberOfConnections;i++) {
			this.connections.add(new Connection());
		}
	}

	/**
	 * 
	 * @return get connection
	 */
	public synchronized Connection getConnection() {
		while(this.connections.isEmpty())
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		Connection connection = this.connections.get(0);
		this.connections.remove(0);
		return connection;
	}

	/**
	 * 
	 * @param connection return the connection
	 */
	public synchronized void returnConnection(Connection connection) {
		this.connections.add(connection);
		this.notify();

	}
	/**
	 * close all connection
	 */
	public void closeConnetions() {
		this.connections.removeAll(connections);
	}

}
