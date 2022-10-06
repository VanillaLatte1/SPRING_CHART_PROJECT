package com.example.demo.repo;

import com.example.demo.vo.MelonVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MelonRepository extends JpaRepository<MelonVo, Long> {
}
