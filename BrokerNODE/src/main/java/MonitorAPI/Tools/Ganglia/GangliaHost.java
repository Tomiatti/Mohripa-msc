/*
 * - All modification in this code must be documented and the author of the modifications prints your name
 * - It is also important to make a Changelog of all modifications below of this description
 * - For each modification, please change the version number incrementing it in .1
 */

/**
 * CHANGELOG 
 * 
 * DATE: DAY/MONTH/YEAR
 * LIST OF MODIFICATIONS
 * --------------------
 * 
 * 
 * 
 * --------------------
 * 
 */

package MonitorAPI.Tools.Ganglia;

/**
 * Obtain all information stored into host port of the Ganglia monitoring system. 
 * All information will be parsed in order to be used to compose a performance index
 * @author Julio Cezar Estrella and Thiago Caproni Tavares
 * @version 1.0
 */
public class GangliaHost {	
	// Host Information
	private String name = "";
	private String IP = "";
	private long heartBeat = 0;
	
	// Metric Information
	private float loadOne = 0.0f;
	private float memTotal = 0.0f;
	private String osRelease = "";
	private int procRun = 0;
	private float loadFive = 0.0f;;
	private String gexec = "";
	private double diskFree = 0.0d;
	private float memCached = 0.0f;
	private float pktsIn = 0.0f;
	private float bytesIn = 0.0f;
	private float bytesOut = 0.0f;
	private float swapTotal = 0.0f;
	private float memFree = 0.0f;
	private float loadFifteen = 0.0f;
	private String osName = "";
	private int boottime = 0;
	private float cpuIdle = 0.0f;
	private float cpuUser = 0.0f;
	private float cpuTop = 0.0f;
	private float cpuNice = 0.0f;
	private float cpuAidle = 0.0f;
	private float memBuffers = 0.0f;
	private float cpuSystem = 0.0f;
	private float partMaxUsed = 0.0f;
	private double diskTotal = 0.0d;
	private float memShared = 0.0f;
	private float cpuWio = 0.0f;
	private String machineType = "";
	private int procTotal = 0;
	private int cpuNum = 0;
	private int cpuSpeed = 0;
	private float pktsOut = 0.0f;
	private float swapFree = 0.0f;
	
	//Getters and Setters
        
        /**
         * 
         * @return 
         */
	public String getName() {
		return name;
	}
        
        /**
         * 
         * @param name 
         */
	public void setName(String name) {
		this.name = name;
	}
	
        /**
         * 
         * @return 
         */
        public String getIP() {
		return IP;
	}
        
        /**
         * 
         * @param ip 
         */
	public void setIP(String ip) {
		IP = ip;
	}
        
        /**
         * 
         * @return 
         */
	public float getLoadOne() {
		return loadOne;
	}
        
        /**
         * 
         * @param loadOne 
         */
	public void setLoadOne(float loadOne) {
		this.loadOne = loadOne;
	}
        
        /**
         * 
         * @return 
         */
	public float getMemTotal() {
		return memTotal;
	}
        
        /**
         * 
         * @param memTotal 
         */
	public void setMemTotal(float memTotal) {
		this.memTotal = memTotal;
	}
        
        /**
         * 
         * @return 
         */
	public String getOsRelease() {
		return osRelease;
	}
        
        /**
         * 
         * @param osRelease 
         */
	public void setOsRelease(String osRelease) {
		this.osRelease = osRelease;
	}
        
        /**
         * 
         * @return 
         */
	public int getProcRun() {
		return procRun;
	}
        
        /**
         * 
         * @param procRun 
         */
	public void setProcRun(int procRun) {
		this.procRun = procRun;
	}
        
        /**
         * 
         * @return 
         */
	public float getLoadFive() {
		return loadFive;
	}
        
        /**
         * 
         * @param loadFive 
         */
	public void setLoadFive(float loadFive) {
		this.loadFive = loadFive;
	}
        
        /**
         * 
         * @return 
         */
	public String getGexec() {
		return gexec;
	}
        
        /**
         * 
         * @param gexec 
         */
	public void setGexec(String gexec) {
		this.gexec = gexec;
	}
        
        /**
         * 
         * @return 
         */
	public double getDiskFree() {
		return diskFree;
	}
        
        /**
         * 
         * @param diskFree 
         */
	public void setDiskFree(double diskFree) {
		this.diskFree = diskFree;
	}
        
        /**
         * 
         * @return 
         */
	public float getMemCached() {
		return memCached;
	}
        
        /**
         * 
         * @param memCached 
         */
	public void setMemCached(float memCached) {
		this.memCached = memCached;
	}
        
