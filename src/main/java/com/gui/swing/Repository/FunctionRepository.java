package com.gui.swing.Repository;

import com.gui.swing.Entity.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Integer> {
}