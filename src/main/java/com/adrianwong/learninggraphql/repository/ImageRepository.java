package com.adrianwong.learninggraphql.repository;

import com.adrianwong.learninggraphql.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
