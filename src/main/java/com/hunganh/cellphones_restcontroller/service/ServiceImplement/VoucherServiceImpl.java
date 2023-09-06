package com.hunganh.cellphones_restcontroller.service.ServiceImplement;

import com.hunganh.cellphones_restcontroller.dto.request.sales.CVoucherDTO;
import com.hunganh.cellphones_restcontroller.dto.response.sales.VoucherInfo;
import com.hunganh.cellphones_restcontroller.entity.sales.Voucher;
import com.hunganh.cellphones_restcontroller.repository.sales.VoucherRepository;
import com.hunganh.cellphones_restcontroller.service.sales.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository repository;

    @Override
    public List<VoucherInfo> getAll() {
        return repository.findAllBy();
    }

    @Override
    public VoucherInfo save(CVoucherDTO dto) {
        return getVoucherInfo(repository.save(convert(dto)));
    }

    private Voucher convert(CVoucherDTO dto) {
        Voucher voucher = new Voucher();
        voucher.setName(dto.getName());
        voucher.setDescription(dto.getDescription());
        return voucher;
    }

    private VoucherInfo getVoucherInfo(Voucher entity) {
        return new SpelAwareProxyProjectionFactory().createProjection(VoucherInfo.class, entity);
    }
}
