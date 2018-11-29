/**
 * Peanuts
 */
package com.soaringroad.common.vo;

import lombok.AllArgsConstructor;

/**
 * <pre>
 * Enum of Elasitcsearch connection type
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/20
 */
@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public enum EsConnectionTypeEnum implements Enum {
    // RestClient
    REST(1),
    // Transport
    TRANSPORT(2);
    private int code;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name();
    }

}
