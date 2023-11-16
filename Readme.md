# Centre de Vaccination

Le projet CentreDeVaccination est une application Java qui permet de gérer les vaccinations contre le COVID-19.
L'application permet de créer des rendez-vous de vaccination, de gérer les stocks de vaccins et de suivre l'état d'avancement de la vaccination.

Lien vers le front-end : https://github.com/BillLeuna/centre-de-vaccination-front.git

## Préréquis

Pour installer et exécuter le projet, vous devez disposer des éléments suivants :

1. Une machine avec un système d'exploitation compatible Java (Windows, Mac, Linux)
2. Une version de Java installée
3. Un IDE Java (IntelliJ IDEA, Eclipse, etc.)
4. Git doit être installé sur votre machine.

## Installation

Pour installer le projet, vous pouvez suivre les étapes suivantes :

1. Clonez le projet depuis GitHub:
   ```bash
   git clone https://github.com/BillLeuna/centre-de-vaccination-back.git
   ```

2. Naviguez vers le répertoire du projet :
   ```bash
   cd centre-de-vaccination-back
   ```

3. Installez les dépendances du projet :
    ```bash
   gradle build
   ```

## Exécution

Pour exécuter le projet en local, vous pouvez suivre les étapes suivantes :

1. Lancez l'application :
   ```bash
   gradle run
   ```

2. L'application sera accessible sur le port `8083`.

## Build depuis Jenkins

Le projet est également accompagné d'un pipeline Jenkins qui permet de lancer des builds automatiques. Pour configurer
le pipeline Jenkins, vous devez suivre les étapes suivantes :

1. **Prérequis:**
    - Assurez-vous d'avoir un compte GitHub ([https://github.com](https://github.com)) et un compte
      DockerHub ([https://hub.docker.com](https://hub.docker.com)).
    - Docker doit être installé sur votre machine.
    - Git doit être installé sur votre machine.
    - Jenkins doit être installé et avoir les droits nécessaires pour accéder au dépôt GitHub


2. **Configuration de Jenkins:**
    - Créez un nouveau pipeline Jenkins...
      ```groovy
      
      ```

3. **Exécution du Pipeline:**
    - Le pipeline ci-dessus effectue le build du backend et crée une image Docker.
    - Assurez-vous que le chemin vers Gradle et le fichier Dockerfile est correct.

4. **Points d'Attention:**
    - Le conteneur ne doit pas s'exécuter en tant que root.
    - Les prérequis de l'environnement pour builder un projet Gradle doivent être satisfaits.
    - Le type de build utilisé est Gradle.
    - L'artefact fabriqué (image de conteneur) est stocké localement.

## Contact

En cas de problème ou de question, n'hésitez pas à me contacter à l'adresse
mail `bill-ruben.mbiawa-leuna1@etu.univ-lorraine.fr`.

---