        /**
         * 
         * @return 
         */
	public float getPktsIn() {
		return pktsIn;
	}
        
        /**
         * 
         * @param pktsIn 
         */
	public void setPktsIn(float pktsIn) {
		this.pktsIn = pktsIn;
	}
        
        /**
         * 
         * @return 
         */
	public float getBytesIn() {
		return bytesIn;
	}
        
        /**
         * 
         * @param bytesIn 
         */
	public void setBytesIn(float bytesIn) {
		this.bytesIn = bytesIn;
	}
        
        /**
         * 
         * @return 
         */
	public float getBytesOut() {
		return bytesOut;
	}
        
        /**
         * 
         * @param bytesOut 
         */
	public void setBytesOut(float bytesOut) {
		this.bytesOut = bytesOut;
	}
        
        /**
         * 
         * @return 
         */
	public float getSwapTotal() {
		return swapTotal;
	}
        
        /**
         * 
         * @param swapTotal 
         */
	public void setSwapTotal(float swapTotal) {
		this.swapTotal = swapTotal;
	}
        
        /**
         * 
         * @return 
         */
	public float getMemFree() {
		return memFree;
	}
        
        /**
         * 
         * @param memFree 
         */
	public void setMemFree(float memFree) {
		this.memFree = memFree;
	}
        
        /**
         * 
         * @return 
         */
	public float getLoadFifteen() {
		return loadFifteen;
	}
        
        /**
         * 
         * @param loadFifteen 
         */
	public void setLoadFifteen(float loadFifteen) {
		this.loadFifteen = loadFifteen;
	}
        
        /**
         * 
         * @return 
         */
	public String getOsName() {
		return osName;
	}
        
        /**
         * 
         * @param osName 
         */
	public void setOsName(String osName) {
		this.osName = osName;
	}
        
        /**
         * 
         * @return 
         */
	public int getBoottime() {
		return boottime;
	}
        
        /**
         * 
         * @param boottime 
         */
	public void setBoottime(int boottime) {
		this.boottime = boottime;
	}
        
        /**
         * 
         * @return 
         */
	public float getCpuIdle() {
		return cpuIdle;
	}
        
        /**
         * 
         * @param cpuIdle 
         */
	public void setCpuIdle(float cpuIdle) {
		this.cpuIdle = cpuIdle;
	}
        
        /**
         * 
         * @param cpuTop 
         */
        public void setCpuTop(float cpuTop) {
		this.cpuTop = cpuTop;
	}
        
        /**
         * 
         * @return 
         */
	public float getCpuUser() {
		return cpuUser;
	}
        
        /**
         * 
         * @param cpuUser 
         */
	public void setCpuUser(float cpuUser) {
		this.cpuUser = cpuUser;
	}
        
        /**
         * 
         * @return 
         */
	public float getCpuNice() {
		return cpuNice;
	}
        
        /**
         * 
         * @param cpuNice 
         */
	public void setCpuNice(float cpuNice) {
		this.cpuNice = cpuNice;
	}
        
        /**
         * 
         * @return 
         */
	public float getCpuAidle() {
		return cpuAidle;
	}
        
        /**
         * 
         * @return 
         */
        public float getCpuTop() {
		return cpuTop;
	}
        
        /**
         * 
         * @param cpuAidle 
         */
	public void setCpuAidle(float cpuAidle) {
		this.cpuAidle = cpuAidle;
	}
        
        /**
         * 
         * @return 
         */
	public float getMemBuffers() {
		return memBuffers;
	}
        
        /**
         * 
         * @param memBuffers 
         */
	public void setMemBuffers(float memBuffers) {
		this.memBuffers = memBuffers;
	}
        
        /**
         * 
         * @return 
         */
	public float getCpuSystem() {
		return cpuSystem;
	}
        
        /**
         * 
         * @param cpuSystem 
         */
	public void setCpuSystem(float cpuSystem) {
		this.cpuSystem = cpuSystem;
	}
        
        /**
         * 
         * @return 
         */
	public float getPartMaxUsed() {
		return partMaxUsed;
	}
        
        /**
         * 
         * @param partMaxUsed 
         */
	public void setPartMaxUsed(float partMaxUsed) {
		this.partMaxUsed = partMaxUsed;
	}
        
        /**
         * 
         * @return 
         */
	public double getDiskTotal() {
		return diskTotal;
	}
        
        /**
         * 
         * @param diskTotal 
         */
	public void setDiskTotal(double diskTotal) {
		this.diskTotal = diskTotal;
	}
        
