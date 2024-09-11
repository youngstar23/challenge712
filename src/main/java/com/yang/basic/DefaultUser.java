package com.yang.basic;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
class DefaultUser implements Serializable {
    private int id;
    private String name;
}
