package edacy.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edacy.project.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
