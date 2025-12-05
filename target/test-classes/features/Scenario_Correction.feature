Feature: remplissage d'un formulaire (d'inscription/demande de devis)
  Scenario: verifier le bon remplissage du formulaire
    Given je suis sur la page DemoQA dans la section "Text Box"
    When je remplis le champ "userName" avec la valeur "Jean Dupond"
    And je remplis le champ "Email" avec la valeur "email@toto.com"
    And je remplis le champ "Current Address" avec la valeur "chez lui"
    And je remplis le champ "Permanent Address" avec la valeur "certainement pas en dessous d un pont"
    And je clique sur le bouton "submit"
    Then le formulaire est pret a etre soumis