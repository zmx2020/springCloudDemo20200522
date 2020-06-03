package com.zmx.springcloud.controller;

import com.zmx.springcloud.entities.CommonResult;
import com.zmx.springcloud.entities.Payment;
import com.zmx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(Payment payment) {
        int count = paymentService.create(payment);
        log.info("====插入结果==={}", count);

        CommonResult commonResult = null;

        if (count > 0) {
            commonResult = new CommonResult(200, "插入成功");
        } else {
            commonResult = new CommonResult(500, "插入失败");
        }
        return commonResult;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("====查询结果==={}" ,payment);
        CommonResult commonResult = null;
        if (payment != null) {
            commonResult = new CommonResult(200, "查询成功", payment);
        } else {
            commonResult = new CommonResult(200, "查询失败,没有找到对应ID:" + id);
        }
        return commonResult;
    }
}
