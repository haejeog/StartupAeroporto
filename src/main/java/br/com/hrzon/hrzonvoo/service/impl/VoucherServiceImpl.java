package br.com.hrzon.hrzonvoo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrzon.hrzonvoo.repository.VoucherRepository;
import br.com.hrzon.hrzonvoo.service.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {
	@Autowired
	private VoucherRepository voucherRepository;

}