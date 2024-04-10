package com.example.server.Repository;

import com.example.server.Entity.SizeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeItemRepository extends JpaRepository<SizeItem, Long> {
}
