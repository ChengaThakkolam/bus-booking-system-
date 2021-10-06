package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Wallet;


@Repository
public interface WalletRepo  extends CrudRepository<Wallet, Integer> {

}
