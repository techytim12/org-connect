package com.org_connect.filter;

public class OrgContext {

    private static final ThreadLocal<String> orgHolder = new ThreadLocal<>();
    private static final ThreadLocal<String> roleHolder = new ThreadLocal<>();


    public static void setOrg(String org){
        orgHolder.set(org);
    }
    public static String getOrg(){
        return orgHolder.get();
    }
    public static void setRole(String role){
        roleHolder.set(role);
    }
    public static String getRole(){
        return roleHolder.get();
    }
    public static void clear(){
        orgHolder.remove();
        roleHolder.remove();
    }

}
