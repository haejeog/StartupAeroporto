package br.com.hrzon.hrzonvoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hrzon.hrzonvoo.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

}
