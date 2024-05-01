package com.ERPsoftware.newERP.Repository;

import com.ERPsoftware.newERP.Model.RawData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawDataRepository extends JpaRepository<RawData, Long> {
    // Add custom query methods if needed
}
