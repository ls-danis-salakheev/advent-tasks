package com.dan.task3;

public class Password {

    private int byr;
    private int iyr;
    private int eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private long pid;
    private int cid;

    public Password() {
    }

    public Password(int byr, int iyr, int eyr, String hgt, String hcl, String ecl, long pid, int cid) {
        this.byr = byr;
        this.iyr = iyr;
        this.eyr = eyr;
        this.hgt = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
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

    public long getPid() {
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
