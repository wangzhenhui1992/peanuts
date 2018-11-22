/**
 * Peanuts
 */
package com.peanuts.community.common.vo;

/**
 * <pre>
 * Enum of Elasitcsearch connection type
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/20
 */
public enum EsConnectionTypeEnum implements Enum {
    // RestClient
    REST(1),
    // Transport
    TRANSPORT(2);
    private int code;

    EsConnectionTypeEnum(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name();
    }

}
