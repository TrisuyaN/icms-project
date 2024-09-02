package com.sc.scbackend.base;

import com.baomidou.mybatisplus.annotation.IEnum;

import java.io.Serializable;

public interface IBaseEnum<T extends Serializable> extends IEnum<T> {
    T getValue();
}
