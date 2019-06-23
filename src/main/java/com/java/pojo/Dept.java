package com.java.pojo;

public class Dept {

    private int deptno;
    private int deptno1;
    private int deptno2;
    private String dname;
    private String loc;

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public int getDeptno1() {
        return deptno1;
    }

    public void setDeptno1(int deptno1) {
        this.deptno1 = deptno1;
    }

    public int getDeptno2() {
        return deptno2;
    }

    public void setDeptno2(int deptno2) {
        this.deptno2 = deptno2;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptno1=" + deptno1 +
                ", deptno2=" + deptno2 +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}