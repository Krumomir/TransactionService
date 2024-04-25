package com.example.transactionservice.repositories;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.transactionservice.entities.CryptoPrice;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryptoPriceRepository extends JpaRepository<CryptoPrice, Long> {
    @Override
    @CacheEvict(value = "cryptoPrice", key = "#p0")
    void deleteById(Long aLong);

    @Override
    @CachePut(value = "cryptoPrice", key = "#result.id")
    <S extends CryptoPrice> S save(S entity);

    @Override
    @Cacheable(value = "cryptoPrice", key = "#p0")
    Optional<CryptoPrice> findById(Long aLong);
}

