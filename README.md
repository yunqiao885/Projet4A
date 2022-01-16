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

Les principaux acteurs de notre application seront les utilisateurs et les administrateurs. Ils auront accès à un interface spécifique en fonction des informations entrées lors de la connexion.
Les différents contenus affichés à l'écran sont gérés par ReactJs et chaque page HTML est généré par un composant de fonction qui traite les informations de cet utilisateur et ses demandes retourne le résultat sous forme de JSX qui affichera le résultat en HTML. Les différents composants et leurs rôles sont recenses dans le tableau ci dessous:

|    Composant     |                             Rôle                             |
| :--------------: | :----------------------------------------------------------: |
|     App.jsx      | C'est le point d'entrée de notre application principale avec les routes pour accéder à la page de connexion, d'inscription ou d'un utilisateur |
|    Header.jsx    | C'est le menu de notre application, il change en fonction de l'acteur |
|    Login.jsx     |             Afficher le formulaire de connexion              |
|   Register.jsx   |             Affiche le formulaire d'inscription              |
|    Error.jsx     |    Affiche un message d'erreur pour les pages non trouves    |
|   UserApp.jsx    | Affiche la page d'accueil d'un utilisateur connecté. Elle y définit les routes pour accéder à la boutique, au compte, à l'application de paiement, à la déconnexion et à la bibliothèque |
|  ListeJeux.jsx   | Affiche la liste des jeux récupéré par appel d'API ainsi que les boutons pour afficher leurs détails ou les ajouter au panier |
|    Panier.jsx    | Affiche la liste des jeux dans le panier ainsi que les boutons pour interagir avec le panier |
|   JeuInfo.jsx    | Affiche les infos d'un jeux en particulier et le bouton pour fermer |
| Bibliotheque.jsx | Affiche tous les jeux dont possède un utilisateur et un bouton pour les telecharger |
|   Boutique.jsx   |    Affiche la boutique avec le panier et la liste de jeux    |
|    Compte.jsx    |       Affiche les éléments de compte d'un utilisateur        |
|  PaymentApp.jsx  | C'est le point d'entrée de l'application de paiement avec les routes pour procéder au paiement |
| CheckoutForm.jsx | C'est le formulaire où l'utilisateur sera invité à entrer les informations de sa carte bancaire |
|   Process.jsx    | Charge les éléments Stripe et affiche le formulaire de paiement |
|   Succeded.jsx   | Il vide le panier, envoi le mail et redirige vers la page d'accueil de l'utilisateur |

Pour accéder aux données de notre service web nous avons utilisés la méthode fetch() car elle nous permet d'effectuer des appels d'API depuis notre application client. fetch() utilise des requêtes pour créer des demandes et les réponses sont reçues et traités grâce à la méthode then().

#### La couche serveur web

Les différents services disponibles sur notre application sont les suivants : 
1. Paiement en ligne
Ce service est géré principalement par le la classe PaymentController qui se charge de créer l'objet de payement avec le montant du payement, la devise et l'id du client, ensuite renvoie un objet de réponse de paiement contenant l'id du payement qui vient être créé. Ensuite l'utilisateur est renvoyé vers une page qui demande de rentrer ses informations de carte bancaire et le paiement est reconnu grâce à l'id envoyé en réponse et effectué du côte de Stripe.

2. Messagerie ou e-mail en ligne

  Ce service lui fonctionne grâce à la classe MailController et aux différentes configurations effectués tels que :
* Le protocole utilisé : SMPT pour Simple Mail Transfert Protocol 
* L'adresse mail source : magasin.de.jeux.video@gmail.com 
* Le numero de port utilisé : 587 (celui de Gmail)
* Le mot de passe : fourni par Gmail et destiné uniquement à l'envoi de mail automatique
* Activation des propriétes d'envoi de mail.

