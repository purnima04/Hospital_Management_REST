package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Entity.BillingEntity;
import com.banfico.hospital_management.Entity.DoctorEntity;

import java.util.List;

public interface BillingServiceInterface {
    public List<BillingEntity> getBills();
    public BillingEntity getBill(Long bill_Id);
    public BillingEntity addBill(BillingEntity billingEntity);
    public BillingEntity updateBill(BillingEntity billingEntity);
    public void deleteBill(Long bill_Id);
}
