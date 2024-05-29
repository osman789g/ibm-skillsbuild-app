package com.example.newone.repos;

import com.example.newone.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Optional<Avatar> findById(Long avatarId);

    Avatar findAvatarIdByAvatarUrl(String avatarUrl);

    List<Avatar> findByAvatarIdLessThanEqual(Long avatarId);
}