Une fois ces configurations effectués, dans le contrôleur, on instancie l'objet JavaMailSender qui implémente l'objet MailSender pour envoyer les messages, puis grâce à sa méthode d'envoi de mail, on récupère l'objet de paiement contenant l'id du client qui nous permettra d'avoir son nom et son email dans la base de données, ainsi que les jeux achetés et on crée le message grâce à l'objet SimpleMailMessage avec les configurations d'envoi de mail (source, port, destinataire, message...). On construit le message à envoyer et enfin on envoi le mail.
3. Gestion des données

Pour la gestion des données, nous avons créés pour chaque classe de notre application un contrôleur avec différentes méthodes qui permettent de modifier d'ajouter ou de supprimer des éléments dans la base de données de notre application. Nous avons également realisé une injection des dépendances et inversion des contrôles pour que notre architecture soit SOLID.

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
#### SimpleMailMessage et JavaMailSender

La classe SimpleMailMessage est un objet de valeur simple qui implémente le MailMessage de JavaMail et prend en charge l'encapsulation des propriétés de messagerie simples, telles que les propriétés from et to. Les méthodes setTo(), setFrom(), setContext(), setSubject() permettent à définir l’expéditeur, le destinataire, la texte et la titre. Ce package contient également une série d'exceptions vérifiées, qui sont des abstractions de niveau supérieur fournies par rapport aux exceptions de système de messagerie de niveau inférieur, l'exception racine étant MailException.

L'interface JavaMailSender implémente l’interface **MailSender** et en tant qu'expéditeur de mail, il fournit principalement une interface d'envoi de mail, crée le MailMessage de Java Mail de manière transparente et les configurations d'envoi de mail par défaut (hostname, protocole...)

### Hibernate
Ce framework permet de realiser le mapping objet relationnel entre les différentes classes que nous avons créé et leurs tables dans la base de données. Elle facilite ainsi la persistance des objets d'une application grâce à ces différentes annotations

### Lombok
Ce framework permet de facilement et rapidement coder des classes en remplacant certaines methodes toujours redondante par classe par des annotations.
### ReactJs et les hooks

React est l'un des frameworks JavaScript les plus populaires. C'est à la fois une bibliothèque et un framework qui permet de créer des interfaces utilisateur. L'idée principale derrière React est que nous pouvons construire notre application à partir de composants. Un composant combine HTML, JS et CSS, personnalisé pour nos besoins, et nous pouvons les réutiliser pour créer des interfaces utilisateur. Un Hook est une fonction qui permet de se brancher sur des fonctionnalités React. Nous pouvons citer notamment :  useState() qui permet d’ajouter le state local React à des fonctions composantes, useEffect() lui permet à notre composant d'exécuter des actions après l'affichage, en choisissant quand effectuer cette action grâce au tableau de dépendances et enfin useNavigate() qui permet d'accéder aux objets de navigation pour effectuer une navigation sur un lien précis ou une redirection.

### Stripe 
C'est un framework développé par la société Stripe permettant d'ajouter sur un site web une solution de payement sécurisé. Il est compatible avec Java et ReactJs en ajoutant les dépendances respectives au projet. Et pour l'exploiter, il est nécessaire de créer un compte sur le site de a société. Ensuite, il nous est fourni une clé secrète qui nous permettra d'utiliser les différentes classes de ce framework pour réaliser les opérations de paiement en ligne en toute sortes, d'enregistrement de client, de produits et de gestion d'évènements.


## CONCLUSION GENERALE

Dans ce projet, nous avons appris à utiliser la technologie de développement front-end REACT pour construire l'architecture front-end, et nous avons également pleinement pratiqué le développement back-end d'un projet avec la technologie SpringBoot. Spring boot fournit une interface JavaMailSender très utile pour envoyer des e-mails. Nous utilisons la technologie Stripe pour intégrer efficacement les paiements en ligne dans nos application Web. Nous avons à peu près terminé le processus de développement d'une application Web. Malheureusement, nous n'avons pas eu le temps de terminer la séparation des autorisations pour les utilisateurs et les administrateurs. Dans le prochain processus de développement, nous ajouterons la technologie de sécurité Spring pour renforcer la capacité de protection des informations des utilisateurs et améliorer la fonction d'échange d'informations entre les utilisateurs.