        /**
         * 
         * @return 
         */
	public float getMemShared() {
		return memShared;
	}
        
        /**
         * 
         * @param memShared 
         */
	public void setMemShared(float memShared) {
		this.memShared = memShared;
	}
        
        /**
         * 
         * @return 
         */
	public float getCpuWio() {
		return cpuWio;
	}
        
        /**
         * 
         * @param cpuWio 
         */
	public void setCpuWio(float cpuWio) {
		this.cpuWio = cpuWio;
	}
        
        /**
         * 
         * @return 
         */
	public String getMachineType() {
		return machineType;
	}
        
        /**
         * 
         * @param machineType 
         */
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
        
        /**
         * 
         * @return 
         */
	public int getProcTotal() {
		return procTotal;
	}
        
        /**
         * 
         * @param procTotal 
         */
	public void setProcTotal(int procTotal) {
		this.procTotal = procTotal;
	}
        
        /**
         * 
         * @return 
         */
	public int getCpuNum() {
		return cpuNum;
	}
        
        /**
         * 
         * @param cpuNum 
         */
	public void setCpuNum(int cpuNum) {
		this.cpuNum = cpuNum;
	}
        
        /**
         * 
         * @return 
         */
	public int getCpuSpeed() {
		return cpuSpeed;
	}
        
        /**
         * 
         * @param cpuSpeed 
         */
	public void setCpuSpeed(int cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}
        
        /**
         * 
         * @return 
         */
	public float getPktsOut() {
		return pktsOut;
	}
        
        /**
         * 
         * @param pktsOut 
         */
	public void setPktsOut(float pktsOut) {
		this.pktsOut = pktsOut;
	}
        
        /**
         * 
         * @return 
         */
	public float getSwapFree() {
		return swapFree;
	}
        
        /**
         * 
         * @param swapFree 
         */
	public void setSwapFree(float swapFree) {
		this.swapFree = swapFree;
	}
        
        /**
         * 
         * @return 
         */
	public long getHeartBeat() {
		return heartBeat;
	}
        
        /**
         * 
         * @param heartBeat 
         */
	public void setHeartBeat(long heartBeat) {
		this.heartBeat = heartBeat;
	}
	
        /**
         * Shows information of the host
         */
	public void showHostInformation(){
		System.out.println("========= HOST INFORMATION =========");
		System.out.println("IP: " + this.IP);
		System.out.println("Name: " + this.name);
		System.out.println("HeartBeat: " + this.heartBeat);
	}
	
        /**
         * Shows all metrics obtained from the host
         */
	public void showMetrics(){
		System.out.println("============== METRICS =============");
		System.out.println("LoadOne: " + this.loadOne);
		System.out.println("MemTotal: " + this.memTotal);
		System.out.println("OsRelease: " + this.osRelease);
		System.out.println("ProcRun: " + this.procRun);
		System.out.println("LoadFive: " + this.loadFive);
		System.out.println("Gexec: " + this.gexec);
		System.out.println("DiskFree: " + this.diskFree);
		System.out.println("MemCached: " + this.memCached);
		System.out.println("PktsIn: " + this.pktsIn);
		System.out.println("BytesIn: " + this.bytesIn);
		System.out.println("BytesOut: " + this.bytesOut);
		System.out.println("SwapTotal: " + this.swapTotal);
		System.out.println("MemFree: " + this.memFree);
		System.out.println("LoadFifteen: " + this.loadFifteen);
		System.out.println("OsName: " + this.osName);
		System.out.println("Boottime: " + this.boottime);
		System.out.println("CpuIdle: " +  this.cpuIdle);
		System.out.println("CpuUser: " + this.cpuUser);
		System.out.println("CpuNice: " + this.cpuNice);
		System.out.println("CpuAidle: " + this.cpuAidle);
		System.out.println("MemBuffers: " + this.memBuffers);
		System.out.println("CpuSystem: " + this.cpuSystem);
		System.out.println("PartMaxUsed: " + this.partMaxUsed);
		System.out.println("DiskTotal: " + this.diskTotal);
		System.out.println("MemShared: " + this.memShared);
		System.out.println("CpuWio: " + this.cpuWio);
		System.out.println("MachineType: " + this.machineType);
		System.out.println("ProcTotal: " + this.procTotal);
		System.out.println("CpuNum: " + this.cpuNum);
		System.out.println("CpuSpeed: " + this.cpuSpeed);
		System.out.println("PktsOut: " + this.pktsOut);
		System.out.println("SwapFree: " + this.swapFree);
	}
}