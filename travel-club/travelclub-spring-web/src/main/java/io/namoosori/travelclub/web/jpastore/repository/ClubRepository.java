package io.namoosori.travelclub.web.jpastore.repository;

import io.namoosori.travelclub.web.jpastore.jpo.TravelClubJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<TravelClubJpo, String> {

}
