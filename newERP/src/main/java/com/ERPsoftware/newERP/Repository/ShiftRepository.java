package com.ERPsoftware.newERP.Repository;

import com.ERPsoftware.newERP.Model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    // Add custom query methods if needed
}

