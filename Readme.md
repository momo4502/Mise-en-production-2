# Centre de Vaccination

Ce projet CentreDeVaccination est une application Java qui met à la disposition des utilisateurs un moyen efficace de gérer les vaccinations contre le COVID-19. C'est-à dire les rendez-vous, les stocks de vaccinet un suivi adéquat pour les patients.

Les screenshots confirmant le fonctionnement sont disponibles dans le dossier `screenshots`

## Préréquis

Voici les outils nécessaires pour le bon fonctionnement de notre application :

1. Java 17
2. Jenkins
3. Git
4. Docker
5. Un IDE Java (Eclipse, VS Code, etc.)
6. pgAdmin 

## Installation

Pour installer le projet, vous pouvez suivre les étapes suivantes :

1. Clonez le projet depuis GitHub:
   ```bash
   git clone 'lien du repository git'
   ```

2. Naviguez vers le répertoire du projet :
   ```bash
   cd centre-de-vaccination
   ```
   
3. Créez une base de données dans pgAdmin nommée `BaseDeDonnees`.

## Pour l'éxécution du programme

Pour exécuter le projet en local, vous pouvez suivre les étapes suivantes :

1. Lancement en local :
    ```bash
   gradle clean build
   ```
   
2. Démarrage de l'application :
   ```bash
   gradle run
   ```

3. L'application sera accessible sur le port `9090`.

Il faut s'assurer d'arrêtez l'exécution de l'application avant de passer à l'étape suivante.

## Build depuis Jenkins

Le projet est également accompagné d'un pipeline Jenkins qui permet de lancer des builds automatiques. Pour configurer
le pipeline Jenkins, vous devez suivre les étapes suivantes :

1. **Pour la configuration du Pipeline Jenkins :**
    - Commencez par créer un nouveau pipeline dans Jenkins
    - Dans la page de configuration suivante, rendez-vous dans la section Pipeline et choisissez l'option  `Pipeline script from SCM`
    - Pour le système de gestion de configuration (SCM), optez pour Git.
    - Spécifiez le lien vers le dépôt GitHub de votre projet dans le champ repository.
    - Enregistrez ces paramètres de configuration pour finaliser le processus.

2. **Exécution du Pipeline :**
    - Exécutez le Pipeline ci-dessus et appréciez les résultats

## Documentation

Le projet CentreDeVaccination est construit et déployé automatiquement sur Jenkins. Le pipeline Jenkins est défini dans le fichier Jenkinsfile.

Le pipeline Jenkins suit les étapes suivantes :

1. **Build du projet :** 

Le pipeline commence par construire le projet à l'aide de Gradle. Il utilise la tâche `clean build` pour installer les dépendances du projet, compiler le code source et générer l'artefact final.

2. **Vérification des conteneurs :**

Le pipeline vérifie ensuite si les conteneurs `vaccination-center-api` et `vaccination-center-database` sont en cours d'exécution. S'ils conteneurs existent, ils sont arrêtés et supprimés.

3. **Pour lancer les conteneurs :**

`docker compose up -d` lance les conteneurs `vaccination-center-api` et `vaccination-center-database`.

L'application est accessible sur le port `8090`.

---
