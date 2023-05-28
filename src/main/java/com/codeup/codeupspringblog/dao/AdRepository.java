package com.codeup.codeupspringblog.dao;
import com.codeup.codeupspringblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {
  Ad findByTitle(String title);
  Ad findFirstByTitle(String title);

  @Query("from Ad a where a.title like %:term%")
  List<Ad> searchByTitleLike(@Param("term") String term);
}
