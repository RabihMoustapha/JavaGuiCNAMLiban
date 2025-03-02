# Université Libanaise Institut Supérieur des Sciences Appliquées et Economiques ISSAE - Le Cnam Liban
# NFA035 Projet 2023-2024
# U.E. : Programmation Java : Bibliothèques et Patterns NFA035
Examen : Projet 2023 - 2024
Thème du projet : Gestion de fabrication de prototypes.

# I. Introduction
Après trois cours Java au sein du Cnam, la conception objet devient un élément primordial pour l’étudiant! L’élaboration d’un modèle objet avec ses données et ses traitements est un must.
A travers le présent devoir, L’étudiant doit valider les connaissances acquises dans les chapitres :
- La programmation objet
- La programmation évènementielle et IHM.
- La généricité et les collections
- Les entrées/sorties
- Les patrons MVC et Observer

# Note importante :
Ce texte donne une idée brève sur le contenu (données et opérations) de l’application. Il présente seulement les technicités générales du cas traité. C’est à l’étudiant de faire davantage de développement et d’inclure des informations et des opérations qu’il voit nécessaires pour l’application.
Une bonne modélisation de données et traitements, une implémentation flexible, ainsi que des interfaces ergonomiques seront bien récompensées.

# II. Présentation du projet
L’entreprise OMEGA s’occupe de la fabrication, de A à Z, de prototypes (premiers modèles) pour les compagnies d’électroménagers à travers des contrats qui imposent à OMEGA l’implémentation d’un projet afin d’obtenir le prototype et son coût.
Un projet de fabrication d’un prototype comprend toutes ou une partie des tâches suivantes :
- Conception
- Préparation des matières premières
- Fabrication d’éléments
- Assemblage et finissage
- Test
Une tâche comprend un ensemble de processus. Chaque processus possède un coût qui mène à pouvoir calculer le cout d’une tâche et, par conséquent, du projet entier. Pour simplifier, nous allons considérer que ce coût inclut :
- Le coût des matières premières utilisées.
- Le coût des ressources humaines (main d’oeuvre) impliquées dans la tâche.
- Les coûts divers comme les logistiques, le carburant, l’électricité, etc.
L’objectif de cet exercice est de faire apparaitre le progrès d’un projet de fabrication à travers une simulation contrôlée des étapes de fabrication, ainsi que de calculer le coût du produit final (le prototype).
Pour l’entreprise OMEGA, la fabrication d’un prototype représente un projet indépendant. Chaque projet inclut toutes ou une partie des tâches susmentionnées.
En ce qui concerne le calcul des coûts des trois catégories susmentionnées, il est effectué comme suit :
- Le coût des matières premières et les coûts divers sont calculés par le nombre d’unités de la matière utilisée et le coût de chaque unité.
- Le coût de main d’oeuvre est calculé pour chaque employé impliqué dans le processus, i.e. chaque employé travaille un nombre déterminé d’heures dans chaque processus et touche un montant pour chaque heure travaillée. (Un employé peut être affecté à plusieurs processus en plusieurs tâches en plusieurs projets). Le tarif de l’heure travaillée dépend de la fonction de l’employé (Job).
 
# Les données
- L’application doit permettre de gérer les données principales des sujets suivants ainsi que d’autres données que vous proposez selon le besoin ou la créativité:
- Les projets : identité, tâches, état d’implémentation, coût progressif pendant les étapes d’exécution, durée.
- Les tâches : identité, processus, coût, état, durée.
- Les processus : identité, ressources affectées, coût, état, durée.
- Les ressources : Humaines et matérielles.
- Les ressources humaines : Des données sur les employées : identité, spécialité, fonction, tarif par heure.
- Les ressources matérielles : identité, coût par unité.
- 
# Les Traitements
L’application doit permettre de:
- Saisir les données nécessaires à l’application
- Valider les données saisies afin qu’elles conforment à des figures logiques du cas traité.
- Construire un projet :
1)Créer le projet
2)Affecter des taches au projet
3)Affecter des processus à chaque tâche
4) Affecter des ressources à chaque processus d’une manière convenable.
5) Lancer une simulation d’une exécution progressive d’un projet ➔ tâche ➔ processus et visualiser le progrès des états et des coûts.
6) Mettre en oeuvre un système de filtrage projet ➔ tâche ➔ processus ➔ ressource pour pouvoir faire des statistiques sur les projets accomplis.
7) Sauvegarder et restituer toutes les données de l’application dans des fichiers sur disques pour toute utilisation ultérieure.

