/**
 * @Title: ConcreteBuilder.java
 * @Package: com.zhurong.designpattern.chuangjianxing5.builder
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.designpattern.chuangjianxing5.builder;

/**
 * @description: 具体的构建
 * @author LZG
 * @date 2019/3/20
 */
public class ConcreteBuilder implements Builder {

    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public void buildBasic() {
        product.setBasic("打好基础");
    }

    @Override
    public void buildWalls() {
        product.setWall("砌墙");
    }

    @Override
    public void roofed() {
        product.setRoofed("封顶大吉");
    }

    @Override
    public Product buildProduct() {
        return product;
    }

}