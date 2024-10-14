package com.IRCTCC.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.IRCTCC.Pojo.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
	
    List<Train> findBySourceAndDestination(String source, String destination);
}
