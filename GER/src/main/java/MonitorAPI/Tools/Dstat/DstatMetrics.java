package MonitorAPI.Tools.Dstat;

public class DstatMetrics {

    /*Cpu Metrics*/
    public static float usr;
    public static float sys;
    public static float idl;
    public static float wai;
    public static float hiq;
    public static float siq;

    /*Mem Metrics*/
    public static float used;
    public static float buff;
    public static float cach;
    public static float free;

    /*Disk Metrics*/
    public static float read;
    public static float writ;

    /*Network Metrics*/
    public static int recv;
    public static int send;

    public DstatMetrics() {

    }


    /*Sobrecarga de metodos para receber informação dos metodos de colhimento e atribuição de metricas*/
    public DstatMetrics(float usr, float sys, float idl, float wai, float hiq, float siq) {
        /*Construtor CPU Metrics*/
        this.usr = usr;
        this.sys = sys;
        this.idl = idl;
        this.wai = wai;
        this.hiq = hiq;
        this.siq = siq;
    }

    public DstatMetrics(float used, float buff, float cach, float free) {
        /*Mem Metrics*/
        this.used = used;
        this.buff = buff;
        this.cach = cach;
        this.free = free;
    }

    public DstatMetrics(float read, float writ) {
        /*Disk Metrics*/
        this.read = read;
        this.writ = writ;
    }

    public DstatMetrics(int recv, int send) {
        /*Network Metrics*/
        this.recv = recv;
        this.send = send;
    }

    /*Getter e Setter CPU*/
    public float getUsr() {
        return usr;
    }

    public void setUsr(float usr) {
        this.usr = usr;
    }

    public float getSys() {
        return sys;
    }

    public void setSys(float sys) {
        this.sys = sys;
    }

    public float getIdl() {
        return idl;
    }

    public void setIdl(float idl) {
        this.idl = idl;
    }

    public float getWai() {
        return wai;
    }

    public void setWai(float wai) {
        this.wai = wai;
    }

    public float getHiq() {
        return hiq;
    }

    public void setHiq(float hiq) {
        this.hiq = hiq;
    }

    public float getSiq() {
        return siq;
    }

    public void setSiq(float siq) {
        this.siq = siq;
    }

    /*Getter e Setter MEMORIA*/
    public float getUsed() {
        return used;
    }

    public void setUsed(float used) {
        this.used = used;
    }

    public float getBuff() {
        return buff;
    }

    public void setBuff(float buff) {
        this.buff = buff;
    }

    public float getCach() {
        return cach;
    }

    public void setCach(float cach) {
        this.cach = cach;
    }

    public float getFree() {
        return free;
    }

    public void setFree(float free) {
        this.free = free;
    }

    /*Getter e Setter DISCO*/
    public float getRead() {
        return read;
    }

    public void setRead(float read) {
        this.read = read;
    }

    public float getWrit() {
        return writ;
    }

    public void setWrit(float writ) {
        this.writ = writ;
    }

    /*Getter e Setter NETWORK*/
    public int getRecv() {
        return recv;
    }

    public void setRecv(int recv) {
        this.recv = recv;
    }

    public int getSend() {
        return send;
    }

    public void setSend(int send) {
        this.send = send;
    }

}
