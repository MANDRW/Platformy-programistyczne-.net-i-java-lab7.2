package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Car entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CarRepository extends ReactiveCrudRepository<Car, Long>, CarRepositoryInternal {
    Flux<Car> findAllBy(Pageable pageable);

    @Override
    <S extends Car> Mono<S> save(S entity);

    @Override
    Flux<Car> findAll();

    @Override
    Mono<Car> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface CarRepositoryInternal {
    <S extends Car> Mono<S> save(S entity);

    Flux<Car> findAllBy(Pageable pageable);

    Flux<Car> findAll();

    Mono<Car> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Car> findAllBy(Pageable pageable, Criteria criteria);
}
