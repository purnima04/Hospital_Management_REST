package com.banfico.hospital_management.Services;

import com.banfico.hospital_management.Dao.BillingRepository;
import com.banfico.hospital_management.Entity.BillingEntity;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.List;
@Service
public class BillingService implements BillingServiceInterface{

    @Autowired
    private BillingRepository billingRepository;
    @Override
    public List<BillingEntity> getBills() {
        return billingRepository.findAll();
    }

    @Override
    public BillingEntity getBill(Long bill_Id) {
        return billingRepository.getById(bill_Id);
    }

    @Override
    public BillingEntity addBill(BillingEntity billingEntity) {
        return billingRepository.save(billingEntity);
    }

    @Override
    public BillingEntity updateBill(BillingEntity billingEntity) {
        return billingRepository.save(billingEntity);
    }

    @Override
    public void deleteBill(Long bill_Id) {
        BillingEntity deletedBill = billingRepository.getById(bill_Id);
        billingRepository.delete(deletedBill);
    }
}
