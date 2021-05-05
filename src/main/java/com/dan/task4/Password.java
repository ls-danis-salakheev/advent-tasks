package com.dan.task4;

public class Password {

    private int byr;
    private int iyr;
    private int eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private int pid;
    private int cid;

    public Password(int byr, int iyr, int eyr, String hgt, String hcl, String ecl, int pid, int cid) {
        this.byr = byr;
        this.iyr = iyr;
        this.eyr = eyr;
        this.hgt = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
        this.cid = cid;
    }

    public Password() {
    }

    public void setByr(int byr) {
        this.byr = byr;
    }

    public void setIyr(int iyr) {
        this.iyr = iyr;
    }

    public void setEyr(int eyr) {
        this.eyr = eyr;
    }

    public void setHgt(String hgt) {
        this.hgt = hgt;
    }

    public void setHcl(String hcl) {
        this.hcl = hcl;
    }

    public void setEcl(String ecl) {
        this.ecl = ecl;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getByr() {
        return byr;
    }

    public int getIyr() {
        return iyr;
    }

    public int getEyr() {
        return eyr;
    }

    public String getHgt() {
        return hgt;
    }

    public String getHcl() {
        return hcl;
    }

    public String getEcl() {
        return ecl;
    }

    public int getPid() {
        return pid;
    }

    public int getCid() {
        return cid;
    }

    @Override
    public String toString() {
        return "Password{" +
                "byr=" + byr +
                ", iyr=" + iyr +
                ", eyr=" + eyr +
                ", hgt='" + hgt + '\'' +
                ", hcl='" + hcl + '\'' +
                ", ecl='" + ecl + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                '}';
    }
}
