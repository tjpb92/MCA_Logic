# MCA_Logic

Partie cliente pour la numérotation automatique.

Communique avec la partie serveur via une socket sur le port 4000.

## Utilisation:
```
java -jar MCA_Logic.jar no_tel login [ref_client]
```
où :
* ```no_tel``` est le numéro de téléphone à composer pour joindre le correspondant (paramètre obligatoire).
* ```login``` est le numéro de poste de l'agent (paramètre obligatoire).
* ```ref_client``` est une référence pour la facturation du client. Vaut COFELY par défaut (paramètre optionnel).

## Pré-requis :
- Java 6 ou supérieur.
- Log4j

## Références:

- [Log4J] (http://logging.apache.org/log4j/2.x/download.html)
- [Tuto Log4J] (https://koor.fr/Java/Tutorial/java_logging_log4j2.wp)
