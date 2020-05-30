package com.asiainfo.billing.cloudproduct.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangran
 * @since 2020-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("PRODUCT_ID")
    private Integer productId;

    @TableId("PRODUCT_NAME")
    private String productName;

    @TableId("PRODUCT_PRICE")
    private Integer productPrice;


}
