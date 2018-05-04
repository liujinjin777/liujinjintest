package com.liujinjin.temp;

/**
 * @author liuxin
 * @date 2017/11/16
 */
public enum Site {
    MeiTuan(0, "美团"),
    XIECHENG(202, "携程"),
    Other(-1, "其他");

    Integer code;
    String desc;

    private Site(int code, String desc) {
        this.code = Integer.valueOf(code);
        this.desc = desc;
    }

    public static Site of(int code) {
        Site[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Site site = var1[var3];
            if(site.getCode().intValue() == code) {
                return site;
            }
        }

        return Other;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
