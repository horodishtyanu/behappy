package com.serverside.behappy.repos;

import com.serverside.behappy.models.NegativeEmotionsPast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NegativeEmotionsPastRepo extends JpaRepository<NegativeEmotionsPast, Long> {
}
