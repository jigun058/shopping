package com.DYC.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Page<Member> findPageBy(Pageable page);
    Slice<Member> findSliceBy(Pageable page);

    Optional<Member> findByUsername(String username);
}