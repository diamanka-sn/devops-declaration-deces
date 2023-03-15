package sn.mairie.declarationDecesService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sn.mairie.declarationDecesService.entities.Declaration;
import sn.mairie.declarationDecesService.repositories.DeclarationRepository;

@Service
@Transactional
public class DeclarationService implements IDeclarationService{
	@Autowired
	DeclarationRepository declarationRepository;
	
	@Override
	public Declaration save(Declaration declaration) {
		// TODO Auto-generated method stub
		return declarationRepository.save(declaration);
	}

	@Override
	public List<Declaration> list() {
		// TODO Auto-generated method stub
		return declarationRepository.findAll();
	}

	@Override
	public String remove(Long id) {
		// TODO Auto-generated method stub
		declarationRepository.deleteById(id);
		return "Suppression réussie";
	}

	@Override
	public Declaration search(Long id) {
		// TODO Auto-generated method stub
		return declarationRepository.findById(id).get();
	}

	@Override
	public String update(Long id, Declaration declaration) {
		// TODO Auto-generated method stub
		
		Declaration existe = declarationRepository.findById(id).get();
		
		if(existe != null) {
			if(declaration.getCentre() != null) existe.setCentre(declaration.getCentre());
			if(declaration.getDate() != null) existe.setDate(declaration.getDate());
			if(declaration.getDateModification() != null) existe.setDateModification(declaration.getDateModification());
			if(declaration.getDeclarant() != null) existe.setDeclarant(declaration.getDeclarant());
			if(declaration.getDeclaration() != null) existe.setDeclaration(declaration.getDeclaration());
			if(declaration.getDefunt() != null) existe.setDefunt(declaration.getDefunt());
			if(declaration.getFormationSanitaire() != null) existe.setFormationSanitaire(declaration.getFormationSanitaire());
			if(declaration.getMention() != null) existe.setMention(declaration.getMention());
			if(declaration.getNature() != null) existe.setNature(declaration.getNature());
			if(declaration.getReference() != null) existe.setReference(declaration.getReference());
			if(declaration.getRegistre() != null) existe.setRegistre(declaration.getRegistre());
			if(declaration.getScanAt() != null) existe.setScanAt(declaration.getScanAt());
			if(declaration.getTemoin() != null) existe.setTemoin(declaration.getTemoin());
			if(declaration.getUtilisateur() != null) existe.setUtilisateur(declaration.getUtilisateur());
			
			declarationRepository.save(existe);
			
			return "Modification effectuée";
		}
		
		return "Modification echouée";
	}


}
