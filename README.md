# Projet Systèmes Distribués : Conception d’une application Web de vente de jeu vidéo


## INTRODUCTION GENERALE

Dans le cadre de notre formation, nous devons réaliser un projet pour la quatrième année, ceci dans le but de mettre en application les notions telles que les Services Web et d'API vues en cours. Nous avons donc choisis de réaliser une application web permettant à des utilisateurs de faire des achats de jeux video sur notre site et de les télécharger.

## DESCRIPTION DETAILLEE DE L'APPLICATION

### Architecture de l'application

Notre application utilise les éléments de architecture 3 tiers qui sont:
* Un client : Ici, nous avons utilisés ReactJs pour faire des appels d'API et communiquer avec notre serveur et afficher les éléments sur le navigateur.
* Un serveur web : Pour réceptionner les requêtes effectués par le client,, nous avons réalisé notre serveur web  en Java Spring Boot.
* Un serveur de données : Le serveur de données utilisé ici est MySQL, mais pour la phase de teste et des essaies, nous allons utiliser la base de donnée H2.

### Description détaillé des différentes couches

#### La couche client

Les principaux acteurs de notre application seront les utilisateurs et les administrateurs. Ceux ci auront les fonctionnalités suivantes:

1. Administrateur
* Se Connecter
* Créer un administrateur
* Modifier ses données
* Ajouter un jeu
* Modifier les données d'un jeu
* Supprimer un jeu

2. Utilisateur
* Consulter les produits sur le site
* Créer un compte
* Se Connecter
* Recevoir le code par téléphone et par mail
* Créer une liste de souhait (panier)
* Faire le paiement par carte bancaire
* Mettre un avis sur un jeu 

#### La couche serveur web

Les différents services disponibles sur notre application sont les suivants : 
* Paiement en ligne
* Messagerie ou e-mail en ligne
* Gestion des données

#### La couche serveur de données
Pour créer notre base de données et manipuler ses informations, nous utiliserons le framework Hibernate, car celui ci nous permettra de faire le mapping relationnel objet entre les différentes tables de notre base de donnée et les différentes classes ou objets qui représenterons ces données dan notre programme Java

### Modélisation de notre application

Pour modéliser notre application, parmi les nombreux outils qui existent, nous avons choisis d'utiliser l'UML car il nous permet de réviser sur les notions que nous avons vu en cours de Génie Logiciel; en plus, il nous permet de bien décrire le fonctionnement de notre application en les 3 diagrammes suivants : 

* Le diagramme de Cas d'utilisation : Ici, nous avons recensé tous les cas d'utilisations et scenarios qui pourraient se produire sir notre application

![](https://github.com/yunqiao885/Projet4A/blob/main/Diagrammes%20UML/Use%20case/Use_Case.png)

* Le diagramme de Classe : Dans ce diagramme, Nous avons représenté toutes les données que notre application traitera, ainsi que les différentes interactions entre ces données

![](https://github.com/yunqiao885/Projet4A/blob/main/Diagrammes%20UML/Class/Classe.png)

* Le diagramme de Séquence : Pour le diagramme de séquence, nous avons traité le cas nominale qui est celui de l'achat d'un jeu et nous avons donc représenté les différentes étapes qui s'effectuent entre un client et nos services web

![](https://github.com/yunqiao885/Projet4A/blob/main/Diagrammes%20UML/Sequence/diag_sequence.PNG)



## LES FRAMEWORKS UTILISES

### Spring Boot
C'est un framework Java qui permet de développer des applications web ou des services web REST sans avoir a faire beaucoup de configurations sur la machine de développement, ce qui permet au développeur de se concentrer essentiellement sur le code. Il contient plusieurs bibliothèques et celles que nous avons utilisés sont les suivantes :
#### RestController
C'est une bibliothèque qui simplifie la création et l'exposition des services Web REST. Elle nous a permis de réaliser tous nos services web en gérant les requêtes GET, POST, PUT et DELETE grâce aux annotations respectives @GetMapping, @PostMapping, @PutMapping et @DeleteMapping.
#### RestRepository
Cette bibliothèque nous permet d'exposer rapidement une ressource grâce à l'API REST. En créant une interface pour chaque classe qui communiquera avec la base de données et effectuera différentes opérations sur ses données associés.
#### JavaMailSender

### Hibernate
Ce framework permet de realiser le mapping objet relationnel entre les différentes classes que nous avons créé et leurs tables dans la base de données. Elle facilite ainsi la persistance des objets d'une application grâce à ces différentes annotations

### Lombok
Ce framework permet de facilement et rapidement coder des classes en remplacant certaines methodes toujours redondante par classe par des annotations.
### ReactJs

### Stripe 
C'est un framework développé par la société Stripe permettant d'ajouter sur un site web une solution de payement sécurisé. Il est compatible avec Java et ReactJs en ajoutant les dépendances respectives au projet. Et pour l'exploiter, il est nécessaire de créer un compte sur le site de a société. Ensuite, il nous est fourni une clé secrète qui nous permettra d'utiliser les différentes classes de ce framework pour réaliser les opérations de paiement en ligne en toute sortes, d'enregistrement de client, de produits et de gestion d'évènements.


## CONCLUSION GENERALE