package com.ERPsoftware.newERP.Repository;

import com.ERPsoftware.newERP.Model.CombinedTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombinedTableRepository extends JpaRepository<CombinedTable, Long> {
    // Add custom query methods if needed
}
