package com.zmx.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
//zmxtest33
public class Payment implements Serializable {
    private Long id;
    private String  serial;
}