# Le travail demandé :
1) En considérant la description du projet ci-haut, nous demandons de :
- Etablir les modèles de données et de traitements de l’application.
- Implémenter les interfaces graphiques nécessaires pour l’interface homme-machine. A titre de conseil, il est préférable d’avoir trois interfaces graphiques qui communiquent entre elles:
1)Une interface de saisie de données (saisie, affectation, …)
2)Une interface pour la simulation d’exécution d’un projet (les tâches, les processus) avec une partie qui reflète les changements progressifs (MVC)
3)Une interface pour le filtrage et statistiques sur tous les détails et les entités du projet.
4)Implémenter les traitements des différentes opérations.
5)Elaborer des sorties informatives et compréhensives sur les opérations effectuées avec possibilité de recherche minutieuse à plusieurs niveaux de filtrage.
  
# III. Affectation du projet aux auditeurs
o
Le projet sera affecté aux auditeurs en groupes de deux personnes (appelons le « binôme ») de votre choix pour vous faciliter le travail en équipe. Un email vous a été envoyé à ce propos.
o
Vous pouvez travailler ensemble sur tous les modules du projet ou bien vous consentez à organiser le travail entre vous deux.
o
Une fois les binômes sont identifiés, une liste de groupes numérotés sera publiée dans la Classroom afin que vous sachiez le numéro de votre groupe.
Attention!
Vous devriez retenir très bien le numéro de votre groupe car il sera utilisé pour identifier votre travail soumis dans la Classroom.
IV.
Consignes de soumission du travail dans la Classroom
Date limite de soumission dans la Classroom : Dimanche le 21.07.2024 à 23:59h
Les fichiers à soumettre :
•
Fichier ZIP contenant le répertoire du code et données du projet Eclipse.
Coordinateur : AWADA Adel 3
Université Libanaise
Institut Supérieur des Sciences Appliquées et Economiques
ISSAE - Le Cnam Liban
NFA035
Projet 2023-2024
•
Fichier PDF contenant un rapport (de maximum 10 pages) incluant les modèles de données et de traitements du projet, ainsi que les choix faits pour l’implémentation.
Les fichiers doivent être nommés comme suit:
Fichier du projet : NFA035_CODE_GRnuméroGroupe.zip
Fichier du rapport : NFA035_REP_GRnuméroGroupe.pdf
Attention!
Tout travail soumis qui ne respecte pas les consignes sera refusé sans aucune responsabilité d’aviser le groupe respectif.
Tout travail soumis en retard sera pénalisé par un nombre de points proportionnel à ce retard.
V.
Consignes concernant le document du rapport du projet
Le rapport du projet ne doit pas dépasser 10 pages.
1
- Brève description et objectif du projet
2
- Analyse:
o
Les données utilisées (un éventuel dictionnaire de données)
o
Les fonctionnalités
3
- Conception:
o
Modèle de données (relations entre classes). Un diagramme de classes est obligatoire.
o
Modèle de traitements (répartition des taches). Un diagramme MCT ou des cas d’utilisation est obligatoire.
o
Application du patron MVC.
4
- Implémentation
o
Les collections utilisées (justification)
o
Les interfaces graphiques et les évènements
o
Les entrées/sorties
5
- Test
o
Les jeux de données utilisés dans les tests unitaires et le test intégral.
6
- Eventuelles améliorations
7
- Problèmes rencontrés
VI.
Consignes concernant la soutenance du projet
1
- Le programme des soutenances sera publié dans la Classroom après l’identification des binômes.
2
- En principe, le premier jour des séances de soutenances sera Lundi le 22 Juillet 2024.
3
- La durée de la soutenance est 20 minutes par binôme:
•
Présentation conception et implémentation: 5 minutes
•
Démo de l’application: 5 minutes
•
Questions du Jury: 10 minutes (5 minutes pour chaque membre du binôme).
4
- Les membres d’un groupe doivent se connecter à la session avec camera ouverte à l’heure exacte selon le programme de soutenances publié dans la Classroom. Tout retard sera déduit du temps consacré à la soutenance de ce groupe.
5
- Les membres du groupe sont les seuls responsables de tout problème technique qui pourrait surgir de leur part.
6
- Pas de report, changement ou reprogrammation de soutenance. Le programme des soutenances est final et non-modifiable.
7
- L’examen de projet représente 40% de la note finale et ceci s’applique sur toutes les sessions d’examens: final et rattrapage.
8
- L’absence de la soutenance résultera en une note « Zéro » même si l’étudiant avait soumis son travail dans la Classroom.
9
- Une démo échouée d’une fonctionnalité aura une note « Zéro » pour cette fonctionnalité.
10
- Toute réponse non claire, non précise ou hors sujet sera considérée comme « Non réponse »
11
- Une fois la délibération terminée, les notes seront finales et non négociables.
12
- Les sessions de soutenance sont enregistrées.
Note très importante:
Pour ne pas perdre le temps de l’examen oral et pour avoir une démonstration rapide de l’application, votre application doit être dotée d’un ensemble consistent de données déjà saisies et enregistrées sur votre disque.
NE PAS VENIR AVEC UNE APPLICATION VIDE!
